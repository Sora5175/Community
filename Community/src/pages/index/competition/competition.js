var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    departmentRange: ["计算机","电力","能动","经管"],
    departmentIndex:0,
    directionRange: ["网络工程", "软件工程"],
    directionRangeObj: [["网络工程", "软件工程"], ["自动化", "电气"], ["设备", "动力"], ["财会","外贸"]],
    directionIndex: 0,
    areaRange:["全部","校内","校外"],
    areaIndex:0,  
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
  departmentChange: function (e) {
    this.setData({
      departmentIndex: e.detail.value,
      directionRange: this.data.directionRangeObj[e.detail.value],
      directionIndex:0,
    });
  },
  directionChange: function (e) {
    this.setData({
      directionIndex: e.detail.value,
    });
  },
  areaChange:function(e){
    this.setData({
      areaIndex:e.detail.value,
    });
  }
})