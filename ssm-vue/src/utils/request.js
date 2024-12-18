import axios from "axios";

// 创建一个 axios 实例
const service = axios.create({
    baseURL: 'http://localhost:8083/ssm_demo_war_exploded/',
    timeout: 5000
})

// request 拦截器
service.interceptors.request.use(
    config => {
        // 在请求发送之前做一些事情
        return config;
    },
    error => {
        // 请求失败的情况
        console.error('请求错误：', error);
        return Promise.reject(error);
    }

)

// 响应拦截器（可选）
service.interceptors.response.use(
    response => {
        // 可以在响应成功时做一些处理
        console.log('响应数据：', response);
        return response; // 必须返回响应数据，才能继续处理
    },
    error => {
        // 响应失败的情况
        console.error('响应错误：', error);
        return Promise.reject(error);
    }
);

export default service