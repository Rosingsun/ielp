import React, { Component } from 'react';
import { Avatar, Calendar, Button } from 'antd'
import { PlusOutlined, ZoomInOutlined, UserOutlined } from '@ant-design/icons';
import { Nav, ConversitionBox, Daka, SpreadLine, PotLine } from "@components/index";
import locale from 'antd/lib/date-picker/locale/zh_CN';
import 'moment/locale/zh-cn';
import moment from 'moment';
import s from "./style.module.scss";
moment.locale('zh-cn');
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
  onPanelChange(value, mode) {
    console.log(value.format('YYYY-MM-DD'), mode);
  }

  onPanelChange() {

  }
  render() {
    return (
      <div className={s.personBody}>
        <Nav hideBack={true} />
        <div className={s.mainBody}>

          <div className={s.personInfo}>


            <div className={s.navBox}>
              <div className={s.userInfo}>
                <div className={s.nameBox}>
                  <Avatar size={100} icon={<UserOutlined />} src="https://joeschmoe.io/api/v1/random" />
                  <Button ghost>修改头像</Button>
                  <Button ghost>修改资料</Button>
                  <Button ghost>查看答题</Button>
                </div>
                <div className={s.infoDetials}>
                  <table>
                    <tr>
                      <th>
                        <p>姓名：我就是我</p>
                      </th>
                    </tr>
                    <tr>
                      <th>
                        <p>
                          <span>性别：不详</span>
                          <span style={{ marginLeft: '20px' }}>年龄：29</span>
                        </p>
                      </th>
                    </tr>
                    <tr>
                      <th>
                        <p>注册日期：2022.1.12</p>
                      </th>
                    </tr>
                    <tr>
                      <th>
                        <div>个性签名：我就是我,颜色不一样的烟火</div>
                      </th>
                    </tr>
                  </table>
                </div>
                <div className={s.signBox}>
                  <div className={s.daka}>
                    <h1>连续打卡<span><br/>1<br/></span>天</h1>
                  </div>
                  <Button type="primary" danger>
                    Primary
                  </Button>
                </div>
              </div>
              <div className={s.calendar}>
                <Calendar fullscreen={false} onPanelChange={(e) => { this.onPanelChange(e) }} locale={locale} />
              </div>

            </div>
          </div>
        </div>
      </div>
    );
  }
}
