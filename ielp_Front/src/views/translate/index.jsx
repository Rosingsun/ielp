import React, { Component } from 'react';
import { Input, Button, message, Select } from 'antd';
import { Nav } from "@components/index";
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
      from: "auto",
      to: 'en',
      list: [{
        name: "自动检测",
        value: "auto"
      }, {
        name: "文言文",
        value: "wyw",
      }, {
        name: "中文",
        value: "zh",
      }, {
        name: "英语",
        value: "en"
      }, {
        name: "韩语",
        value: "kor"
      }, {
        name: "德语",
        value: "de"
      }, {
        name: "法语",
        value: "fra"
      }, {
        name: "韩语",
        value: "kor"
      }],
      localStorageArr: [],
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
        if (!window.localStorage) {
          message.warn("浏览器不支持localstorage")
          return false;
        } else {
          let storage = window.localStorage;
          let translate = JSON.parse(storage.getItem("translateForm") || `[]`);//读取本地的存储历史翻译数据
          translate.unshift(query)
          storage.setItem("translateForm", JSON.stringify(translate));
        }
        let localStorageArr = this.state.localStorageArr;
        localStorageArr.unshift(query)
        message.success("翻译成功")
        this.setState({ dst: res.data.trans_result[0].dst, localStorageArr })
      }
    }).catch(err => {
      console.log(err);
    })
  }
  componentDidMount() {
    let localStorageArr = JSON.parse(window.localStorage.getItem("translateForm") || `[]`)
    this.setState({ localStorageArr })
  }
  render() {
    return (
      <div className={s.body}>
        <Nav imgUrl={require("../../assets/images/translate/translate.png").default}/>
        <div className={s.translateBox}>
          <div className={s.left}>
            <div className={s.leftTop}>
              <div className={s.topChoic}>
                <Select placeholder="请选择输入的语言" defaultValue="自动检测" style={{ width: '40%' }}
                  onChange={(e) => {
                    this.setState({ from: e })
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
                  onChange={(e) => {
                    this.setState({ to: e })
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
              翻译记录：
              {
                this.state.localStorageArr.length == 0 ? '' : this.state.localStorageArr.map((item, index) => {
                  return <p>{item}</p>
                })
              }
            </div>
          </div>
          <div className={s.right}>
            <div className={s.rightTop}>
              <div className={s.content}>{this.state.dst}</div>
            </div>
            {/* <div className={s.rightBtm}></div> */}
          </div>
        </div>
      </div>
    )
  }
}
export default Translate