import React, { Component } from 'react';
import { Row, Col } from 'antd';
import { Nav, ConversitionBox, Daka, SpreadLine, PotLine } from "@components/index";
import s from "./style.module.scss";
export default class Choice extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posArr: [1, 3, 4, 54, 12,],
    }
  }

  render() {
    return (
      <div className={s.ChoiceBody}>
        {/* 导航栏 */}
        <Nav />
        {/* 页面主内容 */}
        <div className={s.potLine}>
          <PotLine posNum={this.state.posArr} />
        </div>
      </div>

    )
  }
}
