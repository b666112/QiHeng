// 查询列表页接口
const getOrderPage = (params) => {
  return $axios({
    url: 'order/page',
    method: 'get',
    params
  })
}
//查询订单详情接口
function getOrderDetailPage(orderId){
  return $axios({
    url:`/orderDetail/${orderId}`,
    method:'get'
  })
}
// 查看接口
const queryOrderDetailById = (id) => {
  return $axios({
    url: `order/stockorder/info/{id}`,
    method: 'get'
  })
}

// 取消，派送，完成接口
const editOrderDetail = (params) => {
  return $axios({
    url: '/order',
    method: 'put',
    data: { ...params }
  })
}
