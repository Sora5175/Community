// community/src/pages/lostfound/noticelost.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    lno:"",
    locarr:[],
    locidarr:[],
    i:0,
    imgpath:"",
    img: "./images/addfile.jpg",
    userId: null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    this.setData({
      userId: getApp().globalData.userInfo.userId,
      lno: options.lno
    });
    // 加载地点列表
    wx.request({
      url: 'http://localhost:8080/Community/wx-lf/loconload',
      dataType: "json",
      data: { uid: that.data.userId },
      success: function (res) {
        var arr = res.data.list;
        var obj;
        var locarr = ["-请点击选择归还地点-"], locidarr = [];
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
  //检查地点选择函数
  checkloc: function () {
    var i = this.data.i;
    if (i == 0)
      return false;
    else
      return true;
  },
  //检查是否选择图片函数
  checkimg: function () {
    return this.data.imgpath == "";
  },
  formsubmit:function(e){
    var that = this;
    var formdata = e.detail.value;
    //验证输入是否完整
    if (!this.checkloc() || this.checkimg()) {
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
    //为表单对象添加信息
    formdata.returnlocid = this.data.locidarr[this.data.i - 1];
    formdata.uid = this.data.userId;
    formdata.lno=this.data.lno;
    wx.uploadFile({
      url: 'http://localhost:8080/Community/wx-lf/returnupload',
      filePath: that.data.imgpath,
      name: "myFile",
      formData: formdata,
      success: function (res) {
        console.log(res);
        wx.showModal({
          title: '提示',
          content: '提交成功',
          showCancel: false,
          success: function (res) {
            if (res.confirm) {
              wx.navigateBack({
                delta:1
              })
            }
          }
        });
      }
    })
  }
})