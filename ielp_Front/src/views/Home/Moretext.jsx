
import React, { Component,createRef } from 'react';
import a from "./style.module.scss";
import E from 'wangeditor';
import { UserOutlined, LockOutlined } from '@ant-design/icons';
// import { Input, Button, message, Select,Card,Icon } from 'antd';
import { Form, Input, InputNumber, Button,Card } from 'antd';
// import Form from 'antd/lib/form/Form';
// @Form.create()
 class Home extends Component {
     handleSubmit=(e)=>{
         console.log(e)
     }
  constructor(props) {
    super(props);
    this.editorRef = createRef()
    this.state = {
    };
  }
  initEditor=()=>{

this.editor = new E(this.editorRef.current)
// this.editor.customConfig.onchange = function (html)
// {
//     // html即变化之后的内容
// console.log(html)

// }

// 配置触发 onchange 的时间频率，默认为 200ms
// this.editor.config.onchangeTimeout = 500 // 修改为 500ms
this.editor.create()

  }
  componentDidMount(){
      this.initEditor()
  }
  render() {
    
    return (
        <Card title="修改资料"
        bordered={false}
        extra={<Button>取消</Button>}
        >
            
        <Form onFinish={this.handleSubmit} className="login-form"> 
        <Form.Item
        label="标题"
              name="username"
              rules={[
                {
                  required: true,
                  message: '请输入用户名!',
                },
                {
                    min:2,
                    message:'用户名必须大于2位',
                },
                {
                    max:8,
                    message:'用户名必须小于8位'
                }
              ]}
            >
              <Input
                className={a.input}
                prefix={<UserOutlined className={a.site_form_item_icon} />}
                placeholder="新用户名"
              // defaultValue={this.state.username}
              />     
              <Button type="primary" htmlType="submit" className={a.login_form_button} onClick={() => { }}>
                登录  </Button>
            </Form.Item>
        <Form.Item>

        </Form.Item>
                </Form>
        <div className="qf-editor" ref={this.editorRef}>这里是内容
        <Button>1111</Button>

        </div>
        </Card>
        // </Form>
 
    );
  }
}
export default Home
