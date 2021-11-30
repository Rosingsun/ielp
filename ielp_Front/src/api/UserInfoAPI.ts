import { requestService } from "../base/request"

/**
 * 返回用户信息，详细信息见后台
 * @param userId 用户id
 * @returns Promise
 */
export function getUserInfoById(userId: number): Promise<any> {
    return requestService({
        url: "/get-user-info-by-id",
        method: "POST",
        data: userId,
    })
}