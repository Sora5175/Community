var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    name:"",
    temp:[],  
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var username = options.signPeople;
    this.setData({
      name:username,
    });

    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/getActivity',
      dataType: "json",
      data: {
       name: that.data.name,
      },
      success: function (res) {
        var arr = res.data.list;
        var temp = [];
        var obj;
        for(var i=0;i<arr.length;i++){
          obj={activityid:arr[i].activityId,content:arr[i].content,starttime:arr[i].startTime,endtime:arr[i].endTime,loc:arr[i].location};
          temp.push(obj);
        }
        that.setData({
         temp: temp
        });
        console.log(temp);
      },
      fail: function () { }
    });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    // var signPeople = option.signPeople;
    // console.log(name);
    // var that = this;
    // // that.setData({

    // wx.request({
    //   url: 'http://localhost:8080/Community/wx-user/GetActivity.action',
    //   data: {
    //     name: that.data.name,
    //   },
    //   header: {
    //     'content-type': 'application/x-www-form-urlencoded'
    //   },
    //   method: 'POST',
    //   success: function (res) {

    //     that.setData({
    //       activityId:res.data.activityId,
    //       signUpTime: res.data.signUpTime,
    //       activityTime: res.data.activityTime,
    //       content: res.data.content,
    //       location:res.data.location,
    //     });
    //     console.log(that.data.activityId);
    //       console.log(that.data.signUpTime);
    //       console.log(that.data.activityTime); 
    //       console.log(that.data.content);
    //       console.log(that.data.location);
    //   }
    // });
    // console.log(this.data.signPeople);


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
  onShareAppMessage:function () {

  },
 /*kindChange: function (e) {
    this.setData({
      kindIndex: e.detail.value,
    });
  },
  areaChange: function (e) {
    this.setData({
      areaIndex: e.detail.value,
    });
  }*/
})