var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    qt: null,
    rname: null,
    up: null,
    down: null,
    text: null,
    turnup: false,
    turndown: false,
    first: 1,
    aNo: getApp().globalData.answerchoose,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    that.setData({
      aNo: getApp().globalData.answerchoose,
    })
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/upget.action',
      data: {
        aNo: this.data.aNo,
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded' 
      },
      method: 'POST',
      success: function (res) {
       
        that.setData({
          qt: res.data.qt,
          rname: res.data.responderName,
          up: res.data.upVotedNum,
          down: res.data.downVotedNum,
          text: res.data.content,
        });
      }
    });
    console.log(this.data.aNo);
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
  upAction: function () {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/up.action',
      data: {
        'ANo': this.data.aNo,
        'upVotedNum': this.data.up+1,
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded' 
      },
      method: 'POST',
      success: function (res) {
        console.log(res.data);
        if (res.data.pass) {
          app.showMessageDialog('点赞成功');
          that.setData({
            up: res.data.upVotedNum,
            turnup: true,
            turndown: false,
          });
        } else {
          app.showMessageDialog('点赞失败');
        }
      },
      fail: function () {
        app.showMessageDialog('服务器繁忙，请稍后再试');
      }
    });
    that.setData({
      first: that.data.first-1,
    })
    console.log(this.data.first);
    if (that.data.first <0) {
      var that = this;
      wx.request({
        url: 'http://localhost:8080/Community/wx-user/down.action',
        data: {
          'ANo': this.data.aNo,
          'downVotedNum': this.data.down-1,
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded' 
        },
        method: 'POST',
        success: function (res) {
          console.log(res.data);
          if (res.data.pass) {
            app.showMessageDialog('点赞成功');
            that.setData({
              down: res.data.downVotedNum,
              turnup: true,
              turndown: false,
            });
          } else {
            app.showMessageDialog('点赞失败');
          }
        },
        fail: function () {
          app.showMessageDialog('服务器繁忙，请稍后再试');
        }
      });
     }
  },


  downAction: function () {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/down.action',
      data: {
        'ANo': this.data.aNo,
        'downVotedNum': this.data.down+1,
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded' // 默认值
      },
      method: 'POST',
      success: function (res) {
        console.log(res.data);
        if (res.data.pass) {
          app.showMessageDialog('点灭成功');
          that.setData({
            down: res.data.downVotedNum,
            turnup: false,
            turndown: true,
          });
        } else {
          app.showMessageDialog('点灭失败');
        }
      },
      fail: function () {
        app.showMessageDialog('服务器繁忙，请稍后再试');
      }
    });
    that.setData({
      first: that.data.first - 1,
    })
    if (that.data.first <0) {
      var that = this;
      wx.request({
        url: 'http://localhost:8080/Community/wx-user/up.action',
        data: {
          'ANo': this.data.aNo,
          'upVotedNum': this.data.up-1,
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded' // 默认值
        },
        method: 'POST',
        success: function (res) {
          console.log(res.data);
          if (res.data.pass) {
            app.showMessageDialog('点灭成功');
            that.setData({
              up: res.data.upVotedNum,
              turnup: false,
              turndown: true,
            });
          } else {
            app.showMessageDialog('点灭失败');
          }
        },
        fail: function () {
          app.showMessageDialog('服务器繁忙，请稍后再试');
        }
      });
    }
  },
})