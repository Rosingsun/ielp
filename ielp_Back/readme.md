# 后台管理系统

## 打开方法

1. 将文件导入IDEA中
2. 等待Maven仓库下载完成
3. 运行即可

## 管理员测试界面

访问http://localhost:8080/admin/testPage

登陆测试界面，进行各项测试

## 提供接口

`AdminController`
- 提供管理员登录

`UserController`



|名称|地址|
|----|----|
|查询所有用户|/getAllUser|
|根据ID查询用户|/getUserById 参数：id|
|登录功能|/login|

登录功能使用了内联界面，之后根据需求修改。