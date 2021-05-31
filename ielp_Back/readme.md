# 后台管理系统

## 一、打开方法

1. 将文件导入IDEA中
2. 等待Maven仓库下载完成
3. 运行即可

## 二、管理员测试界面（该页面暂时禁用）

访问http://localhost:8080/admin/testPage

登陆测试界面，进行各项测试

## 三、提供接口

接口的使用请参考Controller层中的各项函数。

传递的参数请参考各params类。

### 3.1 举例：使用用户登陆接口

进入Controller包，打开`UserController`。

查看方法`login`。

```java
@PassToken
@PostMapping("/login")
@ResponseBody
public UserVO login(LoginParam loginParam) {
    UserVO data = new UserVO();
```

此处为`PostMapping`，那传入应该使用Post方法，并且url动作为`/login`。

然后查看传参表单`LoginParam`，一般作为函数参数。

```java
@Data
public class LoginParam {

    private String accountNum;

    private String passWord;
}
```

综上我们应当使用post方法给`/login`地址传递`accountNum`与`passWord`两个值。

最后就能返回JSON对象，详情返回格式请看`UserVO`。

```java
public class UserVO extends BaseVO {
    private UserDTO user;
    private UserInfoDTO userInfo;
    private String token;
    private boolean isLogin = false;
}
```

### 3.2 管理员接口（暂不可用）
`AdminController`
- 跳转测试界面
- 获取用户信息，包含历史记录，收藏
- 登陆与注册

### 3.3 用户接口

`UserController`

| 名称| 路径 | 参数 | 返回 |
| --- | --- | --- | --- |
| 登陆 | `/login`| `LoginParam`| `TokenVO` |
| 获取用户| `/get-user`|token信息| `UserVO` |
| 获取用户详情| `/get-user-info`|token信息| `UserVO` |

### 3.4 翻译接口

`TranslateController`

| 名称| 路径 | 参数 | 返回 |
| --- | --- | --- | --- |
| 翻译 | `/translate`| `TranslateParam`| `TranslateVO` |
| 收藏 | `/collection`| 历史记录id | `TranslateVO` |
| 翻译历史记录 | `/get-histories`| 用户id | `TranslateVO` |
| 翻译收藏记录 | `/get-histories`| 用户id | `TranslateVO` |

### 3.5 动态接口

`DynamicController`

| 名称| 路径 | 参数 | 返回 |
| --- | --- | --- | --- |
| 发表动态 | `/publish-dynamic`| `DynamicParam`| `DynamicVO` |
| 动态互动 | `/publish-interaction`| `DynamicInteractionParam` | `DynamicInteractionVO` |
| 获取用户动态 | `get-dynamic`| 用户id | `DynamicVO` |