export function hello(): Promise<any> {
    return requestService({
        url: "/hello",
        method: "POST"
    })
}
