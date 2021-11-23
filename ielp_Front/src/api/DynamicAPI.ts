export function collect(data: number): Promise<any> {
    return requestService({
        url: "/collect",
        method: "POST"
    })
}
export function comment(data: CommentParam): Promise<any> {
    return requestService({
        url: "/comment",
        method: "POST"
    })
}
export function publish(data: string): Promise<any> {
    return requestService({
        url: "/publish",
        method: "POST"
    })
}
export function getDynamicById(data: number): Promise<any> {
    return requestService({
        url: "/get-dynamic-by-id",
        method: "POST"
    })
}
export function like(data: number): Promise<any> {
    return requestService({
        url: "/like",
        method: "POST"
    })
}
export function unComment(data: number): Promise<any> {
    return requestService({
        url: "/un-comment",
        method: "POST"
    })
}
export function unPublish(data: number): Promise<any> {
    return requestService({
        url: "/un-publish",
        method: "POST"
    })
}
