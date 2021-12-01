import React, { Component } from 'react';
import { Row, Col } from 'antd';
import { Nav, ConversitionBox, Daka, SpreadLine } from "@components/index";
import s from "./style.module.scss";
export default class Choice extends Component {
  constructor(props) {
    super(props);
    this.state = {
    }
  }

  render() {
    return (
      <div className={s.ChoiceBody}>
        {/* 导航栏 */}
        <Nav />
        {/* 页面主内容 */}
1
      </div>

    )
  }
}
