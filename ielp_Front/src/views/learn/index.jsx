import React, { Component } from 'react';
import { Button, Upload, Image, Select, Tag, Modal } from 'antd'
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
      options: [
        { value: 'animal', text: '动物' },
        { value: 'plant', text: '植物' },
        { value: 'red_wine', text: '红酒' },
        { value: 'dishs', text: '菜品' },
        { value: 'currency', text: '货币' },
        { value: 'landmark', text: '地标' },
        { value: 'ingredient', text: '果蔬' },
        { value: 'logo_search', text: 'logo识别' },
        { value: 'advanced_general', text: '通用物体和场景识别' },
        { value: 'object_detect', text: '图像单主体' },
        { value: 'multi_object_detect', text: '图像多主体' },
      ],
      select: 'animal',
      listData: [{
        title: "历史",
        listItem: [1, 2, 3, 4],
      }, {
        title: "收藏",
        listItem: [],
      }],
      access_token: undefined,//百度识图的token
      isModalVisible: false,//模态框状态
      read_data: [],//百度识图最后的结果
    };
  }
  componentDidMount() {
    console.log("获取数据");
    this.getToken();
  }
  // 获取百度识图的token
  getToken() {
    let pic_token = localStorage.getItem('pic_token')
    if (!pic_token) {
      common.pic_getToekn({
        grant_type: 'client_credentials',
        client_id: readPicKey,
        client_secret: readPicPass,
      }).then((res) => {
        console.log("Res", res);
        this.setState({ access_token: res.data.access_token })
        localStorage.setItem('pic_token', res.data.access_token)
      })
    } else {
      this.setState({ access_token: pic_token })
    }
  }
  // 提交修改图片
  handleChange = info => {
    console.log(info)
    if (info.file.status === 'uploading') {
      this.setState({ loading: true });
      return;
    }
    // 把图片格式改为文本格式
    getBase64(info.file.originFileObj, imageUrl => {
      console.log('imageUrl', imageUrl);
      this.setState({
        imageUrl,
        loading: false,
      })
      this.readPic();
    },
    );
  };
  // 提交图片，百度识图
  readPic() {
    common.pic_read({
      access_token: this.state.access_token,
      image: this.state.imageUrl,
      scenes: [this.state.select],
    }, '?access_token=' + this.state.access_token, () => { })
      .then((res) => {
        console.log("Resss", res.data.result[this.state.select].result)
        let pic_data = [];
        if (Array.isArray(res.data.result[this.state.select].result)) {
          this.setState({
            isModalVisible: true,
            read_data: res.data.result[this.state.select].result,
          })
        }
        else {
          pic_data.push(res.data.result[this.state.select].result)
          this.setState({
            isModalVisible: true,
            read_data: pic_data
          })
        }
      })
  }
  onChange(e) {
    console.log(e);
    this.setState({
      select: e,
    })
  }
  showModal = () => {
    this.setState({
      isModalVisible: true,
    });
  };

  hideModal = () => {
    this.setState({
      isModalVisible: false,
    });
  };
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
            disabled={this.state.imageUrl ? true : false}
          >
            {imageUrl ? <Image src={imageUrl} alt="avatar" style={{ width: 'auto', height: '60vh' }} /> :
              <div>
                {this.state.loading ? <LoadingOutlined style={{ fontSize: '10vw', color: "#fff" }} /> : <PlusOutlined style={{ fontSize: '10vw', color: "#fff" }} />}
              </div >
            }
          </Upload>
        </div>
        <div className={a.listBox}>
          <DownList list={this.state.listData} />
        </div>

        <div className={a.search}>
          <div className={a.choice}>
            <Select
              showSearch
              placeholder="选择您需要的选项"
              optionFilterProp="children"
              defaultValue={this.state.select}
              onChange={(e) => { this.onChange(e) }}
            >
              {
                this.state.options.map((item, index) => {
                  return (
                    < Option value={item.value} >{item.text}</Option>
                  )
                })
              }
            </Select>
          </div>
          <Upload
            name="avatar"
            listType="picture-card"
            className="avatar-uploader"
            showUploadList={false}
            action="https://www.mocky.io/v2/5cc8019d300000980a055e76"
            beforeUpload={beforeUpload}
            onChange={this.handleChange}
            disabled={this.state.imageUrl ? true : false}
          >
            <Button type="primary" shape="round" icon={<ZoomInOutlined />} size='large' onClick={() => { this.handleChange }}>
              上传图片
            </Button>
          </Upload>
        </div>
        <Modal title="读取图片成功" visible={this.state.isModalVisible}   onOk={this.hideModal}
          onCancel={this.hideModal}
          okText="确认"
          cancelText="取消">
          {
            this.state.read_data.map((item) => {
              return (
                <p>{item.name}</p>
              )
            })
          }

        </Modal>
      </div >
    );
  }
}
