import getApi from "../base/request";
import ApiConstants from '../constants/apiConstants';
import {TRANSPORT} from '../constants/apiConstants';

// 翻译接口
export const transport = (params, callback) => {
  return getApi(ApiConstants.translate, params, "GET")
}