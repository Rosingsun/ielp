import React, { Component } from 'react';
import { Input, Button,message } from 'antd';
import s from "./style.module.scss";
import * as common from '@actions/common';
import { APPID, pass } from "@constants/apiConstants.js"; 
import {MD5} from "../../utils/MD5"; 
class translate extends Component {
  constructor(props) {
    super(props);
    this.state = {
      inputWord: '',
    }
  }
  getWord = (e) => {
    console.log(e);
    // 获取前端输入的数据
    this.setState({ inputWord: e });
  }
  transport = (e) => {
    console.log(APPID,pass)
    var salt = (new Date).getTime();
    var query = this.state.inputWord;
    var from = 'zh';
    var to = 'en';
    var str1 = APPID + query + salt + pass;
    var sign = MD5(str1);
    
    common.transport({
      q: query,
      appid: APPID,
      salt: salt,
      from: from,
      to: to,
      sign: sign,
    }).then(res => {
      console.log(res);
      if(res.status==200){
        message.success(res.data.trans_result[0].dst)
      }
    }).catch(err => {
      console.log(err);
    })
  }
  render() {
    return (
      <div className={s.body}>
        <div style={{ width: '30vw' }}>
          <Input placeholder="你想翻译的句子" onChange={(e) => { this.getWord(e.target.value) }} />
          <Button type="primary" onClick={() => { this.transport() }} style={{ marginTop: '20px', width: '100%', height: '60px' }}>翻译 </Button>
        </div>
      </div>
    )
  }
}
export default translate