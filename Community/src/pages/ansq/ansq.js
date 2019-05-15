var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    content: '',
    qt: null,
    responderNo: null,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      responderNo: getApp().globalData.userInfo.userId,
      qt: options.qt,
    });
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
  ansinput: function (e) {
    this.setData({
      content: e.detail.value,
    });
  },
  sub: function () {
    var that = this;
    console.log(that.data.content);
    if (!that.data.content) {
      app.showMessageDialog('请输入回答内容');
    }
    else {
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/answer.action',
      data: {
         qNo: getApp().globalData.qno,
        'content': that.data.content,
        responderNo: that.data.responderNo,
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded' // 默认值
      },
      method: 'POST',
      success: function (res) {
        console.log(res.data);
        if (res.data) {
          app.showMessageDialog('发布成功');
        } else {
          app.showMessageDialog('发布失败');
        }
      },
      fail: function () {
        app.showMessageDialog('服务器繁忙，请稍后再试');
      }
    });}
  }

})
