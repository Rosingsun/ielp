import React, { Component } from 'react';
import { Row, Col, Divider, Avatar, Input, Tabs, Spin } from 'antd';
import { MessageOutlined, TeamOutlined, UserOutlined } from '@ant-design/icons';
import InfiniteScroll from 'react-infinite-scroller';
import { FriendBox } from "../../components/index";
import s from "./style.module.scss";
const { TabPane } = Tabs;
export default class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      loading: false,
      hasMore: true,
      data: [
        { key: 1 }, { key: 2 }, { key: 3 },
        { key: 1 }, { key: 2 }, { key: 3 }, { key: 1 }, { key: 2 }, { key: 3 },
        { key: 1 }, { key: 2 }, { key: 3 },
        { key: 1 }, { key: 2 }, { key: 3 },
        { key: 1 }, { key: 2 }, { key: 3 },
      ]
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
              <Tabs defaultActiveKey="1" type="card" className={s.tab}>
                <TabPane className={s.chatPage} tab={<span> <MessageOutlined /> 消息 </span>} key="1" >

                  <div className={s.friendList}>
                    <Input placeholder="Basic usage" />
                    <div className={s.messageLine}>
                      {
                        this.state.data.map((item, index) => {
                          return (
                            <div className={s.userInfo}>
                              <Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" size={60} />
                              <div className={s.userName}>我的用户名超</div>
                            </div>
                          )
                        })
                      }
                    </div>
                  </div>
                  <div className={s.chatContainer}>
                    <div className={s.chatWindow}></div>
                    {/* <div clas> */}
                  </div>
                  <div className={s.chatObject}>
                    3
                  </div>
                </TabPane>
                <TabPane className={s.chatPage} tab={<span><UserOutlined />好友 </span>} key="2">
                  <div className={s.friendList}>
                    <Input placeholder="Basic usage" />
                    <div className={s.messageLine}>
                      {
                        this.state.data.map((item, index) => {
                          return (
                         
                            <FriendBox />
                          )
                        })
                      }
                    </div>
                  </div>
                  <div className={s.chatContainer}>
                    <div className={s.chatWindow}></div>
                    {/* <div clas> */}
                  </div>
                  <div className={s.chatObject}>
                    3
                  </div>
                </TabPane>
                <TabPane className={s.chatPage} tab={<span><TeamOutlined />聊天室 </span>} key="3">
                  <div className={s.friendList}>
                    <Input placeholder="Basic usage" />
                    <div className={s.messageLine}>
                      {
                        this.state.data.map((item, index) => {
                          return (
                            <div className={s.userInfo}>
                              <Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" size={60} />
                              <div className={s.userName}>我的用户名超</div>
                            </div>
                          )
                        })
                      }
                    </div>
                  </div>
                  <div className={s.chatContainer}>
                    <div className={s.chatWindow}></div>
                    {/* <div clas> */}
                  </div>
                  <div className={s.chatObject}>
                    3
                  </div>
                </TabPane>
              </Tabs>
            </div>
          </Col>
        </Row>
      </div>
    );
  }
}
