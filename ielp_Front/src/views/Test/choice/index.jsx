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
        questionState: 2,//0,表示没答题，1表示正在答题，2表示已经答过，
        isRight: false,//isRight=true是答题正确，false是答题错误
      }, {
        id: 2,
        questionState: 2,//0,表示没答题，1表示正在答题，2表示已经答过，
        isRight: true,//isRight=true是答题正确，false是答题错误
      }, {
        id: 3,
        questionState: 2,//0,表示没答题，1表示正在答题，2表示已经答过，
        isRight: true,//isRight=true是答题正确，false是答题错误
      }, {
        id: 4,
        questionState: 1,//0,表示没答题，1表示正在答题，2表示已经答过，
        isRight: true,//isRight=true是答题正确，false是答题错误
      },
      {
        id: 4,
        questionState: 0,//0,表示没答题，1表示正在答题，2表示已经答过，
        isRight: true,//isRight=true是答题正确，false是答题错误
      },
      {
        id: 4,
        questionState: 0,//0,表示没答题，1表示正在答题，2表示已经答过，
        isRight: true,//isRight=true是答题正确，false是答题错误
      },
      {
        id: 4,
        questionState: 0,//0,表示没答题，1表示正在答题，2表示已经答过，
        isRight: true,//isRight=true是答题正确，false是答题错误
      },
      {
        id: 4,
        questionState: 0,//0,表示没答题，1表示正在答题，2表示已经答过，
        isRight: true,//isRight=true是答题正确，false是答题错误
      },],
      anwswer: ['A.loyal partner', 'B. first wife', 'C.maintaining', 'D.business man'],
      choicedNum: undefined,
      choiced: 0,
    }
  }

  render() {
    return (
      <div className={s.ChoiceBody}>
        {/* 导航栏 */}
        <Nav imgUrl={require("../../../assets/images/test/test.png").default} />
        {/* 页面主内容 */}
        <div className={s.potLine}>
          <div className={s.pot}>
            <PotLine posNum={this.state.posArr} />
          </div>
          <div className={s.questionBox}>
            <div className={s.questionTitle}>
              What do most people think is very important in spoken communication?

              <div className={s.questionDetails}>Now, the merchant's 1st wife is a very loyal partner and has made great contributions in maintaining his wealth and business as well as taking care of the household. However, the merchant did not love the first wife and although she loved him deeply, he hardly took notice of her.</div>
            </div>

            <div className={s.questionAnswer}>
              <ul>
                {
                  this.state.anwswer.map((item, index) => {
                    return (
                      < li className={this.state.choicedNum == index ? s.choiced : s.unChoiced} onClick={(e) => { this.setState({ choicedNum: index }); console.log(index,e) }} key={item}>{item}</li>
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
            this.state.posArr[3].isRight ? <div className={s.right} ></div> : <div className={s.worng}></div>
          }
        </div>
      </div >

    )
  }
}
