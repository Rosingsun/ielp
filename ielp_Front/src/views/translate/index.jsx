import React, { Component } from 'react';
import { Input, Button, message, Select } from 'antd';
import s from "./style.module.scss";
import * as common from '@actions/common';
import { APPID, pass } from "@constants/apiConstants.js";
import { MD5 } from "../../utils/MD5";
const { TextArea } = Input;
const { Option } = Select;
class Translate extends Component {
  constructor(props) {
    super(props);
    this.state = {
      inputWord: '',//用户输入的文字
      dst: "",//翻译出来的目标文字
      from: "zh",
      to : 'en',
      list: [
        {
          name: "中文",
          value: "zh",
        }, {
          name: "英语",
          value: "en"
        }
      ]
    }
  }
  getWord = (e) => {
    // 获取前端输入的数据
    this.setState({ inputWord: e });
  }
  transport = (e) => {
    var salt = (new Date).getTime();
    var query = this.state.inputWord;
    var str1 = APPID + query + salt + pass;
    var sign = MD5(str1);

    common.transport({
      q: query,
      appid: APPID,
      salt: salt,
      from: this.state.from,
      to: this.state.to,
      sign: sign,
    }).then(res => {
      if (res.status == 200) {
        message.success("翻译成功")
        this.setState({ dst: res.data.trans_result[0].dst })
      }
    }).catch(err => {
      console.log(err);
    })
  }
  render() {
    return (
      <div className={s.body}>
        <div className={s.translateBox}>
          <div className={s.left}>
            <div className={s.leftTop}>
              <div className={s.topChoic}>
                <Select placeholder="请选择输入的语言" defaultValue="中文" style={{ width: '40%' }} 
                onChange={(e)=>{
                  this.setState({from:e})
                }}>
                  {
                    this.state.list.map((item, index) => {
                      return (
                        <Option key={index} value={item.value}>{item.name}</Option>
                      )
                    })
                  }

                </Select>
                <Select placeholder="请选择目标语言" defaultValue="英语" style={{ width: '40%' }}
                onChange={(e)=>{
                  this.setState({to:e})
                }}>
                  {
                    this.state.list.map((item, index) => {
                      return (
                        <Option key={index} value={item.value}>{item.name}</Option>
                      )
                    })
                  }
                </Select>
                <Button type="primary" onClick={() => { this.transport() }}>翻译 </Button>
              </div>
              <div className={s.Input}>
                <TextArea autoSize={{ minRows: 5, maxRows: 6 }} placeholder="你想翻译的句子" style={{ height: '120px', marginTop: "20px", width: "95%" }} onChange={(e) => { this.getWord(e.target.value) }} />
              </div>
            </div>
            <div className={s.leftBottom}>

            </div>
          </div>
          <div className={s.right}>
            <div className={s.rightTop}>
              <div className={s.content}>{this.state.dst}</div>
            </div>
            <div className={s.rightBtm}></div>
          </div>
        </div>
      </div>
    )
  }
}
export default Translate