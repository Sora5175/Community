var app = getApp(); 
Page({

  /**
   * 页面的初始数据
   */
  data: {
    courseList:[],
    userList:[],
    nameList:[],
    check:"",
    options:null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      options:options,
      check:options.check,
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
    wx.request({
      url: 'http://localhost:8080/Community/wx-course/getCheckedCourseList.action',
      data: {
        uId: app.globalData.userInfo.userId,
        check: that.data.check,
      },
      success: function (res) {
        that.setData({
          courseList: res.data.courseList,
          nameList: res.data.nameList
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
  checkInput: function (e) {
    this.setData({
      check: e.detail.value,
    });
  },
  intoInfo: function (event) {
    var courseId = event.currentTarget.dataset.courseid == "undefined" ? "" : event.currentTarget.dataset.courseid;
    wx.navigateTo({
      url: '../courseInfo/courseInfo?courseId=' + courseId,
    });
  },
  checkCourse: function () {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-course/getCheckedCourseList.action',
      data: {
        uId: app.globalData.userInfo.userId,
        check: that.data.check
      },
      success: function (res) {
        that.setData({
          courseList: res.data.courseList,
          nameList: res.data.nameList
        });
      }
    });
  }
})