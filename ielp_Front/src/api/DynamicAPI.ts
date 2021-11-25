import { requestService } from "../base/request";

/**
 * 收藏，再次取消
 * @param dynamicId 动态id 
 * @returns Promise，无值或异常
 */
export function collect(dynamicId: number): Promise<any> {
    return requestService({
        url: "/collect",
        method: "POST",
        data: dynamicId
    })
}

interface CommentParam {
    dynamicId: number;
    comment: string;
}

/**
 * 评论
 * @param data 评论数据
 * @returns 
 */
export function comment(data: CommentParam): Promise<any> {
    return requestService({
        url: "/comment",
        method: "POST",
        data: data
    })
}

/**
 * 发布动态
 * @param data 动态信息（暂时只支持文本内容）
 * @returns Promise，值为空或异常
 */
export function publish(data: string): Promise<any> {
    return requestService({
        url: "/publish",
        method: "POST",
        data: data
    })
}

/**
 * 通过id获取动态
 * @param dynamicId 动态id
 * @returns Promise，值为动态
 */
export function getDynamicById(dynamicId: number): Promise<any> {
    return requestService({
        url: "/get-dynamic-by-id",
        method: "POST",
        data: dynamicId
    })
}

/**
 * 点赞，再次取消点赞
 * @param dynamicId 动态id
 * @returns Promise，值为空或异常
 */
export function like(dynamicId: number): Promise<any> {
    return requestService({
        url: "/like",
        method: "POST",
        data: dynamicId
    })
}

/**
 * 取消评论
 * @param dynamicId 动态id
 * @returns Promise，值为空或异常
 */
export function unComment(dynamicId: number): Promise<any> {
    return requestService({
        url: "/un-comment",
        method: "POST",
        data: dynamicId
    })
}

/**
 * 取消发布
 * @param dynamicId 动态id
 * @returns Promise，值为空或异常
 */
export function unPublish(dynamicId: number): Promise<any> {
    return requestService({
        url: "/un-publish",
        method: "POST",
        data: dynamicId
    })
}