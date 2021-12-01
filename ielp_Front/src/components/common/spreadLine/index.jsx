/**
 * 分割线
 * mainColor 主要的颜色
 */
import React, { Component } from 'react';
import { Row, Col } from 'antd';
import s from "./style.module.scss";
export default class SpreadLine extends Component {
  constructor(props) {
    super(props);
    this.state = {

    }
  }

  render() {
    return (
      <div className={s.SpreadLine}>
        <div className={s.headCircle} style={{ backgroundColor: this.props.mainColor || '#efefef' }}>{this.props.title || '标题'}</div>
        <div className={s.line} style={{ borderColor: this.props.borderColor || 'rgba(151,143,183,1)' }}></div>
      </div>
    )
  }
}
