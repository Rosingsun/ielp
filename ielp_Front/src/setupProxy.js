// 域名 配置文件，拒绝跨域问题
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