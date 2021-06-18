// import logo from './logo.svg';

import './App.css';
import { PageConfig } from "@components/index.jsx";
import React, { Component } from 'react';
import { Layout, Menu, Breadcrumb } from 'antd';
import { createHashHistory } from 'history'; // hash路由
import { Login } from '@views/index';

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
          {/* {this.state.loaded == false ? <Login onLoaded={this.onLoaded} /> :<PageConfig /> } */}
          <PageConfig />
        </header>
      </div>
    );
  }
}

export default App;
