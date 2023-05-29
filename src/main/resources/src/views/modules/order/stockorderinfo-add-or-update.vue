<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="stock_order id" prop="stockOrderId">
      <el-input v-model="dataForm.stockOrderId" placeholder="stock_order id"></el-input>
    </el-form-item>
    <el-form-item label="商品id" prop="productId">
      <el-input v-model="dataForm.productId" placeholder="商品id"></el-input>
    </el-form-item>
    <el-form-item label="销售订单上的数量" prop="number">
      <el-input v-model="dataForm.number" placeholder="销售订单上的数量"></el-input>
    </el-form-item>
    <el-form-item label="" prop="createdAt">
      <el-input v-model="dataForm.createdAt" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="updatedAt">
      <el-input v-model="dataForm.updatedAt" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="price">
      <el-input v-model="dataForm.price" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="已发货数量" prop="sendNum">
      <el-input v-model="dataForm.sendNum" placeholder="已发货数量"></el-input>
    </el-form-item>
    <el-form-item label="0正常1删除2取消" prop="flag">
      <el-input v-model="dataForm.flag" placeholder="0正常1删除2取消"></el-input>
    </el-form-item>
    <el-form-item label="0:普通,其他:限时特价的id" prop="specialId">
      <el-input v-model="dataForm.specialId" placeholder="0:普通,其他:限时特价的id"></el-input>
    </el-form-item>
    <el-form-item label="0:普通,其他:套餐spu的id" prop="unionId">
      <el-input v-model="dataForm.unionId" placeholder="0:普通,其他:套餐spu的id"></el-input>
    </el-form-item>
    <el-form-item label="下单的套餐数量" prop="unionNumber">
      <el-input v-model="dataForm.unionNumber" placeholder="下单的套餐数量"></el-input>
    </el-form-item>
    <el-form-item label="原价" prop="originPrice">
      <el-input v-model="dataForm.originPrice" placeholder="原价"></el-input>
    </el-form-item>
    <el-form-item label="会员优惠" prop="vipDiscount">
      <el-input v-model="dataForm.vipDiscount" placeholder="会员优惠"></el-input>
    </el-form-item>
    <el-form-item label="商品类型  0 普通商品 1 赠品 2 换购商品" prop="activitySkuType">
      <el-input v-model="dataForm.activitySkuType" placeholder="商品类型  0 普通商品 1 赠品 2 换购商品"></el-input>
    </el-form-item>
    <el-form-item label="活动id" prop="activityId">
      <el-input v-model="dataForm.activityId" placeholder="活动id"></el-input>
    </el-form-item>
    <el-form-item label="当前活动  none 不参加" prop="activityDesc">
      <el-input v-model="dataForm.activityDesc" placeholder="当前活动  none 不参加"></el-input>
    </el-form-item>
    <el-form-item label="换购价" prop="increasePrice">
      <el-input v-model="dataForm.increasePrice" placeholder="换购价"></el-input>
    </el-form-item>
    <el-form-item label="完税总价格" prop="taxprice">
      <el-input v-model="dataForm.taxprice" placeholder="完税总价格"></el-input>
    </el-form-item>
    <el-form-item label="应征关税" prop="customstax">
      <el-input v-model="dataForm.customstax" placeholder="应征关税"></el-input>
    </el-form-item>
    <el-form-item label="应征增值税" prop="valueaddedtax">
      <el-input v-model="dataForm.valueaddedtax" placeholder="应征增值税"></el-input>
    </el-form-item>
    <el-form-item label="应征消费税" prop="consumptiontax">
      <el-input v-model="dataForm.consumptiontax" placeholder="应征消费税"></el-input>
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
          stockOrderId: '',
          productId: '',
          number: '',
          createdAt: '',
          updatedAt: '',
          price: '',
          sendNum: '',
          flag: '',
          specialId: '',
          unionId: '',
          unionNumber: '',
          originPrice: '',
          vipDiscount: '',
          activitySkuType: '',
          activityId: '',
          activityDesc: '',
          increasePrice: '',
          taxprice: '',
          customstax: '',
          valueaddedtax: '',
          consumptiontax: ''
        },
        dataRule: {
          stockOrderId: [
            { required: true, message: 'stock_order id不能为空', trigger: 'blur' }
          ],
          productId: [
            { required: true, message: '商品id不能为空', trigger: 'blur' }
          ],
          number: [
            { required: true, message: '销售订单上的数量不能为空', trigger: 'blur' }
          ],
          createdAt: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          updatedAt: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sendNum: [
            { required: true, message: '已发货数量不能为空', trigger: 'blur' }
          ],
          flag: [
            { required: true, message: '0正常1删除2取消不能为空', trigger: 'blur' }
          ],
          specialId: [
            { required: true, message: '0:普通,其他:限时特价的id不能为空', trigger: 'blur' }
          ],
          unionId: [
            { required: true, message: '0:普通,其他:套餐spu的id不能为空', trigger: 'blur' }
          ],
          unionNumber: [
            { required: true, message: '下单的套餐数量不能为空', trigger: 'blur' }
          ],
          originPrice: [
            { required: true, message: '原价不能为空', trigger: 'blur' }
          ],
          vipDiscount: [
            { required: true, message: '会员优惠不能为空', trigger: 'blur' }
          ],
          activitySkuType: [
            { required: true, message: '商品类型  0 普通商品 1 赠品 2 换购商品不能为空', trigger: 'blur' }
          ],
          activityId: [
            { required: true, message: '活动id不能为空', trigger: 'blur' }
          ],
          activityDesc: [
            { required: true, message: '当前活动  none 不参加不能为空', trigger: 'blur' }
          ],
          increasePrice: [
            { required: true, message: '换购价不能为空', trigger: 'blur' }
          ],
          taxprice: [
            { required: true, message: '完税总价格不能为空', trigger: 'blur' }
          ],
          customstax: [
            { required: true, message: '应征关税不能为空', trigger: 'blur' }
          ],
          valueaddedtax: [
            { required: true, message: '应征增值税不能为空', trigger: 'blur' }
          ],
          consumptiontax: [
            { required: true, message: '应征消费税不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/order/stockorderinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.stockOrderId = data.stockOrderInfo.stockOrderId
                this.dataForm.productId = data.stockOrderInfo.productId
                this.dataForm.number = data.stockOrderInfo.number
                this.dataForm.createdAt = data.stockOrderInfo.createdAt
                this.dataForm.updatedAt = data.stockOrderInfo.updatedAt
                this.dataForm.price = data.stockOrderInfo.price
                this.dataForm.sendNum = data.stockOrderInfo.sendNum
                this.dataForm.flag = data.stockOrderInfo.flag
                this.dataForm.specialId = data.stockOrderInfo.specialId
                this.dataForm.unionId = data.stockOrderInfo.unionId
                this.dataForm.unionNumber = data.stockOrderInfo.unionNumber
                this.dataForm.originPrice = data.stockOrderInfo.originPrice
                this.dataForm.vipDiscount = data.stockOrderInfo.vipDiscount
                this.dataForm.activitySkuType = data.stockOrderInfo.activitySkuType
                this.dataForm.activityId = data.stockOrderInfo.activityId
                this.dataForm.activityDesc = data.stockOrderInfo.activityDesc
                this.dataForm.increasePrice = data.stockOrderInfo.increasePrice
                this.dataForm.taxprice = data.stockOrderInfo.taxprice
                this.dataForm.customstax = data.stockOrderInfo.customstax
                this.dataForm.valueaddedtax = data.stockOrderInfo.valueaddedtax
                this.dataForm.consumptiontax = data.stockOrderInfo.consumptiontax
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
              url: this.$http.adornUrl(`/order/stockorderinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'stockOrderId': this.dataForm.stockOrderId,
                'productId': this.dataForm.productId,
                'number': this.dataForm.number,
                'createdAt': this.dataForm.createdAt,
                'updatedAt': this.dataForm.updatedAt,
                'price': this.dataForm.price,
                'sendNum': this.dataForm.sendNum,
                'flag': this.dataForm.flag,
                'specialId': this.dataForm.specialId,
                'unionId': this.dataForm.unionId,
                'unionNumber': this.dataForm.unionNumber,
                'originPrice': this.dataForm.originPrice,
                'vipDiscount': this.dataForm.vipDiscount,
                'activitySkuType': this.dataForm.activitySkuType,
                'activityId': this.dataForm.activityId,
                'activityDesc': this.dataForm.activityDesc,
                'increasePrice': this.dataForm.increasePrice,
                'taxprice': this.dataForm.taxprice,
                'customstax': this.dataForm.customstax,
                'valueaddedtax': this.dataForm.valueaddedtax,
                'consumptiontax': this.dataForm.consumptiontax
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
