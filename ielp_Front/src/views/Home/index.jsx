import React, { Component } from 'react';
import a from "./style.module.scss";
export default class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
    };
  }
  render() {
    return (
      <div className={a.one}>
        <div className={a.three}>
          <img src={require('./abc.png').default} width='30%' ></img>
        </div>
          <div className={a.two}>
            <div>
              <a className={a.text1}>今日未打卡</a>
            </div>
            <button className={a.btn}>
              <a className={a.text1}>今日未打卡</a>
            </button>
        </div>
      </div>
    );
  }
}
