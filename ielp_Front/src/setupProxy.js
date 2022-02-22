// 域名 配置文件，拒绝跨域问题
const proxy = require("http-proxy-middleware")
module.exports= function(app){
  app.use(
    proxy('/translate',{//百度翻译
      target:"http://api.fanyi.baidu.com/api/trans/vip/translate",//目标地址
      changeOrigin:true,//是否允许跨域
      pathRewrite:{'^/translate':''}//重写请求地址
    }),
    proxy('/getToken',{//百度识图获取token
      target:"https://aip.baidubce.com/oauth/2.0/token",
      changeOrigin:true,
      pathRewrite:{'^/getToken':''}
    }),
    proxy('/readPic',{//百度识图获取token
      target:"https://aip.baidubce.com/api/v1/solution/direct/imagerecognition/combination",
      changeOrigin:true,
      pathRewrite:{'^/readPic':''}
    })
  )
}