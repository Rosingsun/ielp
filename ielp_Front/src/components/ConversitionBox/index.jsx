import React, { Component } from 'react';
import a from "./style.module.scss";
export default class ConversitionBox extends Component {
    constructor(props) {
        super(props);
        this.state = {
        };
    }
    
    render() {
        return (
            <div>
                {
                    this.props.isBlue ? <p>蓝色</p> : <p>红色</p>
                }
            </div>
        )
    }
}
