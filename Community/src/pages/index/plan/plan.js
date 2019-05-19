var app = getApp()
Page({
  data: {
    showTip:false,
    courseList:null,
    name:"",
    check:""
  },
  onLoad: function () {
    
  },
  onShow:function(){
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-course/getCourseList.action',
      data: {
        uId: app.globalData.userInfo.userId,
      },
      success: function (res) {
        that.setData({
          courseList: res.data.courseList
        });
      }
    })
  },
  nameInput: function (e) {
    this.setData({
      name: e.detail.value,
    });
  },
  checkInput: function (e) {
    this.setData({
      check: e.detail.value,
    });
  },
  createCourse:function(){
    this.setData({
      showTip: true
    });
  },
  confirm:function(){
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-course/addCourse.action',
      data: {
        uId: app.globalData.userInfo.userId,
        name: that.data.name
      },
      success: function (res) {
        that.setData({
          showTip: false
        });
        if (res.data.pass || res.data.pass == "true") {
          app.showMessageDialog('添加成功');
          that.onShow();
        } else {
          app.showMessageDialog('添加失败');
          that.onShow();
        }
      }
    })
  },
  cancel:function(){
    this.setData({
      showTip:false
    });
  },
  intoInfo: function (event) {
    var courseId = event.currentTarget.dataset.courseid == "undefined" ? "" : event.currentTarget.dataset.courseid;
    wx.navigateTo({
      url: '../courseInfo/courseInfo?courseId=' + courseId,
    });
  },
  checkCourse:function(){
    wx.navigateTo({
      url: '../checkedcourse/checkedcourse?check='+this.data.check,
    })
  }
})