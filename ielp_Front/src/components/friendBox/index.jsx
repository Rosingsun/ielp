import React, { Component } from "react";
import { Row, Col, Divider, Avatar, Input, Tabs, Spin } from 'antd';
import routesConfig from "@src/route";
import s from "./style.module.scss";
// function PageConfig() {
class FriendBox extends Component {
  render() {
    return (
      <div className={s.friendBox}>
        <div className={s.userHead}>
          <Avatar src="http://pic.51yuansu.com/backgd/cover/00/56/64/5d089d0b2cc59.jpg!/fw/780/quality/90/unsharp/true/compress/true" size={50} />
          <div className={s.userName}>
            ta的眸子
          </div>
          <div className={s.userState}>
            <div className={s.time}>
              3min
            </div>
            <div className={s.unRead}>
              3
            </div>
          </div>
        </div>
        <div className={s.userInfo}>

          <div className={s.userWord}>
            他的名字正好你的按时
          </div>
        </div>

      </div >
    );
  }
}
export default FriendBox;