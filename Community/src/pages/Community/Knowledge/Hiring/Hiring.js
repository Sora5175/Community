var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    groupName:'',
    groupContent:'',
    needNumber:'0',
    alternateNumber:'0',
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
  groupNameInput:function(e){
    this.data.groupName = e.detail.value;
  },
  groupContentInput: function (e) {
    this.data.groupContent = e.detail.value;
  },
  needNumberInput:function(e){
    this.data.needNumber = e.detail.value;
  },
  alternateNumberInput:function(e){
    this.data.alternateNumber = e.detail.value;
  },
  confirmHiring:function(){
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/createGroup.action',
      data: {
        groupName: that.data.groupName,
        groupContent: that.data.groupContent,
        uId : app.globalData.userInfo.userId,
        needNumber: that.data.needNumber,
        alternateNumber: that.data.alternateNumber,
      },
      success: function (res) {
        if(res.data.pass){
          app.showMessageDialog("成功");
          wx.navigateTo({
            url: '../MyGroup/MyGroup',
          });
        }
      }
    });
  },
})