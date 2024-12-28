package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.NongchanpinOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 农产品订单
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("nongchanpin_order")
public class NongchanpinOrderView extends NongchanpinOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String nongchanpinOrderValue;

	//级联表 收货地址
					 
		/**
		* 收货地址 的 创建用户
		*/
		@ColumnInfo(comment="创建用户",type="int(20)")
		private Integer addressYonghuId;
		/**
		* 收货人
		*/

		@ColumnInfo(comment="收货人",type="varchar(200)")
		private String addressName;
		/**
		* 电话
		*/

		@ColumnInfo(comment="电话",type="varchar(200)")
		private String addressPhone;
		/**
		* 地址
		*/

		@ColumnInfo(comment="地址",type="varchar(200)")
		private String addressDizhi;
		/**
		* 是否默认地址
		*/
		@ColumnInfo(comment="是否默认地址",type="int(11)")
		private Integer isdefaultTypes;
			/**
			* 是否默认地址的值
			*/
			@ColumnInfo(comment="是否默认地址的字典表值",type="varchar(200)")
			private String isdefaultValue;
	//级联表 农产品
					 
		/**
		* 农产品 的 商家
		*/
		@ColumnInfo(comment="商家",type="int(11)")
		private Integer nongchanpinShangjiaId;
		/**
		* 农产品名称
		*/

		@ColumnInfo(comment="农产品名称",type="varchar(200)")
		private String nongchanpinName;
		/**
		* 农产品照片
		*/

		@ColumnInfo(comment="农产品照片",type="varchar(200)")
		private String nongchanpinPhoto;
		/**
		* 农产品类型
		*/
		@ColumnInfo(comment="农产品类型",type="int(11)")
		private Integer nongchanpinTypes;
			/**
			* 农产品类型的值
			*/
			@ColumnInfo(comment="农产品类型的字典表值",type="varchar(200)")
			private String nongchanpinValue;
		/**
		* 农产品库存
		*/

		@ColumnInfo(comment="农产品库存",type="int(11)")
		private Integer nongchanpinKucunNumber;
		/**
		* 农产品原价
		*/
		@ColumnInfo(comment="农产品原价",type="decimal(10,2)")
		private Double nongchanpinOldMoney;
		/**
		* 现价
		*/
		@ColumnInfo(comment="现价",type="decimal(10,2)")
		private Double nongchanpinNewMoney;
		/**
		* 点击次数
		*/

		@ColumnInfo(comment="点击次数",type="int(11)")
		private Integer nongchanpinClicknum;
		/**
		* 农产品介绍
		*/

		@ColumnInfo(comment="农产品介绍",type="text")
		private String nongchanpinContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer nongchanpinDelete;
	//级联表 用户
		/**
		* 用户编号
		*/

		@ColumnInfo(comment="用户编号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;



	public NongchanpinOrderView() {

	}

	public NongchanpinOrderView(NongchanpinOrderEntity nongchanpinOrderEntity) {
		try {
			BeanUtils.copyProperties(this, nongchanpinOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getNongchanpinOrderValue() {
		return nongchanpinOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setNongchanpinOrderValue(String nongchanpinOrderValue) {
		this.nongchanpinOrderValue = nongchanpinOrderValue;
	}


	//级联表的get和set 收货地址
		/**
		* 获取：收货地址 的 创建用户
		*/
		public Integer getAddressYonghuId() {
			return addressYonghuId;
		}
		/**
		* 设置：收货地址 的 创建用户
		*/
		public void setAddressYonghuId(Integer addressYonghuId) {
			this.addressYonghuId = addressYonghuId;
		}

		/**
		* 获取： 收货人
		*/
		public String getAddressName() {
			return addressName;
		}
		/**
		* 设置： 收货人
		*/
		public void setAddressName(String addressName) {
			this.addressName = addressName;
		}

		/**
		* 获取： 电话
		*/
		public String getAddressPhone() {
			return addressPhone;
		}
		/**
		* 设置： 电话
		*/
		public void setAddressPhone(String addressPhone) {
			this.addressPhone = addressPhone;
		}

		/**
		* 获取： 地址
		*/
		public String getAddressDizhi() {
			return addressDizhi;
		}
		/**
		* 设置： 地址
		*/
		public void setAddressDizhi(String addressDizhi) {
			this.addressDizhi = addressDizhi;
		}
		/**
		* 获取： 是否默认地址
		*/
		public Integer getIsdefaultTypes() {
			return isdefaultTypes;
		}
		/**
		* 设置： 是否默认地址
		*/
		public void setIsdefaultTypes(Integer isdefaultTypes) {
			this.isdefaultTypes = isdefaultTypes;
		}


			/**
			* 获取： 是否默认地址的值
			*/
			public String getIsdefaultValue() {
				return isdefaultValue;
			}
			/**
			* 设置： 是否默认地址的值
			*/
			public void setIsdefaultValue(String isdefaultValue) {
				this.isdefaultValue = isdefaultValue;
			}
	//级联表的get和set 农产品
		/**
		* 获取：农产品 的 商家
		*/
		public Integer getNongchanpinShangjiaId() {
			return nongchanpinShangjiaId;
		}
		/**
		* 设置：农产品 的 商家
		*/
		public void setNongchanpinShangjiaId(Integer nongchanpinShangjiaId) {
			this.nongchanpinShangjiaId = nongchanpinShangjiaId;
		}

		/**
		* 获取： 农产品名称
		*/
		public String getNongchanpinName() {
			return nongchanpinName;
		}
		/**
		* 设置： 农产品名称
		*/
		public void setNongchanpinName(String nongchanpinName) {
			this.nongchanpinName = nongchanpinName;
		}

		/**
		* 获取： 农产品照片
		*/
		public String getNongchanpinPhoto() {
			return nongchanpinPhoto;
		}
		/**
		* 设置： 农产品照片
		*/
		public void setNongchanpinPhoto(String nongchanpinPhoto) {
			this.nongchanpinPhoto = nongchanpinPhoto;
		}
		/**
		* 获取： 农产品类型
		*/
		public Integer getNongchanpinTypes() {
			return nongchanpinTypes;
		}
		/**
		* 设置： 农产品类型
		*/
		public void setNongchanpinTypes(Integer nongchanpinTypes) {
			this.nongchanpinTypes = nongchanpinTypes;
		}


			/**
			* 获取： 农产品类型的值
			*/
			public String getNongchanpinValue() {
				return nongchanpinValue;
			}
			/**
			* 设置： 农产品类型的值
			*/
			public void setNongchanpinValue(String nongchanpinValue) {
				this.nongchanpinValue = nongchanpinValue;
			}

		/**
		* 获取： 农产品库存
		*/
		public Integer getNongchanpinKucunNumber() {
			return nongchanpinKucunNumber;
		}
		/**
		* 设置： 农产品库存
		*/
		public void setNongchanpinKucunNumber(Integer nongchanpinKucunNumber) {
			this.nongchanpinKucunNumber = nongchanpinKucunNumber;
		}

		/**
		* 获取： 农产品原价
		*/
		public Double getNongchanpinOldMoney() {
			return nongchanpinOldMoney;
		}
		/**
		* 设置： 农产品原价
		*/
		public void setNongchanpinOldMoney(Double nongchanpinOldMoney) {
			this.nongchanpinOldMoney = nongchanpinOldMoney;
		}

		/**
		* 获取： 现价
		*/
		public Double getNongchanpinNewMoney() {
			return nongchanpinNewMoney;
		}
		/**
		* 设置： 现价
		*/
		public void setNongchanpinNewMoney(Double nongchanpinNewMoney) {
			this.nongchanpinNewMoney = nongchanpinNewMoney;
		}

		/**
		* 获取： 点击次数
		*/
		public Integer getNongchanpinClicknum() {
			return nongchanpinClicknum;
		}
		/**
		* 设置： 点击次数
		*/
		public void setNongchanpinClicknum(Integer nongchanpinClicknum) {
			this.nongchanpinClicknum = nongchanpinClicknum;
		}

		/**
		* 获取： 农产品介绍
		*/
		public String getNongchanpinContent() {
			return nongchanpinContent;
		}
		/**
		* 设置： 农产品介绍
		*/
		public void setNongchanpinContent(String nongchanpinContent) {
			this.nongchanpinContent = nongchanpinContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getNongchanpinDelete() {
			return nongchanpinDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setNongchanpinDelete(Integer nongchanpinDelete) {
			this.nongchanpinDelete = nongchanpinDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户编号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 用户编号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}


	@Override
	public String toString() {
		return "NongchanpinOrderView{" +
			", nongchanpinOrderValue=" + nongchanpinOrderValue +
			", addressName=" + addressName +
			", addressPhone=" + addressPhone +
			", addressDizhi=" + addressDizhi +
			", nongchanpinName=" + nongchanpinName +
			", nongchanpinPhoto=" + nongchanpinPhoto +
			", nongchanpinKucunNumber=" + nongchanpinKucunNumber +
			", nongchanpinOldMoney=" + nongchanpinOldMoney +
			", nongchanpinNewMoney=" + nongchanpinNewMoney +
			", nongchanpinClicknum=" + nongchanpinClicknum +
			", nongchanpinContent=" + nongchanpinContent +
			", nongchanpinDelete=" + nongchanpinDelete +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
