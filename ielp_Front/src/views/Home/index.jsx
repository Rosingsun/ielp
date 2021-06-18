import React, { Component } from 'react';
import a from "./style.module.scss";
import { Daka } from "@components/index";

export default class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      date: new Date()
    };
  }
  render() {
    return (
      <div className={a.one}>
        <Daka />
      </div>
    );
  }
}
