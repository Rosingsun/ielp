// import logo from './logo.svg';
import './App.css';
import { PageConfig } from "@components/index.jsx";
import {Login} from './views/index.js';
import { Component } from 'react';
class App extends Component {
  constructor(props){
    super(props)

  }
  render() {
    return (
      <div className="App" >
        <header className="App-header">
        {/* <Login/> */}
          <PageConfig />
        </header>
      </div>
    );
  }
}

export default App;
