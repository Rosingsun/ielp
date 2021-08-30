import React, { Component } from "react";
import { Collapse } from 'antd';
import {
  RightOutlined,
  DownOutlined
} from '@ant-design/icons';
import routesConfig from "@src/route";
import s from "./style.module.scss";
const { Panel } = Collapse;
class downList extends Component {
  constructor(props) {
    super(props)
    this.state = {
    }
  }
  render() {
    return (
      <div className={s.listBox}>
        <div className={s.listItem} className={s.nav} >
          <Collapse accordion>
            {
              this.props.list && this.props.list.map((item, index) => {
                return (
                  <Panel header={item.title || '下拉菜单'} key={index}>
                    {
                      item.listItem.map((item2, index2) => {
                        return (<p>{item2}</p>)
                      })
                    }
                  </Panel>
                )
              })
            }
          </Collapse>
        </div>
      </div>
    );
  }
}
export default downList;