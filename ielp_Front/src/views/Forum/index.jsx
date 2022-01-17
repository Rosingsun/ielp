
import React, { Component, createRef } from 'react';
import { UserOutlined, LockOutlined } from '@ant-design/icons';
import { Form, Input, InputNumber, Button, Avatar, Row, Col } from 'antd';
import { BellFilled, RedditCircleFilled, FireFilled, StarFilled } from '@ant-design/icons';
import { Nav, ForumItem } from '../../components/index';
import a from "./style.module.scss";
const { TextArea } = Input;
export default class Forum extends Component {
  constructor(props) {
    super(props);
    this.state = {
      navItem: [{
        title: "最新",
        icon: "",
        id: 'laster',
      }, {
        title: "最热",
        icon: "",
        id: "hotest",
      }, {
        title: "关注",
        icon: "",
        id: "focus",
      }]
    }
  }
  componentDidMount() {
  }
  render() {
    return (
      <div className={a.forumBody}>
        <Nav hideBack={true} />
        <div className={a.mainiContainer}>
          <div className={a.leftNav, a.borderNav}>
            <div className={a.navList}>
              <ul className={a.menuList}>
                <li>
                  <BellFilled />
                  <span>最新咨询</span>
                </li>
                <li>
                  <FireFilled />
                  <span>热门内容</span>
                </li>
                <li>
                  <StarFilled />
                  <span>我的收藏</span>
                </li>
                <li>
                <RedditCircleFilled />
                  <span>我的发布</span>
                </li>
              </ul>
            </div>
          </div>
          <div className={a.container} >
            <div className={a.topSection}>
              {/* <Avatar size={64} src="http://pic.51yuansu.com/pic3/cover/04/01/06/5fa8ac9fd035d_610.jpg!/fw/260/quality/90/unsharp/true/compress/true" /> */}
              <TextArea placeholder="请输入" maxLength={200} showCount />
              <Button type="primary" size="small" loading={false}>发表</Button>
            </div>
            <div className={a.nextBox}>
              <ForumItem type={1} />
              <ForumItem type={2} />
              <ForumItem type={3} />
            </div>
          </div>
          <div className={a.rightNav, a.borderNav}>
            {/* 左边 */}
          </div>
        </div>
      </div>
    )
  }
}
