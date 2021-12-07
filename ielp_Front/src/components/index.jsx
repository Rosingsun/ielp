/**
 * 组件统一暴露接口
 * 能够复用的东西基本上都写出来组件
 * 统一格式
 * export { default as 组件名称 } from "./路径";//组件解释
 */
export { default as PageConfig } from './PrivateRoute/index';//路由
export { default as FriendBox } from './friendBox/index';//路由
export { default as Nav } from './Nav/index';//顶部导航（二级）
export { default as Daka } from './daka/index';//打卡的卡片
export { default as DownList } from "./downList/index";//下拉菜单
export { default as ConversitionBox } from "./ConversitionBox/index"//答题页面的弹出框样式
export { default as SpreadLine } from "./common/spreadLine/index";//分割线
export { default as PotLine } from "./common/potLine/index";//分割线
export { default as ForumItem } from "./common/forum/index";//社区框
export { default as ReadPic } from "./common/readPic";//识图结果组件
