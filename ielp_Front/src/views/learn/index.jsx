import React, { Component } from 'react';
import { Button } from 'antd'
import { Daka } from "@components/index";
import { PlusOutlined, ZoomInOutlined } from '@ant-design/icons';
import { Nav, DownList } from '@components/index';
import a from "./style.module.scss";

export default class Learn extends Component {
  constructor(props) {
    super(props);
    this.state = {
      listData: [{
        title: "历史",
        listItem: [1, 2, 3, 4],
      }, {
        title: "收藏",
        listItem: [],
      }]
    };
  }
  render() {
    return (
      <div className={a.body}>
        <Nav />
        <div className={a.container}>
          <PlusOutlined style={{ fontSize: '10vw', color: "#fff" }} />
        </div>
        <div className={a.listBox}>
          <DownList list={this.state.listData} />
        </div>
        <div className={a.search}>
          <Button type="primary" shape="round" icon={<ZoomInOutlined />} size='large'>
            上传图片
          </Button>
        </div>
      </div>
    );
  }
}
