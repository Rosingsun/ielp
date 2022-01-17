import * as api from "../base/request";
import ApiConstants from '../constants/apiConstants';
import {TRANSPORT} from '../constants/apiConstants';

// 翻译接口
export const transport = (params, callback) => {
  return api.getApi(ApiConstants.translate, params, "GET")
}
// 获取token
export const pic_getToekn = (params, callback) => {
  return api.getApi(ApiConstants.pic_getToken, params, "GET")
}
//百度识图
export const pic_read = (data,urlParams, callback) => {
  console.log('ApiConstants.pic_read',ApiConstants.pic_read)
  console.log('data',data)
  console.log('ApiConstants.pic_read')
  return api.postApi(ApiConstants.pic_read, data, "POST",urlParams)
}