// Community/src/pages/Community/Knowledge/CVSInfo/CVSInfo.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    gId:null,
    name:null,
    CVSList:[],
    userInfoList:[],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      gId: options.gId,
      name: options.name,
    });
    wx.setNavigationBarTitle({
      title: options.name
    });
    var that = this;
    var getCVSList = [];
    var getUserInfoList = [];
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/getCVSList.action',
      data: {
        gId: that.data.gId,
      },
      success: function (res) {
        for (var i in res.data.CVSList) {
          getCVSList.push(res.data.CVSList[i]);
          getUserInfoList.push(res.data.userInfoList[i]);
        }
        that.setData({
          CVSList: getCVSList,
          userInfoList: getUserInfoList,
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

  },
  intoCVInfo:function(event){
    var temp = event.currentTarget.dataset.temp == "undefined" ? "" : event.currentTarget.dataset.temp;
    wx.navigateTo({
      url: '../CVInfo/CVInfo' +temp,
    });
  }
})