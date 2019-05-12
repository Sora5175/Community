Page({

  /**
   * 页面的初始数据
   */
  data: {
    gId: null,
    publisherId:null,
    name: null,
    memberList: [],
    alternateMemberList: [],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      gId: options.gId,
      name: options.name,
      publisherId:options.publisherId
    });
    wx.setNavigationBarTitle({
      title: options.name
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
    var that = this;
    var getAlternateMemberList = [];
    var getMemberList = [];
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/getMemberList.action',
      data: {
        gId: that.data.gId,
      },
      success: function (res) {
        for (var i in res.data.alternateMemberList) {
          getAlternateMemberList.push(res.data.alternateMemberList[i]);
        }
        for (var i in res.data.memberList) {
          getMemberList.push(res.data.memberList[i]);
        }
        that.setData({
          alternateMemberList: getAlternateMemberList,
          memberList: getMemberList,
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
  intoMemberInfo: function (event) {
    var temp = event.currentTarget.dataset.temp == "undefined" ? "" : event.currentTarget.dataset.temp;
    wx.navigateTo({
      url: '../MemberInfo/MemberInfo' + temp,
    });
  }
})