import React, { Component } from 'react'
import { Nav } from "../../components/index";
import s from"./style.module.scss"
export default class Test extends Component {
  render() {
    return (
      <div className={s.testBody}>
        <Nav />
      </div>
    )
  }
}
