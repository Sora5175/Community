var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    kindRange: ["全部","文体艺术", "科技创新"],
    kindIndex: 0,
    areaRange: ["全部", "校内", "校外"],
    areaIndex: 0,  
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
  kindChange: function (e) {
    this.setData({
      kindIndex: e.detail.value,
    });
  },
  areaChange: function (e) {
    this.setData({
      areaIndex: e.detail.value,
    });
  }
})