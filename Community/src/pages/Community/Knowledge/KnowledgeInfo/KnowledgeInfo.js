var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    group:null,
    publisherName:null,
    isSended: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      group:JSON.parse(options.group),
      publisherName:JSON.parse(options.publisherName),
      isSended: JSON.parse(options.isSended)
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
  confirmCV:function(){
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/sendCV.action',
      data: {
        uId: app.globalData.userInfo.userId,
        gId: that.data.group.gId
      },
      success: function (res) {
        if (res.data || res.data == 'true') {
          app.showMessageDialog("投递简历成功！");
          wx.navigateBack({
            url: '../Knowledge/Knowledge',
          });
        }
      }
    });
  },
})