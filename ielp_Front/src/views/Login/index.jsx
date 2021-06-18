import React, { Component } from 'react';
import { Form, Input, Button, Checkbox, message } from 'antd';
import { UserOutlined, LockOutlined } from '@ant-design/icons';
import { withRouter } from 'react-router-dom';
import moment from 'moment';
import s from "./style.module.scss";
import * as user from "../../actions/user";
let storage = window.localStorage;
class Login extends Component {
  constructor(props) {
    super(props)
    this.state = {
    }
  }
  componentWillMount() {
  }

  onFinish = (values) => {
    this.props.onLoaded(true);
    this.props.history.push("/Home");
    // let data = {
    //   'username': values.username,
    //   'password': values.password,
    //   'loadTime': moment().format('YYYY-MM-DD hh:mm:ss')
    // };
    // user.Login(data).then((res) => {
    //   console.log("resres", res)
    //   if (res && res.data.state == "登录成功") {
    //     message.success(res.data.state)
    //     this.props.onLoaded(true);
    //     this.props.history.push("/Home");
    //     // return(<Redirect to="/Home"/>)
    //   } else {
    //     message.warning(res.data.state);
    //     this.props.onLoaded(false);
    //   }
    // });
    // if (values.remember) {
    //   storage.username = values.username;
    //   storage.password = values.password;
    // } else {
    //   storage.removeItem("username");
    //   storage.removeItem("password");
    // }
  };
  render() {
    return (
      <div className={s.loginBody}>
        <div className={s.topPic}>
          <img src={require("@assets/images/login/top.png").default}/>
        </div>
        <div className={s.loginBox}>
          <Form
            name="normal_login"
            className={s.login_form}
            initialValues={{
              remember: true,
              username: storage.username,
              password: storage.password
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
                placeholder="用户名"
              // defaultValue={this.state.username}
              />
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
              // defaultValue={this.state.password}
              />
            </Form.Item>
            <Form.Item>
              <Form.Item name="remember" valuePropName="checked" noStyle>
                <Checkbox style={{ color: "#Fff" }}>记住密码</Checkbox>
              </Form.Item>
              <a className={s.login_form_forgot} href=""> 忘记密码？</a>
            </Form.Item>
            <Form.Item>
              <Button type="primary" htmlType="submit"  className={s.login_form_button} onClick={() => { }}>
                登录 | Login  </Button>
            </Form.Item>
            <Form.Item>
              <Button className={s.regesit_form_button} type="primary" onClick={() => { }}>
                注册 | Regedit  </Button>
            </Form.Item>
          </Form>
        </div>
      </div>
    )
  }
}
export default withRouter(Login)