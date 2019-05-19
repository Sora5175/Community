var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    courseId:null,
    course:null,
    name:"",
    insign:false,
    options:null,
    isMine:false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      options:options,
      courseId:options.courseId
    })
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-course/getCourse.action',
      data: {
        courseId: that.data.courseId
      },
      success: function (res) {
        var isMine = res.data.course.uId == app.globalData.userInfo.userId;
        that.setData({
          course:res.data.course,
          name: res.data.name,
          inSign:res.data.inSign,
          isMine:isMine
        })
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
  startSign:function(){
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-course/startSign.action',
      data: {
        courseId:that.data.courseId
      },
      success: function (res) {
        if (res.data.pass || res.data.pass == "true") {
          app.showMessageDialog('签到发起成功');
        } else {
          app.showMessageDialog('签到发起失败');
        }
        that.onLoad(that.data.options);
      }
    })
  },
  endCourse: function () {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-course/endCourse.action',
      data: {
        courseId: that.data.courseId
      },
      success: function (res) {
        if(res.data.pass || res.data.pass == 'true'){
          app.showMessageDialog("课程结束成功！");
          wx.navigateBack({
            url:"../plan/plan"
          });
        }else{
          app.showMessageDialog("课程结束失败！");
        }
      }
    });
  },
  intoSignList:function(){
    wx.navigateTo({
      url: '../signlist/signlist?courseId='+this.data.courseId,
    })
  },
  joinCourse:function(){
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-course/joinCourse.action',
      data: {
        courseId: that.data.courseId,
        uId:app.globalData.userInfo.userId
      },
      success: function (res) {
        if (res.data.pass || res.data.pass == 'true') {
          app.showMessageDialog("加入课程成功！");
          var pages = getCurrentPages();
          var prevPage = pages[pages.length - 2].route;
          wx.navigateBack({
            url:prevPage
          });
        } else {
          app.showMessageDialog("加入课程失败！");
        }
      }
    });
  },
})