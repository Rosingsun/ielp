import  * as api  from "../base/request";
import ApiConstants from '../constants/apiConstants';

export const Login = (params, callback) => {
  return api.getApi(ApiConstants.login, params, "POST")
}
export const userList = (params, callback) => {
  return api.getApi(ApiConstants.userList, params, "POST")
}