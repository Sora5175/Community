var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    sexRange: ["请选择", "男", "女"],
    sexIndex: 0,
    schoolRange: [{ "isExist": "0", "schoolId": null, "schoolName": "请选择" }],
    schoolIndex: 0,
    departmentRange: [{ "departmentId": null, "departmentName": "请选择学校", "isExist": null, "schoolId": null }],
    departmentIndex: 0,
    gradeRange: [{ "departmentId": null, "gradeId": null, "gradeName": "请选择院系", "isExist": null }],
    gradeIndex: 0,
    classRange: [{ "classId": null, "className": "请选择年级", "gradeId": null, "isExist": null }],
    classIndex: 0,
    userId: null,
    userName: null,
    userSex: null,
    userSchoolId: null,
    userDepartmentId: null,
    userGradeId: null,
    userClassId: null,
    openId: null,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      userId: app.globalData.userInfo.userId,
      userName: app.globalData.userInfo.name,
      userSex: app.globalData.userInfo.sex,
      userSchoolId: app.globalData.userInfo.schoolId,
      userDepartmentId: app.globalData.userInfo.departmentId,
      userGradeId: app.globalData.userInfo.gradeId,
      userClassId: app.globalData.userInfo.classId,
    });
    this.getSchoolList(true);
    this.getDepartmentList(app.globalData.userInfo.schoolId,true);
    this.getGradeList(app.globalData.userInfo.departmentId,true);
    this.getClassList(app.globalData.userInfo.gradeId,true);
    this.setInfo();
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
  userIdInput: function (e) {
    this.setData({
      userId: e.detail.value,
    });
  },
  userNameInput: function (e) {
    this.setData({
      userName: e.detail.value,
    });
  },
  sexChange: function (e) {
    var that = this;
    this.setData({
      sexIndex: e.detail.value,
    });
    this.setData({
      userSex: that.data.sexRange[that.data.sexIndex],
    });
  },
  schoolChange: function (e) {
    var that = this;
    this.setData({
      schoolIndex: e.detail.value,
    });
    this.setData({
      userSchoolId: that.data.schoolRange[that.data.schoolIndex].schoolId,
    });
    this.getDepartmentList(this.data.schoolRange[this.data.schoolIndex].schoolId,false);
  },
  departmentChange: function (e) {
    var that = this;
    this.setData({
      departmentIndex: e.detail.value,
    });
    this.setData({
      userDepartmentId: that.data.departmentRange[that.data.departmentIndex].departmentId,
    });
    this.getGradeList(this.data.departmentRange[this.data.departmentIndex].departmentId,false);
  },
  gradeChange: function (e) {
    var that = this;
    this.setData({
      gradeIndex: e.detail.value,
    });
    this.setData({
      userGradeId: that.data.gradeRange[that.data.gradeIndex].gradeId,
    });
    this.getClassList(this.data.gradeRange[this.data.gradeIndex].gradeId,false);
  },
  classChange: function (e) {
    var that = this;
    this.setData({
      classIndex: e.detail.value,
    });
    this.setData({
      userClassId: that.data.classRange[that.data.classIndex].classId,
    });
  },
  registerAction: function () {
    this.addUserInfo();
  },
  getSchoolList: function (isSet) {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/getSchoolList.action',
      data: {
      },
      success: function (res) {
        var schoolList = [{ "isExist": null, "schoolId": null, "schoolName": "请选择" }];
        for (var i in res.data) {
          schoolList.push(res.data[i]);
        }
        that.setData({
          schoolRange: schoolList,
        });
        if(isSet){
          for (var i in that.data.schoolRange) {
            if (that.data.schoolRange[i].schoolId == app.globalData.userInfo.schoolId) {
              that.setData({
                schoolIndex: i
              })
            }
          }
        }
      }
    });
  },
  getDepartmentList: function (userSchoolId,isSet) {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/getDepartmentList.action',
      data: {
        userSchoolId: userSchoolId,
      },
      success: function (res) {
        var departmentList = [{ "departmentId": null, "departmentName": "请选择", "isExist": null, "schoolId": null }];
        for (var i in res.data) {
          departmentList.push(res.data[i]);
        }
        that.setData({
          departmentRange: departmentList,
        });
        if(isSet){
          for (var i in that.data.departmentRange) {
            if (that.data.departmentRange[i].departmentId == app.globalData.userInfo.departmentId) {
              that.setData({
                departmentIndex: i
              })
            }
          }
        }
      }
    });
  },
  getGradeList: function (userDepartmentId,isSet) {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/getGradeList.action',
      data: {
        userDepartmentId: userDepartmentId,
      },
      success: function (res) {
        var gradeList = [{ "departmentId": null, "gradeId": null, "gradeName": "请选择", "isExist": null }];
        for (var i in res.data) {
          gradeList.push(res.data[i]);
        }
        that.setData({
          gradeRange: gradeList,
        });
        if(isSet){
          for (var i in that.data.gradeRange) {
            if (that.data.gradeRange[i].gradeId == app.globalData.userInfo.gradeId) {
              that.setData({
                gradeIndex: i
              })
            }
          }
        }
      }
    });
  },
  getClassList: function (userGradeId,isSet) {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/getClassList.action',
      data: {
        userGradeId: userGradeId,
      },
      success: function (res) {
        var classList = [{ "classId": null, "className": "请选择", "gradeId": null, "isExist": null }];
        for (var i in res.data) {
          classList.push(res.data[i]);
        }
        that.setData({
          classRange: classList,
        });
        if(isSet){
          for (var i in that.data.classRange) {
            if (that.data.classRange[i].classId == app.globalData.userInfo.classId) {
              that.setData({
                classIndex: i
              })
            }
          }
        }
      }
    });
  },
  updateUserAction: function () {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/updateUserInfo.action',
      data: {
        wxUserInfo: app.globalData.userInfo,
        userName: that.data.userName,
        userSex: that.data.userSex,
        userSchoolId: that.data.userSchoolId,
        userDepartmentId: that.data.userDepartmentId,
        userGradeId: that.data.userGradeId,
        userClassId: that.data.userClassId,
      },
      success: function (res) {
        if (res.data.pass) {
          getApp().globalData.userInfo = res.data.userInfo;
          app.showMessageDialog('修改成功');
          that.onLoad();
        } else {
          app.showMessageDialog('修改失败，请稍后再试！');
        }
      },
      fail: function () {
        app.showMessageDialog('服务器繁忙，请稍后再试');
      }
    });
  },
  setInfo:function(){
    for (var i in this.data.sexRange) {
      if (this.data.sexRange[i] == app.globalData.userInfo.sex) {
        this.setData({
          sexIndex: i
        })
      }
    }
  }
})