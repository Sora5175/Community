// community/src/pages/lostfound/lostcontent.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    lno:"",
    item: {},
    flag:0
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      lno:options.lno
    });
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-lf/lostcontentonload',
      dataType: "json",
      data: { lno:that.data.lno },
      success: function (res) {
        var map=res.data.map;
        if(map.flag=="1"){
          that.setData({
            item: { img: "./images/addfile.jpg", uname: "pty", describe: map.describe, tel: map.tel, email: map.email, lostimg: "http://localhost:8080/Community/lostimgupload/"+map.photo,losttime:map.time,location:map.location},
            flag: 1
          })
        }else{
          wx.showModal({
            title: '提示',
            content: '该信息不存在,点击确认返回',
            showCancel:false,
            success:function(res){
              if(res.confirm){
                wx.navigateBack({
                  delta:1
                })
              }
            }
          })
        }
      },
      fail: function () {

      }
    })
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
  returnlost:function(e){
    var that=this;
    wx.navigateTo({
      url: 'noticelost?lno='+that.data.lno,
    })
  }
})