package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 农产品订单
 *
 * @author 
 * @email
 */
@TableName("nongchanpin_order")
public class NongchanpinOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public NongchanpinOrderEntity() {

	}

	public NongchanpinOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单号
     */
    @ColumnInfo(comment="订单号",type="varchar(200)")
    @TableField(value = "nongchanpin_order_uuid_number")

    private String nongchanpinOrderUuidNumber;


    /**
     * 收获地址
     */
    @ColumnInfo(comment="收获地址",type="int(11)")
    @TableField(value = "address_id")

    private Integer addressId;


    /**
     * 农产品
     */
    @ColumnInfo(comment="农产品",type="int(11)")
    @TableField(value = "nongchanpin_id")

    private Integer nongchanpinId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 购买数量
     */
    @ColumnInfo(comment="购买数量",type="int(11)")
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "nongchanpin_order_true_price")

    private Double nongchanpinOrderTruePrice;


    /**
     * 快递公司
     */
    @ColumnInfo(comment="快递公司",type="varchar(200)")
    @TableField(value = "nongchanpin_order_courier_name")

    private String nongchanpinOrderCourierName;


    /**
     * 订单快递单号
     */
    @ColumnInfo(comment="订单快递单号",type="varchar(200)")
    @TableField(value = "nongchanpin_order_courier_number")

    private String nongchanpinOrderCourierNumber;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "nongchanpin_order_types")

    private Integer nongchanpinOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单号
	 */
    public String getNongchanpinOrderUuidNumber() {
        return nongchanpinOrderUuidNumber;
    }
    /**
	 * 设置：订单号
	 */

    public void setNongchanpinOrderUuidNumber(String nongchanpinOrderUuidNumber) {
        this.nongchanpinOrderUuidNumber = nongchanpinOrderUuidNumber;
    }
    /**
	 * 获取：收获地址
	 */
    public Integer getAddressId() {
        return addressId;
    }
    /**
	 * 设置：收获地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 获取：农产品
	 */
    public Integer getNongchanpinId() {
        return nongchanpinId;
    }
    /**
	 * 设置：农产品
	 */

    public void setNongchanpinId(Integer nongchanpinId) {
        this.nongchanpinId = nongchanpinId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }
    /**
	 * 设置：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getNongchanpinOrderTruePrice() {
        return nongchanpinOrderTruePrice;
    }
    /**
	 * 设置：实付价格
	 */

    public void setNongchanpinOrderTruePrice(Double nongchanpinOrderTruePrice) {
        this.nongchanpinOrderTruePrice = nongchanpinOrderTruePrice;
    }
    /**
	 * 获取：快递公司
	 */
    public String getNongchanpinOrderCourierName() {
        return nongchanpinOrderCourierName;
    }
    /**
	 * 设置：快递公司
	 */

    public void setNongchanpinOrderCourierName(String nongchanpinOrderCourierName) {
        this.nongchanpinOrderCourierName = nongchanpinOrderCourierName;
    }
    /**
	 * 获取：订单快递单号
	 */
    public String getNongchanpinOrderCourierNumber() {
        return nongchanpinOrderCourierNumber;
    }
    /**
	 * 设置：订单快递单号
	 */

    public void setNongchanpinOrderCourierNumber(String nongchanpinOrderCourierNumber) {
        this.nongchanpinOrderCourierNumber = nongchanpinOrderCourierNumber;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getNongchanpinOrderTypes() {
        return nongchanpinOrderTypes;
    }
    /**
	 * 设置：订单类型
	 */

    public void setNongchanpinOrderTypes(Integer nongchanpinOrderTypes) {
        this.nongchanpinOrderTypes = nongchanpinOrderTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "NongchanpinOrder{" +
            ", id=" + id +
            ", nongchanpinOrderUuidNumber=" + nongchanpinOrderUuidNumber +
            ", addressId=" + addressId +
            ", nongchanpinId=" + nongchanpinId +
            ", yonghuId=" + yonghuId +
            ", buyNumber=" + buyNumber +
            ", nongchanpinOrderTruePrice=" + nongchanpinOrderTruePrice +
            ", nongchanpinOrderCourierName=" + nongchanpinOrderCourierName +
            ", nongchanpinOrderCourierNumber=" + nongchanpinOrderCourierNumber +
            ", nongchanpinOrderTypes=" + nongchanpinOrderTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
