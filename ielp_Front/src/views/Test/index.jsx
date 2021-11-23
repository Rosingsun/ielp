import React, { Component } from 'react'
import { Nav, ConversitionBox } from "../../components/index";
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
      <div className={s.testBody}>
        <Nav />
        <div className={s.mainBox}>
          {
            this.state.questionIndex == 0 ?
              <div>
                <ConversitionBox isBlue={true} title='blue' />
                <ConversitionBox isBlue={false} title='red' />
              </div>
              : <div>123123</div>
          }
        </div>
      </div>
    )
  }
}
