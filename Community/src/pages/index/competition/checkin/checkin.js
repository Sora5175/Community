var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    name: null,
    userid: null,
    needBook: null,
    compeid: null,
    classroom: null,
    phone: null,
    email: null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      name: getApp().globalData.userInfo.name,
      userid: getApp().globalData.userInfo.userId,
      compeid: options.competitionid
    })
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/getCheckPass.action',
      data: {
        competitionId:that.data.compeid,
        userId:that.data.userid
      },
      success:function(res) {
        if(!res.data.checkList==null) {
          app.showMessageDialog('1');
          wx.navigateBack({
          })
        }
      }
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

  changechoice:function(e) {
    this.setData({
      needBook:e.detail.value
    });
  },
  classroominput:function(e) {
    this.setData({
      classroom: e.detail.value
    })
  },
  phoneinput:function(e) {
    this.setData({
      phone: e.detail.value
    })
  },
  emailinput:function(e) {
    this.setData({
      email: e.detail.value
    })
  },
  submit:function() {
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/addCheckPass.action',
      data: {
        competitionId: compeid,
        userId: userId,
        username: username,
        classroom: classroom,
        phone: phone,
        email: email,
        needBook: needBook
      },
      success: function(res) {
        if(!res.data.isSuccess==null) {
          app.showMessageDialog('提交成功，请耐心等待');
          wx.navigateBack({
          })
        }
      }
    })
  }
})