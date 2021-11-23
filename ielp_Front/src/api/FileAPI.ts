export function createImage(data: MultipartFile): Promise<any> {
    return requestService({
        url: "/create-image",
        method: "POST"
    })
}
export function createMusic(data: MultipartFile): Promise<any> {
    return requestService({
        url: "/create-music",
        method: "POST"
    })
}
export function getImage(data: number): Promise<any> {
    return requestService({
        url: "/get-image",
        method: "POST"
    })
}
export function getMusic(data: number): Promise<any> {
    return requestService({
        url: "/get-music",
        method: "POST"
    })
}
