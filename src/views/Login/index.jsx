import React, { Component } from 'react';
import { Form, Input, Button, Checkbox, message } from 'antd';
import s from "./style.module.scss";
import { UserOutlined, LockOutlined } from '@ant-design/icons';
import { createHashHistory } from 'history'; // hash路由
import * as user from "../../actions/user";
const history = createHashHistory();

export default class Login extends Component {
  constructor(props) {
    super(props)
    this.state = {

    }
  }
  onFinish = (values) => {
   user.getUserInfo(values).then((res)=>{
      if(res.data.state=="登录成功"){
        // history.push('/Intro');
        this.props.history.push("/Intro")
      }else{
        message.warning(res.data.state);
      }
   });
  };
  render() {
    return (
      <div className={s.body}>
        <div className={s.loginBox}>
          <Form
            name="normal_login"
            className={s.login_form}
            initialValues={{
              remember: true,
            }}
            onFinish={this.onFinish}
          >
            <Form.Item
              name="username"
              rules={[
                {
                  required: true,
                  message: '请输入用户名!',
                },
              ]}

            >
              <Input
                className={s.input}
                prefix={<UserOutlined className={s.site_form_item_icon} />}
                placeholder="用户名" />
            </Form.Item>
            <Form.Item
              name="password"
              rules={[
                {
                  required: true,
                  message: '请输入密码!',
                },
              ]}
            >
              <Input.Password
                className={s.input}
                prefix={<LockOutlined className={s.site_form_item_icon} />}
                type="password"
                placeholder="密码"
              />
            </Form.Item>
            <Form.Item>
              <Form.Item name="remember" valuePropName="checked" noStyle>
                <Checkbox>记住密码</Checkbox>
              </Form.Item>
              <a className={s.login_form_forgot} href=""> 忘记密码？ </a>
            </Form.Item>
            <Form.Item>
              <Button type="primary" htmlType="submit" className={s.login_form_button} onClick={() => { }}>
                登录  </Button>  或 <a>注册</a>
            </Form.Item>
          </Form>
        </div>
      </div>
    )
  }
}
