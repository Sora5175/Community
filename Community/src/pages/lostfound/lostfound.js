var app = getApp();
Page({
  data: {
    foundindex:0,
    fi:0,
    ri:0,
    foundname:"",
    founddescribe:"",

    lostname:"",//对应于表单的lostname输入字段
    describe:"",//对应于表单的describe输入字段
    i:0,//丢失地点数组下标
    locarr:[],//丢失地点名数组
    locidarr:[],//丢失地点id，和名字对应
    imgpath:"",//存放图片的临时路径
    refreshsize:5,//刷新获取的数据数目
    index:0,//加载的第一个页面，下拉加载时index+refreshsize
    img:"./images/addfile.jpg",

    navTab:["失物信息","招领信息","失物发布","招领发布","我的信息"],
    currentTabIndex:0,

    exbar_type: [{ name: "全部", color: "gray" }, { name: "图书", color: "white" }, { name: "电子", color: "white" }, { name: "衣服", color: "white" }, { name: "鞋子", color: "white" }, { name: "玩具", color: "white" }, { name: "箱包", color: "white" }, { name: "洗护", color: "white" }, { name: "眼镜", color: "white" }, { name: "手表", color: "white" }, { name: "乐器", color: "white" }, { name: "美食", color: "white" }, { name: "宠物", color: "white" }, { name: "办公", color: "white" }, { name: "百货", color: "white" }, { name: "证件", color: "white" }, { name: "其他", color: "white" }],
    exbar_type_found: [{ name: "全部", color: "gray" }, { name: "图书", color: "white" }, { name: "电子", color: "white" }, { name: "衣服", color: "white" }, { name: "鞋子", color: "white" }, { name: "玩具", color: "white" }, { name: "箱包", color: "white" }, { name: "洗护", color: "white" }, { name: "眼镜", color: "white" }, { name: "手表", color: "white" }, { name: "乐器", color: "white" }, { name: "美食", color: "white" }, { name: "宠物", color: "white" }, { name: "办公", color: "white" }, { name: "百货", color: "white" }, { name: "证件", color: "white" }, { name: "其他", color: "white" }],
    Type: ["-请点击选择物品分类-", "图书", "电子", "衣服", "鞋子", "玩具", "箱包", "洗护", "眼镜", "手表", "乐器", "美食", "宠物", "办公", "百货", "证件", "其他"],
    lj:0,
    fj:0,

    exbar_lost_img:"./images/down.PNG",
    exbar_lost_text:"全部",
    exbar_lost_hidden:true,
    // exbar_lost_index:0,

    exbar_found_img:"./images/down.PNG",
    exbar_found_text:"全部",
    exbar_found_hidden:true,

    lostinfo: [],
    foundinfo: [],

    start: "",
    end: "",
    date: "-选择时间-",
    userId:null
  },
  // 招领列表的筛选
  clickforlabel_found:function(e){
    var index = e.target.dataset.index;
    var temp = this.data.exbar_type_found;
    var obj = [];
    for (var i = 0; i < temp.length; i++) {
      obj = temp[i];
      obj.color = "white";
    }
    temp[index].color = "gray";
    this.setData({
      exbar_type_found: temp,
      exbar_found_text: temp[index].name,
      exbar_found_hidden: true,
      exbar_found_img: "./images/down.PNG"
    });

    var that = this;
    // 刷新列表
    this.setData({
      foundindex: 0
    })
    
    wx.request({
      url: 'http://localhost:8080/Community/wx-lf/foundonload',
      dataType: "json",
      data: { size: that.data.refreshsize, index: that.data.foundindex },
      success: function (res) {
        var arr = res.data.list;
        var temparr = [];
        var obj;
        var label_text = that.data.exbar_found_text;
        for (var i = 0; i < arr.length; i++) {
          obj = arr[i];
          // temparr.push({ fno: obj.fNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });

          if (label_text == "全部") {
            temparr.push({ fno: obj.fNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });
          } else {
            if (label_text == obj.type) {
              temparr.push({ fno: obj.fNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });
            }
          }
        }

        that.setData({
          foundinfo: temparr,
          foundindex: that.data.foundindex + arr.length
        })
      },
      fail: function () {

      }
    });
  },
  // 失物列表的筛选
  clickforlabel:function(e){
    var index=e.target.dataset.index;
    var temp=this.data.exbar_type;
    var obj=[];
    for(var i=0;i<temp.length;i++){
      obj=temp[i];
      obj.color="white";
    }
    temp[index].color="gray";
    this.setData({
      exbar_type:temp,
      exbar_lost_text:temp[index].name,
      exbar_lost_hidden:true,
      exbar_lost_img:"./images/down.PNG"
    });

    var that=this;
    // 刷新列表
    this.setData({
      index:0
    })
    wx.request({
      url: 'http://localhost:8080/Community/wx-lf/lostonload',
      dataType: "json",
      data: { size: that.data.refreshsize, index: that.data.index },
      success: function (res) {
        var arr = res.data.list;
        var temparr = [];
        var obj;
        var label_text = temp[index].name;
        for (var i = 0; i < arr.length; i++) {
          obj = arr[i];
          // temparr.push({ lno: obj.lNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/lostimgupload/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });
          if (label_text == "全部") {
            temparr.push({ lno: obj.lNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/lostimgupload/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });
          } else {
            if (label_text == obj.type) {
              temparr.push({ lno: obj.lNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/lostimgupload/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });
            }
          }
        }
        that.setData({
          lostinfo: temparr,
          index: that.data.index + arr.length
        })
      },
      fail: function () {

      }
    });
  },
  // 失物列表的筛选事件
  bindTypeChange:function(e){
    this.setData({
      lj: e.detail.value
    })
  },
  // 招领列表的筛选事件
  bindTypeChange_found:function(e){
    this.setData({
      fj: e.detail.value
    })
  }, 
  // 选择时期事件
  bindDateChange: function (e) {
    this.setData({
      date: e.detail.value
    })
  },
  // 获得当前日期的字符串
  getToday:function(e){
    var date=new Date();
    var day=date.getDate();
    var month=date.getMonth()+1;
    var year=date.getFullYear();
    var str=year+"-";
    if(month<10){
      str+="0"+month+"-";
    }else{
      str+=month+"-";
    }
    if(day<10){
      str+="0"+day;
    }else{
      str+=day;
    }
    return str;
  },
  // 页面加载
  onLoad: function () {
    var that=this;
    // 设置时间
    var year = new Date().getFullYear();
    this.setData({
      userId: getApp().globalData.userInfo.userId,
      start: (year-1) + "-01-01",
      end: this.getToday()
    })
    // 加载失物信息
    wx.request({
      url: 'http://localhost:8080/Community/wx-lf/lostonload',
      dataType:"json",
      data: { size: that.data.refreshsize, index: that.data.index},
      success:function(res){
        var arr = res.data.list;
        var temparr=[];
        var obj;
        for (var i = 0; i <arr.length;i++){
          obj=arr[i];
          temparr.push({ lno: obj.lNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/lostimgupload/"+obj.photo, feed_content_text: obj.describe, time:obj.publisherTime});
        }
        that.setData({
          lostinfo:temparr,
          index:that.data.index+arr.length
        })
      },
      fail:function(){}
    });
    // 加载招领信息
    wx.request({
      url: 'http://localhost:8080/Community/wx-lf/foundonload',
      dataType: "json",
      data: {index:that.data.foundindex,size:that.data.refreshsize},
      success: function (res) {
        var arr = res.data.list;
        var temparr = [];
        var obj;
        for (var i = 0; i < arr.length; i++) {
          obj = arr[i];
          temparr.push({ fno: obj.fNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });
        }
        that.setData({
          foundinfo: temparr,
          foundindex: that.data.foundindex + arr.length
        })
      },
      fail: function () { }
    });
    // 加载地点列表
    wx.request({
      url: 'http://localhost:8080/Community/wx-lf/loconload',
      dataType:"json",
      data:{uid:that.data.userId},
      success:function(res){
        var arr=res.data.list;
        var obj;
        var locarr = ["-请点击选择地点-"],locidarr=[];
        for(var i=0;i<arr.length;i++){
          obj=arr[i];
          locarr.push(obj.classroomName);
          locidarr.push(obj.classroomId);
        }
        that.setData({
          locarr:locarr,
          locidarr:locidarr
        })
      },
      fail:function(){}
    })
  },
  // 切换导航页
  switchTab: function (e) {
    this.setData({
      currentTabIndex: e.currentTarget.dataset.idx,
      imgpath:"",
      foundname:"",
      founddescribe:"",
      lostname:"",
      describe:"",
      i:0,
      ri:0,
      fi:0,
      lj:0,
      fj:0,
      exbar_lost_hidden:true,
      exbar_found_hidden:true,
      exbar_lost_img:"./images/down.PNG",
      exbar_found_img: "./images/down.PNG",
      date: "-选择时间-"
    });
  },
  // 进入具体丢失信息贴
  loststepin:function(e){
    wx.navigateTo({
      url: './lostcontent?lno='+e.currentTarget.dataset.lno,
    })
  },
  // 进入具体招领信息贴
  foundstepin:function(e){
    wx.navigateTo({
      url: './foundcontent?fno=' + e.currentTarget.dataset.fno,
    })
  },
  // 失物发布提交
  formsubmit:function(e){
    var that = this;
    var formdata = e.detail.value;
    //验证输入是否完整
    if(!this.checkloc() || formdata.lostname=="" || formdata.describe=="" || this.data.lj==0 || this.data.date=="-选择时间-"){
      wx.showModal({
        title: '提示',
        content: '请将信息填写完整',
        showCancel:false,
        success: function (res) {
          if (res.confirm) {
            return;
          }
        }
      });
      return;
    }
    //为表单对象添加丢失地点信息和用户信息
    formdata.lostlocid=this.data.locidarr[this.data.i-1];
    formdata.uid = this.data.userId;
    formdata.type = this.data.Type[this.data.lj];
    if(that.data.imgpath==""){
      wx.request({
        url: 'http://localhost:8080/Community/wx-lf/lostuploadwithoutpic',
        dataType:"json",
        data:formdata,
        success:function(r){
          if(r.data.confirm){
            wx.showModal({
              title: '提示',
              content: '提交成功,请到我的信息->确认失物信息中查看系统推送的失物记录。(如果有的话)',
              showCancel: false,
              success: function (res) {
                if (res.confirm) {
                  that.setData({
                    img: "./images/addfile.jpg",
                    i: 0,
                    lostname: "",
                    describe: "",
                    lj:0,
                    date:"-选择时间-"
                  })
                }
              }
            });
          }
        },
        fail:function(){}
      })
    }else{
      wx.uploadFile({
        url: 'http://localhost:8080/Community/wx-lf/lostupload',
        filePath: that.data.imgpath,
        name: "myFile",
        formData: formdata,
        success: function (res) {
          wx.showModal({
            title: '提示',
            content: '提交成功,请到我的信息->确认失物信息中查看系统推送的失物记录。(如果有的话)',
            showCancel: false,
            success: function (res) {
              if (res.confirm) {
                that.setData({
                  img: "./images/addfile.jpg",
                  i: 0,
                  lostname: "",
                  describe: "",
                  lj:0,
                  date: "-选择时间-"
                })
              }
            }
          });
        }
      })
    }
  },
  // 招领发布提交
  formsubmit_found:function(e){
    var that = this;
    var formdata = e.detail.value;
    //验证输入是否完整
    if(formdata.foundname=="" || formdata.founddescribe=="" || that.data.ri==0 || that.data.fi==0 || that.data.imgpath=="" || this.data.fj==0){
      wx.showModal({
        title: '提示',
        content: '请将信息填写完整',
        showCancel: false,
        success: function (res) {
          if (res.confirm) {
            return;
          }
        }
      });
      return;
    }
    // 为表单添加信息
    formdata.foundlocid=this.data.locidarr[this.data.fi-1];
    formdata.returnlocid = this.data.locidarr[this.data.ri - 1];
    formdata.uid = this.data.userId;
    formdata.type = this.data.Type[this.data.fj];
    wx.uploadFile({
      url: 'http://localhost:8080/Community/wx-lf/foundupload',
      filePath: that.data.imgpath,
      name: "myFile",
      formData: formdata,
      success: function (res) {
        wx.showModal({
          title: '提示',
          content: '提交成功',
          showCancel: false,
          success: function (res) {
            if (res.confirm) {
              that.setData({
                img: "./images/addfile.jpg",
                fi: 0,
                ri: 0,
                fj:0,
                foundname: "",
                founddescribe: ""
              })
            }
          }
        });
      }
    })
  },
  // 上传图片事件
  uploadimg:function(e){
    var that=this;
    wx.chooseImage({
      count: 1,
      sizeType: ['original', 'compressed'],
      sourceType: ['album', 'camera'],
      success: function (res) {
        that.setData({
          imgpath:res.tempFilePaths[0],
          img:res.tempFilePaths[0]
        })
      }
    })
  },
  //刷新信息
  up :function(e){
    var that = this;
    switch(this.data.currentTabIndex){
      // 刷新失物信息
      case 0:{
        wx.showNavigationBarLoading();
        that.setData({
          index: 0
        });
        wx.request({
          url: 'http://localhost:8080/Community/wx-lf/lostonload',
          dataType: "json",
          data: { size: that.data.refreshsize, index: that.data.index },
          success: function (res) {
            var arr = res.data.list;
            var temparr = [];
            var obj;
            var label_text=that.data.exbar_lost_text;
            for (var i = 0; i < arr.length; i++) {
              obj = arr[i];
              // temparr.push({ lno: obj.lNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/lostimgupload/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });
              if(label_text=="全部"){
                temparr.push({ lno: obj.lNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/lostimgupload/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });
              }else{
                if(label_text==obj.type){
                  temparr.push({ lno: obj.lNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/lostimgupload/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });
                }
              }
            }
            that.setData({
              lostinfo: temparr,
              index: that.data.index + arr.length
            })
          },
          fail: function () {

          }
        });
        setTimeout(function () { wx.hideNavigationBarLoading(); wx.stopPullDownRefresh(); }, 1000);
        break;
      }
      // 刷新招领信息
      case 1:{
        wx.showNavigationBarLoading();
        that.setData({
          foundindex: 0
        });
        wx.request({
          url: 'http://localhost:8080/Community/wx-lf/foundonload',
          dataType: "json",
          data: { size: that.data.refreshsize, index: that.data.foundindex },
          success: function (res) {
            var arr = res.data.list;
            var temparr = [];
            var obj;
            var label_text = that.data.exbar_found_text;
            for (var i = 0; i < arr.length; i++) {
              obj = arr[i];
              // temparr.push({ fno: obj.fNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });

              if (label_text == "全部") {
                temparr.push({ fno: obj.fNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });
              } else {
                if (label_text == obj.type) {
                  temparr.push({ fno: obj.fNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });
                }
              }
            }

            that.setData({
              foundinfo: temparr,
              foundindex: that.data.foundindex + arr.length
            })
          },
          fail: function () {

          }
        });
        setTimeout(function () { wx.hideNavigationBarLoading(); wx.stopPullDownRefresh(); }, 1000);
        break;
      }
      case 2:{
        break;
      }
      case 3:{
        break;
      }
      case 4:{
        break;
      }
    }
  },
  //加载信息
  low :function(e){
    var that=this;
    switch(this.data.currentTabIndex){
      // 加载失物信息
      case 0:{
        wx.request({
          url: 'http://localhost:8080/Community/wx-lf/lostonload',
          dataType: "json",
          data: { size: that.data.refreshsize, index: that.data.index },
          success: function (res) {
            var arr = res.data.list;
            var ismore = res.data.isMore;
            if (!ismore) {
              wx.showToast({
                title: '没有更多数据了',
                icon: 'loading',
                duration: 1000
              });
            }
            var temparr = [];
            var obj;
            var label_text=that.data.exbar_lost_text;
            for (var i = 0; i < arr.length; i++) {
              obj = arr[i];
              // temparr.push({ lno: obj.lNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/lostimgupload/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });
              if(label_text=="全部"){
                temparr.push({ lno: obj.lNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/lostimgupload/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });
              }else{
                if(label_text==obj.type){
                  temparr.push({ lno: obj.lNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/lostimgupload/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });
                }
              }
            }
            that.setData({
              lostinfo: that.data.lostinfo.concat(temparr),
              index: that.data.index + arr.length
            })
          },
          fail: function () {

          }
        });
        break;
      }
      //加载招领信息
      case 1:{
        wx.request({
          url: 'http://localhost:8080/Community/wx-lf/foundonload',
          dataType: "json",
          data: {index:that.data.foundindex,size:that.data.refreshsize},
          success: function (res) {
            var arr = res.data.list;
            var ismore = res.data.isMore;
            if (!ismore) {
              wx.showToast({
                title: '没有更多数据了',
                icon: 'loading',
                duration: 1000
              });
            }
            var temparr = [];
            var obj;
            var label_text = that.data.exbar_found_text;
            for (var i = 0; i < arr.length; i++) {
              obj = arr[i];
              // temparr.push({ fno: obj.fNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });

              if (label_text == "全部") {
                temparr.push({ fno: obj.fNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });
              } else {
                if (label_text == obj.type) {
                  temparr.push({ fno: obj.fNo, uid: obj.publisherNo, feed_source_img: "./images/addfile.jpg", feed_source_name: "pty", feed_content_img: "http://localhost:8080/Community/" + obj.photo, feed_content_text: obj.describe, time: obj.publisherTime });
                }
              }
            }
            that.setData({
              foundinfo: that.data.foundinfo.concat(temparr),
              foundindex: that.data.foundindex + arr.length
            })
          },
          fail: function () { }
        });
        break;
      }
      case 2:{
        break;
      }
      case 3:{
        break;
      }
      case 4:{
        break;
      }
    }
  },
  //选择地点事件
  bindPickerChange:function(e){
    this.setData({
      i:e.detail.value
    })
  },
  FLocChange:function(e){
    this.setData({
      fi:e.detail.value
    })
  },
  RLocChange: function (e) {
    this.setData({
      ri: e.detail.value
    })
  },
  //检查地点选择函数
  checkloc:function(){
    var i=this.data.i;
    if(i==0)
      return false;
    else
      return true;
  },
  //检查是否选择图片函数
  checkimg:function(){
    return this.data.imgpath=="";
  },
  // 跳转到上传界面的函数
  my_createlost:function(){
    wx.navigateTo({
      url: 'mylost',
    })
  },
  my_createfound:function(){
    wx.navigateTo({
      url: 'myfound',
    })
  },
  enterlost:function(){
    wx.navigateTo({
      url: 'enterlost',
    })
  },
  enterfound:function(){
    wx.navigateTo({
      url: 'enterfound',
    })
  },
  // 失物列表的筛选功能下拉
  pulldown_lost:function(e){
    var that=this;
    var ifhidden=this.data.exbar_lost_hidden;
    if(ifhidden){
      this.setData({
        exbar_lost_img:"./images/up.PNG",
        exbar_lost_hidden:!ifhidden
      })
    }else{
      this.setData({
        exbar_lost_img:"./images/down.PNG",
        exbar_lost_hidden:!ifhidden
      })
    }
  },
  // 招领列表的筛选功能下拉
  pulldown_found:function(e){
    var that = this;
    var ifhidden = this.data.exbar_found_hidden;
    if (ifhidden) {
      this.setData({
        exbar_found_img: "./images/up.PNG",
        exbar_found_hidden: !ifhidden
      })
    } else {
      this.setData({
        exbar_found_img: "./images/down.PNG",
        exbar_found_hidden: !ifhidden
      })
    }
  }
})