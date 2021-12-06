import React, { Component } from "react";
import {
  LeftCircleFilled
} from '@ant-design/icons';
import s from "./style.module.scss";
class Nav extends Component {
  constructor(props) {
    super(props)
    this.state = {
    }
  }
  goBack = () => {
    // HTMLFormControlsCollection. this.props.goBack();
    console.log("这里有回调函数", this.props);
    if (this.props) {
      console.log("回调函数是GObACK");
      // this.props.history.push("/Home");
    }
  }
  render() {
    return (
      <div className={s.navBody}>
        {
          this.props.hideBack?'':<div className={s.goBack} onClick={() => { this.goBack(); }}>
          <LeftCircleFilled twoToneColor="#fff" />
        </div>
        }
        
        <div className={s.leftBar}></div>
        <div className={s.leftImg}>
          <img src={require("../../assets/images/login/top.png").default} />
        </div>
        <div className={s.minBarr}></div>
        <div className={s.rightImg}>
          <img src={require("../../assets/images/logo.jpg").default} />
        </div>
        <div className={s.rightBar}></div>

      </div >
    );
  }
}
export default Nav;