import React, { Component } from 'react';
import a from "./style.module.scss";
import { Button ,Divider} from 'antd';

export default class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      // currentTime:formateData(Data.now()),
    };
    // getTime=()=>{
    //   setInterval(()=>{
    //     const currentTime=formateData(Date.now())
    //     this.setState({currentTime})
    //   },1000)
    // }
    // componentDidMount() {
    //   this.getTime()
  }
  render() {
    // const {currentTime}=this.state
    return (
      <div className={a.one}>
        
        <div className={a.left}>
          <div className={a.time}>
          </div>
          <div className={a.two}>
            <Button type="primary" className={a.btn1}>
              <a className={a.text1}>今日未打卡</a>
            </Button>
            <Button type="primary" className={a.btn} onClick={() => {}}>
              <a className={a.text1}>马上去打卡</a>
            </Button>
        </div> 
        </div>
        <div className={a.right}>
          <img src={require('./abc.png').default} width='170%' height='75%' margin-right='50px' ></img>
        </div>
      </div>
    );
  }
}
