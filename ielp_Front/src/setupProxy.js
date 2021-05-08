// 域名 配置文件，拒绝跨域问题
// 格式说明
// proxy('/translate(你写的路径)',{
//   target:"http://api.fanyi.baidu.com/api/trans/vip/translate（目标路径）",
//   changeOrigin:true,（跟着我写就好啦）
  // pathRewrite:{'^/translate':''}（跟着我写就好啦）
// })
const proxy = require("http-proxy-middleware")
module.exports= function(app){
  app.use(
    proxy('/translate',{
      target:"http://api.fanyi.baidu.com/api/trans/vip/translate",
      changeOrigin:true,
      pathRewrite:{'^/translate':''}
    })
  )
}