var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    onUpdate: false,
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
    gId:null,
    name:null,
    cId:null,
    userId: null,
    userName: null,
    userSex: null,
    userSchoolId: null,
    userDepartmentId: null,
    userGradeId: null,
    userClassId: null,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      gId:options.gId,
      name:options.name,
      cId:options.cId,
      userId: options.userId,
      userName: options.userName,
      userSex: options.userSex,
      userSchoolId: options.userSchoolId,
      userDepartmentId: options.userDepartmentId,
      userGradeId: options.userGradeId,
      userClassId: options.userClassId,
    });
    this.getSex();
    this.getSchoolList(true);
    this.getDepartmentList(this.data.userSchoolId, true);
    this.getGradeList(this.data.userDepartmentId, true);
    this.getClassList(this.data.userGradeId, true);
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
      departmentIndex: 0,
      gradeIndex: 0,
      classIndex: 0,
    });
    this.setData({
      userSchoolId: that.data.schoolRange[that.data.schoolIndex].schoolId,
    });
    this.getDepartmentList(this.data.schoolRange[this.data.schoolIndex].schoolId, false);
    this.getGradeList(this.data.departmentRange[this.data.departmentIndex].departmentId, false);
    this.getClassList(this.data.gradeRange[this.data.gradeIndex].gradeId, false);
  },
  departmentChange: function (e) {
    var that = this;
    this.setData({
      departmentIndex: e.detail.value,
      gradeIndex: 0,
      classIndex: 0,
    });
    this.setData({
      userDepartmentId: that.data.departmentRange[that.data.departmentIndex].departmentId,
    });
    this.getGradeList(this.data.departmentRange[this.data.departmentIndex].departmentId, false);
    this.getClassList(this.data.gradeRange[this.data.gradeIndex].gradeId, false);
  },
  gradeChange: function (e) {
    var that = this;
    this.setData({
      gradeIndex: e.detail.value,
      classIndex: 0,
    });
    this.setData({
      userGradeId: that.data.gradeRange[that.data.gradeIndex].gradeId,
    });
    this.getClassList(this.data.gradeRange[this.data.gradeIndex].gradeId, false);
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
  getSchoolList: function (getInfo) {
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
        if (getInfo) {
          for (var i in that.data.schoolRange) {
            if (that.data.schoolRange[i].schoolId == that.data.userSchoolId) {
              that.setData({
                schoolIndex: i,
              });
            }
          }
        }
      }
    });
  },
  getDepartmentList: function (userSchoolId, getInfo) {
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
        if (getInfo) {
          for (var i in that.data.departmentRange) {
            if (that.data.departmentRange[i].departmentId == that.data.userDepartmentId) {
              that.setData({
                departmentIndex: i,
              });
            }
          }
        }
      }
    });
  },
  getGradeList: function (userDepartmentId, getInfo) {
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
        if (getInfo) {
          for (var i in that.data.gradeRange) {
            if (that.data.gradeRange[i].gradeId == that.data.userGradeId) {
              that.setData({
                gradeIndex: i,
              });
            }
          }
        }
      }
    });
  },
  getClassList: function (userGradeId, getInfo) {
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
        if (getInfo) {
          for (var i in that.data.classRange) {
            if (that.data.classRange[i].classId == that.data.userClassId) {
              that.setData({
                classIndex: i,
              });
            }
          }
        }
      }
    });
  },
  getSex: function () {
    var that = this;
    for (var i in that.data.sexRange) {
      if (that.data.sexRange[i] == that.data.userSex) {
        that.setData({
          sexIndex: i,
        });
      }
    }
  },
  CVAccept:function(){
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/CVAction.action',
      data: {
        cId: that.data.cId,
        accept: true,
      },
      success: function (res) {
        if(res.data.pass){
          app.showMessageDialog(res.data.message);
          wx.navigateBack({
            url: '../CVSInfo/CVSInfo?gId=' + that.data.gId + "&name=" + that.data.name,
          });
        }
      },
    });
  },
  CVReject:function(){
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/CVAction.action',
      data: {
        cId: that.data.cId,
        accept: false,
      },
      success: function (res) {
        if (res.data.pass) {
          app.showMessageDialog(res.data.message);
          wx.navigateBack({
            url: '../CVSInfo/CVSInfo?gId=' + that.data.gId + "&name=" + that.data.name,
          });
        }
      },
    });
  },
})