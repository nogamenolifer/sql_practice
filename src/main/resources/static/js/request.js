(function (win) {
    axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'
    //创建axios实例
    const axios = axios.create({
        //请求公共部分
        baseURL: '/',
        //超时
        timeout: 10000
    })

    // // 设置请求拦截器
    // axios.interceptors.request.use(
    //     config => {
    //         // console.log(config) // 该处可以将config打印出来看一下，该部分将发送给后端（server端）
    //         config.headers.Authorization = store.state.token
    //         return config // 对config处理完后返回，下一步将向后端发送请求
    //     },
    //     error => { // 当发生错误时，执行该部分代码
    //         // console.log(error) // 调试用
    //         return Promise.reject(error)
    //     }
    // )

    // 定义响应拦截器 -->session值无效时,清空session,并强制跳转登录页
    axios.interceptors.response.use( res => {
        console.log("---响应拦截器---",res);
        const code = res.data.code;
        const msg = res.data.msg;
        console.log("---code---",code);
        // 响应状态码为 2xx 时触发成功的回调，形参中的 response 是“成功的结果”
        if(res.data.code === 0 && res.data.msg === "NOTLOGIN") {
            console.log("到达request");
            localStorage.removeItem('userInfo');
            window.top.location.href = '../pages/login.html';
        } else {
            return res.data;
        }
    }, error => {
        console.log("err:" + error);
        return Promise.reject(error);
    })
    export default axios;
})

