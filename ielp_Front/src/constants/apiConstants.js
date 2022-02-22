export const HOME = 'http://localhost:9981';//例子，使用时候换路径
export const TRANSPORT = "http://api.fanyi.baidu.com/api/trans/vip/translate";//百度翻译
export const PIC_GET_TOKEN = "https://aip.baidubce.com/oauth/2.0/token";//百度识图，获取token
export const PIC_READ = "https://aip.baidubce.com/api/v1/solution/direct/imagerecognition/combination";//百度识图API
export const readPicPass = "Yc20Gqu9Xqr9uSDxYcLkciotBwwAIekj";//百度识图密钥
export const readPicKey = "FC5cUReV0TIoBQSzUO6kMBv3";//百度识图APIkey
export const APPID = "20210308000719477";//百度翻译id
export const pass = "yfPd92dO0_xafBRSNNyc";//百度翻译密匙
export default {
  // 借用其他厂商的api，为了解决跨域的问题
  translate: "/translate",//百度翻译
  pic_getToken:"/getToken",//百度识图_获取token
  pic_read:'/readPic',//百度识图

  // 自己的api接口
  login: HOME + '/users/login',//测试路径
  userList: HOME + '/users/userList'//测试路径
}