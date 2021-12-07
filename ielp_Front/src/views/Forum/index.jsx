
import React, { Component, createRef } from 'react';
import { UserOutlined, LockOutlined } from '@ant-design/icons';
import { Form, Input, InputNumber, Button, Card, Avatar, Row, Col } from 'antd';
import { Nav, ForumItem } from '../../components/index';
import a from "./style.module.scss";
const { TextArea } = Input;
export default class Forum extends Component {
  constructor(props) {
    super(props);
  }
  componentDidMount() {
  }
  render() {
    return (
      <div className={a.forumBody}><Nav hideBack={true} />
        <div className={a.leftNav}>
          左边
        </div>
        <div className={a.container} >
          <div className={a.topSection}>
            <Avatar size={64} src="http://pic.51yuansu.com/pic3/cover/04/01/06/5fa8ac9fd035d_610.jpg!/fw/260/quality/90/unsharp/true/compress/true" />
            <TextArea placeholder="请输入" maxLength={200} showCount />
            <Button type="primary" size="small" loading={false}>发表</Button>
          </div>
          <div className={a.nextBox}>
            <ForumItem type={3}/>
          </div>
        </div>
      </div>
    )
  }
}
