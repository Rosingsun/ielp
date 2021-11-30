import { requestService } from "../base/request";

/**
 * 创建图片
 * @param data 图片属性，大概类型为图片表单
 * @returns Promise，无值（可能为异常）
 */
export function createImage(data: FormData): Promise<any> {
    return requestService({
        url: "/create-image",
        method: "POST",
        data: data,
    })
}

/**
 * 创建音乐
 * @param data 音乐属性
 * @returns Promise，无值（可能为异常）
 */
export function createMusic(data: FormData): Promise<any> {
    return requestService({
        url: "/create-music",
        method: "POST",
        data: data,
    })
}

/**
 * 通过id获取图片，在获取动态时可得到此id
 * @param imageId 图片id
 * @returns Promise，图片
 */
export function getImage(imageId: number): Promise<any> {
    return requestService({
        url: "/get-image",
        method: "POST",
        data: imageId
    })
}

/**
 * 通过id获取音乐，在获取动态时可得到此id
 * @param musicId 音乐id
 * @returns Promise，音乐
 */
export function getMusic(musicId: number): Promise<any> {
    return requestService({
        url: "/get-music",
        method: "POST",
        data: musicId,
    })
}
