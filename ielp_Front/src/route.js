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
    path: "/Register",
    component: page.Register,
    title:"注册",
    acehe:true,
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
  {
    path: "/Test",
    component: page.Test,
    title:"测试",
    acehe:true,
  },{
    path: "/choice",
    component: page.Choice,
    title:"测试",
    acehe:true,
  },
  {
    path: "/learn",
    component: page.Learn,
    title:"学习",
    acehe:true,
  },
  {
    path: "/person",
    component: page.Person,
    title:"个人中心",
    acehe:true,
  },
];
export default routesConfig;