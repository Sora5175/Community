var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    groupList:[],
    isFull:[],
    isOwner:[],
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
    var that = this;
    var getGroupList = [];
    var getIsFull = [];
    var getIsOwner = [];
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/getMyGroupList.action',
      data: {
        uId: app.globalData.userInfo.userId,
      },
      success: function (res) {
        for (var i in res.data.groupList) {
          getGroupList.push(res.data.groupList[i]);
          getIsFull.push(res.data.isFull[i]);
          getIsOwner.push(res.data.isOwner[i]);
        }
        that.setData({
          groupList: getGroupList,
          isFull: getIsFull,
          isOwner: getIsOwner,
        });
      }
    });
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
  intoHiring:function(){
    wx.navigateTo({
      url: '../Hiring/Hiring',
    });
  },
  intoMyReceivedCV:function(){
    wx.navigateTo({
      url: '../MyReceivedCV/MyReceivedCV',
    });
  },
  intoGroupInfo:function(event){
    var temp = event.currentTarget.dataset.temp == "undefined" ? "" : JSON.stringify(event.currentTarget.dataset.temp);
    wx.navigateTo({
      url: '../GroupInfo/GroupInfo?group=' + temp,
    });
  },
})