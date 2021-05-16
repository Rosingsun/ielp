import React, { Component } from 'react';
import { Row, Col, Divider, Avatar, List,Tabs , Spin } from 'antd';
import { MessageOutlined, TeamOutlined, UserOutlined } from '@ant-design/icons';
import s from "./style.module.scss";
const { TabPane } = Tabs;
export default class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {

    };
  }
  render() {
    return (
      <div className={s.Chatbody}>
        <Row justify="center" align="top">
          <Col span={18}>
            <div className={s.chatBox}>
              <div className={s.titleLine}>
                <div className={s.userInfo}>
                  <div className={s.userName}>
                    用户名
                </div>
                  <div className={s.userHead}>
                    <Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" size={60} />
                  </div>
                </div>
              </div>
              <Tabs defaultActiveKey="1" type="card">
                <TabPane tab={<span> <MessageOutlined /> 消息 </span>} key="1" >
                  <div className={s.chatPage}>
                  <div className={s.messageLine}>

                  </div>
                  <div className={s.chatContainer}>

                  </div>
                  <div className={s.chatObject}>

                  </div>
                  </div>
                </TabPane>
                <TabPane tab={<span><UserOutlined />好友 </span>} key="2">

                </TabPane>
                <TabPane tab={<span><TeamOutlined />聊天室 </span>} key="3">

                </TabPane>
              </Tabs>
            </div>
          </Col>
        </Row>
      </div>
    );
  }
}
