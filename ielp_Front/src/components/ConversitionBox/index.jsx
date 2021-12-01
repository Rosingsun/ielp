/**
 * 回答框
 * @param {String} title 题目标题
 * @param {Boolean} isBlue是否是蓝色的框（蓝色问题，红色回答）
 */
import React, { Component } from 'react';
import s from "./style.module.scss";
export default class ConversitionBox extends Component {
  constructor(props) {
    super(props);
    this.state = {
    };
  }

  subject(params) {

  }
  render() {
    return (
      <div className={s.ConversitionBox}>
        {
          this.props.isBlue ?
            <div className={`${s.questin}  ${s.blueQuestin}`}>
              <p>{this.props.title}</p>
            </div> :
            <div className={`${s.questin} ${s.redQuestin}`}>
              <p>{this.props.title}</p>
            </div>
        }
      </div>
    )
  }
}
