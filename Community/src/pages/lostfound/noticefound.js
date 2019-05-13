// community/src/pages/lostfound/noticefound.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    img:"./images/addfile.jpg",
    fno:"",
    locarr:[],
    locidarr:[],
    imgpath:"",
    i:0,
    start:"",
    end:"",
    date:"-选择时间-",
    j:0,
    Type:["-请点击选择物品分类-","图书","电子","衣服","鞋子","玩具","箱包","洗护","眼镜","手表","乐器","美食","宠物","办公","百货","证件","其他"],
    userId: null,
  },

  getToday: function (e) {
    var date = new Date();
    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();
    var str = year + "-";
    if (month < 10) {
      str += "0" + month + "-";
    } else {
      str += month + "-";
    }
    if (day < 10) {
      str += "0" + day;
    } else {
      str += day;
    }
    return str;
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    this.setData({
      userId: getApp().globalData.userInfo.userId,
      fno: options.fno
    });
    // 设置时间
    var year=new Date().getFullYear();
    this.setData({
      start:(year-1)+"-01-01",
      end:this.getToday()
    })
    // 加载地点列表
    wx.request({
      url: 'http://localhost:8080/Community/wx-lf/loconload',
      dataType: "json",
      data: { uid: that.data.userId },
      success: function (res) {
        var arr = res.data.list;
        var obj;
        var locarr = ["-请点击选择丢失地点-"], locidarr = [];
        for (var i = 0; i < arr.length; i++) {
          obj = arr[i];
          locarr.push(obj.classroomName);
          locidarr.push(obj.classroomId);
        }
        that.setData({
          locarr: locarr,
          locidarr: locidarr
        })
      },
      fail: function () { }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  uploadimg: function (e) {
    var that = this;
    wx.chooseImage({
      count: 1,
      sizeType: ['original', 'compressed'],
      sourceType: ['album', 'camera'],
      success: function (res) {
        that.setData({
          imgpath: res.tempFilePaths[0],
          img: res.tempFilePaths[0]
        })
      }
    })
  },
  bindPickerChange: function (e) {
    this.setData({
      i: e.detail.value
    })
  },
  bindDateChange:function(e){
    this.setData({
      date:e.detail.value
    })
  },
  bindTypeChange:function(e){
    this.setData({
      j:e.detail.value
    })
  },
  formsubmit:function(e){
    var that = this;
    var formdata = e.detail.value;
    // 检查
    if (that.data.i==0 || that.data.j==0 || that.data.date=="-选择时间-" || formdata.color=="" || formdata.lostname=="") {
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
    formdata.lostloc = this.data.locidarr[this.data.i - 1];
    formdata.uid = this.data.userId;
    formdata.fno = this.data.fno;
    formdata.type = this.data.Type[this.data.j];
    if(this.data.imgpath==""){
      wx.request({
        url: 'http://localhost:8080/Community/wx-lf/getlostuploadwithoutpic',
        dataType: "json",
        data: formdata,
        success: function (r) {
          if (r.data.confirm) {
            wx.showModal({
              title: '提示',
              content: '提交成功',
              showCancel: false,
              success: function (res) {
                if (res.confirm) {
                  wx.navigateBack({
                    delta: 1
                  })
                }
              }
            });
          }
        },
        fail: function () { }
      })
    }else{
      wx.uploadFile({
        url: 'http://localhost:8080/Community/wx-lf/getlostupload',
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
                wx.navigateBack({
                  delta: 1
                })
              }
            }
          });
        }
      })
    }
  }
})