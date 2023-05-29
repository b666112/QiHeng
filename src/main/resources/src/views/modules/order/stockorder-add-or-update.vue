<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="订单编号" prop="orderNum">
      <el-input v-model="dataForm.orderNum" placeholder="订单编号"></el-input>
    </el-form-item>
    <el-form-item label="在线订单编号" prop="onlineOrderNum">
      <el-input v-model="dataForm.onlineOrderNum" placeholder="在线订单编号"></el-input>
    </el-form-item>
    <el-form-item label="销售日期" prop="saleDate">
      <el-input v-model="dataForm.saleDate" placeholder="销售日期"></el-input>
    </el-form-item>
    <el-form-item label="仓库" prop="warehouseId">
      <el-input v-model="dataForm.warehouseId" placeholder="仓库"></el-input>
    </el-form-item>
    <el-form-item label="客户id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="客户id"></el-input>
    </el-form-item>
    <el-form-item label="收款账户id" prop="account">
      <el-input v-model="dataForm.account" placeholder="收款账户id"></el-input>
    </el-form-item>
    <el-form-item label="销售员id" prop="saleUserId">
      <el-input v-model="dataForm.saleUserId" placeholder="销售员id"></el-input>
    </el-form-item>
    <el-form-item label="" prop="freight">
      <el-input v-model="dataForm.freight" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="substitute">
      <el-input v-model="dataForm.substitute" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="发货备注 0发货1不发货2预定" prop="sendRemark">
      <el-input v-model="dataForm.sendRemark" placeholder="发货备注 0发货1不发货2预定"></el-input>
    </el-form-item>
    <el-form-item label="客户备注" prop="userRemark">
      <el-input v-model="dataForm.userRemark" placeholder="客户备注"></el-input>
    </el-form-item>
    <el-form-item label="销售备注" prop="saleRemark">
      <el-input v-model="dataForm.saleRemark" placeholder="销售备注"></el-input>
    </el-form-item>
    <el-form-item label="收件人姓名" prop="name">
      <el-input v-model="dataForm.name" placeholder="收件人姓名"></el-input>
    </el-form-item>
    <el-form-item label="收件人手机号" prop="tel">
      <el-input v-model="dataForm.tel" placeholder="收件人手机号"></el-input>
    </el-form-item>
    <el-form-item label="" prop="phone">
      <el-input v-model="dataForm.phone" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="province">
      <el-input v-model="dataForm.province" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="city">
      <el-input v-model="dataForm.city" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="area">
      <el-input v-model="dataForm.area" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="address">
      <el-input v-model="dataForm.address" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="发件人姓名" prop="sendName">
      <el-input v-model="dataForm.sendName" placeholder="发件人姓名"></el-input>
    </el-form-item>
    <el-form-item label="" prop="sendTel">
      <el-input v-model="dataForm.sendTel" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="sendProvince">
      <el-input v-model="dataForm.sendProvince" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="sendCity">
      <el-input v-model="dataForm.sendCity" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="sendArea">
      <el-input v-model="dataForm.sendArea" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="sendAddress">
      <el-input v-model="dataForm.sendAddress" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="remark">
      <el-input v-model="dataForm.remark" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="flag">
      <el-input v-model="dataForm.flag" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="createdAt">
      <el-input v-model="dataForm.createdAt" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="updatedAt">
      <el-input v-model="dataForm.updatedAt" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="businessId">
      <el-input v-model="dataForm.businessId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="发货状态 0未发货 1已发货 2发货中3已收货 -1 已出货" prop="sendStatus">
      <el-input v-model="dataForm.sendStatus" placeholder="发货状态 0未发货 1已发货 2发货中3已收货 -1 已出货"></el-input>
    </el-form-item>
    <el-form-item label="0未付款 1已付款" prop="payStatus">
      <el-input v-model="dataForm.payStatus" placeholder="0未付款 1已付款"></el-input>
    </el-form-item>
    <el-form-item label="" prop="price">
      <el-input v-model="dataForm.price" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="payPrice">
      <el-input v-model="dataForm.payPrice" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="0未打印1已打印2部分打印   3 打印收银" prop="printExpress">
      <el-input v-model="dataForm.printExpress" placeholder="0未打印1已打印2部分打印   3 打印收银"></el-input>
    </el-form-item>
    <el-form-item label="是否打印配货单" prop="printDistribution">
      <el-input v-model="dataForm.printDistribution" placeholder="是否打印配货单"></el-input>
    </el-form-item>
    <el-form-item label="操作人userid" prop="operatorUserId">
      <el-input v-model="dataForm.operatorUserId" placeholder="操作人userid"></el-input>
    </el-form-item>
    <el-form-item label="支付方式 数据字典在admin.php" prop="payMethod">
      <el-input v-model="dataForm.payMethod" placeholder="支付方式 数据字典在admin.php"></el-input>
    </el-form-item>
    <el-form-item label="0erp后台添加、1小程序商城添加" prop="insertType">
      <el-input v-model="dataForm.insertType" placeholder="0erp后台添加、1小程序商城添加"></el-input>
    </el-form-item>
    <el-form-item label="发货人电话" prop="sendPhone">
      <el-input v-model="dataForm.sendPhone" placeholder="发货人电话"></el-input>
    </el-form-item>
    <el-form-item label="身份证号码" prop="idnumber">
      <el-input v-model="dataForm.idnumber" placeholder="身份证号码"></el-input>
    </el-form-item>
    <el-form-item label="身份证正面照片" prop="imagefront">
      <el-input v-model="dataForm.imagefront" placeholder="身份证正面照片"></el-input>
    </el-form-item>
    <el-form-item label="身份证反面照片" prop="imageback">
      <el-input v-model="dataForm.imageback" placeholder="身份证反面照片"></el-input>
    </el-form-item>
    <el-form-item label="身份证姓名" prop="idname">
      <el-input v-model="dataForm.idname" placeholder="身份证姓名"></el-input>
    </el-form-item>
    <el-form-item label="erp_shopmp_identity_card的id" prop="identId">
      <el-input v-model="dataForm.identId" placeholder="erp_shopmp_identity_card的id"></el-input>
    </el-form-item>
    <el-form-item label="erp_market_freight的id,用户选择的运费优惠" prop="marketFreightId">
      <el-input v-model="dataForm.marketFreightId" placeholder="erp_market_freight的id,用户选择的运费优惠"></el-input>
    </el-form-item>
    <el-form-item label="优惠前的运费" prop="originFreight">
      <el-input v-model="dataForm.originFreight" placeholder="优惠前的运费"></el-input>
    </el-form-item>
    <el-form-item label="馆区id" prop="mpId">
      <el-input v-model="dataForm.mpId" placeholder="馆区id"></el-input>
    </el-form-item>
    <el-form-item label="团购订单状态0不是团购单,1拼单中未付款,2拼单中待发货,3拼单成功未付款,4拼单成功待发货,5拼单失败退款中" prop="groupStatus">
      <el-input v-model="dataForm.groupStatus" placeholder="团购订单状态0不是团购单,1拼单中未付款,2拼单中待发货,3拼单成功未付款,4拼单成功待发货,5拼单失败退款中"></el-input>
    </el-form-item>
    <el-form-item label="团购价或团购原价" prop="groupPrice">
      <el-input v-model="dataForm.groupPrice" placeholder="团购价或团购原价"></el-input>
    </el-form-item>
    <el-form-item label="关联采购订单" prop="relatePurchaseOrder">
      <el-input v-model="dataForm.relatePurchaseOrder" placeholder="关联采购订单"></el-input>
    </el-form-item>
    <el-form-item label="订单类型 1 商品订单2充值订单" prop="orderType">
      <el-input v-model="dataForm.orderType" placeholder="订单类型 1 商品订单2充值订单"></el-input>
    </el-form-item>
    <el-form-item label="运费模版组合ID" prop="freightId">
      <el-input v-model="dataForm.freightId" placeholder="运费模版组合ID"></el-input>
    </el-form-item>
    <el-form-item label="原价" prop="originPrice">
      <el-input v-model="dataForm.originPrice" placeholder="原价"></el-input>
    </el-form-item>
    <el-form-item label="会员优惠金额" prop="vipDiscount">
      <el-input v-model="dataForm.vipDiscount" placeholder="会员优惠金额"></el-input>
    </el-form-item>
    <el-form-item label="批发价优惠金额" prop="tradePriceDiscount">
      <el-input v-model="dataForm.tradePriceDiscount" placeholder="批发价优惠金额"></el-input>
    </el-form-item>
    <el-form-item label="优惠券使用描述" prop="couponUseDesc">
      <el-input v-model="dataForm.couponUseDesc" placeholder="优惠券使用描述"></el-input>
    </el-form-item>
    <el-form-item label="是否是团购订单 0 否 其他是团购id" prop="isGroupBuying">
      <el-input v-model="dataForm.isGroupBuying" placeholder="是否是团购订单 0 否 其他是团购id"></el-input>
    </el-form-item>
    <el-form-item label="用户的团购记录" prop="userGroupBuyingId">
      <el-input v-model="dataForm.userGroupBuyingId" placeholder="用户的团购记录"></el-input>
    </el-form-item>
    <el-form-item label="支付时间" prop="payTime">
      <el-input v-model="dataForm.payTime" placeholder="支付时间"></el-input>
    </el-form-item>
    <el-form-item label="确认收货时间" prop="confirmTime">
      <el-input v-model="dataForm.confirmTime" placeholder="确认收货时间"></el-input>
    </el-form-item>
    <el-form-item label="汇付 huifu 通联tonglian" prop="payCompany">
      <el-input v-model="dataForm.payCompany" placeholder="汇付 huifu 通联tonglian"></el-input>
    </el-form-item>
    <el-form-item label="活动优惠详情" prop="activityDiscount">
      <el-input v-model="dataForm.activityDiscount" placeholder="活动优惠详情"></el-input>
    </el-form-item>
    <el-form-item label="全场活动详情" prop="fullActivityDiscount">
      <el-input v-model="dataForm.fullActivityDiscount" placeholder="全场活动详情"></el-input>
    </el-form-item>
    <el-form-item label="全场活动id" prop="fullActivityId">
      <el-input v-model="dataForm.fullActivityId" placeholder="全场活动id"></el-input>
    </el-form-item>
    <el-form-item label="全场活动" prop="fullActivityDesc">
      <el-input v-model="dataForm.fullActivityDesc" placeholder="全场活动"></el-input>
    </el-form-item>
    <el-form-item label="快递单编号" prop="deliverNum">
      <el-input v-model="dataForm.deliverNum" placeholder="快递单编号"></el-input>
    </el-form-item>
    <el-form-item label="快递类型" prop="expressType">
      <el-input v-model="dataForm.expressType" placeholder="快递类型"></el-input>
    </el-form-item>
    <el-form-item label="是否独立主体面单" prop="isMainOrder">
      <el-input v-model="dataForm.isMainOrder" placeholder="是否独立主体面单"></el-input>
    </el-form-item>
    <el-form-item label="是否是无需物流 1是 0 否" prop="isNeedOrder">
      <el-input v-model="dataForm.isNeedOrder" placeholder="是否是无需物流 1是 0 否"></el-input>
    </el-form-item>
    <el-form-item label="分店id" prop="originBusinessId">
      <el-input v-model="dataForm.originBusinessId" placeholder="分店id"></el-input>
    </el-form-item>
    <el-form-item label="是否独立库存订单" prop="isIndependent">
      <el-input v-model="dataForm.isIndependent" placeholder="是否独立库存订单"></el-input>
    </el-form-item>
    <el-form-item label="门店分账详情" prop="storesAccount">
      <el-input v-model="dataForm.storesAccount" placeholder="门店分账详情"></el-input>
    </el-form-item>
    <el-form-item label="是否是客户选择的发货地址1是0否" prop="isCustomerSelect">
      <el-input v-model="dataForm.isCustomerSelect" placeholder="是否是客户选择的发货地址1是0否"></el-input>
    </el-form-item>
    <el-form-item label="分账明细" prop="shareDetail">
      <el-input v-model="dataForm.shareDetail" placeholder="分账明细"></el-input>
    </el-form-item>
    <el-form-item label="1退款中，2已同意" prop="refundStatus">
      <el-input v-model="dataForm.refundStatus" placeholder="1退款中，2已同意"></el-input>
    </el-form-item>
    <el-form-item label="退款类型，0，无，1仅退款，2退货退款" prop="refundType">
      <el-input v-model="dataForm.refundType" placeholder="退款类型，0，无，1仅退款，2退货退款"></el-input>
    </el-form-item>
    <el-form-item label="留言" prop="message">
      <el-input v-model="dataForm.message" placeholder="留言"></el-input>
    </el-form-item>
    <el-form-item label="税费" prop="tax">
      <el-input v-model="dataForm.tax" placeholder="税费"></el-input>
    </el-form-item>
    <el-form-item label="是否新人订单" prop="isNewOrder">
      <el-input v-model="dataForm.isNewOrder" placeholder="是否新人订单"></el-input>
    </el-form-item>
    <el-form-item label="发货类型" prop="deliveryType">
      <el-input v-model="dataForm.deliveryType" placeholder="发货类型"></el-input>
    </el-form-item>
    <el-form-item label="自提点id" prop="pickupSiteId">
      <el-input v-model="dataForm.pickupSiteId" placeholder="自提点id"></el-input>
    </el-form-item>
    <el-form-item label="自提码" prop="pickupCode">
      <el-input v-model="dataForm.pickupCode" placeholder="自提码"></el-input>
    </el-form-item>
    <el-form-item label="支付订单号" prop="transactionId">
      <el-input v-model="dataForm.transactionId" placeholder="支付订单号"></el-input>
    </el-form-item>
    <el-form-item label="是否境外订单" prop="crossBorder">
      <el-input v-model="dataForm.crossBorder" placeholder="是否境外订单"></el-input>
    </el-form-item>
    <el-form-item label="" prop="defrayPush">
      <el-input v-model="dataForm.defrayPush" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="payPush">
      <el-input v-model="dataForm.payPush" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="0未推送1推送成功2推送中待回执3回执失败" prop="orderPush">
      <el-input v-model="dataForm.orderPush" placeholder="0未推送1推送成功2推送中待回执3回执失败"></el-input>
    </el-form-item>
    <el-form-item label="" prop="logisticsPush">
      <el-input v-model="dataForm.logisticsPush" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="inventoryPush">
      <el-input v-model="dataForm.inventoryPush" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="撤销推送单状态" prop="cancelPush">
      <el-input v-model="dataForm.cancelPush" placeholder="撤销推送单状态"></el-input>
    </el-form-item>
    <el-form-item label="退货单状态" prop="refundPush">
      <el-input v-model="dataForm.refundPush" placeholder="退货单状态"></el-input>
    </el-form-item>
    <el-form-item label="积分兑换商品/积分id" prop="integralId">
      <el-input v-model="dataForm.integralId" placeholder="积分兑换商品/积分id"></el-input>
    </el-form-item>
    <el-form-item label="积分详情" prop="integralInfo">
      <el-input v-model="dataForm.integralInfo" placeholder="积分详情"></el-input>
    </el-form-item>
    <el-form-item label="订单星级" prop="star">
      <el-input v-model="dataForm.star" placeholder="订单星级"></el-input>
    </el-form-item>
    <el-form-item label="积分获得状态，1表示已获得" prop="scoreStatus">
      <el-input v-model="dataForm.scoreStatus" placeholder="积分获得状态，1表示已获得"></el-input>
    </el-form-item>
    <el-form-item label="分账类型，与支付类型挂钩，0表示没分账" prop="shareType">
      <el-input v-model="dataForm.shareType" placeholder="分账类型，与支付类型挂钩，0表示没分账"></el-input>
    </el-form-item>
    <el-form-item label="1 分账完成" prop="shareComplete">
      <el-input v-model="dataForm.shareComplete" placeholder="1 分账完成"></el-input>
    </el-form-item>
    <el-form-item label="1默认 2自选" prop="expressSelect">
      <el-input v-model="dataForm.expressSelect" placeholder="1默认 2自选"></el-input>
    </el-form-item>
    <el-form-item label="导入的优惠" prop="headBusinessId">
      <el-input v-model="dataForm.headBusinessId" placeholder="导入的优惠"></el-input>
    </el-form-item>
    <el-form-item label="总店事业部id" prop="headBusiness">
      <el-input v-model="dataForm.headBusiness" placeholder="总店事业部id"></el-input>
    </el-form-item>
    <el-form-item label="" prop="importDiscount">
      <el-input v-model="dataForm.importDiscount" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="退款 销售单关联" prop="refundOrderId">
      <el-input v-model="dataForm.refundOrderId" placeholder="退款 销售单关联"></el-input>
    </el-form-item>
    <el-form-item label="发货时间" prop="sendTime">
      <el-input v-model="dataForm.sendTime" placeholder="发货时间"></el-input>
    </el-form-item>
    <el-form-item label="平台下总店是否收账" prop="mainmoney">
      <el-input v-model="dataForm.mainmoney" placeholder="平台下总店是否收账"></el-input>
    </el-form-item>
    <el-form-item label="中间件 0 不是" prop="isMiddleware">
      <el-input v-model="dataForm.isMiddleware" placeholder="中间件 0 不是"></el-input>
    </el-form-item>
    <el-form-item label="是否是平台订单" prop="isPlat">
      <el-input v-model="dataForm.isPlat" placeholder="是否是平台订单"></el-input>
    </el-form-item>
    <el-form-item label="订单关联采购单" prop="purchaseOrder">
      <el-input v-model="dataForm.purchaseOrder" placeholder="订单关联采购单"></el-input>
    </el-form-item>
    <el-form-item label="货物来源 oupai 欧派" prop="source">
      <el-input v-model="dataForm.source" placeholder="货物来源 oupai 欧派"></el-input>
    </el-form-item>
    <el-form-item label="" prop="toBusinessId">
      <el-input v-model="dataForm.toBusinessId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="关联的合并支付单" prop="mergeId">
      <el-input v-model="dataForm.mergeId" placeholder="关联的合并支付单"></el-input>
    </el-form-item>
    <el-form-item label="免税金额" prop="freeTaxPrice">
      <el-input v-model="dataForm.freeTaxPrice" placeholder="免税金额"></el-input>
    </el-form-item>
    <el-form-item label="帮卖 分销人的 wxuser_id" prop="helpSaleUser">
      <el-input v-model="dataForm.helpSaleUser" placeholder="帮卖 分销人的 wxuser_id"></el-input>
    </el-form-item>
    <el-form-item label="帮卖 分销人的盈利" prop="helpUserPrice">
      <el-input v-model="dataForm.helpUserPrice" placeholder="帮卖 分销人的盈利"></el-input>
    </el-form-item>
    <el-form-item label="电商平台代码" prop="ebpcode">
      <el-input v-model="dataForm.ebpcode" placeholder="电商平台代码"></el-input>
    </el-form-item>
    <el-form-item label="电商平台名称" prop="ebpname">
      <el-input v-model="dataForm.ebpname" placeholder="电商平台名称"></el-input>
    </el-form-item>
    <el-form-item label="拼多多订单id" prop="pddOrderid">
      <el-input v-model="dataForm.pddOrderid" placeholder="拼多多订单id"></el-input>
    </el-form-item>
    <el-form-item label="" prop="freightTax">
      <el-input v-model="dataForm.freightTax" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="推送到wms系统的状态 0 未推送 1推送成功 2失败" prop="wmsStatus">
      <el-input v-model="dataForm.wmsStatus" placeholder="推送到wms系统的状态 0 未推送 1推送成功 2失败"></el-input>
    </el-form-item>
    <el-form-item label="wms 返回的提示" prop="wmsMsg">
      <el-input v-model="dataForm.wmsMsg" placeholder="wms 返回的提示"></el-input>
    </el-form-item>
    <el-form-item label="推送到wms取消系统的状态 0 未推送 1推送成功 2失败" prop="wmsCancelStatus">
      <el-input v-model="dataForm.wmsCancelStatus" placeholder="推送到wms取消系统的状态 0 未推送 1推送成功 2失败"></el-input>
    </el-form-item>
    <el-form-item label="wms 返回的提示" prop="wmsCancelMsg">
      <el-input v-model="dataForm.wmsCancelMsg" placeholder="wms 返回的提示"></el-input>
    </el-form-item>
    <el-form-item label="" prop="guideId">
      <el-input v-model="dataForm.guideId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="分账物流信息采集" prop="pushCross">
      <el-input v-model="dataForm.pushCross" placeholder="分账物流信息采集"></el-input>
    </el-form-item>
    <el-form-item label="购买人手机号" prop="buyPhone">
      <el-input v-model="dataForm.buyPhone" placeholder="购买人手机号"></el-input>
    </el-form-item>
    <el-form-item label="" prop="freeFreightTax">
      <el-input v-model="dataForm.freeFreightTax" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="订单来源" prop="fromType">
      <el-input v-model="dataForm.fromType" placeholder="订单来源"></el-input>
    </el-form-item>
    <el-form-item label="" prop="pddName">
      <el-input v-model="dataForm.pddName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="pddPhone">
      <el-input v-model="dataForm.pddPhone" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="pddIdnumber">
      <el-input v-model="dataForm.pddIdnumber" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="pddIdName">
      <el-input v-model="dataForm.pddIdName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="pddPayNo">
      <el-input v-model="dataForm.pddPayNo" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="pddAddress">
      <el-input v-model="dataForm.pddAddress" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="pdd 发货状态" prop="pddSend">
      <el-input v-model="dataForm.pddSend" placeholder="pdd 发货状态"></el-input>
    </el-form-item>
    <el-form-item label="pdd 物流轨迹 0 1已揽收 2 已签收" prop="pddDeliverStatus">
      <el-input v-model="dataForm.pddDeliverStatus" placeholder="pdd 物流轨迹 0 1已揽收 2 已签收"></el-input>
    </el-form-item>
    <el-form-item label="" prop="ccType">
      <el-input v-model="dataForm.ccType" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="pddRefundStatus">
      <el-input v-model="dataForm.pddRefundStatus" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="pddOrderStatus">
      <el-input v-model="dataForm.pddOrderStatus" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="color">
      <el-input v-model="dataForm.color" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="pddAllAddress">
      <el-input v-model="dataForm.pddAllAddress" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="0 未确认 1已确认 2失败" prop="isSubmit">
      <el-input v-model="dataForm.isSubmit" placeholder="0 未确认 1已确认 2失败"></el-input>
    </el-form-item>
    <el-form-item label="委外仓id" prop="storeId">
      <el-input v-model="dataForm.storeId" placeholder="委外仓id"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          orderNum: '',
          onlineOrderNum: '',
          saleDate: '',
          warehouseId: '',
          userId: '',
          account: '',
          saleUserId: '',
          freight: '',
          substitute: '',
          sendRemark: '',
          userRemark: '',
          saleRemark: '',
          name: '',
          tel: '',
          phone: '',
          province: '',
          city: '',
          area: '',
          address: '',
          sendName: '',
          sendTel: '',
          sendProvince: '',
          sendCity: '',
          sendArea: '',
          sendAddress: '',
          remark: '',
          flag: '',
          createdAt: '',
          updatedAt: '',
          businessId: '',
          sendStatus: '',
          payStatus: '',
          price: '',
          payPrice: '',
          printExpress: '',
          printDistribution: '',
          operatorUserId: '',
          payMethod: '',
          insertType: '',
          sendPhone: '',
          idnumber: '',
          imagefront: '',
          imageback: '',
          idname: '',
          identId: '',
          marketFreightId: '',
          originFreight: '',
          mpId: '',
          groupStatus: '',
          groupPrice: '',
          relatePurchaseOrder: '',
          orderType: '',
          freightId: '',
          originPrice: '',
          vipDiscount: '',
          tradePriceDiscount: '',
          couponUseDesc: '',
          isGroupBuying: '',
          userGroupBuyingId: '',
          payTime: '',
          confirmTime: '',
          payCompany: '',
          activityDiscount: '',
          fullActivityDiscount: '',
          fullActivityId: '',
          fullActivityDesc: '',
          deliverNum: '',
          expressType: '',
          isMainOrder: '',
          isNeedOrder: '',
          originBusinessId: '',
          isIndependent: '',
          storesAccount: '',
          isCustomerSelect: '',
          shareDetail: '',
          refundStatus: '',
          refundType: '',
          message: '',
          tax: '',
          isNewOrder: '',
          deliveryType: '',
          pickupSiteId: '',
          pickupCode: '',
          transactionId: '',
          crossBorder: '',
          defrayPush: '',
          payPush: '',
          orderPush: '',
          logisticsPush: '',
          inventoryPush: '',
          cancelPush: '',
          refundPush: '',
          integralId: '',
          integralInfo: '',
          star: '',
          scoreStatus: '',
          shareType: '',
          shareComplete: '',
          expressSelect: '',
          headBusinessId: '',
          headBusiness: '',
          importDiscount: '',
          refundOrderId: '',
          sendTime: '',
          mainmoney: '',
          isMiddleware: '',
          isPlat: '',
          purchaseOrder: '',
          source: '',
          toBusinessId: '',
          mergeId: '',
          freeTaxPrice: '',
          helpSaleUser: '',
          helpUserPrice: '',
          ebpcode: '',
          ebpname: '',
          pddOrderid: '',
          freightTax: '',
          wmsStatus: '',
          wmsMsg: '',
          wmsCancelStatus: '',
          wmsCancelMsg: '',
          guideId: '',
          pushCross: '',
          buyPhone: '',
          freeFreightTax: '',
          fromType: '',
          pddName: '',
          pddPhone: '',
          pddIdnumber: '',
          pddIdName: '',
          pddPayNo: '',
          pddAddress: '',
          pddSend: '',
          pddDeliverStatus: '',
          ccType: '',
          pddRefundStatus: '',
          pddOrderStatus: '',
          color: '',
          pddAllAddress: '',
          isSubmit: '',
          storeId: ''
        },
        dataRule: {
          orderNum: [
            { required: true, message: '订单编号不能为空', trigger: 'blur' }
          ],
          onlineOrderNum: [
            { required: true, message: '在线订单编号不能为空', trigger: 'blur' }
          ],
          saleDate: [
            { required: true, message: '销售日期不能为空', trigger: 'blur' }
          ],
          warehouseId: [
            { required: true, message: '仓库不能为空', trigger: 'blur' }
          ],
          userId: [
            { required: true, message: '客户id不能为空', trigger: 'blur' }
          ],
          account: [
            { required: true, message: '收款账户id不能为空', trigger: 'blur' }
          ],
          saleUserId: [
            { required: true, message: '销售员id不能为空', trigger: 'blur' }
          ],
          freight: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          substitute: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sendRemark: [
            { required: true, message: '发货备注 0发货1不发货2预定不能为空', trigger: 'blur' }
          ],
          userRemark: [
            { required: true, message: '客户备注不能为空', trigger: 'blur' }
          ],
          saleRemark: [
            { required: true, message: '销售备注不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '收件人姓名不能为空', trigger: 'blur' }
          ],
          tel: [
            { required: true, message: '收件人手机号不能为空', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          province: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          city: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          area: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          address: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sendName: [
            { required: true, message: '发件人姓名不能为空', trigger: 'blur' }
          ],
          sendTel: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sendProvince: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sendCity: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sendArea: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sendAddress: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          flag: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          createdAt: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          updatedAt: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          businessId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sendStatus: [
            { required: true, message: '发货状态 0未发货 1已发货 2发货中3已收货 -1 已出货不能为空', trigger: 'blur' }
          ],
          payStatus: [
            { required: true, message: '0未付款 1已付款不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          payPrice: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          printExpress: [
            { required: true, message: '0未打印1已打印2部分打印   3 打印收银不能为空', trigger: 'blur' }
          ],
          printDistribution: [
            { required: true, message: '是否打印配货单不能为空', trigger: 'blur' }
          ],
          operatorUserId: [
            { required: true, message: '操作人userid不能为空', trigger: 'blur' }
          ],
          payMethod: [
            { required: true, message: '支付方式 数据字典在admin.php不能为空', trigger: 'blur' }
          ],
          insertType: [
            { required: true, message: '0erp后台添加、1小程序商城添加不能为空', trigger: 'blur' }
          ],
          sendPhone: [
            { required: true, message: '发货人电话不能为空', trigger: 'blur' }
          ],
          idnumber: [
            { required: true, message: '身份证号码不能为空', trigger: 'blur' }
          ],
          imagefront: [
            { required: true, message: '身份证正面照片不能为空', trigger: 'blur' }
          ],
          imageback: [
            { required: true, message: '身份证反面照片不能为空', trigger: 'blur' }
          ],
          idname: [
            { required: true, message: '身份证姓名不能为空', trigger: 'blur' }
          ],
          identId: [
            { required: true, message: 'erp_shopmp_identity_card的id不能为空', trigger: 'blur' }
          ],
          marketFreightId: [
            { required: true, message: 'erp_market_freight的id,用户选择的运费优惠不能为空', trigger: 'blur' }
          ],
          originFreight: [
            { required: true, message: '优惠前的运费不能为空', trigger: 'blur' }
          ],
          mpId: [
            { required: true, message: '馆区id不能为空', trigger: 'blur' }
          ],
          groupStatus: [
            { required: true, message: '团购订单状态0不是团购单,1拼单中未付款,2拼单中待发货,3拼单成功未付款,4拼单成功待发货,5拼单失败退款中不能为空', trigger: 'blur' }
          ],
          groupPrice: [
            { required: true, message: '团购价或团购原价不能为空', trigger: 'blur' }
          ],
          relatePurchaseOrder: [
            { required: true, message: '关联采购订单不能为空', trigger: 'blur' }
          ],
          orderType: [
            { required: true, message: '订单类型 1 商品订单2充值订单不能为空', trigger: 'blur' }
          ],
          freightId: [
            { required: true, message: '运费模版组合ID不能为空', trigger: 'blur' }
          ],
          originPrice: [
            { required: true, message: '原价不能为空', trigger: 'blur' }
          ],
          vipDiscount: [
            { required: true, message: '会员优惠金额不能为空', trigger: 'blur' }
          ],
          tradePriceDiscount: [
            { required: true, message: '批发价优惠金额不能为空', trigger: 'blur' }
          ],
          couponUseDesc: [
            { required: true, message: '优惠券使用描述不能为空', trigger: 'blur' }
          ],
          isGroupBuying: [
            { required: true, message: '是否是团购订单 0 否 其他是团购id不能为空', trigger: 'blur' }
          ],
          userGroupBuyingId: [
            { required: true, message: '用户的团购记录不能为空', trigger: 'blur' }
          ],
          payTime: [
            { required: true, message: '支付时间不能为空', trigger: 'blur' }
          ],
          confirmTime: [
            { required: true, message: '确认收货时间不能为空', trigger: 'blur' }
          ],
          payCompany: [
            { required: true, message: '汇付 huifu 通联tonglian不能为空', trigger: 'blur' }
          ],
          activityDiscount: [
            { required: true, message: '活动优惠详情不能为空', trigger: 'blur' }
          ],
          fullActivityDiscount: [
            { required: true, message: '全场活动详情不能为空', trigger: 'blur' }
          ],
          fullActivityId: [
            { required: true, message: '全场活动id不能为空', trigger: 'blur' }
          ],
          fullActivityDesc: [
            { required: true, message: '全场活动不能为空', trigger: 'blur' }
          ],
          deliverNum: [
            { required: true, message: '快递单编号不能为空', trigger: 'blur' }
          ],
          expressType: [
            { required: true, message: '快递类型不能为空', trigger: 'blur' }
          ],
          isMainOrder: [
            { required: true, message: '是否独立主体面单不能为空', trigger: 'blur' }
          ],
          isNeedOrder: [
            { required: true, message: '是否是无需物流 1是 0 否不能为空', trigger: 'blur' }
          ],
          originBusinessId: [
            { required: true, message: '分店id不能为空', trigger: 'blur' }
          ],
          isIndependent: [
            { required: true, message: '是否独立库存订单不能为空', trigger: 'blur' }
          ],
          storesAccount: [
            { required: true, message: '门店分账详情不能为空', trigger: 'blur' }
          ],
          isCustomerSelect: [
            { required: true, message: '是否是客户选择的发货地址1是0否不能为空', trigger: 'blur' }
          ],
          shareDetail: [
            { required: true, message: '分账明细不能为空', trigger: 'blur' }
          ],
          refundStatus: [
            { required: true, message: '1退款中，2已同意不能为空', trigger: 'blur' }
          ],
          refundType: [
            { required: true, message: '退款类型，0，无，1仅退款，2退货退款不能为空', trigger: 'blur' }
          ],
          message: [
            { required: true, message: '留言不能为空', trigger: 'blur' }
          ],
          tax: [
            { required: true, message: '税费不能为空', trigger: 'blur' }
          ],
          isNewOrder: [
            { required: true, message: '是否新人订单不能为空', trigger: 'blur' }
          ],
          deliveryType: [
            { required: true, message: '发货类型不能为空', trigger: 'blur' }
          ],
          pickupSiteId: [
            { required: true, message: '自提点id不能为空', trigger: 'blur' }
          ],
          pickupCode: [
            { required: true, message: '自提码不能为空', trigger: 'blur' }
          ],
          transactionId: [
            { required: true, message: '支付订单号不能为空', trigger: 'blur' }
          ],
          crossBorder: [
            { required: true, message: '是否境外订单不能为空', trigger: 'blur' }
          ],
          defrayPush: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          payPush: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          orderPush: [
            { required: true, message: '0未推送1推送成功2推送中待回执3回执失败不能为空', trigger: 'blur' }
          ],
          logisticsPush: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          inventoryPush: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          cancelPush: [
            { required: true, message: '撤销推送单状态不能为空', trigger: 'blur' }
          ],
          refundPush: [
            { required: true, message: '退货单状态不能为空', trigger: 'blur' }
          ],
          integralId: [
            { required: true, message: '积分兑换商品/积分id不能为空', trigger: 'blur' }
          ],
          integralInfo: [
            { required: true, message: '积分详情不能为空', trigger: 'blur' }
          ],
          star: [
            { required: true, message: '订单星级不能为空', trigger: 'blur' }
          ],
          scoreStatus: [
            { required: true, message: '积分获得状态，1表示已获得不能为空', trigger: 'blur' }
          ],
          shareType: [
            { required: true, message: '分账类型，与支付类型挂钩，0表示没分账不能为空', trigger: 'blur' }
          ],
          shareComplete: [
            { required: true, message: '1 分账完成不能为空', trigger: 'blur' }
          ],
          expressSelect: [
            { required: true, message: '1默认 2自选不能为空', trigger: 'blur' }
          ],
          headBusinessId: [
            { required: true, message: '导入的优惠不能为空', trigger: 'blur' }
          ],
          headBusiness: [
            { required: true, message: '总店事业部id不能为空', trigger: 'blur' }
          ],
          importDiscount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          refundOrderId: [
            { required: true, message: '退款 销售单关联不能为空', trigger: 'blur' }
          ],
          sendTime: [
            { required: true, message: '发货时间不能为空', trigger: 'blur' }
          ],
          mainmoney: [
            { required: true, message: '平台下总店是否收账不能为空', trigger: 'blur' }
          ],
          isMiddleware: [
            { required: true, message: '中间件 0 不是不能为空', trigger: 'blur' }
          ],
          isPlat: [
            { required: true, message: '是否是平台订单不能为空', trigger: 'blur' }
          ],
          purchaseOrder: [
            { required: true, message: '订单关联采购单不能为空', trigger: 'blur' }
          ],
          source: [
            { required: true, message: '货物来源 oupai 欧派不能为空', trigger: 'blur' }
          ],
          toBusinessId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          mergeId: [
            { required: true, message: '关联的合并支付单不能为空', trigger: 'blur' }
          ],
          freeTaxPrice: [
            { required: true, message: '免税金额不能为空', trigger: 'blur' }
          ],
          helpSaleUser: [
            { required: true, message: '帮卖 分销人的 wxuser_id不能为空', trigger: 'blur' }
          ],
          helpUserPrice: [
            { required: true, message: '帮卖 分销人的盈利不能为空', trigger: 'blur' }
          ],
          ebpcode: [
            { required: true, message: '电商平台代码不能为空', trigger: 'blur' }
          ],
          ebpname: [
            { required: true, message: '电商平台名称不能为空', trigger: 'blur' }
          ],
          pddOrderid: [
            { required: true, message: '拼多多订单id不能为空', trigger: 'blur' }
          ],
          freightTax: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          wmsStatus: [
            { required: true, message: '推送到wms系统的状态 0 未推送 1推送成功 2失败不能为空', trigger: 'blur' }
          ],
          wmsMsg: [
            { required: true, message: 'wms 返回的提示不能为空', trigger: 'blur' }
          ],
          wmsCancelStatus: [
            { required: true, message: '推送到wms取消系统的状态 0 未推送 1推送成功 2失败不能为空', trigger: 'blur' }
          ],
          wmsCancelMsg: [
            { required: true, message: 'wms 返回的提示不能为空', trigger: 'blur' }
          ],
          guideId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pushCross: [
            { required: true, message: '分账物流信息采集不能为空', trigger: 'blur' }
          ],
          buyPhone: [
            { required: true, message: '购买人手机号不能为空', trigger: 'blur' }
          ],
          freeFreightTax: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          fromType: [
            { required: true, message: '订单来源不能为空', trigger: 'blur' }
          ],
          pddName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pddPhone: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pddIdnumber: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pddIdName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pddPayNo: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pddAddress: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pddSend: [
            { required: true, message: 'pdd 发货状态不能为空', trigger: 'blur' }
          ],
          pddDeliverStatus: [
            { required: true, message: 'pdd 物流轨迹 0 1已揽收 2 已签收不能为空', trigger: 'blur' }
          ],
          ccType: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pddRefundStatus: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pddOrderStatus: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          color: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pddAllAddress: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          isSubmit: [
            { required: true, message: '0 未确认 1已确认 2失败不能为空', trigger: 'blur' }
          ],
          storeId: [
            { required: true, message: '委外仓id不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/order/stockorder/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.orderNum = data.stockOrder.orderNum
                this.dataForm.onlineOrderNum = data.stockOrder.onlineOrderNum
                this.dataForm.saleDate = data.stockOrder.saleDate
                this.dataForm.warehouseId = data.stockOrder.warehouseId
                this.dataForm.userId = data.stockOrder.userId
                this.dataForm.account = data.stockOrder.account
                this.dataForm.saleUserId = data.stockOrder.saleUserId
                this.dataForm.freight = data.stockOrder.freight
                this.dataForm.substitute = data.stockOrder.substitute
                this.dataForm.sendRemark = data.stockOrder.sendRemark
                this.dataForm.userRemark = data.stockOrder.userRemark
                this.dataForm.saleRemark = data.stockOrder.saleRemark
                this.dataForm.name = data.stockOrder.name
                this.dataForm.tel = data.stockOrder.tel
                this.dataForm.phone = data.stockOrder.phone
                this.dataForm.province = data.stockOrder.province
                this.dataForm.city = data.stockOrder.city
                this.dataForm.area = data.stockOrder.area
                this.dataForm.address = data.stockOrder.address
                this.dataForm.sendName = data.stockOrder.sendName
                this.dataForm.sendTel = data.stockOrder.sendTel
                this.dataForm.sendProvince = data.stockOrder.sendProvince
                this.dataForm.sendCity = data.stockOrder.sendCity
                this.dataForm.sendArea = data.stockOrder.sendArea
                this.dataForm.sendAddress = data.stockOrder.sendAddress
                this.dataForm.remark = data.stockOrder.remark
                this.dataForm.flag = data.stockOrder.flag
                this.dataForm.createdAt = data.stockOrder.createdAt
                this.dataForm.updatedAt = data.stockOrder.updatedAt
                this.dataForm.businessId = data.stockOrder.businessId
                this.dataForm.sendStatus = data.stockOrder.sendStatus
                this.dataForm.payStatus = data.stockOrder.payStatus
                this.dataForm.price = data.stockOrder.price
                this.dataForm.payPrice = data.stockOrder.payPrice
                this.dataForm.printExpress = data.stockOrder.printExpress
                this.dataForm.printDistribution = data.stockOrder.printDistribution
                this.dataForm.operatorUserId = data.stockOrder.operatorUserId
                this.dataForm.payMethod = data.stockOrder.payMethod
                this.dataForm.insertType = data.stockOrder.insertType
                this.dataForm.sendPhone = data.stockOrder.sendPhone
                this.dataForm.idnumber = data.stockOrder.idnumber
                this.dataForm.imagefront = data.stockOrder.imagefront
                this.dataForm.imageback = data.stockOrder.imageback
                this.dataForm.idname = data.stockOrder.idname
                this.dataForm.identId = data.stockOrder.identId
                this.dataForm.marketFreightId = data.stockOrder.marketFreightId
                this.dataForm.originFreight = data.stockOrder.originFreight
                this.dataForm.mpId = data.stockOrder.mpId
                this.dataForm.groupStatus = data.stockOrder.groupStatus
                this.dataForm.groupPrice = data.stockOrder.groupPrice
                this.dataForm.relatePurchaseOrder = data.stockOrder.relatePurchaseOrder
                this.dataForm.orderType = data.stockOrder.orderType
                this.dataForm.freightId = data.stockOrder.freightId
                this.dataForm.originPrice = data.stockOrder.originPrice
                this.dataForm.vipDiscount = data.stockOrder.vipDiscount
                this.dataForm.tradePriceDiscount = data.stockOrder.tradePriceDiscount
                this.dataForm.couponUseDesc = data.stockOrder.couponUseDesc
                this.dataForm.isGroupBuying = data.stockOrder.isGroupBuying
                this.dataForm.userGroupBuyingId = data.stockOrder.userGroupBuyingId
                this.dataForm.payTime = data.stockOrder.payTime
                this.dataForm.confirmTime = data.stockOrder.confirmTime
                this.dataForm.payCompany = data.stockOrder.payCompany
                this.dataForm.activityDiscount = data.stockOrder.activityDiscount
                this.dataForm.fullActivityDiscount = data.stockOrder.fullActivityDiscount
                this.dataForm.fullActivityId = data.stockOrder.fullActivityId
                this.dataForm.fullActivityDesc = data.stockOrder.fullActivityDesc
                this.dataForm.deliverNum = data.stockOrder.deliverNum
                this.dataForm.expressType = data.stockOrder.expressType
                this.dataForm.isMainOrder = data.stockOrder.isMainOrder
                this.dataForm.isNeedOrder = data.stockOrder.isNeedOrder
                this.dataForm.originBusinessId = data.stockOrder.originBusinessId
                this.dataForm.isIndependent = data.stockOrder.isIndependent
                this.dataForm.storesAccount = data.stockOrder.storesAccount
                this.dataForm.isCustomerSelect = data.stockOrder.isCustomerSelect
                this.dataForm.shareDetail = data.stockOrder.shareDetail
                this.dataForm.refundStatus = data.stockOrder.refundStatus
                this.dataForm.refundType = data.stockOrder.refundType
                this.dataForm.message = data.stockOrder.message
                this.dataForm.tax = data.stockOrder.tax
                this.dataForm.isNewOrder = data.stockOrder.isNewOrder
                this.dataForm.deliveryType = data.stockOrder.deliveryType
                this.dataForm.pickupSiteId = data.stockOrder.pickupSiteId
                this.dataForm.pickupCode = data.stockOrder.pickupCode
                this.dataForm.transactionId = data.stockOrder.transactionId
                this.dataForm.crossBorder = data.stockOrder.crossBorder
                this.dataForm.defrayPush = data.stockOrder.defrayPush
                this.dataForm.payPush = data.stockOrder.payPush
                this.dataForm.orderPush = data.stockOrder.orderPush
                this.dataForm.logisticsPush = data.stockOrder.logisticsPush
                this.dataForm.inventoryPush = data.stockOrder.inventoryPush
                this.dataForm.cancelPush = data.stockOrder.cancelPush
                this.dataForm.refundPush = data.stockOrder.refundPush
                this.dataForm.integralId = data.stockOrder.integralId
                this.dataForm.integralInfo = data.stockOrder.integralInfo
                this.dataForm.star = data.stockOrder.star
                this.dataForm.scoreStatus = data.stockOrder.scoreStatus
                this.dataForm.shareType = data.stockOrder.shareType
                this.dataForm.shareComplete = data.stockOrder.shareComplete
                this.dataForm.expressSelect = data.stockOrder.expressSelect
                this.dataForm.headBusinessId = data.stockOrder.headBusinessId
                this.dataForm.headBusiness = data.stockOrder.headBusiness
                this.dataForm.importDiscount = data.stockOrder.importDiscount
                this.dataForm.refundOrderId = data.stockOrder.refundOrderId
                this.dataForm.sendTime = data.stockOrder.sendTime
                this.dataForm.mainmoney = data.stockOrder.mainmoney
                this.dataForm.isMiddleware = data.stockOrder.isMiddleware
                this.dataForm.isPlat = data.stockOrder.isPlat
                this.dataForm.purchaseOrder = data.stockOrder.purchaseOrder
                this.dataForm.source = data.stockOrder.source
                this.dataForm.toBusinessId = data.stockOrder.toBusinessId
                this.dataForm.mergeId = data.stockOrder.mergeId
                this.dataForm.freeTaxPrice = data.stockOrder.freeTaxPrice
                this.dataForm.helpSaleUser = data.stockOrder.helpSaleUser
                this.dataForm.helpUserPrice = data.stockOrder.helpUserPrice
                this.dataForm.ebpcode = data.stockOrder.ebpcode
                this.dataForm.ebpname = data.stockOrder.ebpname
                this.dataForm.pddOrderid = data.stockOrder.pddOrderid
                this.dataForm.freightTax = data.stockOrder.freightTax
                this.dataForm.wmsStatus = data.stockOrder.wmsStatus
                this.dataForm.wmsMsg = data.stockOrder.wmsMsg
                this.dataForm.wmsCancelStatus = data.stockOrder.wmsCancelStatus
                this.dataForm.wmsCancelMsg = data.stockOrder.wmsCancelMsg
                this.dataForm.guideId = data.stockOrder.guideId
                this.dataForm.pushCross = data.stockOrder.pushCross
                this.dataForm.buyPhone = data.stockOrder.buyPhone
                this.dataForm.freeFreightTax = data.stockOrder.freeFreightTax
                this.dataForm.fromType = data.stockOrder.fromType
                this.dataForm.pddName = data.stockOrder.pddName
                this.dataForm.pddPhone = data.stockOrder.pddPhone
                this.dataForm.pddIdnumber = data.stockOrder.pddIdnumber
                this.dataForm.pddIdName = data.stockOrder.pddIdName
                this.dataForm.pddPayNo = data.stockOrder.pddPayNo
                this.dataForm.pddAddress = data.stockOrder.pddAddress
                this.dataForm.pddSend = data.stockOrder.pddSend
                this.dataForm.pddDeliverStatus = data.stockOrder.pddDeliverStatus
                this.dataForm.ccType = data.stockOrder.ccType
                this.dataForm.pddRefundStatus = data.stockOrder.pddRefundStatus
                this.dataForm.pddOrderStatus = data.stockOrder.pddOrderStatus
                this.dataForm.color = data.stockOrder.color
                this.dataForm.pddAllAddress = data.stockOrder.pddAllAddress
                this.dataForm.isSubmit = data.stockOrder.isSubmit
                this.dataForm.storeId = data.stockOrder.storeId
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/order/stockorder/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'orderNum': this.dataForm.orderNum,
                'onlineOrderNum': this.dataForm.onlineOrderNum,
                'saleDate': this.dataForm.saleDate,
                'warehouseId': this.dataForm.warehouseId,
                'userId': this.dataForm.userId,
                'account': this.dataForm.account,
                'saleUserId': this.dataForm.saleUserId,
                'freight': this.dataForm.freight,
                'substitute': this.dataForm.substitute,
                'sendRemark': this.dataForm.sendRemark,
                'userRemark': this.dataForm.userRemark,
                'saleRemark': this.dataForm.saleRemark,
                'name': this.dataForm.name,
                'tel': this.dataForm.tel,
                'phone': this.dataForm.phone,
                'province': this.dataForm.province,
                'city': this.dataForm.city,
                'area': this.dataForm.area,
                'address': this.dataForm.address,
                'sendName': this.dataForm.sendName,
                'sendTel': this.dataForm.sendTel,
                'sendProvince': this.dataForm.sendProvince,
                'sendCity': this.dataForm.sendCity,
                'sendArea': this.dataForm.sendArea,
                'sendAddress': this.dataForm.sendAddress,
                'remark': this.dataForm.remark,
                'flag': this.dataForm.flag,
                'createdAt': this.dataForm.createdAt,
                'updatedAt': this.dataForm.updatedAt,
                'businessId': this.dataForm.businessId,
                'sendStatus': this.dataForm.sendStatus,
                'payStatus': this.dataForm.payStatus,
                'price': this.dataForm.price,
                'payPrice': this.dataForm.payPrice,
                'printExpress': this.dataForm.printExpress,
                'printDistribution': this.dataForm.printDistribution,
                'operatorUserId': this.dataForm.operatorUserId,
                'payMethod': this.dataForm.payMethod,
                'insertType': this.dataForm.insertType,
                'sendPhone': this.dataForm.sendPhone,
                'idnumber': this.dataForm.idnumber,
                'imagefront': this.dataForm.imagefront,
                'imageback': this.dataForm.imageback,
                'idname': this.dataForm.idname,
                'identId': this.dataForm.identId,
                'marketFreightId': this.dataForm.marketFreightId,
                'originFreight': this.dataForm.originFreight,
                'mpId': this.dataForm.mpId,
                'groupStatus': this.dataForm.groupStatus,
                'groupPrice': this.dataForm.groupPrice,
                'relatePurchaseOrder': this.dataForm.relatePurchaseOrder,
                'orderType': this.dataForm.orderType,
                'freightId': this.dataForm.freightId,
                'originPrice': this.dataForm.originPrice,
                'vipDiscount': this.dataForm.vipDiscount,
                'tradePriceDiscount': this.dataForm.tradePriceDiscount,
                'couponUseDesc': this.dataForm.couponUseDesc,
                'isGroupBuying': this.dataForm.isGroupBuying,
                'userGroupBuyingId': this.dataForm.userGroupBuyingId,
                'payTime': this.dataForm.payTime,
                'confirmTime': this.dataForm.confirmTime,
                'payCompany': this.dataForm.payCompany,
                'activityDiscount': this.dataForm.activityDiscount,
                'fullActivityDiscount': this.dataForm.fullActivityDiscount,
                'fullActivityId': this.dataForm.fullActivityId,
                'fullActivityDesc': this.dataForm.fullActivityDesc,
                'deliverNum': this.dataForm.deliverNum,
                'expressType': this.dataForm.expressType,
                'isMainOrder': this.dataForm.isMainOrder,
                'isNeedOrder': this.dataForm.isNeedOrder,
                'originBusinessId': this.dataForm.originBusinessId,
                'isIndependent': this.dataForm.isIndependent,
                'storesAccount': this.dataForm.storesAccount,
                'isCustomerSelect': this.dataForm.isCustomerSelect,
                'shareDetail': this.dataForm.shareDetail,
                'refundStatus': this.dataForm.refundStatus,
                'refundType': this.dataForm.refundType,
                'message': this.dataForm.message,
                'tax': this.dataForm.tax,
                'isNewOrder': this.dataForm.isNewOrder,
                'deliveryType': this.dataForm.deliveryType,
                'pickupSiteId': this.dataForm.pickupSiteId,
                'pickupCode': this.dataForm.pickupCode,
                'transactionId': this.dataForm.transactionId,
                'crossBorder': this.dataForm.crossBorder,
                'defrayPush': this.dataForm.defrayPush,
                'payPush': this.dataForm.payPush,
                'orderPush': this.dataForm.orderPush,
                'logisticsPush': this.dataForm.logisticsPush,
                'inventoryPush': this.dataForm.inventoryPush,
                'cancelPush': this.dataForm.cancelPush,
                'refundPush': this.dataForm.refundPush,
                'integralId': this.dataForm.integralId,
                'integralInfo': this.dataForm.integralInfo,
                'star': this.dataForm.star,
                'scoreStatus': this.dataForm.scoreStatus,
                'shareType': this.dataForm.shareType,
                'shareComplete': this.dataForm.shareComplete,
                'expressSelect': this.dataForm.expressSelect,
                'headBusinessId': this.dataForm.headBusinessId,
                'headBusiness': this.dataForm.headBusiness,
                'importDiscount': this.dataForm.importDiscount,
                'refundOrderId': this.dataForm.refundOrderId,
                'sendTime': this.dataForm.sendTime,
                'mainmoney': this.dataForm.mainmoney,
                'isMiddleware': this.dataForm.isMiddleware,
                'isPlat': this.dataForm.isPlat,
                'purchaseOrder': this.dataForm.purchaseOrder,
                'source': this.dataForm.source,
                'toBusinessId': this.dataForm.toBusinessId,
                'mergeId': this.dataForm.mergeId,
                'freeTaxPrice': this.dataForm.freeTaxPrice,
                'helpSaleUser': this.dataForm.helpSaleUser,
                'helpUserPrice': this.dataForm.helpUserPrice,
                'ebpcode': this.dataForm.ebpcode,
                'ebpname': this.dataForm.ebpname,
                'pddOrderid': this.dataForm.pddOrderid,
                'freightTax': this.dataForm.freightTax,
                'wmsStatus': this.dataForm.wmsStatus,
                'wmsMsg': this.dataForm.wmsMsg,
                'wmsCancelStatus': this.dataForm.wmsCancelStatus,
                'wmsCancelMsg': this.dataForm.wmsCancelMsg,
                'guideId': this.dataForm.guideId,
                'pushCross': this.dataForm.pushCross,
                'buyPhone': this.dataForm.buyPhone,
                'freeFreightTax': this.dataForm.freeFreightTax,
                'fromType': this.dataForm.fromType,
                'pddName': this.dataForm.pddName,
                'pddPhone': this.dataForm.pddPhone,
                'pddIdnumber': this.dataForm.pddIdnumber,
                'pddIdName': this.dataForm.pddIdName,
                'pddPayNo': this.dataForm.pddPayNo,
                'pddAddress': this.dataForm.pddAddress,
                'pddSend': this.dataForm.pddSend,
                'pddDeliverStatus': this.dataForm.pddDeliverStatus,
                'ccType': this.dataForm.ccType,
                'pddRefundStatus': this.dataForm.pddRefundStatus,
                'pddOrderStatus': this.dataForm.pddOrderStatus,
                'color': this.dataForm.color,
                'pddAllAddress': this.dataForm.pddAllAddress,
                'isSubmit': this.dataForm.isSubmit,
                'storeId': this.dataForm.storeId
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
