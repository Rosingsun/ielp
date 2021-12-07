/**
 * 分割线
 * mainColor 主要的颜色
 */
import React, { Component } from 'react';
import { Row, Col } from 'antd';
import s from "./style.module.scss";
export default class ReadPic extends Component {
  constructor(props) {
    super(props);
    this.state = {

    }
  }

  render() {
    return (
      <div className={s.readPic}>
        {/* 最左边一列 */}
        <div></div>
        {/* 中间一列 */}
        <div></div>
        {/* 左右边一列 */}
        <div></div>
      </div>
    )
  }
}
