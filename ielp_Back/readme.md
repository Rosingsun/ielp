# 后台管理系统

## 打开方法

1. 将文件导入IDEA中
2. 等待Maven仓库下载完成
3. 运行即可

## 管理员测试界面（该页面暂时禁用）

访问http://localhost:8080/admin/testPage

登陆测试界面，进行各项测试

## 提供接口

接口的使用请参考Controller层中的各项函数。

传递的参数请参考各params类。

### 举例：使用用户登陆接口

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

### 管理员接口（暂不可用）
`AdminController`
- 跳转测试界面
- 获取用户信息，包含历史记录，收藏
- 登陆与注册

### 用户接口
`UserController`
- 登陆
- 获取用户安全信息

登录功能使用了内联界面，之后根据需求修改。