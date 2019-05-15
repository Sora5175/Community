//answer.js

var app = getApp()
Page({
  data: {
    qNo: '',
    answerList: [],
    qt: null,
  },
 
  onLoad: function () {
    console.log('onLoad')
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/answerget.action',
      data: {
        qNo: getApp().globalData.qno,
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'POST',
      success: function (res) {
        var getAnswerList = [];
        for(var i in res.data){
          getAnswerList.push(res.data[i]);
        }
        that.setData({
          answerList: getAnswerList,
          qt: getAnswerList[0].qt,
        });
        console.log(that.data.answerList);
      }
    });
    
  },
  //事件处理函数
  bindItemTap: function (e) {
    var id = e.currentTarget.dataset.item;
    getApp().globalData.answerchoose = id
    wx.navigateTo({
      url: '../answer/answer'
    })
  },

  askTap: function () {
    var that = this;
    wx.navigateTo({
      url: '../../pages/ansq/ansq?qt='+that.data.qt,
    })
  },
  
  tapName: function(event){
    console.log(event)
  }
})
