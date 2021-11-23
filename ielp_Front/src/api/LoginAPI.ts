export function register(data: LoginParam): Promise<any> {
    return requestService({
        url: "/register",
        method: "POST"
    })
}
export function login(data: LoginParam): Promise<any> {
    return requestService({
        url: "/login",
        method: "POST"
    })
}
