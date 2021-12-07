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
        <div className={s.searchPic}>
          <div className={s.pic}>
            <img src="http://pic.51yuansu.com/pic3/cover/04/01/04/5fa50a14e46df_610.jpg"></img>
          </div>
          <div className={s.transfromType}>
            <p>英语</p><p>中文</p>
          </div>
          <div>
            <p>英语</p><p>中文</p>
          </div>
        </div>
        {/* 中间一列 */}
        <div></div>
        {/* 左右边一列 */}
        <div></div>
      </div>
    )
  }
}
