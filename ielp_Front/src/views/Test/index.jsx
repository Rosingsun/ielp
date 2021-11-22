import React, { Component } from 'react'
import { Nav, ConversitionBox } from "../../components/index";
import s from "./style.module.scss";

export default class Test extends Component {
  render() {
    return (
      <div className={s.testBody}>
        <Nav />
        <ConversitionBox isBlue={false} signWord='你好你好'/>
      </div>
    )
  }
}
