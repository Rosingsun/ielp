import React, { Component } from 'react';
import s from "./style.module.scss";

export default class Data extends Component {
  render() {
    return (
      <div className={s.body}>
        <a>你好 Data</a>
      </div>
    )
  }
}
