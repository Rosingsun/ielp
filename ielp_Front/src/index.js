import React from 'react';
import ReactDOM from 'react-dom';
import { HashRouter as Router, Switch, Route, Link } from "react-router-dom";
import App from './views/Home/index';

ReactDOM.render(
  <React.StrictMode>
    <Router>
      <App />
    </Router>
  </React.StrictMode>,
  document.getElementById('root')
);
