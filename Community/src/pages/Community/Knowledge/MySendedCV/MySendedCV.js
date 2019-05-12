var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    groupList:[],
    CVList:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var getGroupList = [];
    var getCVList = [];
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/getMySendedCV.action',
      data: {
        uId: app.globalData.userInfo.userId,
      },
      success: function (res) {
        for (var i in res.data.groupList) {
          getGroupList.push(res.data.groupList[i]);
          getCVList.push(res.data.CVList[i]);
        }
        that.setData({
          groupList:getGroupList,
          CVList:getCVList
        });
      }
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

  }
})