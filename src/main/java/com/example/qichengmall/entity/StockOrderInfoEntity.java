package com.example.qichengmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 库存销售订单详情
 * 
 * @author HuChangQi
 * @email 1029812802@qq.com
 * @date 2023-04-28 13:28:34
 */
@Data
@TableName("erp_stock_order_info")
public class StockOrderInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * stock_order id
	 */
	private Integer stockOrderId;
	/**
	 * 商品id
	 */
	private Integer productId;
	/**
	 * 销售订单上的数量
	 */
	private Integer number;
	/**
	 * 
	 */
	private String createdAt;
	/**
	 * 
	 */
	private String updatedAt;
	/**
	 * 
	 */
	private Float price;
	/**
	 * 已发货数量
	 */
	private Integer sendNum;
	/**
	 * 0正常1删除2取消
	 */
	private Integer flag;
	/**
	 * 0:普通,其他:限时特价的id
	 */
	private String specialId;
	/**
	 * 0:普通,其他:套餐spu的id
	 */
	private Integer unionId;
	/**
	 * 下单的套餐数量
	 */
	private Integer unionNumber;
	/**
	 * 原价
	 */
	private BigDecimal originPrice;
	/**
	 * 会员优惠
	 */
	private BigDecimal vipDiscount;
	/**
	 * 商品类型  0 普通商品 1 赠品 2 换购商品
	 */
	private Integer activitySkuType;
	/**
	 * 活动id
	 */
	private Integer activityId;
	/**
	 * 当前活动  none 不参加
	 */
	private String activityDesc;
	/**
	 * 换购价
	 */
	private BigDecimal increasePrice;
	/**
	 * 完税总价格
	 */
	private String taxprice;
	/**
	 * 应征关税
	 */
	private String customstax;
	/**
	 * 应征增值税
	 */
	private String valueaddedtax;
	/**
	 * 应征消费税
	 */
	private String consumptiontax;

}
