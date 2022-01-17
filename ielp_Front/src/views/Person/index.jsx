import React, { Component } from 'react';
import { Button, Upload, Descriptions, Image } from 'antd'
import { PlusOutlined, ZoomInOutlined, LoadingOutlined } from '@ant-design/icons';
import { Nav, ConversitionBox, Daka, SpreadLine, PotLine } from "@components/index";
import s from "./style.module.scss";

export default class Person extends Component {
  constructor(props) {
    super(props);
    this.state = {
      visible: false
    };
  }
  setVisivle(vis) {
    console.log(vis)
    this.setState({
      visible: vis
    })
  }

  render() {
    return (
      <div className={s.personBody}>
        <Nav hideBack={true} />
        <div className={s.mainBody}>
          <div className={s.personInfo}>
            {/* <Descriptions title="个人信息">
              <Descriptions.Item label="姓名">Rosingsun</Descriptions.Item>
              <Descriptions.Item label="联系方式">17857336887</Descriptions.Item>
              <Descriptions.Item label="出生年月">1998年11月17日</Descriptions.Item>
              <Descriptions.Item label="地址">
                浙江省 杭州市 拱墅区 ****街道 **** 小区 **幢A区
              </Descriptions.Item>
            </Descriptions> */}
          </div>
        </div>
      </div>
    );
  }
}
