import React, { Component } from 'react';
import { Table, Tag, Space } from 'antd';
import * as s from "./style.module.scss";
import * as user from "../../actions/user";
const { Column, ColumnGroup } = Table;
class userList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            data: [
                {
                    key: '1',
                    firstName: 'John',
                    lastName: 'Brown',
                    age: 32,
                    address: 'New York No. 1 Lake Park',
                    tags: ['nice', 'developer'],
                },
                {
                    key: '2',
                    firstName: 'Jim',
                    lastName: 'Green',
                    age: 42,
                    address: 'London No. 1 Lake Park',
                    tags: ['loser'],
                },
                {
                    key: '3',
                    firstName: 'Joe',
                    lastName: 'Black',
                    age: 32,
                    address: 'Sidney No. 1 Lake Park',
                    tags: ['cool', 'teacher'],
                },
            ]
        }
    }
    componentDidMount(){
        user.userList().then((res)=>{
            console.log("ressss",res)
        })
    }
    render() {
        return (
            <Table dataSource={this.state.data}>
                <Column title="用户昵称" dataIndex="用户昵称" key="name" />
                <Column title="用户名" dataIndex="用户名" key="username" />
                <Column title="年龄" dataIndex="age" key="age" />
                <Column title="注册日期" dataIndex="InsertTime" key="InsertTime" />
                <Column title="上一次登录时间" dataIndex="lastTime" key="address" />
                <Column
                    title="操作"
                    key="action"
                    render={(text, record) => (
                        <Space size="middle">
                            <a>修改</a>
                            <a>删除</a>
                        </Space>
                    )}
                />
            </Table>
        )
    }
}
export default userList;