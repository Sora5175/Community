var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    content:null,
    describe:null,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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
  askinput: function(e){
    this.setData({
      content: e.detail.value,
    });
  },
  describeinput: function (e) {
    this.setData({
      describe: e.detail.value,
    });
  },
  sub: function () {
    var that = this; 
    console.log(that.data.content);
    if(!that.data.content){
      app.showMessageDialog('请输入问题标题');
    }
    else{
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/ask.action',
      data: {
        publisherNo: getApp().globalData.userInfo.userId,
        content: that.data.content,
        qdescribe: that.data.describe,
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
