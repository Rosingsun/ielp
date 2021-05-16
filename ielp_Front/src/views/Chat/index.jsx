import React, { Component } from 'react';
import { Row, Col, Divider } from 'antd';
import s from "./style.module.scss";
export default class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {

    };
  }
  render() {
    return (
      <div className={s.body}>
        <Row justify="center" align="top">
          <Col span={18}>
            <div className={s.chatBox}></div>
          </Col>
        </Row>
      </div>
    );
  }
}
