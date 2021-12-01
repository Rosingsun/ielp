import React, { Component } from 'react';
import { Row, Col } from 'antd';
import { Nav, ConversitionBox, Daka, SpreadLine } from "@components/index";
import s from "./style.module.scss";
export default class Test extends Component {
  constructor(props) {
    super(props);
    this.state = {
      questionIndex: 0,
    }
  }

  render() {
    return (
      <Row>
        <div className={s.testBody}>
          {/* 导航栏 */}
          <Nav />
          {/* 页面主内容 */}
          <Col span={18} push={6}>
            <div className={s.mainBody}>
              <Daka />

              <SpreadLine mainColor='red' />
              <div className={s.hardChoice}>
                <div className={s.choice}>12</div>
                <div className={s.choice}>12</div>
              </div>
              <SpreadLine mainColor='blue' />
              <div className={s.hardChoice}>
                <div className={s.choice}>12</div>
                <div className={s.choice}>12</div>
              </div>
            </div>
          </Col>
          {/* 菜单栏 */}
          <Col span={6} pull={18}>
            <div className={s.menu}>菜单栏</div>
          </Col>


        </div>
      </Row>

    )
  }
}
