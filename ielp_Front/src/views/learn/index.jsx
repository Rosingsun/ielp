import React, { Component } from 'react';
import { Button, Upload } from 'antd'
import { Daka } from "@components/index";
import { PlusOutlined, ZoomInOutlined, LoadingOutlined } from '@ant-design/icons';
import { Nav, DownList } from '@components/index';
import a from "./style.module.scss";
import { beforeUpload, getBase64 } from "../../utils/conformPic";

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
      }]
    };
  }

  uploadButton() {
    return (
      <div>
        {this.state.loading ? <LoadingOutlined /> : <PlusOutlined />}
        <div style={{ marginTop: 8 }}>Upload</div>
      </div >
    )
  }
  handleChange = info => {
    if (info.file.status === 'uploading') {
      this.setState({ loading: true });
      return;
    }
    if (info.file.status === 'done') {
      // Get this url from response in real world.
      getBase64(info.file.originFileObj, imageUrl =>
        this.setState({
          imageUrl,
          loading: false,
        }),
      );
    }
  };
  render() {
    const { imageUrl } = this.state
    return (
      <div className={a.body}>
        <Nav />
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
            {imageUrl ? <img src={imageUrl} alt="avatar" style={{ width: '100%' }} /> :
              <div>
                {this.state.loading ? <LoadingOutlined style={{ fontSize: '10vw', color: "#fff" }}/> : <PlusOutlined style={{ fontSize: '10vw', color: "#fff" }} />}
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
