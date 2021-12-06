/**
 * 分割线
 * mainColor 主要的颜色
 */
import React, { Component } from 'react';
import { Row, Col } from 'antd';
import s from "./style.module.scss";
export default class PotLine extends Component {
  constructor(props) {
    super(props);
    this.state = {

    }
  }

  render() {
    return (
      <div className={s.potLine}>
        {
          this.props.posNum && this.props.posNum.map((item, index) => {
            return (
              <div className={s.pot} style={{backgroundColor:item.questionState==0?'gray':item.questionState==1?"#ffc300":item.isRight?"#a5d63f":"#d43030"}}></div>
            )
          })
        }
      </div>
    )
  }
}
