var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    imgUrls:[
      "images/b1.jpg",
      "images/b2.jpg",
      "images/b3.jpg",
      "images/b4.jpg",
    ],
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
  intoSign: function () {
    wx.scanCode({
      onlyFromCamera: true,
      //扫码成功
      success: (res) => {
        var result = res.result;
        wx.request({
          url: result + "&uId="+ app.globalData.userInfo.userId,
          method: "GET",
          success: function (res) {
            //签到成功
            if (res.data.pass || res.data.pass == 'true') {
              //弹窗提示
              app.showMessageDialog('签到成功！');
            } else {
              if (res.data.timeout || res.data.timeout == 'true') {
                app.showMessageDialog('二维码已超时！');
              } else {
                app.showMessageDialog('请勿重复签到！');
              }
            }
          },
          fail: function (res) {
            app.showMessageDialog('服务器繁忙，请稍后重试！');
          }
        });
      },
    });
  },
  intoPlan:function(){
    wx.navigateTo({
      url: '../../pages/index/plan/plan'
    })
  },
  intoActivity:function(){
    wx.navigateTo({
      url: '../../pages/index/activity/activity'
    })
  },
  intoCompetition: function () {
    wx.navigateTo({
      url: '../../pages/index/competition/competition'
    })
  },
});