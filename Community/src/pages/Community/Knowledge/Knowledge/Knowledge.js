var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    groupList:[],
    groupPublisher:[],
    isSended:[],
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
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/getGroupList.action',
      data: {
        uId: app.globalData.userInfo.userId,
      },
      success: function (res) {
        var getGroupList = [];
        var getGroupPublisher = [];
        var getIsSended = [];
        for (var i in res.data.groupList) {
          getGroupList.push(res.data.groupList[i]);
          getGroupPublisher.push(res.data.groupPublisher[i]);
          getIsSended.push(res.data.isSended[i]);
        }
        that.setData({
          groupList: getGroupList,
          groupPublisher: getGroupPublisher,
          isSended: getIsSended
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
  intoMyGroup: function(){
    wx.navigateTo({
      url: '../MyGroup/MyGroup',
    });
  },
  intoMySendedCV: function(){
    wx.navigateTo({
      url: '../MySendedCV/MySendedCV',
    });
  },
  intoInfo:function(event){
    var group = event.currentTarget.dataset.group == "undefined" ? "" : JSON.stringify(event.currentTarget.dataset.group);
    var publisherName = event.currentTarget.dataset.publisher == "undefined" ? "" : JSON.stringify(event.currentTarget.dataset.publisher.name);
    var isSended = event.currentTarget.dataset.issended == "undefined" ? "" : JSON.stringify(event.currentTarget.dataset.issended);
    wx.navigateTo({
      url: '../KnowledgeInfo/KnowledgeInfo?group='+group+"&publisherName="+publisherName+"&isSended="+isSended,
    });
  },
})