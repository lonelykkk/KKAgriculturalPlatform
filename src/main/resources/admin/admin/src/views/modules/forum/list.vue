<template>
    <div class="main-content">
        <el-dialog title="帖子回复详情" :visible.sync="forumReplyDialogVisible">
            <el-dialog
                    width="30%"
                    :title="forumReplyInfoContent"
                    :visible.sync="forumReplyInfoDialogVisible"
                    append-to-body>
            </el-dialog>
            <div class="demo-input-suffix">
                <span style="width: 20%">帖子标题：</span><el-input v-model="forumTitle" :disabled="true" placeholder="帖子标题" style="width: 80%"></el-input>
            </div>
            <div class="demo-input-suffix">
                <span style="width: 20%">帖子内容：</span><span style="width: 80%;height: 20%;" v-html="forumContent"></span>
            </div>
            <el-table :data="forumData" height="250">
                <!--<el-table-column label="id" width="40"></el-table-column>-->
                <el-table-column label="身份">
                    <template slot-scope="scope">
                        <span v-if="scope.row.yonghuId">
                            用户
                        </span>
                        <span v-if="scope.row.shangjiaId">
                            商家
                        </span>
                        <span v-if="scope.row.usersId">
                            管理员
                        </span>
                    </template>
                </el-table-column>
                <el-table-column label="姓名">
                        <template slot-scope="scope">
                        <span v-if="scope.row.yonghuId">
                            {{scope.row.yonghuName}}
                        </span>
                        <span v-if="scope.row.shangjiaId">
                            {{scope.row.shangjiaName}}
                        </span>
                        <span v-if="scope.row.usersId">
                            管理员
                        </span>
                    </template>
                </el-table-column>
                <el-table-column label="手机号">
                    <template slot-scope="scope">
                        <span v-if="scope.row.yonghuId">
                            {{scope.row.yonghuPhone}}
                        </span>
                        <span v-if="scope.row.shangjiaId">
                            {{scope.row.shangjiaPhone}}
                        </span>
                        <span v-if="scope.row.usersId">
                            管理员
                        </span>
                    </template>
                </el-table-column>
                <el-table-column label="回复内容">
                    <template slot-scope="scope">
                        {{scope.row.forumContent.length>20?(scope.row.forumContent.substring(0,20)+'...'):scope.row.forumContent}}
                    </template>
                </el-table-column>
                <el-table-column property="insertTime" label="回帖时间"></el-table-column>
                <el-table-column property="caozuo" label="操作">
                    <template slot-scope="scope">
                        <el-button type="info"                          @click="seeForumContent(scope.row.forumContent)">回帖详情</el-button>
                            <el-button v-if="true &&( false|| (sessionTable == 'yonghu' && scope.row.yonghuId ==userId)
|| (sessionTable == 'shangjia' && scope.row.shangjiaId ==userId)
|| sessionTable == 'users')" type="danger" icon="el-icon-delete" size="mini" @click="deleteHandler(scope.row.id)">删除帖子</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="demo-input-suffix">
                <span>回帖内容：</span>
                <el-input v-model="forumReplyContent" placeholder="回帖内容" type="textarea"></el-input>
            </div>
            <div slot="footer" class="dialog-footer">
                <el-button @click="forumReplyDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="forumReply">回 帖</el-button>
            </div>
        </el-dialog>
        <!-- 条件查询 -->
        <div v-if="showFlag">
            <el-form :inline="true" :model="searchForm" class="form-content">
                <el-row :gutter="20" class="slt" :style="{justifyContent:contents.searchBoxPosition=='1'?'flex-start':contents.searchBoxPosition=='2'?'center':'flex-end'}">
                 
                     <el-form-item :label="contents.inputTitle == 1 ? '帖子标题' : ''">
                         <el-input prefix-icon="el-icon-search" v-model="searchForm.forumName" placeholder="帖子标题" clearable></el-input>
                     </el-form-item>
                                                                        
                                         
                    <el-form-item :label="contents.inputTitle == 1 ? '商家名称' : ''">
                        <el-input prefix-icon="el-icon-search" v-model="searchForm.shangjiaName" placeholder="商家名称" clearable></el-input>
                    </el-form-item>
                                                                                                                                                                                                         
                    <el-form-item :label="contents.inputTitle == 1 ? '用户编号' : ''">
                        <el-input prefix-icon="el-icon-search" v-model="searchForm.yonghuUuidNumber" placeholder="用户编号" clearable></el-input>
                    </el-form-item>
                     
                    <el-form-item :label="contents.inputTitle == 1 ? '用户姓名' : ''">
                        <el-input prefix-icon="el-icon-search" v-model="searchForm.yonghuName" placeholder="用户姓名" clearable></el-input>
                    </el-form-item>
                                                                                                                                                                                                                            

                    <el-form-item>
                        <el-button type="success" @click="search()">查询<i class="el-icon-search el-icon--right"/></el-button>
                    </el-form-item>
                </el-row>
                <el-row class="ad" :style="{justifyContent:contents.btnAdAllBoxPosition=='1'?'flex-start':contents.btnAdAllBoxPosition=='2'?'center':'flex-end'}">
                    <el-form-item>
                        <el-button
                                v-if="isAuth('forum','新增')"
                                type="success"
                                icon="el-icon-plus"
                                @click="addOrUpdateHandler()"
                        >新增</el-button>
                        &nbsp;
                        <el-button
                                v-if="isAuth('forum','报表')"
                                type="success"
                                icon="el-icon-pie-chart"
                                @click="chartDialog()"
                        >报表</el-button>
                        &nbsp;
                        <a style="text-decoration:none" class="el-button el-button--success"
                           v-if="isAuth('forum','导入导出')"
                           icon="el-icon-download"
                           href="http://localhost:8080/lelenongchanpinxiaoshou/upload/forumMuBan.xls"
                        >批量导入交流论坛数据模板</a>
                        &nbsp;
                        <el-upload
                                v-if="isAuth('forum','导入导出')"
                                style="display: inline-block"
                                :action="getActionUrl"
                                :on-success="forumUploadSuccess"
                                :on-error="forumUploadError"
                                :show-file-list = false>
                            <el-button
                                    v-if="isAuth('forum','导入导出')"
                                    type="success"
                                    icon="el-icon-upload2"
                            >批量导入交流论坛数据</el-button>
                        </el-upload>
                        &nbsp;
                        <!-- 导出excel -->
                        <download-excel v-if="isAuth('forum','导入导出')" style="display: inline-block" class = "export-excel-wrapper" :data = "dataList" :fields = "json_fields" name = "forum.xls">
                            <!-- 导出excel -->
                            <el-button
                                    type="success"
                                    icon="el-icon-download"
                            >导出</el-button>
                        </download-excel>
                        &nbsp;
                    </el-form-item>
                </el-row>
            </el-form>
            <div class="table-content">
                <el-table class="tables" :size="contents.tableSize" :show-header="contents.tableShowHeader"
                          :header-row-style="headerRowStyle" :header-cell-style="headerCellStyle"
                          :border="contents.tableBorder"
                          :fit="contents.tableFit"
                          :stripe="contents.tableStripe"
                          :row-style="rowStyle"
                          :cell-style="cellStyle"
                          :style="{width: '100%',fontSize:contents.tableContentFontSize,color:contents.tableContentFontColor}"
                          v-if="isAuth('forum','查看')"
                          :data="dataList"
                          v-loading="dataListLoading"
                          @selection-change="selectionChangeHandler">
                    <el-table-column label="索引" v-if="contents.tableIndex" type="index" width="50" />
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      header-align="center"
                                      label="身份">
                        <template slot-scope="scope">
                            <span v-if="scope.row.yonghuId">
                                用户
                            </span>
                            <span v-if="scope.row.shangjiaId">
                                商家
                            </span>
                            <span v-if="scope.row.usersId">
                                管理员
                            </span>
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      header-align="center"
                                      label="姓名">
                        <template slot-scope="scope">
                            <span v-if="scope.row.yonghuId">
                                {{scope.row.yonghuName}}
                            </span>
                            <span v-if="scope.row.shangjiaId">
                                {{scope.row.shangjiaName}}
                            </span>
                            <span v-if="scope.row.usersId">
                                管理员
                            </span>
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      header-align="center"
                                      label="手机号">
                        <template slot-scope="scope">
                            <span v-if="scope.row.yonghuId">
                                {{scope.row.yonghuPhone}}
                            </span>
                            <span v-if="scope.row.shangjiaId">
                                {{scope.row.shangjiaPhone}}
                            </span>
                            <span v-if="scope.row.usersId">
                                管理员
                            </span>
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      header-align="center"
                                      label="头像">
                        <template slot-scope="scope">
                            <span v-if="scope.row.yonghuId">
                                <div v-if="scope.row.yonghuPhoto">
                                    <img :src="$base.url+scope.row.yonghuPhoto" width="100" height="100">
                                </div>
                                <div v-else>无图片</div>
                            </span>
                            <span v-if="scope.row.shangjiaId">
                                <div v-if="scope.row.shangjiaPhoto">
                                    <img :src="$base.url+scope.row.shangjiaPhoto" width="100" height="100">
                                </div>
                                <div v-else>无图片</div>
                            </span>
                            <span v-if="scope.row.usersId">
                                管理员
                            </span>
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="forumName"
                                      header-align="center"
                                      label="帖子标题">
                        <template slot-scope="scope">
                            {{scope.row.forumName}}
                        </template>
                    </el-table-column>
    <!--                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="forumContent"
                                      header-align="center"
                                      label="帖子内容">
                        <template slot-scope="scope">
                            {{scope.row.forumContent.length>20?(scope.row.forumContent.substring(0,20)+'...'):scope.row.forumContent}}
                        </template>
                    </el-table-column>-->
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                      prop="insertTime"
                      header-align="center"
                      label="发帖时间">
                        <template slot-scope="scope">
                            {{scope.row.insertTime}}
                        </template>
                    </el-table-column>

                    <el-table-column width="300" :align="contents.tableAlign"
                                     header-align="center"
                                     label="操作">
                        <template slot-scope="scope">
                            <el-button v-if="sessionTable=='false'" type="primary" size="mini" @click="wuyong(scope.row.id)">无用按钮</el-button>
                            <el-button v-if="sessionTable=='false'" type="success" icon="el-icon-printer" size="mini" @click="dayinOpen(scope.row)">打印</el-button>
                            <el-button v-if="isAuth('forum','查看')" type="success" icon="el-icon-tickets" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
                            <el-button v-if="isAuth('forum','查看')" type="primary" icon="el-icon-edit" size="mini" @click="openReplyForum(scope.row.id,scope.row.forumName,scope.row.forumContent)">查看论坛回复</el-button>
                            <el-button v-if="isAuth('forum','修改')" type="primary" icon="el-icon-edit" size="mini" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>

                            <el-button v-if="true &&( false|| (sessionTable == 'yonghu' && scope.row.yonghuId ==userId)
|| (sessionTable == 'shangjia' && scope.row.shangjiaId ==userId)
|| sessionTable == 'users')" type="danger" icon="el-icon-delete" size="mini" @click="deleteHandler(scope.row.id)">删除帖子</el-button>

                        </template>
                    </el-table-column>
                </el-table>
                <el-pagination
                        clsss="pages"
                        :layout="layouts"
                        @size-change="sizeChangeHandle"
                        @current-change="currentChangeHandle"
                        :current-page="pageIndex"
                        :page-sizes="[10, 20, 50, 100]"
                        :page-size="Number(contents.pageEachNum)"
                        :total="totalPage"
                        :small="contents.pageStyle"
                        class="pagination-content"
                        :background="contents.pageBtnBG"
                        :style="{textAlign:contents.pagePosition==1?'left':contents.pagePosition==2?'center':'right'}"
                ></el-pagination>
            </div>
        </div>
        <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
        <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>


        <el-dialog title="打印" :visible.sync="printVisiable" width="500px">
            <el-form ref="printContent" :model="printFrom" label-width="auto">
                <el-form-item label="发件人">
                    <div  style="display: flex">
                        <el-input v-model="printFrom.kuaidiFajianName" disabled></el-input>
                        :
                        <el-input v-model="printFrom.kuaidiFajianShoujihao" disabled></el-input>
                    </div>
                </el-form-item>
                <el-form-item label="发件人地址">
                    <el-input v-model="printFrom.kuaidiFajianAddress" disabled></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
              <el-button @click="printContent()" icon="el-icon-printer" type="success">打印</el-button>
              <el-button @click="printVisiable = false">关闭</el-button>
            </span>
        </el-dialog>

        <el-dialog title="统计报表" :visible.sync="chartVisiable" width="80%">
            <el-date-picker v-model="echartsDate" type="year" placeholder="选择年"> </el-date-picker>
            <el-button @click="chartDialog()">查询</el-button>
                <div id="statistic" style="width:100%;height:600px;"></div>

            <span slot="footer" class="dialog-footer">
				<el-button @click="chartVisiable = false">关闭</el-button>
			</span>
        </el-dialog>

    </div>
</template>
<script>
    import AddOrUpdate from "./add-or-update";
    import styleJs from "../../../utils/style.js";
    import utilsJs, {getYearFormat,getMonthFormat,getDateFormat,getDatetimeFormat} from "../../../utils/utils.js";

    export default {
        data() {
        return {
            //打印开始
            printFrom: {
                name1:"",
            },
            printVisiable: false,
            //打印结束
            searchForm: {
                key: ""
            },
            sessionTable : "",//登录账户所在表名
            role : "",//权限
            userId:"",//当前登录人的id
    //级联表下拉框搜索条件
    //当前表下拉框搜索条件
            form:{
                id : null,
                forumName : null,
                yonghuId : null,
                shangjiaId : null,
                usersId : null,
                forumContent : null,
                superIds : null,
                forumStateTypes : null,
                insertTime : null,
                updateTime : null,
                createTime : null,
            },
            dataList: [],
            pageIndex: 1,
            pageSize: 10,
            totalPage: 0,
            dataListLoading: false,
            dataListSelections: [],
            showFlag: true,
            sfshVisiable: false,
            shForm: {},
            chartVisiable: false,
            echartsDate: new Date(),//echarts的时间查询字段
            addOrUpdateFlag:false,
            contents:null,
            layouts: '',

            forumReplyDialogVisible : false,//论坛回复模态框
            forumReplyInfoDialogVisible : false,//论坛回复详情模态框
            superIds : "",//帖子id
            forumTitle : "",//帖子标题
            forumContent : "",//帖子内容
            forumReplyContent : "",//帖子回复内容
            forumReplyInfoContent : "",//帖子某个回复详情 全
            forumData : [],//论坛回复数据集合

            //导出excel
            json_fields: {
                //级联表字段
                     '商家名称': 'shangjiaName',
                     '联系方式': 'shangjiaPhone',
                     '邮箱': 'shangjiaEmail',
                     '营业执照展示': 'shangjiaPhoto',
                     '商家信用类型': 'shangjiaXingjiTypes',
                     '现有余额': 'newMoney',
                     '用户编号': 'yonghuUuidNumber',
                     '用户姓名': 'yonghuName',
                     '用户手机号': 'yonghuPhone',
                     '用户身份证号': 'yonghuIdNumber',
                     '用户头像': 'yonghuPhoto',
                     '用户邮箱': 'yonghuEmail',
                     '余额': 'newMoney',
                     '儿童名': 'username',
                     '角色': 'role',
                     '新增时间': 'addtime',
                //本表字段
                     '帖子标题': "forumName",
                     '父id': "superIds",
                     '帖子状态': "forumStateValue",
                     '发帖时间': "insertTime",
                     '修改时间': "updateTime",
            },

            };
        },
        created() {
            this.contents = styleJs.listStyle();
            this.init();
            this.getDataList();
            this.contentStyleChange()
        },
        mounted() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");

        },
        filters: {
            htmlfilter: function (val) {
                return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
            }
        },
        components: {
            AddOrUpdate,
        },
        computed: {
            getActionUrl: function() {
                return `/`+this.$base.name+`/file/upload`;
            }
        },
        methods: {
            chartDialog() {
                let _this = this;
                let params = {
                    dateFormat :"%Y", //%Y-%m
                    riqi :getYearFormat(_this.echartsDate),//年
                    // riqi :getMonthFormat(_this.echartsDate),//年月
                    thisTable : {//当前表
                        tableName :'forum',//当前表表名,
                        sumColum : 'forum_number', //求和字段
                        date : 'insert_time',//分组日期字段
                        // string : 'forum_name',//分组字符串字段
                        // types : 'forum_types',//分组下拉框字段
                    },
                    // joinTable : {//级联表（可以不存在）
                    //     tableName :'yonghu',//级联表表名
                    //     // date : 'insert_time',//分组日期字段
                    //     string : 'yonghu_name',//分组字符串字段
                    //     // types : 'yonghu_types',//分组下拉框字段
                    // }
                }
                _this.chartVisiable = true;
                _this.$nextTick(() => {
                    var statistic = this.$echarts.init(document.getElementById("statistic"), 'macarons');
                    this.$http({
                        url: "barSum",//barCountOne barCountTwo barSumOne barSumTwo
                        method: "get",
                        params: params
                    }).then(({data}) => {
                        if(data && data.code === 0){
                            let yAxisName = "数值";//y轴
                            let xAxisName = "月份";//x轴
                            let series = [];//具体数据值
                            data.data.yAxis.forEach(function (item,index) {//点击可关闭的按钮字符串在后台方法中
                                let tempMap = {};
                                tempMap.name=data.data.legend[index];
                                tempMap.type='bar';
                                tempMap.data=item;
                                series.push(tempMap);
                            })

                            var option = {
                                tooltip: {
                                    trigger: 'axis',
                                    axisPointer: {
                                        type: 'cross',
                                        crossStyle: {
                                            color: '#999'
                                        }
                                    }
                                },
                                toolbox: {
                                    feature: {
                                        // dataView: { show: true, readOnly: false },  // 数据查看
                                        magicType: { show: true, type: ['line', 'bar'] },//切换图形展示方式
                                        // restore: { show: true }, // 刷新
                                        saveAsImage: { show: true }//保存
                                    }
                                },
                                legend: {
                                    data: data.data.legend//标题  可以点击导致某一列数据消失
                                },
                                xAxis: [
                                    {
                                        type: 'category',
                                        axisLabel:{interval: 0},
                                        name: xAxisName,
                                        data: data.data.xAxis,
                                        axisPointer: {
                                            type: 'shadow'
                                        }
                                    }
                                ],
                                yAxis: [
                                    {
                                        type: 'value',//不能改
                                        name: yAxisName,//y轴单位
                                        axisLabel: {
                                            formatter: '{value}' // 后缀
                                        }
                                    }
                                ],
                                series:series//具体数据
                            };
                            statistic.setOption(option,true);
                            window.onresize = function () {
                                statistic.resize();
                            };
                        }else {
                            this.$message({
                                message: "报表未查询到数据",
                                type: "success",
                                duration: 1500,
                                onClose: () => {
                                    this.search();
                                }
                            });
                        }
                    });
                });
                ////饼状图
                //_this.chartVisiable = true;
                // this.$nextTick(()=>{
                //     var statistic = this.$echarts.init(document.getElementById("statistic"),'macarons');
                //     let params = {
                //         tableName: "forum",
                //         groupColumn: "forum_types",
                //// riqi :getMonthFormat(_this.echartsDate),//年月
                //     }
                //     this.$http({
                //         url: "newSelectGroupCount",//pieSum pieCount
                //         method: "get",
                //         params: params
                //     }).then(({data}) => {
                //         if (data && data.code === 0) {
                //             let res = data.data;
                //             let xAxis = [];
                //             let yAxis = [];
                //             let pArray = []
                //             var option = {};
                //             for(let i=0;i<res.length;i++){
                //                 xAxis.push(res[i].name);
                //                 yAxis.push(res[i].value);
                //                 pArray.push({
                //                     value: res[i].value,
                //                     name: res[i].name
                //                 })
                //                 option = {
                //                     title: {
                //                         text: '保险合同类型统计',
                //                         left: 'center'
                //                     },
                //                     tooltip: {
                //                         trigger: 'item',
                //                         formatter: '{b} : {c} ({d}%)'
                //                     },
                //                     legend: {
                //                         orient: 'vertical',
                //                         left: 'left'
                //                     },
                //                     series: [
                //                         {
                //                             type: 'pie',
                //                             radius: '55%',
                //                             center: ['50%', '60%'],
                //                             data: pArray,
                //                             emphasis: {
                //                                 itemStyle: {
                //                                     shadowBlur: 10,
                //                                     shadowOffsetX: 0,
                //                                     shadowColor: 'rgba(0, 0, 0, 0.5)'
                //                                 }
                //                             }
                //                         }
                //                     ]
                //                 };
                //             }
                //             statistic.setOption(option,true);
                //             window.onresize = function() {
                //                 statistic.resize();
                //             };
                //         }
                //     });
                // })
            },
            contentStyleChange() {
                this.contentSearchStyleChange()
                this.contentBtnAdAllStyleChange()
                this.contentSearchBtnStyleChange()
                this.contentTableBtnStyleChange()
                this.contentPageStyleChange()
            },
            contentSearchStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.form-content .slt .el-input__inner').forEach(el => {
                        let textAlign = 'left'
                        if(this.contents.inputFontPosition == 2)
                            textAlign = 'center'
                            if (this.contents.inputFontPosition == 3) textAlign = 'right'
                                el.style.textAlign = textAlign
                            el.style.height = this.contents.inputHeight
                            el.style.lineHeight = this.contents.inputHeight
                            el.style.color = this.contents.inputFontColor
                            el.style.fontSize = this.contents.inputFontSize
                            el.style.borderWidth = this.contents.inputBorderWidth
                            el.style.borderStyle = this.contents.inputBorderStyle
                            el.style.borderColor = this.contents.inputBorderColor
                            el.style.borderRadius = this.contents.inputBorderRadius
                            el.style.backgroundColor = this.contents.inputBgColor
                    })
                    if (this.contents.inputTitle) {
                        document.querySelectorAll('.form-content .slt .el-form-item__label').forEach(el => {
                            el.style.color = this.contents.inputTitleColor
                            el.style.fontSize = this.contents.inputTitleSize
                            el.style.lineHeight = this.contents.inputHeight
                        })
                    }
                    setTimeout(() => {
                        document.querySelectorAll('.form-content .slt .el-input__prefix').forEach(el => {
                            el.style.color = this.contents.inputIconColor
                            el.style.lineHeight = this.contents.inputHeight
                        })
                        document.querySelectorAll('.form-content .slt .el-input__suffix').forEach(el => {
                            el.style.color = this.contents.inputIconColor
                            el.style.lineHeight = this.contents.inputHeight
                        })
                        document.querySelectorAll('.form-content .slt .el-input__icon').forEach(el => {
                            el.style.lineHeight = this.contents.inputHeight
                        })
                    }, 10 )
                })
            },
            // 搜索按钮
            contentSearchBtnStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.form-content .slt .el-button--success').forEach(el => {
                        el.style.height = this.contents.searchBtnHeight
                        el.style.color = this.contents.searchBtnFontColor
                        el.style.fontSize = this.contents.searchBtnFontSize
                        el.style.borderWidth = this.contents.searchBtnBorderWidth
                        el.style.borderStyle = this.contents.searchBtnBorderStyle
                        el.style.borderColor = this.contents.searchBtnBorderColor
                        el.style.borderRadius = this.contents.searchBtnBorderRadius
                        el.style.backgroundColor = this.contents.searchBtnBgColor
                    })
                })
            },
            // 新增、批量删除
            contentBtnAdAllStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.form-content .ad .el-button--success').forEach(el => {
                        el.style.height = this.contents.btnAdAllHeight
                        el.style.color = this.contents.btnAdAllAddFontColor
                        el.style.fontSize = this.contents.btnAdAllFontSize
                        el.style.borderWidth = this.contents.btnAdAllBorderWidth
                        el.style.borderStyle = this.contents.btnAdAllBorderStyle
                        el.style.borderColor = this.contents.btnAdAllBorderColor
                        el.style.borderRadius = this.contents.btnAdAllBorderRadius
                        el.style.backgroundColor = this.contents.btnAdAllAddBgColor
                    })
                    document.querySelectorAll('.form-content .ad .el-button--danger').forEach(el => {
                        el.style.height = this.contents.btnAdAllHeight
                        el.style.color = this.contents.btnAdAllDelFontColor
                        el.style.fontSize = this.contents.btnAdAllFontSize
                        el.style.borderWidth = this.contents.btnAdAllBorderWidth
                        el.style.borderStyle = this.contents.btnAdAllBorderStyle
                        el.style.borderColor = this.contents.btnAdAllBorderColor
                        el.style.borderRadius = this.contents.btnAdAllBorderRadius
                        el.style.backgroundColor = this.contents.btnAdAllDelBgColor
                    })
                    document.querySelectorAll('.form-content .ad .el-button--warning').forEach(el => {
                        el.style.height = this.contents.btnAdAllHeight
                        el.style.color = this.contents.btnAdAllWarnFontColor
                        el.style.fontSize = this.contents.btnAdAllFontSize
                        el.style.borderWidth = this.contents.btnAdAllBorderWidth
                        el.style.borderStyle = this.contents.btnAdAllBorderStyle
                        el.style.borderColor = this.contents.btnAdAllBorderColor
                        el.style.borderRadius = this.contents.btnAdAllBorderRadius
                        el.style.backgroundColor = this.contents.btnAdAllWarnBgColor
                    })
                })
            },
            // 表格
            rowStyle({row, rowIndex}) {
                if (rowIndex % 2 == 1) {
                    if (this.contents.tableStripe) {
                        return {color: this.contents.tableStripeFontColor}
                    }
                } else {
                    return ''
                }
            },
            cellStyle({row, rowIndex}) {
                if (rowIndex % 2 == 1) {
                    if (this.contents.tableStripe) {
                        return {backgroundColor: this.contents.tableStripeBgColor}
                    }
                } else {
                    return ''
                }
            },
            headerRowStyle({row, rowIndex}) {
                return {color: this.contents.tableHeaderFontColor}
            },
            headerCellStyle({row, rowIndex}) {
                return {backgroundColor: this.contents.tableHeaderBgColor}
            },
            // 表格按钮
            contentTableBtnStyleChange() {
                // this.$nextTick(()=>{
                //   setTimeout(()=>{
                //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--success').forEach(el=>{
                //       el.style.height = this.contents.tableBtnHeight
                //       el.style.color = this.contents.tableBtnDetailFontColor
                //       el.style.fontSize = this.contents.tableBtnFontSize
                //       el.style.borderWidth = this.contents.tableBtnBorderWidth
                //       el.style.borderStyle = this.contents.tableBtnBorderStyle
                //       el.style.borderColor = this.contents.tableBtnBorderColor
                //       el.style.borderRadius = this.contents.tableBtnBorderRadius
                //       el.style.backgroundColor = this.contents.tableBtnDetailBgColor
                //     })
                //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--primary').forEach(el=>{
                //       el.style.height = this.contents.tableBtnHeight
                //       el.style.color = this.contents.tableBtnEditFontColor
                //       el.style.fontSize = this.contents.tableBtnFontSize
                //       el.style.borderWidth = this.contents.tableBtnBorderWidth
                //       el.style.borderStyle = this.contents.tableBtnBorderStyle
                //       el.style.borderColor = this.contents.tableBtnBorderColor
                //       el.style.borderRadius = this.contents.tableBtnBorderRadius
                //       el.style.backgroundColor = this.contents.tableBtnEditBgColor
                //     })
                //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--danger').forEach(el=>{
                //       el.style.height = this.contents.tableBtnHeight
                //       el.style.color = this.contents.tableBtnDelFontColor
                //       el.style.fontSize = this.contents.tableBtnFontSize
                //       el.style.borderWidth = this.contents.tableBtnBorderWidth
                //       el.style.borderStyle = this.contents.tableBtnBorderStyle
                //       el.style.borderColor = this.contents.tableBtnBorderColor
                //       el.style.borderRadius = this.contents.tableBtnBorderRadius
                //       el.style.backgroundColor = this.contents.tableBtnDelBgColor
                //     })

                //   }, 50)
                // })
            },
            // 分页
            contentPageStyleChange() {
                let arr = []
                if (this.contents.pageTotal) arr.push('total')
                if (this.contents.pageSizes) arr.push('sizes')
                if (this.contents.pagePrevNext) {
                    arr.push('prev')
                    if (this.contents.pagePager) arr.push('pager')
                    arr.push('next')
                }
                if (this.contents.pageJumper) arr.push('jumper')
                this.layouts = arr.join()
                this.contents.pageEachNum = 10
            },

            init() {
            },
            search() {
                this.pageIndex = 1;
                this.getDataList();
            },
            // 获取数据列表
            getDataList() {
                this.dataListLoading = true;
                let params = {
                    page: this.pageIndex,
                    limit: this.pageSize,
                    sort: 'id',
                    forumStateTypes:1
                }

                                         
                if (this.searchForm.shangjiaName!= '' && this.searchForm.shangjiaName!= undefined) {
                    params['shangjiaName'] = '%' + this.searchForm.shangjiaName + '%'
                }
                                                                                                                                                                                                         
                if (this.searchForm.yonghuUuidNumber!= '' && this.searchForm.yonghuUuidNumber!= undefined) {
                    params['yonghuUuidNumber'] = '%' + this.searchForm.yonghuUuidNumber + '%'
                }
                     
                if (this.searchForm.yonghuName!= '' && this.searchForm.yonghuName!= undefined) {
                    params['yonghuName'] = '%' + this.searchForm.yonghuName + '%'
                }
                                                                                                                                                                                                                                             
                if (this.searchForm.forumName!= '' && this.searchForm.forumName!= undefined) {
                    params['forumName'] = '%' + this.searchForm.forumName + '%'
                }
                                                                        
                params['forumDelete'] = 1// 逻辑删除字段 1 未删除 2 删除


                this.$http({
                    url: "forum/list",
                    method: "get",
                    params: params
                }).then(({data}) => {
                    if(data && data.code === 0){
                        this.dataList = data.data.list;
                        this.totalPage = data.data.total;
                    }else{
                        this.dataList = [];
                        this.totalPage = 0;
                    }
                    this.dataListLoading = false;
                });

                //查询级联表搜索条件所有列表
                //查询当前表搜索条件所有列表
            },
            //每页数
            sizeChangeHandle(val) {
                this.pageSize = val;
                this.pageIndex = 1;
                this.getDataList();
            },
            // 当前页
            currentChangeHandle(val) {
                this.pageIndex = val;
                this.getDataList();
            },
            // 多选
            selectionChangeHandler(val) {
                this.dataListSelections = val;
            },
            // 添加/修改
            addOrUpdateHandler(id, type) {
                this.showFlag = false;
                this.addOrUpdateFlag = true;
                this.crossAddOrUpdateFlag = false;
                if (type != 'info') {
                    type = 'else';
                }
                this.$nextTick(() => {
                    this.$refs.addOrUpdate.init(id, type);
                });
            },
            // 下载
            download(file) {
                window.open(" ${file} ")
            },
            // 弹出打印模态框
            dayinOpen(item) {
                let _this = this;
                _this.printVisiable = true;
                _this.printFrom=item;
            },
            // 打印内容
            printContent() {
                let _this = this;
                _this.$print(_this.$refs.printContent)
                _this.printVisiable = false;
            },
            // 删除
            deleteHandler(id) {
                var ids = id ? [Number(id)] : this.dataListSelections.map(item => {
                    return Number(item.id);
                });

                this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(() => {
                    this.$http({
                        url: "forum/delete",
                        method: "post",
                        data: ids
                    }).then(({data}) => {
                        if(data && data.code === 0){
                            this.$message({
                                message: "操作成功",
                                type: "success",
                                duration: 1500,
                                onClose: () => {
                                    this.forumReplyDialogVisible = false;
                                    this.search();
                                }
                            });
                        }else{
                            this.$message.error(data.msg);
                        }
                    });
                });
            },
            // 导入功能上传文件成功后调用导入方法
            forumUploadSuccess(data){
                let _this = this;
                _this.$http({
                    url: "forum/batchInsert?fileName=" + data.file,
                    method: "get"
                }).then(({data}) => {
                    if(data && data.code === 0){
                        _this.$message({
                            message: "导入交流论坛数据成功",
                            type: "success",
                            duration: 1500,
                            onClose: () => {
                                _this.search();
                            }
                        });
                    }else{
                        _this.$message.error(data.msg);
                    }
                });

            },
            // 导入功能上传文件失败后调用导入方法
            forumUploadError(data){
                this.$message.error('上传失败');
            },
	            // 打开回帖模态框
            openReplyForum(id,forumName,forumContent) {
                let _this = this;
            // 当前帖子相关 start
                _this.superIds = id;
                _this.forumTitle = forumName;
                _this.forumContent = forumContent.replace("<img","<img  style=\"width:100%\"").replace("src=\"upload/","src=\""+_this.$base.url+ "upload/");
            // 当前帖子相关 end
                _this.forumReplyContent = "";//帖子回复
                _this.forumReplyDialogVisible = true;//论坛回复模态框
                _this.forumReplyInfoDialogVisible = false;//论坛回复详情模态框


                // 查看当前帖子的回复列表
                let params = {
                    page: 1,
                    limit: 10000,
                    sort: 'id',
                    forumStateTypes:2,
                    superIds:_this.superIds
                }
                _this.$http({
                    url: "forum/list",
                    method: "get",
                    params: params
                }).then(({data}) => {
                    if (data && data.code === 0) {
                        _this.forumData = [];
                        data.data.list.forEach(el=>{
                            let forum  = {};
                            forum.id = el.id;
                            forum.forumName = el.forumName;
                            forum.yonghuId = el.yonghuId;//---
                            forum.yonghuUuidNumber = el.yonghuUuidNumber;
                            forum.yonghuName = el.yonghuName;
                            forum.yonghuPhone = el.yonghuPhone;
                            forum.yonghuIdNumber = el.yonghuIdNumber;
                            forum.yonghuPhoto = el.yonghuPhoto;
                            forum.yonghuEmail = el.yonghuEmail;
                            forum.newMoney = el.newMoney;
                            forum.createTime = el.createTime;
                            forum.shangjiaId = el.shangjiaId;//---
                            forum.shangjiaName = el.shangjiaName;
                            forum.shangjiaPhone = el.shangjiaPhone;
                            forum.shangjiaEmail = el.shangjiaEmail;
                            forum.shangjiaPhoto = el.shangjiaPhoto;
                            forum.shangjiaXingjiTypes = el.shangjiaXingjiTypes;
                            forum.newMoney = el.newMoney;
                            forum.shangjiaContent = el.shangjiaContent;
                            forum.shangjiaDelete = el.shangjiaDelete;
                            forum.createTime = el.createTime;
                            forum.usersId = el.usersId;//---
                            forum.username = el.username;
                            forum.password = el.password;
                            forum.role = el.role;
                            forum.addtime = el.addtime;
                            forum.forumContent = el.forumContent;
                            forum.superIds = el.superIds;
                            forum.forumStateTypes = el.forumStateTypes;
                            forum.insertTime = el.insertTime;
                            forum.updateTime = el.updateTime;
                            forum.createTime = el.createTime;
                            _this.forumData.push(forum);
                        })
                    }
                });
            },

            // 查看某个回复帖子的帖子内容全部
            seeForumContent(forumContent) {
                let _this = this;
                _this.forumReplyInfoContent = forumContent;//帖子某个回复详情 全
                _this.forumReplyInfoDialogVisible = true;//论坛回复详情模态框
            },
            // 删除数据
            deleteForumData(id){
                let _this = this;
                let ids = [];
                ids.push(Number(id));
                _this.$http({
                    url: "forum/delete",
                    method: "post",
                    data: ids
                }).then(({data}) => {
                    if(data && data.code === 0){
                        _this.$message({
                            message: "删除回帖成功",
                            type: "success",
                            duration: 1500,
                            onClose: () => {
                                _this.openReplyForum(_this.superIds,_this.forumTitle,_this.forumContent);
                            }
                        });
                    }else{
                        _this.$message.error(data.msg);
                    }
                });
            },

            // 回帖
            forumReply() {
                let _this = this;
                if(_this.forumReplyContent == ""){
                    alert("请输入回帖内容");
                    return false;
                }
                let data = {"superIds":_this.superIds,"forumStateTypes":2,"forumContent":_this.forumReplyContent,"forumPhoto":_this.forumReplyPhoto};
                _this.$http({
                    url:`forum/save`,
                    method: "post",
                    data: data
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.$message({
                            message: "回帖成功",
                            type: "success",
                            duration: 1500,
                            onClose: () => {
                                _this.openReplyForum(_this.superIds,_this.forumTitle,_this.forumContent);
                            }
                        });
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            //无用
            wuyong(id) {
                let _this = this;
                _this.$confirm(`确定    操作?`, "提示", {confirmButtonText: "确定",cancelButtonText: "取消",type: "warning"
                }).then(() => {
                    _this.$http({
                        url: "forum/update",
                        method: "post",
                        data: {
                            id:id,
//                            forumTypes:forumTypes,
                        }
                    }).then(({data}) => {
                        if(data && data.code === 0){
                            _this.$message({message: "操作成功",type: "success",duration: 1500,onClose: () => {
                                    _this.search();
                                }});
                        }else{
                            _this.$message.error(data.msg);
                        }
                    });
                });
            },
        }
    };
</script>
<style lang="scss" scoped>
.slt {
    margin: 0 !important;
    display: flex;
  }

  .ad {
    margin: 0 !important;
    display: flex;
  }

  .pages {
    & /deep/ el-pagination__sizes{
      & /deep/ el-input__inner {
        height: 22px;
        line-height: 22px;
      }
    }
  }


  .el-button+.el-button {
    margin:0;
  }

  .tables {
	& /deep/ .el-button--success {
		height: 40px;
		color: #333;
		font-size: 14px;
		border-width: 2px;
		border-style: dashed ;
		border-color: rgba(255, 255, 255, 1);
		border-radius: 20px;
		background-color: var(--publicSubColor);
	}

	& /deep/ .el-button--primary {
		height: 40px;
		color: #333;
		font-size: 14px;
		border-width: 2px;
		border-style: dashed ;
		border-color: rgba(255, 255, 255, 1);
		border-radius: 20px;
		background-color: var(--publicSubColor);
	}

	& /deep/ .el-button--danger {
		height: 40px;
		color: #333;
		font-size: 14px;
		border-width: 2px;
		border-style: dashed ;
		border-color: rgba(255, 255, 255, 1);
		border-radius: 20px;
		background-color: var(--publicSubColor);
	}

    & /deep/ .el-button {
      margin: 4px;
    }
  }
	.form-content {
		background: transparent;
	}
	.table-content {
		background: transparent;
	}

	.tables /deep/ .el-table__body tr {
				background-color: rgba(255, 255, 255, 1) !important;
				color: rgba(92, 93, 95, 1) !important;
	 }
	.tables /deep/ .el-table__body tr.el-table__row--striped td {
	    background: transparent;
	}
	.tables /deep/ .el-table__body tr.el-table__row--striped {
		background-color: #F5F7FA !important;
		color: #606266 !important;
	}

	.tables /deep/ .el-table__body tr:hover>td {
	   background-color: #f5f5f5 !important;
		   color: #333 !important;
 	}</style>


