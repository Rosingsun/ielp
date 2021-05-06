import getApi from "../base/request";
import ApiConstants from '../constants/apiConstants';

export const Login = (params, callback) => {
    return getApi(ApiConstants.login, params, "POST")
}
export const userList = (params, callback) => {
    return getApi(ApiConstants.userList, params, "POST")
}