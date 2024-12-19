import axios from "axios";

// 创建一个 axios 实例
const service = axios.create({
    baseURL: 'http://localhost:8083/ssm_demo_war_exploded/',
    timeout: 5000
})

// request 拦截器
service.interceptors.request.use(
    config => {
        let jwtToken = window.localStorage.getItem("jwtToken");

        // 判断是否有 token
        if (jwtToken) {
            // 如果有 token, 将它添加到请求头
            config.headers.Authorization = jwtToken;
        } else {
            // 如果没有 token, 打印日志
            console.log('本次请求没有携带 token');
        }

        return config;
    },
    error => {
        // 请求失败的情况
        console.error('请求错误：', error);
        return Promise.reject(error);
    }
);


// 响应拦截器
service.interceptors.response.use(
    response => {
        // 可以在响应成功时做一些处理
        if (response.data.code !== 200) {
            console.log('响应数据：', response);
            return response; // 必须返回响应数据，才能继续处理
        }
        return response;
    },
    error => {
        // 响应失败的情况
        if (error.response.status > 400 && error.response.status < 500) {
            router.push('/login')
        }
        console.error('响应错误：', error);
        return Promise.reject(error);
    }
);

export default service