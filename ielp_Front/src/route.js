// import Home from "@views/Home";
// import Data from "@views/Data";
// import Login from "@views/Login";
import * as page from "@views/index.js"
//顶部引入页面
/*
* @exprot routesConfig 导出页面
*/
const routesConfig = [
  {
    path: "/login",//登录注册
    component: page.Login,
    title:'登录注册',
    acehe:false// 是否在主菜单上显示
  },
  {
    path: "/home",
    component: page.Home,
    title:'主页',
    acehe:true,
  },
  {
    path: "/data",
    component: page.Data,
    title:"数据页",
    acehe:true,
  },
  {
    path: "/translate",
    component: page.Translate,
    title:"翻译页面",
    acehe:true,
  },
  {
    path: "/Chat",
    component: page.Chat,
    title:"即时聊天",
    acehe:true,
  },
  {
    path: "/Forum",
    component: page.Forum,
    title:"论坛",
    acehe:true,
  },
];
export default routesConfig;