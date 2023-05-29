package com.example.qichengmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 库存销售订单
 * 
 * @author HuChangQi
 * @email 1029812802@qq.com
 * @date 2023-04-28 13:28:34
 */
@Data
@TableName("erp_stock_order")
public class StockOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 订单编号
	 */
	private String orderNum;
	/**
	 * 在线订单编号
	 */
	private String onlineOrderNum;
	/**
	 * 销售日期
	 */
	private String saleDate;
	/**
	 * 仓库
	 */
	private Integer warehouseId;
	/**
	 * 客户id
	 */
	private Integer userId;
	/**
	 * 收款账户id
	 */
	private Integer account;
	/**
	 * 销售员id
	 */
	private Integer saleUserId;
	/**
	 * 
	 */
	private BigDecimal freight;
	/**
	 * 
	 */
	private BigDecimal substitute;
	/**
	 * 发货备注 0发货1不发货2预定
	 */
	private Integer sendRemark;
	/**
	 * 客户备注
	 */
	private String userRemark;
	/**
	 * 销售备注
	 */
	private String saleRemark;
	/**
	 * 收件人姓名
	 */
	private String name;
	/**
	 * 收件人手机号
	 */
	private String tel;
	/**
	 * 
	 */
	private String phone;
	/**
	 * 
	 */
	private String province;
	/**
	 * 
	 */
	private String city;
	/**
	 * 
	 */
	private String area;
	/**
	 * 
	 */
	private String address;
	/**
	 * 发件人姓名
	 */
	private String sendName;
	/**
	 * 
	 */
	private String sendTel;
	/**
	 * 
	 */
	private String sendProvince;
	/**
	 * 
	 */
	private String sendCity;
	/**
	 * 
	 */
	private String sendArea;
	/**
	 * 
	 */
	private String sendAddress;
	/**
	 * 
	 */
	private String remark;
	/**
	 * 
	 */
	private Integer flag;
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
	private Integer businessId;
	/**
	 * 发货状态 0未发货 1已发货 2发货中3已收货 -1 已出货
	 */
	private Integer sendStatus;
	/**
	 * 0未付款 1已付款
	 */
	private Integer payStatus;
	/**
	 * 
	 */
	private BigDecimal price;
	/**
	 * 
	 */
	private BigDecimal payPrice;
	/**
	 * 0未打印1已打印2部分打印   3 打印收银
	 */
	private Integer printExpress;
	/**
	 * 是否打印配货单
	 */
	private Integer printDistribution;
	/**
	 * 操作人userid
	 */
	private Integer operatorUserId;
	/**
	 * 支付方式 数据字典在admin.php
	 */
	private Integer payMethod;
	/**
	 * 0erp后台添加、1小程序商城添加
	 */
	private Integer insertType;
	/**
	 * 发货人电话
	 */
	private String sendPhone;
	/**
	 * 身份证号码
	 */
	private String idnumber;
	/**
	 * 身份证正面照片
	 */
	private String imagefront;
	/**
	 * 身份证反面照片
	 */
	private String imageback;
	/**
	 * 身份证姓名
	 */
	private String idname;
	/**
	 * erp_shopmp_identity_card的id
	 */
	private Integer identId;
	/**
	 * erp_market_freight的id,用户选择的运费优惠
	 */
	private Integer marketFreightId;
	/**
	 * 优惠前的运费
	 */
	private BigDecimal originFreight;
	/**
	 * 馆区id
	 */
	private Integer mpId;
	/**
	 * 团购订单状态0不是团购单,1拼单中未付款,2拼单中待发货,3拼单成功未付款,4拼单成功待发货,5拼单失败退款中
	 */
	private Integer groupStatus;
	/**
	 * 团购价或团购原价
	 */
	private BigDecimal groupPrice;
	/**
	 * 关联采购订单
	 */
	private Integer relatePurchaseOrder;
	/**
	 * 订单类型 1 商品订单2充值订单
	 */
	private Integer orderType;
	/**
	 * 运费模版组合ID
	 */
	private String freightId;
	/**
	 * 原价
	 */
	private BigDecimal originPrice;
	/**
	 * 会员优惠金额
	 */
	private BigDecimal vipDiscount;
	/**
	 * 批发价优惠金额
	 */
	private BigDecimal tradePriceDiscount;
	/**
	 * 优惠券使用描述
	 */
	private String couponUseDesc;
	/**
	 * 是否是团购订单 0 否 其他是团购id
	 */
	private Integer isGroupBuying;
	/**
	 * 用户的团购记录
	 */
	private Integer userGroupBuyingId;
	/**
	 * 支付时间
	 */
	private String payTime;
	/**
	 * 确认收货时间
	 */
	private String confirmTime;
	/**
	 * 汇付 huifu 通联tonglian
	 */
	private String payCompany;
	/**
	 * 活动优惠详情
	 */
	private String activityDiscount;
	/**
	 * 全场活动详情
	 */
	private String fullActivityDiscount;
	/**
	 * 全场活动id
	 */
	private Integer fullActivityId;
	/**
	 * 全场活动
	 */
	private String fullActivityDesc;
	/**
	 * 快递单编号
	 */
	private String deliverNum;
	/**
	 * 快递类型
	 */
	private Integer expressType;
	/**
	 * 是否独立主体面单
	 */
	private Integer isMainOrder;
	/**
	 * 是否是无需物流 1是 0 否
	 */
	private Integer isNeedOrder;
	/**
	 * 分店id
	 */
	private Integer originBusinessId;
	/**
	 * 是否独立库存订单
	 */
	private Integer isIndependent;
	/**
	 * 门店分账详情
	 */
	private String storesAccount;
	/**
	 * 是否是客户选择的发货地址1是0否
	 */
	private Integer isCustomerSelect;
	/**
	 * 分账明细
	 */
	private String shareDetail;
	/**
	 * 1退款中，2已同意
	 */
	private Integer refundStatus;
	/**
	 * 退款类型，0，无，1仅退款，2退货退款
	 */
	private Integer refundType;
	/**
	 * 留言
	 */
	private String message;
	/**
	 * 税费
	 */
	private BigDecimal tax;
	/**
	 * 是否新人订单
	 */
	private Integer isNewOrder;
	/**
	 * 发货类型
	 */
	private Integer deliveryType;
	/**
	 * 自提点id
	 */
	private Integer pickupSiteId;
	/**
	 * 自提码
	 */
	private String pickupCode;
	/**
	 * 支付订单号
	 */
	private String transactionId;
	/**
	 * 是否境外订单
	 */
	private Integer crossBorder;
	/**
	 * 
	 */
	private Integer defrayPush;
	/**
	 * 
	 */
	private Integer payPush;
	/**
	 * 0未推送1推送成功2推送中待回执3回执失败
	 */
	private Integer orderPush;
	/**
	 * 
	 */
	private Integer logisticsPush;
	/**
	 * 
	 */
	private Integer inventoryPush;
	/**
	 * 撤销推送单状态
	 */
	private Integer cancelPush;
	/**
	 * 退货单状态
	 */
	private Integer refundPush;
	/**
	 * 积分兑换商品/积分id
	 */
	private Integer integralId;
	/**
	 * 积分详情
	 */
	private String integralInfo;
	/**
	 * 订单星级
	 */
	private Integer star;
	/**
	 * 积分获得状态，1表示已获得
	 */
	private Integer scoreStatus;
	/**
	 * 分账类型，与支付类型挂钩，0表示没分账
	 */
	private Integer shareType;
	/**
	 * 1 分账完成
	 */
	private Integer shareComplete;
	/**
	 * 1默认 2自选
	 */
	private Integer expressSelect;
	/**
	 * 导入的优惠
	 */
	private BigDecimal headBusinessId;
	/**
	 * 总店事业部id
	 */
	private Integer headBusiness;
	/**
	 * 
	 */
	private BigDecimal importDiscount;
	/**
	 * 退款 销售单关联
	 */
	private Integer refundOrderId;
	/**
	 * 发货时间
	 */
	private String sendTime;
	/**
	 * 平台下总店是否收账
	 */
	private Integer mainmoney;
	/**
	 * 中间件 0 不是
	 */
	private Integer isMiddleware;
	/**
	 * 是否是平台订单
	 */
	private Integer isPlat;
	/**
	 * 订单关联采购单
	 */
	private Integer purchaseOrder;
	/**
	 * 货物来源 oupai 欧派
	 */
	private String source;
	/**
	 * 
	 */
	private Integer toBusinessId;
	/**
	 * 关联的合并支付单
	 */
	private Integer mergeId;
	/**
	 * 免税金额
	 */
	private BigDecimal freeTaxPrice;
	/**
	 * 帮卖 分销人的 wxuser_id
	 */
	private Integer helpSaleUser;
	/**
	 * 帮卖 分销人的盈利
	 */
	private BigDecimal helpUserPrice;
	/**
	 * 电商平台代码
	 */
	private String ebpcode;
	/**
	 * 电商平台名称
	 */
	private String ebpname;
	/**
	 * 拼多多订单id
	 */
	private Integer pddOrderid;
	/**
	 * 
	 */
	private BigDecimal freightTax;
	/**
	 * 推送到wms系统的状态 0 未推送 1推送成功 2失败
	 */
	private Integer wmsStatus;
	/**
	 * wms 返回的提示
	 */
	private String wmsMsg;
	/**
	 * 推送到wms取消系统的状态 0 未推送 1推送成功 2失败
	 */
	private Integer wmsCancelStatus;
	/**
	 * wms 返回的提示
	 */
	private String wmsCancelMsg;
	/**
	 * 
	 */
	private Integer guideId;
	/**
	 * 分账物流信息采集
	 */
	private Integer pushCross;
	/**
	 * 购买人手机号
	 */
	private String buyPhone;
	/**
	 * 
	 */
	private BigDecimal freeFreightTax;
	/**
	 * 订单来源
	 */
	private Integer fromType;
	/**
	 * 
	 */
	private String pddName;
	/**
	 * 
	 */
	private String pddPhone;
	/**
	 * 
	 */
	private String pddIdnumber;
	/**
	 * 
	 */
	private String pddIdName;
	/**
	 * 
	 */
	private String pddPayNo;
	/**
	 * 
	 */
	private String pddAddress;
	/**
	 * pdd 发货状态
	 */
	private Integer pddSend;
	/**
	 * pdd 物流轨迹 0 1已揽收 2 已签收
	 */
	private Integer pddDeliverStatus;
	/**
	 * 
	 */
	private Integer ccType;
	/**
	 * 
	 */
	private Integer pddRefundStatus;
	/**
	 * 
	 */
	private Integer pddOrderStatus;
	/**
	 * 
	 */
	private Integer color;
	/**
	 * 
	 */
	private String pddAllAddress;
	/**
	 * 0 未确认 1已确认 2失败
	 */
	private Integer isSubmit;
	/**
	 * 委外仓id
	 */
	private Integer storeId;

}
