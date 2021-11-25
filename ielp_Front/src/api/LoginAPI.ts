import { requestService } from "../base/request"

interface LoginParam {
    username: string;
    password: string;
}

/**
 * 注册用户
 * @param data 登录表单
 * @returns Promise，值为token
 */
export function register(data: LoginParam): Promise<any> {
    return requestService({
        url: "/register",
        method: "POST"
    })
}

/**
 * 登录用户
 * @param data 登录表单
 * @returns Promise，值为token
 */
export function login(data: LoginParam): Promise<any> {
    return requestService({
        url: "/login",
        method: "POST"
    })
}
