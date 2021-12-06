import React, { Component } from 'react';
import { Row, Col } from 'antd';
import { Nav, ConversitionBox, Daka, SpreadLine, PotLine } from "@components/index";
import s from "./style.module.scss";
export default class Choice extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posArr: [{
        id: 1,
        questionState: 0,//0,表示没答题，1表示正在答题，2表示已经答过，
        isRight: false,//isRight=true是答题正确，false是答题错误
      }, {
        id: 2,
        questionState: 1,//0,表示没答题，1表示正在答题，2表示已经答过，
        isRight: false,//isRight=true是答题正确，false是答题错误
      }, {
        id: 3,
        questionState: 2,//0,表示没答题，1表示正在答题，2表示已经答过，
        isRight: false,//isRight=true是答题正确，false是答题错误
      }, {
        id: 4,
        questionState: 2,//0,表示没答题，1表示正在答题，2表示已经答过，
        isRight: true,//isRight=true是答题正确，false是答题错误
      },],
      anwswer: ['A', 'B', 'C', 'D'],
      choicedNum: 0,
    }
  }

  render() {
    return (
      <div className={s.ChoiceBody}>
        {/* 导航栏 */}
        <Nav />
        {/* 页面主内容 */}
        <div className={s.potLine}>
          <div className={s.pot}>
            <PotLine posNum={this.state.posArr} />
          </div>
          <div className={s.questionBox}>
            <div className={s.questionTitle}>
              这里是题目的位置
              <div className={s.questionDetails}>也可以阅读理解</div>
            </div>

            <div className={s.questionAnswer}>
              <ul>
                {
                  this.state.anwswer.map((item, index) => {
                    return (
                      < li className={this.choicedNum == index ? { ...s.choiced } : s.unChoiced} onClick={(e) => { this.setState({ choicedNum: index }) }} key={item}>{item}</li>
                    )
                  })
                }

              </ul>
            </div>
          </div>
          <div className={s.questoinChoice}>
            <p style={{ backgroundColor: "#ffc300" }}>上一题</p>
            <p style={{ backgroundColor: "#a5d63f" }}>NEXT</p>
          </div>
        </div>
        <div className={s.thisState}>
          {
            this.state.isRight ? <div className={s.right}></div> : <div className={s.worng}></div>
          }
        </div>
      </div >

    )
  }
}
