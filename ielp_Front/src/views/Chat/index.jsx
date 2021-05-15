import React, { Component } from 'react';
import s from "./style.module.scss";
export default class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {

    };
  }
  render() {
    return (
      <div className={s.body}>
        <div className={s.chatBox}>

        </div>
      </div>
    );
  }
}
