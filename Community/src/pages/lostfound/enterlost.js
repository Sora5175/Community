// community/src/pages/lostfound/enterlost.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    pageindex:0,
    lostinfo: [],
    load_content:"点击加载更多",
    ifloadmore:true,
    userId: null
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    this.setData({
      userId: getApp().globalData.userInfo.userId
    })
    wx.request({
      url: 'http://localhost:8080/Community/wx-lf/ensurelostonload',
      dataType:"json",
      data:{index:that.data.pageindex,uid:that.data.userId},
      success:function(res){
        var arr=res.data.list;
        var obj={};
        var a={};
        var newarr=[];
        if(arr.length<5){
          that.setData({
            load_content:"无法加载更多内容了",
            ifloadmore:false,
          })
        }
        for(var i=0;i<arr.length;i++){
          obj=arr[i];
          a = { returnloc: obj.returnLoc, name: obj.publisherId, tel: obj.time, pic: "http://localhost:8080/Community/" +obj.pic,lno:obj.lNo,id:obj.id};
          newarr.push(a);
        }
        that.setData({
          lostinfo:newarr
        })
      },
      fail:function(){}
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
  //确认找回
  confirm:function(e){
    var that=this;
    wx.showModal({
      title: '提示',
      content: '是否确认找回？若确认后，与该失物相关的确认记录将消失并且删除失物记录。',
      success: function (res) {
        if (res.confirm) {
          //删除本地记录
          var lno=e.target.dataset.lno;
          var arr=that.data.lostinfo;
          var obj={};
          for(var i=arr.length-1;i>=0;i--){
            obj=arr[i];
            if(obj.lno==lno){
              arr.splice(i,1);
            }
          }
          that.setData({
            lostinfo:arr
          });
          //删除数据库记录
          wx.request({
            url: 'http://localhost:8080/Community/wx-lf/deleteofconfirm',
            dataType:"json",
            data:{lno:e.target.dataset.lno},
            success:function(res){
              if(res.data.flag == false){
                wx.showModal({
                  title: '提示',
                  content: '出现了一点小问题，请稍后再试',
                })
              }
            },
            fail:function(){}
          })
        }
      }
    });
  },
  //删除记录
  deleteinfo:function(e){
    var that=this;
    var idx=e.target.dataset.idx;
    wx.showModal({
      title: '提示',
      content: '确认要删除本条记录吗？',
      success:function(res){
        if(res.confirm){
          var arr = that.data.lostinfo;
          //删除本地记录
          for (var i = 0; i < arr.length; i++) {
            if(arr[i].id == idx){
              arr.splice(i,1);
            }
          }
          that.setData({
            lostinfo:arr
          })
          //删除数据库记录
          wx.request({
            url: 'http://localhost:8080/Community/wx-lf/deleteofdel',
            dataType:"json",
            data:{id:idx},
            success:function(res){
              if(res.data.flag == false){
                wx.showModal({
                  title: '提示',
                  content: '出现了一点小问题，请稍后再试',
                })
              }
            },
            fail:function(){}
          })
        }
      }
    })
  },
  loadmore:function(){
    var that=this;
    if(this.data.ifloadmore){
      this.setData({
        pageindex:this.data.pageindex+5
      });
      wx.request({
        url: 'http://localhost:8080/Community/wx-lf/ensurelostonload',
        dataType:"json",
        data:{index:that.data.pageindex,uid:that.data.userId},
        success:function(res){
          var arr=res.data.list;
          var temparr=[];
          var obj={};
          for(var i=0;i<arr.length;i++){
            obj=arr[i];
            temparr.push({ returnloc: obj.returnLoc, name: obj.publisherId, tel: obj.time, pic: "http://localhost:8080/Community/" + obj.pic, lno: obj.lNo, id: obj.id });
          }
          that.setData({
            lostinfo:that.data.lostinfo.concat(temparr)
          });
          if(arr.length<5){
            that.setData({
              load_content: "无法加载更多内容了",
              ifloadmore: false,
            })
          }
        },
        fail:function(){}
      })
    }
  }
})