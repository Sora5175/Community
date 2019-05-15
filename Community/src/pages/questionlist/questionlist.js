// Community/src/pages/questionlist/questionlist.js
var app = getApp()
Page({
  data: {
    questionList: [],
    qin: getApp().globalData.questioninput,
    user: getApp().globalData.userInfo,
  },

  onLoad: function () {
    console.log('onLoad')
    var that = this;
    wx.request({
      url: 'http://localhost:8080/Community/wx-user/questionget.action',
      data: {
        qinput: getApp().globalData.questioninput,
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'POST',
      success: function (res) {
        var getQuestionList = [];
        for (var i in res.data) {
          getQuestionList.push(res.data[i]);
        }
        that.setData({
          questionList: getQuestionList,
        });
        console.log(that.data.questionList);
        console.log(getApp().globalData.userInfo);
      }
    });

  },

  gettext: function (e) {
    var actionArr = this.data.actionArr;
    var val = e.detail.value;
    getApp().globalData.questioninput = val;
  },

  intoSearch: function () {
    wx.navigateTo({
      url: '../../pages/questionlist/questionlist',
    })
  },
  
  bindQueTap: function (e) {
    var qno = e.currentTarget.dataset.item;
    getApp().globalData.qno = qno
    wx.navigateTo({
      url: '../question/question'
    })
  },

  bindAnsTap: function (e) {
    var ano = e.currentTarget.dataset.item;
    getApp().globalData.answerchoose = ano
    wx.navigateTo({
      url: '../answer/answer'
    })
  },

})