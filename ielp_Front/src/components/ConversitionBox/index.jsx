import React, { Component } from 'react';
import s from "./style.module.scss";
export default class ConversitionBox extends Component {
  constructor(props) {
    super(props);
    this.state = {
    };
  }

  subject(params) {

  }
  render() {
    return (
      <div className={s.ConversitionBox}>

        {
          this.props.isBlue ?
            <div className={`${s.questin}  ${s.blueQuestin}`}>
              <p>{this.props.title}</p>
            </div> :
            <div className={`${s.questin} ${s.redQuestin}`}>
              <p>{this.props.title}</p>
            </div>
        }
      </div>
    )
  }
}
