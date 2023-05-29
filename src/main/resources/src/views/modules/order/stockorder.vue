<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('order:stockorder:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('order:stockorder:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="id"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="orderNum"
        header-align="center"
        align="center"
        label="订单编号">
      </el-table-column>
      <el-table-column
        prop="onlineOrderNum"
        header-align="center"
        align="center"
        label="在线订单编号">
      </el-table-column>
      <el-table-column
        prop="saleDate"
        header-align="center"
        align="center"
        label="销售日期">
      </el-table-column>
      <el-table-column
        prop="warehouseId"
        header-align="center"
        align="center"
        label="仓库">
      </el-table-column>
      <el-table-column
        prop="userId"
        header-align="center"
        align="center"
        label="客户id">
      </el-table-column>
      <el-table-column
        prop="account"
        header-align="center"
        align="center"
        label="收款账户id">
      </el-table-column>
      <el-table-column
        prop="saleUserId"
        header-align="center"
        align="center"
        label="销售员id">
      </el-table-column>
      <el-table-column
        prop="freight"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="substitute"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="sendRemark"
        header-align="center"
        align="center"
        label="发货备注 0发货1不发货2预定">
      </el-table-column>
      <el-table-column
        prop="userRemark"
        header-align="center"
        align="center"
        label="客户备注">
      </el-table-column>
      <el-table-column
        prop="saleRemark"
        header-align="center"
        align="center"
        label="销售备注">
      </el-table-column>
      <el-table-column
        prop="name"
        header-align="center"
        align="center"
        label="收件人姓名">
      </el-table-column>
      <el-table-column
        prop="tel"
        header-align="center"
        align="center"
        label="收件人手机号">
      </el-table-column>
      <el-table-column
        prop="phone"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="province"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="city"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="area"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="address"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="sendName"
        header-align="center"
        align="center"
        label="发件人姓名">
      </el-table-column>
      <el-table-column
        prop="sendTel"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="sendProvince"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="sendCity"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="sendArea"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="sendAddress"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="remark"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="flag"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="createdAt"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="updatedAt"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="businessId"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="sendStatus"
        header-align="center"
        align="center"
        label="发货状态 0未发货 1已发货 2发货中3已收货 -1 已出货">
      </el-table-column>
      <el-table-column
        prop="payStatus"
        header-align="center"
        align="center"
        label="0未付款 1已付款">
      </el-table-column>
      <el-table-column
        prop="price"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="payPrice"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="printExpress"
        header-align="center"
        align="center"
        label="0未打印1已打印2部分打印   3 打印收银">
      </el-table-column>
      <el-table-column
        prop="printDistribution"
        header-align="center"
        align="center"
        label="是否打印配货单">
      </el-table-column>
      <el-table-column
        prop="operatorUserId"
        header-align="center"
        align="center"
        label="操作人userid">
      </el-table-column>
      <el-table-column
        prop="payMethod"
        header-align="center"
        align="center"
        label="支付方式 数据字典在admin.php">
      </el-table-column>
      <el-table-column
        prop="insertType"
        header-align="center"
        align="center"
        label="0erp后台添加、1小程序商城添加">
      </el-table-column>
      <el-table-column
        prop="sendPhone"
        header-align="center"
        align="center"
        label="发货人电话">
      </el-table-column>
      <el-table-column
        prop="idnumber"
        header-align="center"
        align="center"
        label="身份证号码">
      </el-table-column>
      <el-table-column
        prop="imagefront"
        header-align="center"
        align="center"
        label="身份证正面照片">
      </el-table-column>
      <el-table-column
        prop="imageback"
        header-align="center"
        align="center"
        label="身份证反面照片">
      </el-table-column>
      <el-table-column
        prop="idname"
        header-align="center"
        align="center"
        label="身份证姓名">
      </el-table-column>
      <el-table-column
        prop="identId"
        header-align="center"
        align="center"
        label="erp_shopmp_identity_card的id">
      </el-table-column>
      <el-table-column
        prop="marketFreightId"
        header-align="center"
        align="center"
        label="erp_market_freight的id,用户选择的运费优惠">
      </el-table-column>
      <el-table-column
        prop="originFreight"
        header-align="center"
        align="center"
        label="优惠前的运费">
      </el-table-column>
      <el-table-column
        prop="mpId"
        header-align="center"
        align="center"
        label="馆区id">
      </el-table-column>
      <el-table-column
        prop="groupStatus"
        header-align="center"
        align="center"
        label="团购订单状态0不是团购单,1拼单中未付款,2拼单中待发货,3拼单成功未付款,4拼单成功待发货,5拼单失败退款中">
      </el-table-column>
      <el-table-column
        prop="groupPrice"
        header-align="center"
        align="center"
        label="团购价或团购原价">
      </el-table-column>
      <el-table-column
        prop="relatePurchaseOrder"
        header-align="center"
        align="center"
        label="关联采购订单">
      </el-table-column>
      <el-table-column
        prop="orderType"
        header-align="center"
        align="center"
        label="订单类型 1 商品订单2充值订单">
      </el-table-column>
      <el-table-column
        prop="freightId"
        header-align="center"
        align="center"
        label="运费模版组合ID">
      </el-table-column>
      <el-table-column
        prop="originPrice"
        header-align="center"
        align="center"
        label="原价">
      </el-table-column>
      <el-table-column
        prop="vipDiscount"
        header-align="center"
        align="center"
        label="会员优惠金额">
      </el-table-column>
      <el-table-column
        prop="tradePriceDiscount"
        header-align="center"
        align="center"
        label="批发价优惠金额">
      </el-table-column>
      <el-table-column
        prop="couponUseDesc"
        header-align="center"
        align="center"
        label="优惠券使用描述">
      </el-table-column>
      <el-table-column
        prop="isGroupBuying"
        header-align="center"
        align="center"
        label="是否是团购订单 0 否 其他是团购id">
      </el-table-column>
      <el-table-column
        prop="userGroupBuyingId"
        header-align="center"
        align="center"
        label="用户的团购记录">
      </el-table-column>
      <el-table-column
        prop="payTime"
        header-align="center"
        align="center"
        label="支付时间">
      </el-table-column>
      <el-table-column
        prop="confirmTime"
        header-align="center"
        align="center"
        label="确认收货时间">
      </el-table-column>
      <el-table-column
        prop="payCompany"
        header-align="center"
        align="center"
        label="汇付 huifu 通联tonglian">
      </el-table-column>
      <el-table-column
        prop="activityDiscount"
        header-align="center"
        align="center"
        label="活动优惠详情">
      </el-table-column>
      <el-table-column
        prop="fullActivityDiscount"
        header-align="center"
        align="center"
        label="全场活动详情">
      </el-table-column>
      <el-table-column
        prop="fullActivityId"
        header-align="center"
        align="center"
        label="全场活动id">
      </el-table-column>
      <el-table-column
        prop="fullActivityDesc"
        header-align="center"
        align="center"
        label="全场活动">
      </el-table-column>
      <el-table-column
        prop="deliverNum"
        header-align="center"
        align="center"
        label="快递单编号">
      </el-table-column>
      <el-table-column
        prop="expressType"
        header-align="center"
        align="center"
        label="快递类型">
      </el-table-column>
      <el-table-column
        prop="isMainOrder"
        header-align="center"
        align="center"
        label="是否独立主体面单">
      </el-table-column>
      <el-table-column
        prop="isNeedOrder"
        header-align="center"
        align="center"
        label="是否是无需物流 1是 0 否">
      </el-table-column>
      <el-table-column
        prop="originBusinessId"
        header-align="center"
        align="center"
        label="分店id">
      </el-table-column>
      <el-table-column
        prop="isIndependent"
        header-align="center"
        align="center"
        label="是否独立库存订单">
      </el-table-column>
      <el-table-column
        prop="storesAccount"
        header-align="center"
        align="center"
        label="门店分账详情">
      </el-table-column>
      <el-table-column
        prop="isCustomerSelect"
        header-align="center"
        align="center"
        label="是否是客户选择的发货地址1是0否">
      </el-table-column>
      <el-table-column
        prop="shareDetail"
        header-align="center"
        align="center"
        label="分账明细">
      </el-table-column>
      <el-table-column
        prop="refundStatus"
        header-align="center"
        align="center"
        label="1退款中，2已同意">
      </el-table-column>
      <el-table-column
        prop="refundType"
        header-align="center"
        align="center"
        label="退款类型，0，无，1仅退款，2退货退款">
      </el-table-column>
      <el-table-column
        prop="message"
        header-align="center"
        align="center"
        label="留言">
      </el-table-column>
      <el-table-column
        prop="tax"
        header-align="center"
        align="center"
        label="税费">
      </el-table-column>
      <el-table-column
        prop="isNewOrder"
        header-align="center"
        align="center"
        label="是否新人订单">
      </el-table-column>
      <el-table-column
        prop="deliveryType"
        header-align="center"
        align="center"
        label="发货类型">
      </el-table-column>
      <el-table-column
        prop="pickupSiteId"
        header-align="center"
        align="center"
        label="自提点id">
      </el-table-column>
      <el-table-column
        prop="pickupCode"
        header-align="center"
        align="center"
        label="自提码">
      </el-table-column>
      <el-table-column
        prop="transactionId"
        header-align="center"
        align="center"
        label="支付订单号">
      </el-table-column>
      <el-table-column
        prop="crossBorder"
        header-align="center"
        align="center"
        label="是否境外订单">
      </el-table-column>
      <el-table-column
        prop="defrayPush"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="payPush"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="orderPush"
        header-align="center"
        align="center"
        label="0未推送1推送成功2推送中待回执3回执失败">
      </el-table-column>
      <el-table-column
        prop="logisticsPush"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="inventoryPush"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="cancelPush"
        header-align="center"
        align="center"
        label="撤销推送单状态">
      </el-table-column>
      <el-table-column
        prop="refundPush"
        header-align="center"
        align="center"
        label="退货单状态">
      </el-table-column>
      <el-table-column
        prop="integralId"
        header-align="center"
        align="center"
        label="积分兑换商品/积分id">
      </el-table-column>
      <el-table-column
        prop="integralInfo"
        header-align="center"
        align="center"
        label="积分详情">
      </el-table-column>
      <el-table-column
        prop="star"
        header-align="center"
        align="center"
        label="订单星级">
      </el-table-column>
      <el-table-column
        prop="scoreStatus"
        header-align="center"
        align="center"
        label="积分获得状态，1表示已获得">
      </el-table-column>
      <el-table-column
        prop="shareType"
        header-align="center"
        align="center"
        label="分账类型，与支付类型挂钩，0表示没分账">
      </el-table-column>
      <el-table-column
        prop="shareComplete"
        header-align="center"
        align="center"
        label="1 分账完成">
      </el-table-column>
      <el-table-column
        prop="expressSelect"
        header-align="center"
        align="center"
        label="1默认 2自选">
      </el-table-column>
      <el-table-column
        prop="headBusinessId"
        header-align="center"
        align="center"
        label="导入的优惠">
      </el-table-column>
      <el-table-column
        prop="headBusiness"
        header-align="center"
        align="center"
        label="总店事业部id">
      </el-table-column>
      <el-table-column
        prop="importDiscount"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="refundOrderId"
        header-align="center"
        align="center"
        label="退款 销售单关联">
      </el-table-column>
      <el-table-column
        prop="sendTime"
        header-align="center"
        align="center"
        label="发货时间">
      </el-table-column>
      <el-table-column
        prop="mainmoney"
        header-align="center"
        align="center"
        label="平台下总店是否收账">
      </el-table-column>
      <el-table-column
        prop="isMiddleware"
        header-align="center"
        align="center"
        label="中间件 0 不是">
      </el-table-column>
      <el-table-column
        prop="isPlat"
        header-align="center"
        align="center"
        label="是否是平台订单">
      </el-table-column>
      <el-table-column
        prop="purchaseOrder"
        header-align="center"
        align="center"
        label="订单关联采购单">
      </el-table-column>
      <el-table-column
        prop="source"
        header-align="center"
        align="center"
        label="货物来源 oupai 欧派">
      </el-table-column>
      <el-table-column
        prop="toBusinessId"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="mergeId"
        header-align="center"
        align="center"
        label="关联的合并支付单">
      </el-table-column>
      <el-table-column
        prop="freeTaxPrice"
        header-align="center"
        align="center"
        label="免税金额">
      </el-table-column>
      <el-table-column
        prop="helpSaleUser"
        header-align="center"
        align="center"
        label="帮卖 分销人的 wxuser_id">
      </el-table-column>
      <el-table-column
        prop="helpUserPrice"
        header-align="center"
        align="center"
        label="帮卖 分销人的盈利">
      </el-table-column>
      <el-table-column
        prop="ebpcode"
        header-align="center"
        align="center"
        label="电商平台代码">
      </el-table-column>
      <el-table-column
        prop="ebpname"
        header-align="center"
        align="center"
        label="电商平台名称">
      </el-table-column>
      <el-table-column
        prop="pddOrderid"
        header-align="center"
        align="center"
        label="拼多多订单id">
      </el-table-column>
      <el-table-column
        prop="freightTax"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="wmsStatus"
        header-align="center"
        align="center"
        label="推送到wms系统的状态 0 未推送 1推送成功 2失败">
      </el-table-column>
      <el-table-column
        prop="wmsMsg"
        header-align="center"
        align="center"
        label="wms 返回的提示">
      </el-table-column>
      <el-table-column
        prop="wmsCancelStatus"
        header-align="center"
        align="center"
        label="推送到wms取消系统的状态 0 未推送 1推送成功 2失败">
      </el-table-column>
      <el-table-column
        prop="wmsCancelMsg"
        header-align="center"
        align="center"
        label="wms 返回的提示">
      </el-table-column>
      <el-table-column
        prop="guideId"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="pushCross"
        header-align="center"
        align="center"
        label="分账物流信息采集">
      </el-table-column>
      <el-table-column
        prop="buyPhone"
        header-align="center"
        align="center"
        label="购买人手机号">
      </el-table-column>
      <el-table-column
        prop="freeFreightTax"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="fromType"
        header-align="center"
        align="center"
        label="订单来源">
      </el-table-column>
      <el-table-column
        prop="pddName"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="pddPhone"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="pddIdnumber"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="pddIdName"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="pddPayNo"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="pddAddress"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="pddSend"
        header-align="center"
        align="center"
        label="pdd 发货状态">
      </el-table-column>
      <el-table-column
        prop="pddDeliverStatus"
        header-align="center"
        align="center"
        label="pdd 物流轨迹 0 1已揽收 2 已签收">
      </el-table-column>
      <el-table-column
        prop="ccType"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="pddRefundStatus"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="pddOrderStatus"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="color"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="pddAllAddress"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="isSubmit"
        header-align="center"
        align="center"
        label="0 未确认 1已确认 2失败">
      </el-table-column>
      <el-table-column
        prop="storeId"
        header-align="center"
        align="center"
        label="委外仓id">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
  import AddOrUpdate from './stockorder-add-or-update'
  export default {
    data () {
      return {
        dataForm: {
          key: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false
      }
    },
    components: {
      AddOrUpdate
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/order/stockorder/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      // 每页数
      sizeChangeHandle (val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle (val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle (id) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id)
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/order/stockorder/delete'),
            method: 'post',
            data: this.$http.adornData(ids, false)
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      }
    }
  }
</script>
