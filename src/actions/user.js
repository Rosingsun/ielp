import axios from 'axios';
import getApi from "../base/request";
import ApiConstants from '../constants/apiConstants';

export const getUserInfo = (params, callback) => {
    return getApi(ApiConstants.userInfo, params, "POST")
}
export const load = (params, callback) => {
    return getApi(ApiConstants.allUser, params, "POST")
}