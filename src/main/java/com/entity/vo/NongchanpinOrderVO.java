package com.entity.vo;

import com.entity.NongchanpinOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 农产品订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("nongchanpin_order")
public class NongchanpinOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单号
     */

    @TableField(value = "nongchanpin_order_uuid_number")
    private String nongchanpinOrderUuidNumber;


    /**
     * 收获地址
     */

    @TableField(value = "address_id")
    private Integer addressId;


    /**
     * 农产品
     */

    @TableField(value = "nongchanpin_id")
    private Integer nongchanpinId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 购买数量
     */

    @TableField(value = "buy_number")
    private Integer buyNumber;


    /**
     * 实付价格
     */

    @TableField(value = "nongchanpin_order_true_price")
    private Double nongchanpinOrderTruePrice;


    /**
     * 快递公司
     */

    @TableField(value = "nongchanpin_order_courier_name")
    private String nongchanpinOrderCourierName;


    /**
     * 订单快递单号
     */

    @TableField(value = "nongchanpin_order_courier_number")
    private String nongchanpinOrderCourierNumber;


    /**
     * 订单类型
     */

    @TableField(value = "nongchanpin_order_types")
    private Integer nongchanpinOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getNongchanpinOrderUuidNumber() {
        return nongchanpinOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setNongchanpinOrderUuidNumber(String nongchanpinOrderUuidNumber) {
        this.nongchanpinOrderUuidNumber = nongchanpinOrderUuidNumber;
    }
    /**
	 * 设置：收获地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 获取：收获地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 设置：农产品
	 */
    public Integer getNongchanpinId() {
        return nongchanpinId;
    }


    /**
	 * 获取：农产品
	 */

    public void setNongchanpinId(Integer nongchanpinId) {
        this.nongchanpinId = nongchanpinId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getNongchanpinOrderTruePrice() {
        return nongchanpinOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setNongchanpinOrderTruePrice(Double nongchanpinOrderTruePrice) {
        this.nongchanpinOrderTruePrice = nongchanpinOrderTruePrice;
    }
    /**
	 * 设置：快递公司
	 */
    public String getNongchanpinOrderCourierName() {
        return nongchanpinOrderCourierName;
    }


    /**
	 * 获取：快递公司
	 */

    public void setNongchanpinOrderCourierName(String nongchanpinOrderCourierName) {
        this.nongchanpinOrderCourierName = nongchanpinOrderCourierName;
    }
    /**
	 * 设置：订单快递单号
	 */
    public String getNongchanpinOrderCourierNumber() {
        return nongchanpinOrderCourierNumber;
    }


    /**
	 * 获取：订单快递单号
	 */

    public void setNongchanpinOrderCourierNumber(String nongchanpinOrderCourierNumber) {
        this.nongchanpinOrderCourierNumber = nongchanpinOrderCourierNumber;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getNongchanpinOrderTypes() {
        return nongchanpinOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setNongchanpinOrderTypes(Integer nongchanpinOrderTypes) {
        this.nongchanpinOrderTypes = nongchanpinOrderTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
