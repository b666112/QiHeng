function getBusinessList (params) {
    return $axios({
        url: '/business/page',
        method: 'get',
        params
    })
}

// 修改---启用禁用接口
function enableOrDisableBusiness (params) {
    return $axios({
        url: '/business',
        method: 'put',
        data: { ...params }
    })
}

// 新增---添加商家
function addBusiness (params) {
    return $axios({
        url: '/business',
        method: 'post',
        data: { ...params }
    })
}

// 修改---添加商家
function editBusiness (params) {
    return $axios({
        url: '/business/updatePassword',
        method: 'put',
        data: { ...params }
    })
}

// 修改页面反查详情接口
function queryBusinessById (id) {
    return $axios({
        url: `/business/${id}`,
        method: 'get'
    })
}
function updateBusinessPassword(params){
    return $axios({
        url:'/business',
        method:'put',
        data: params
    })
}