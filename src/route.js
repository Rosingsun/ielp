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
    path: "/userList",
    component: page.userList,
    title:"用户列表",
    acehe:true,
  },
  {
    path: "/loginOute",
    component: page.loginOute,
    title:"退出登录",
    acehe:true,
  }
];
export default routesConfig;