import React, { Component } from 'react';
import a from "./style.module.scss";
import { Button, Divider } from 'antd';
import moment from 'moment';

export default class Daka extends Component {
  constructor(props) {
    super(props);
    this.state = {
      date: new Date()
    };


  }
  componentDidMount() {
    this.timerID = setInterval(
      () => this.tick(),
      1000
    );
  }

  componentWillUnmount() {
    clearInterval(this.timerID);
  }

  tick() {
    this.setState({
      date: new Date()
    });
  }
  render() {

    return (
      <div className={a.one}>
        <div className={a.left}>
          <div className={a.time}>
            <div className={a.up}>
              <div className={a.month}>
                <a className={a.monthtext}> {moment().format("MMM ")} </a>
              </div>
              <div className={a.week}>
                <a className={a.weektext}>星期{moment().format('d')}</a>
              </div>
            </div>
            <div className={a.down}>
              <div className={a.day}>
                <a className={a.daytext}>{moment().format("YY")}</a>
              </div>
              <div className={a.weather}>
                <a className={a.weathertext}>晴</a>
              </div>
            </div>

          </div>
          <div className={a.two}>
            <Button className={a.btn1}>
              <a className={a.text1}>今日未打卡</a>
            </Button>
            <Button className={a.btn} onClick={() => { }}>
              <a className={a.text1}>马上去打卡</a>
            </Button>
          </div>
        </div>
        <div className={a.right}>
          <img src={require('../../assets/home/abc.png').default} height="100%" width="100%" ></img>
        </div>
      </div>
    );
  }
}
