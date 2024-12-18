import request from '@/utils/request'


// 数据根据id查找客户
export function queryByIdEcho(id) {
    return request({
        url: `emp/${id}`,
        method: 'get',
    })
}

// 编辑数据
export function edit(id,data) {
    return request({
        url: `emp/update/${id}`,
        method: 'put',
        data: data
    })
}

// 删除数据
export function deleteById(id) {
    return request({
        url: `emp`,
        method: 'delete',
        params: { id },
    })
}
// 分页查询
export function queryByPage(pageNum, pageSize) {
    return request({
        url: `emp/page/${pageNum}/${pageSize}`,
        method: 'get'
    })
}

// 根据 name,Id 动态查询
export function queryById(query) {
    return request({
        url: `emp/search`,
        method: 'get',
        params: query
    })
}
// 新增客户
export function add(data) {
    return request({
        url: `emp`,
        method: 'post',
        data: data,
        headers: {
            'Content-Type': 'application/json'  // 设置正确的Content-Type
        }
    })
}

// 客户等级
export function grade() {
    return request({
        url: `grade`,
        method: 'get',
    })
}

// 客户所在行业
export function industry() {
    return request({
        url: `industry`,
        method: 'get',
    })
}

// 客户来源
export function source() {
    return request({
        url: `source`,
        method: 'get',
    })
}