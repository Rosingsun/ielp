/**
 * 分割线
 * mainColor 主要的颜色
 */
import React, { Component } from 'react';
import { Row, Col, Avatar } from 'antd';
import s from "./style.module.scss";
export default class ForumItem extends Component {
  constructor(props) {
    super(props);
    this.state = {

    }
  }

  render() {
    return (
      <div className={s.forum}>
        <div className={s.section}>
          <Avatar size={90} src="http://pic.51yuansu.com/pic3/cover/04/01/04/5fa50a14e46df_610.jpg" />

          <div className={s.mainBody}>
            {this.props.type == 1 ?
              // 状态1，普通的发版言论
              <section>
                <div className={s.userName}>发表的人的用户名称</div>
                <div className={s.text}>发表的人发表的内容</div>
              </section>
              : this.props.type == 2 ?
                // 状态2,从测试页面分享过来
                <section>
                  <div className={s.userName}>状态2</div>
                </section>
                : this.props.type == 3 ?
                //状态3,识别图片页面分享过来
                <section>
                  <div className={s.userName}>状态3</div>
                </section>
                : this.props.type == 4 ?
                // 状态4,预留
                <section>
                  <div className={s.userName}>状态3</div>
                </section>
                :''
            }

          </div>
        </div>
      </div>
    )
  }
}
