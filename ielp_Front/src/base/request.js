import axios from 'axios';
import { message } from 'antd';
//开发环境与产品环境的url
// const devBaseURL = 'localhost:9981';
// const proBaseURL = 'localhost:9981';
//判断url
// export const BASE_URL = process.env.NODE_ENV === 'development' ? devBaseURL : proBaseURL;
export const TIMEOUT = 5000;
//实例化对象与设置基础

const instance = axios.create({
    // baseURL: BASE_URL,
    timeout: TIMEOUT,
    headers: { 'Content-Type': 'application/x-www-form-urlencoded', 'Access-Control-Allow-Origin': '*' }
})

//添加拦截
instance.interceptors.request.use(config => {
    console.log('请求被拦截')
    return config
}, error => {

})

instance.interceptors.response.use(res => {
    return res.data
}, error => {
    return error;
})

/**
 * 
 * @param {String} type 传输的类型，一般就 post 和 get就好了 但是要大写
 * @param {String} url 连接后台的路由
 * @param {Object} data 传递给接口的对象数据
 */
const getApi = (url, params, method) => {
  const data =  axios({
        url: url,
        params: params,
        method: method,
        headers: { 
            'Content-Type': 'application/x-www-form-urlencoded',
            'Access-Control-Allow-Origin': '*',
             'Access-Control-Allow-Methods': '*'
        }
    })
        .then((res) => {
            return res;
        }).catch((err) => {
            message.error('接口发生错误');
            return err;
        });
        return data
}
// const spacialGetApi(url,params,method){

// }
export default getApi