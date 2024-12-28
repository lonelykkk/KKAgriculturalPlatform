package com.entity.model;

import com.entity.NongchanpinOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 农产品订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class NongchanpinOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String nongchanpinOrderUuidNumber;


    /**
     * 收获地址
     */
    private Integer addressId;


    /**
     * 农产品
     */
    private Integer nongchanpinId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 购买数量
     */
    private Integer buyNumber;


    /**
     * 实付价格
     */
    private Double nongchanpinOrderTruePrice;


    /**
     * 快递公司
     */
    private String nongchanpinOrderCourierName;


    /**
     * 订单快递单号
     */
    private String nongchanpinOrderCourierNumber;


    /**
     * 订单类型
     */
    private Integer nongchanpinOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
