import React, { Component } from 'react';
import { Row, Col, Divider, Avatar, List, Tabs, Spin } from 'antd';
import { MessageOutlined, TeamOutlined, UserOutlined } from '@ant-design/icons';
import InfiniteScroll from 'react-infinite-scroller';
import s from "./style.module.scss";
const { TabPane } = Tabs;
export default class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      loading:false,
      hasMore:true,
      data:[
        {key:1},{key:2},{key:3},{key:4},{key:5},{key:6},{key:7},{key:8},{key:9},{key:10},{key:11},{key:13},{key:14},{key:15},{key:16},
      ]
    };
  }
  handleInfiniteOnLoad=()=>{
    // this.setState({loading:true})
    console.log("加载更多");
    let newData=[...this.state.data]
    this.state.data.map((item,index)=>{
      newData.push({key:this.state.data.length+index+1});
    });
    // console.log(newData)
    this.setState({data:newData,loading:false});
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
                  <div className={s.messageLine}>
                    <InfiniteScroll
                      initialLoad={true}
                      pageStart={0}
                      loadMore={this.handleInfiniteOnLoad}
                      hasMore={!this.state.loading && this.state.hasMore}
                      useWindow={false}
                    >
                      <List
                        dataSource={this.state.data}
                        renderItem={item => (
                          <List.Item key={item.key}>
                            <List.Item.Meta
                              avatar={
                                <Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" />
                              }
                              title={<a href="https://ant.design">{item.key}</a>}
                              description={item.key}
                            />
                            <div>Content</div>
                          </List.Item>
                        )}
                      >
                        {this.state.loading && this.state.hasMore && (
                          <div className={s.demo_loading_container}>
                            <Spin />
                          </div>
                        )}
                      </List>
                    </InfiniteScroll>
                  </div>
                  <div className={s.chatContainer}>

                  </div>
                  <div className={s.chatObject}>

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
