// import logo from './logo.svg';

import './App.css';
import { PageConfig } from "@components/index.jsx";
import React, { Component } from 'react';
import { Layout, Menu, Breadcrumb } from 'antd';
import { PieChartOutlined } from '@ant-design/icons';
import { createHashHistory } from 'history'; // hash路由
import routesConfig from "@src/route";
import { Link } from "react-router-dom";
import { Login,Translate } from '@views/index';

const history = createHashHistory();
const { Header, Content, Footer, Sider } = Layout;
let storage = window.localStorage;
class App extends Component {
  constructor(props) {
    super(props)
    this.state = {
      collapsed: false,
      loaded: false,
    }
  }
  onCollapse = collapsed => {
    console.log(collapsed);
    this.setState({ collapsed });
  };
  onLoaded = (data) => {
    this.setState({ loaded: data })
  }
  render() {
    const { collapsed } = this.state;
    return (
      <div className="App" >
        <header className="App-header">
          {this.state.loaded == false ? <Login onLoaded={this.onLoaded} /> :<PageConfig /> }
          {/* <PageConfig /> */}
        </header>
      </div>
    );
  }
}

export default App;
