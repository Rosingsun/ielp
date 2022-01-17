import React, { Component } from 'react';
import { Button, Upload, Image } from 'antd'
import { PlusOutlined, ZoomInOutlined, LoadingOutlined } from '@ant-design/icons';
import { Nav, DownList } from '@components/index';
import { beforeUpload, getBase64 } from "../../utils/conformPic";
import { readPicPass, readPicKey } from "@constants/apiConstants.js";
import { Daka } from "@components/index";
import * as common from '@actions/common';
import a from "./style.module.scss";
export default class Learn extends Component {
  constructor(props) {
    super(props);
    this.state = {
      imageUrl: '',//pic url
      loading: false,//pic upload s
      listData: [{
        title: "历史",
        listItem: [1, 2, 3, 4],
      }, {
        title: "收藏",
        listItem: [],
      }],
      access_token: undefined,//百度识图的token
    };
  }
  componentDidMount() {
    console.log("获取数据");
    this.getToken();
  }

  uploadButton() {
    return (
      <div>
        {this.state.loading ? <LoadingOutlined /> : <PlusOutlined />}
        <div style={{ marginTop: 8 }}>Upload</div>
      </div >
    )
  }

  getToken() {
    common.pic_getToekn({
      grant_type: 'client_credentials',
      client_id: readPicKey,
      client_secret: readPicPass,
    }).then((res) => {
      console.log("Res", res);
      this.setState({ access_token: res.data.access_token })
    })
  }
  handleChange = info => {
    console.log(info)
    if (info.file.status === 'uploading') {
      this.setState({ loading: true });
      return;
    }
    getBase64(info.file.originFileObj, imageUrl => {
      console.log('imageUrl', imageUrl);
      this.setState({
        imageUrl,
        loading: false,
      })
      this.readPic();
    },
    );
    // }
  };
  readPic() {
    common.pic_read({
      access_token: this.state.access_token,
      image: this.state.imageUrl,
      scenes: ["animal", "plant", "ingredient", "dishs", "red_wine", "currency", "landmark"],
    }, '?access_token=' + this.state.access_token,()=>{})
    // .then((res)=>{
    //   console.log("Resss",res)
    // })
  }
  render() {
    const { imageUrl } = this.state
    return (
      <div className={a.body}>
        <Nav imgUrl={require("../../assets/images/learn/learn.png").default} />
        <div className={a.container}>
          <Upload
            name="avatar"
            listType="picture-card"
            className="avatar-uploader"
            showUploadList={false}
            action="https://www.mocky.io/v2/5cc8019d300000980a055e76"
            beforeUpload={beforeUpload}
            onChange={this.handleChange}
          >
            {imageUrl ? <Image src={imageUrl} alt="avatar" style={{ width: 'auto', height: '60vh' }} /> :
              <div>
                {this.state.loading ? <LoadingOutlined style={{ fontSize: '10vw', color: "#fff" }} /> : <PlusOutlined style={{ fontSize: '10vw', color: "#fff" }} />}
                {/* <div style={{ marginTop: 8 }}>Upload</div> */}
              </div >
            }
          </Upload>
          {/* <PlusOutlined style={{ fontSize: '10vw', color: "#fff" }} /> */}
        </div>
        <div className={a.listBox}>
          <DownList list={this.state.listData} />
        </div>
        <div className={a.search}>
          <Button type="primary" shape="round" icon={<ZoomInOutlined />} size='large'>
            上传图片
          </Button>
        </div>
      </div>
    );
  }
}
