var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    group:null,
    isOwner: false,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var group = JSON.parse(options.group);
    this.setData({
      groupName: group.name,
      groupContent: group.content,
      needNumber: group.needNumber,
      alternateNumber: group.alternateNumber,
      group: group,
      isOwner: (group.uId == app.globalData.userInfo.userId),
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
  onShow: function (options) {
    
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
  groupNameInput: function (e) {
    this.data.group.name = e.detail.value;
  },
  groupContentInput: function (e) {
    this.data.group.content = e.detail.value;
  },
  needNumberInput: function (e) {
    this.data.group.needNumber = e.detail.value;
  },
  alternateNumberInput: function (e) {
    this.data.group.alternateNumber = e.detail.value;
  },
  confirmUpdate:function(){
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/updateGroup',
      data:{
        gId:that.data.group.gId,
        name: that.data.group.name,
        content: that.data.group.content,
        needNumber: that.data.group.needNumber,
        alternateNumber: that.data.group.alternateNumber,
      },
      success:function(res){
        if(res.data == 'true'){
          app.showMessageDialog("修改成功！");
        }else{
          app.showMessageDialog(res.data);
        }
      },
      fail:function(){
          app.showMessageDialog("服务器繁忙，请稍后重试！");
          that.onLoad();
      },
    });
  },
  intoManagement:function(){
    var that = this;
    wx.navigateTo({
      url: '../GroupManagement/GroupManagement?gId='+that.data.group.gId+"&name="+that.data.group.name+"&publisherId="+that.data.group.uId,
    })
  },
})