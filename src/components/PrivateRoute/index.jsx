import React, { Component } from "react";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import routesConfig from "@src/route";
import { Login } from "@views/index";
// function PageConfig() {
class PageConfig extends Component {
  render() {
    return (
      <div >
        <Switch>
          {
            routesConfig.map((route, index) => {
              return (
                <Route
                  path={route.path}
                  render={props => (
                    <route.component {...props} routes={route.routes} />
                  )}
                />
              )
            }
            )
          }
        </Switch>
      </div >
    );
  }
}
export default PageConfig;