
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 农产品订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/nongchanpinOrder")
public class NongchanpinOrderController {
    private static final Logger logger = LoggerFactory.getLogger(NongchanpinOrderController.class);

    private static final String TABLE_NAME = "nongchanpinOrder";

    @Autowired
    private NongchanpinOrderService nongchanpinOrderService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//交流论坛
    @Autowired
    private GonggaoService gonggaoService;//公告信息
    @Autowired
    private NongchanpinService nongchanpinService;//农产品
    @Autowired
    private NongchanpinCollectionService nongchanpinCollectionService;//农产品收藏
    @Autowired
    private NongchanpinCommentbackService nongchanpinCommentbackService;//农产品评价
    @Autowired
    private ShangjiaService shangjiaService;//商家
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("商家".equals(role))
            params.put("shangjiaId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = nongchanpinOrderService.queryPage(params);

        //字典表数据转换
        List<NongchanpinOrderView> list =(List<NongchanpinOrderView>)page.getList();
        for(NongchanpinOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        NongchanpinOrderEntity nongchanpinOrder = nongchanpinOrderService.selectById(id);
        if(nongchanpinOrder !=null){
            //entity转view
            NongchanpinOrderView view = new NongchanpinOrderView();
            BeanUtils.copyProperties( nongchanpinOrder , view );//把实体数据重构到view中
            //级联表 收货地址
            //级联表
            AddressEntity address = addressService.selectById(nongchanpinOrder.getAddressId());
            if(address != null){
            BeanUtils.copyProperties( address , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setAddressId(address.getId());
            }
            //级联表 农产品
            //级联表
            NongchanpinEntity nongchanpin = nongchanpinService.selectById(nongchanpinOrder.getNongchanpinId());
            if(nongchanpin != null){
            BeanUtils.copyProperties( nongchanpin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setNongchanpinId(nongchanpin.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(nongchanpinOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody NongchanpinOrderEntity nongchanpinOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,nongchanpinOrder:{}",this.getClass().getName(),nongchanpinOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            nongchanpinOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        nongchanpinOrder.setCreateTime(new Date());
        nongchanpinOrder.setInsertTime(new Date());
        nongchanpinOrderService.insert(nongchanpinOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody NongchanpinOrderEntity nongchanpinOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,nongchanpinOrder:{}",this.getClass().getName(),nongchanpinOrder.toString());
        NongchanpinOrderEntity oldNongchanpinOrderEntity = nongchanpinOrderService.selectById(nongchanpinOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            nongchanpinOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            nongchanpinOrderService.updateById(nongchanpinOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<NongchanpinOrderEntity> oldNongchanpinOrderList =nongchanpinOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        nongchanpinOrderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<NongchanpinOrderEntity> nongchanpinOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            NongchanpinOrderEntity nongchanpinOrderEntity = new NongchanpinOrderEntity();
//                            nongchanpinOrderEntity.setNongchanpinOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            nongchanpinOrderEntity.setAddressId(Integer.valueOf(data.get(0)));   //收获地址 要改的
//                            nongchanpinOrderEntity.setNongchanpinId(Integer.valueOf(data.get(0)));   //农产品 要改的
//                            nongchanpinOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            nongchanpinOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //购买数量 要改的
//                            nongchanpinOrderEntity.setNongchanpinOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            nongchanpinOrderEntity.setNongchanpinOrderCourierName(data.get(0));                    //快递公司 要改的
//                            nongchanpinOrderEntity.setNongchanpinOrderCourierNumber(data.get(0));                    //订单快递单号 要改的
//                            nongchanpinOrderEntity.setNongchanpinOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            nongchanpinOrderEntity.setInsertTime(date);//时间
//                            nongchanpinOrderEntity.setCreateTime(date);//时间
                            nongchanpinOrderList.add(nongchanpinOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("nongchanpinOrderUuidNumber")){
                                    List<String> nongchanpinOrderUuidNumber = seachFields.get("nongchanpinOrderUuidNumber");
                                    nongchanpinOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> nongchanpinOrderUuidNumber = new ArrayList<>();
                                    nongchanpinOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("nongchanpinOrderUuidNumber",nongchanpinOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<NongchanpinOrderEntity> nongchanpinOrderEntities_nongchanpinOrderUuidNumber = nongchanpinOrderService.selectList(new EntityWrapper<NongchanpinOrderEntity>().in("nongchanpin_order_uuid_number", seachFields.get("nongchanpinOrderUuidNumber")));
                        if(nongchanpinOrderEntities_nongchanpinOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(NongchanpinOrderEntity s:nongchanpinOrderEntities_nongchanpinOrderUuidNumber){
                                repeatFields.add(s.getNongchanpinOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        nongchanpinOrderService.insertBatch(nongchanpinOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = nongchanpinOrderService.queryPage(params);

        //字典表数据转换
        List<NongchanpinOrderView> list =(List<NongchanpinOrderView>)page.getList();
        for(NongchanpinOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        NongchanpinOrderEntity nongchanpinOrder = nongchanpinOrderService.selectById(id);
            if(nongchanpinOrder !=null){


                //entity转view
                NongchanpinOrderView view = new NongchanpinOrderView();
                BeanUtils.copyProperties( nongchanpinOrder , view );//把实体数据重构到view中

                //级联表
                    AddressEntity address = addressService.selectById(nongchanpinOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                }
                //级联表
                    NongchanpinEntity nongchanpin = nongchanpinService.selectById(nongchanpinOrder.getNongchanpinId());
                if(nongchanpin != null){
                    BeanUtils.copyProperties( nongchanpin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setNongchanpinId(nongchanpin.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(nongchanpinOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody NongchanpinOrderEntity nongchanpinOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,nongchanpinOrder:{}",this.getClass().getName(),nongchanpinOrder.toString());
            NongchanpinEntity nongchanpinEntity = nongchanpinService.selectById(nongchanpinOrder.getNongchanpinId());
            if(nongchanpinEntity == null){
                return R.error(511,"查不到该农产品");
            }
            // Double nongchanpinNewMoney = nongchanpinEntity.getNongchanpinNewMoney();

            if(false){
            }
            else if(nongchanpinEntity.getNongchanpinNewMoney() == null){
                return R.error(511,"现价不能为空");
            }
            else if((nongchanpinEntity.getNongchanpinKucunNumber() -nongchanpinOrder.getBuyNumber())<0){
                return R.error(511,"购买数量不能大于库存数量");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - nongchanpinEntity.getNongchanpinNewMoney()*nongchanpinOrder.getBuyNumber();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            nongchanpinOrder.setNongchanpinOrderTypes(101); //设置订单状态为已支付
            nongchanpinOrder.setNongchanpinOrderTruePrice(nongchanpinEntity.getNongchanpinNewMoney()*nongchanpinOrder.getBuyNumber()); //设置实付价格
            nongchanpinOrder.setYonghuId(userId); //设置订单支付人id
            nongchanpinOrder.setNongchanpinOrderUuidNumber(String.valueOf(new Date().getTime()));
            nongchanpinOrder.setInsertTime(new Date());
            nongchanpinOrder.setCreateTime(new Date());
                nongchanpinEntity.setNongchanpinKucunNumber( nongchanpinEntity.getNongchanpinKucunNumber() -nongchanpinOrder.getBuyNumber());
                nongchanpinService.updateById(nongchanpinEntity);
                nongchanpinOrderService.insert(nongchanpinOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);

            ShangjiaEntity shangjiaEntity = shangjiaService.selectById(nongchanpinEntity.getShangjiaId());
            shangjiaEntity.setNewMoney(shangjiaEntity.getNewMoney()+nongchanpinOrder.getNongchanpinOrderTruePrice());//动态计算金额
            shangjiaService.updateById(shangjiaEntity);

            return R.ok();
    }
    /**
     * 添加订单
     */
    @RequestMapping("/order")
    public R add(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("order方法:,,Controller:{},,params:{}",this.getClass().getName(),params.toString());
        String nongchanpinOrderUuidNumber = String.valueOf(new Date().getTime());

        //获取当前登录用户的id
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        Integer addressId = Integer.valueOf(String.valueOf(params.get("addressId")));


        String data = String.valueOf(params.get("nongchanpins"));
        JSONArray jsonArray = JSON.parseArray(data);
        List<Map> nongchanpins = JSON.parseObject(jsonArray.toString(), List.class);

        //获取当前登录用户的个人信息
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);

        //当前订单表
        List<NongchanpinOrderEntity> nongchanpinOrderList = new ArrayList<>();
        //商家表
        ArrayList<ShangjiaEntity> shangjiaList = new ArrayList<>();
        //商品表
        List<NongchanpinEntity> nongchanpinList = new ArrayList<>();
        //购物车ids
        List<Integer> cartIds = new ArrayList<>();

        BigDecimal zhekou = new BigDecimal(1.0);

        //循环取出需要的数据
        for (Map<String, Object> map : nongchanpins) {
           //取值
            Integer nongchanpinId = Integer.valueOf(String.valueOf(map.get("nongchanpinId")));//商品id
            Integer buyNumber = Integer.valueOf(String.valueOf(map.get("buyNumber")));//购买数量
            NongchanpinEntity nongchanpinEntity = nongchanpinService.selectById(nongchanpinId);//购买的商品
            String id = String.valueOf(map.get("id"));
            if(StringUtil.isNotEmpty(id))
                cartIds.add(Integer.valueOf(id));
            //获取商家信息
            Integer shangjiaId = nongchanpinEntity.getShangjiaId();
            ShangjiaEntity shangjiaEntity = shangjiaService.selectById(shangjiaId);//商家

            //判断商品的库存是否足够
            if(nongchanpinEntity.getNongchanpinKucunNumber() < buyNumber){
                //商品库存不足直接返回
                return R.error(nongchanpinEntity.getNongchanpinName()+"的库存不足");
            }else{
                //商品库存充足就减库存
                nongchanpinEntity.setNongchanpinKucunNumber(nongchanpinEntity.getNongchanpinKucunNumber() - buyNumber);
            }

            //订单信息表增加数据
            NongchanpinOrderEntity nongchanpinOrderEntity = new NongchanpinOrderEntity<>();

            //赋值订单信息
            nongchanpinOrderEntity.setNongchanpinOrderUuidNumber(nongchanpinOrderUuidNumber);//订单号
            nongchanpinOrderEntity.setAddressId(addressId);//收获地址
            nongchanpinOrderEntity.setNongchanpinId(nongchanpinId);//农产品
                        nongchanpinOrderEntity.setYonghuId(userId);//用户
            nongchanpinOrderEntity.setBuyNumber(buyNumber);//购买数量 ？？？？？？
            nongchanpinOrderEntity.setNongchanpinOrderTypes(101);//订单类型
            nongchanpinOrderEntity.setInsertTime(new Date());//订单创建时间
            nongchanpinOrderEntity.setCreateTime(new Date());//创建时间

            //判断是什么支付方式 1代表余额 2代表积分
//            if(nongchanpinOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = new BigDecimal(nongchanpinEntity.getNongchanpinNewMoney()).multiply(new BigDecimal(buyNumber)).multiply(zhekou).doubleValue();

                if(yonghuEntity.getNewMoney() - money <0 ){
                    return R.error("余额不足,请充值！！！");
                }else{
                    //计算所获得积分
                    Double buyJifen =0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - money); //设置金额


                    nongchanpinOrderEntity.setNongchanpinOrderTruePrice(money);

                    //修改商家余额
                    shangjiaEntity.setNewMoney(shangjiaEntity.getNewMoney()+money);
                }
//            }
            nongchanpinOrderList.add(nongchanpinOrderEntity);
            shangjiaList.add(shangjiaEntity);
            nongchanpinList.add(nongchanpinEntity);

        }
        nongchanpinOrderService.insertBatch(nongchanpinOrderList);
        shangjiaService.updateBatchById(shangjiaList);
        nongchanpinService.updateBatchById(nongchanpinList);
        yonghuService.updateById(yonghuEntity);
        if(cartIds != null && cartIds.size()>0)
            cartService.deleteBatchIds(cartIds);

        return R.ok();
    }


    /**
    * 退款
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            NongchanpinOrderEntity nongchanpinOrder = nongchanpinOrderService.selectById(id);//当前表service
            Integer buyNumber = nongchanpinOrder.getBuyNumber();
            Integer nongchanpinId = nongchanpinOrder.getNongchanpinId();
            if(nongchanpinId == null)
                return R.error(511,"查不到该农产品");
            NongchanpinEntity nongchanpinEntity = nongchanpinService.selectById(nongchanpinId);
            if(nongchanpinEntity == null)
                return R.error(511,"查不到该农产品");
            //获取商家信息
            Integer shangjiaId = nongchanpinEntity.getShangjiaId();
            ShangjiaEntity shangjiaEntity = shangjiaService.selectById(shangjiaId);//商家
            Double nongchanpinNewMoney = nongchanpinEntity.getNongchanpinNewMoney();
            if(nongchanpinNewMoney == null)
                return R.error(511,"农产品价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

                //计算金额
                Double money = nongchanpinEntity.getNongchanpinNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额


                //修改商家余额
                shangjiaEntity.setNewMoney(shangjiaEntity.getNewMoney() - money);

            nongchanpinEntity.setNongchanpinKucunNumber(nongchanpinEntity.getNongchanpinKucunNumber() + buyNumber);

            nongchanpinOrder.setNongchanpinOrderTypes(102);//设置订单状态为已退款
            nongchanpinOrderService.updateAllColumnById(nongchanpinOrder);//根据id更新
            shangjiaService.updateById(shangjiaEntity);
            yonghuService.updateById(yonghuEntity);//更新用户信息
            nongchanpinService.updateById(nongchanpinEntity);//更新订单中农产品的信息

            return R.ok();
    }

    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer nongchanpinCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            NongchanpinOrderEntity nongchanpinOrder = nongchanpinOrderService.selectById(id);
        if(nongchanpinOrder == null)
            return R.error(511,"查不到该订单");
        Integer nongchanpinId = nongchanpinOrder.getNongchanpinId();
        if(nongchanpinId == null)
            return R.error(511,"查不到该农产品");

        NongchanpinCommentbackEntity nongchanpinCommentbackEntity = new NongchanpinCommentbackEntity();
            nongchanpinCommentbackEntity.setId(id);
            nongchanpinCommentbackEntity.setNongchanpinId(nongchanpinId);
            nongchanpinCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            nongchanpinCommentbackEntity.setNongchanpinCommentbackText(commentbackText);
            nongchanpinCommentbackEntity.setInsertTime(new Date());
            nongchanpinCommentbackEntity.setReplyText(null);
            nongchanpinCommentbackEntity.setUpdateTime(null);
            nongchanpinCommentbackEntity.setCreateTime(new Date());
            nongchanpinCommentbackService.insert(nongchanpinCommentbackEntity);

            nongchanpinOrder.setNongchanpinOrderTypes(105);//设置订单状态为已评价
            nongchanpinOrderService.updateById(nongchanpinOrder);//根据id更新
            return R.ok();
    }

    /**
     * 发货
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ,String nongchanpinOrderCourierNumber, String nongchanpinOrderCourierName , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        NongchanpinOrderEntity  nongchanpinOrderEntity = nongchanpinOrderService.selectById(id);
        nongchanpinOrderEntity.setNongchanpinOrderTypes(103);//设置订单状态为已发货
        nongchanpinOrderEntity.setNongchanpinOrderCourierNumber(nongchanpinOrderCourierNumber);
        nongchanpinOrderEntity.setNongchanpinOrderCourierName(nongchanpinOrderCourierName);
        nongchanpinOrderService.updateById( nongchanpinOrderEntity);

        return R.ok();
    }


    /**
     * 收货
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        NongchanpinOrderEntity  nongchanpinOrderEntity = nongchanpinOrderService.selectById(id);
        nongchanpinOrderEntity.setNongchanpinOrderTypes(104);//设置订单状态为收货
        nongchanpinOrderService.updateById( nongchanpinOrderEntity);
        return R.ok();
    }

}

