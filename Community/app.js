App({

  /**
   * 当小程序初始化完成时，会触发 onLaunch（全局只触发一次）
   */
  globalData: {
    userInfo:null,
    openId:null,
  },
  onLaunch: function () {

  },

  /**
   * 当小程序启动，或从后台进入前台显示，会触发 onShow
   */
  onShow: function (options) {
    var that = this;
    wx.login({
      success: function (res) {
        if (res.code) {
          wx.request({
            url: 'http://localhost:8080/Community/wx-user/login.action',
            header: {
              'content-type': 'application/json'
            },
            data: {
              code: res.code,
            },
            success: function (res) {
              if (res.data.userInfo == null) {
                that.globalData.openId = res.data.openId;
                wx.redirectTo({
                  url: '/register/register',
                })
              } else {
                that.globalData.userInfo = res.data.userInfo;
                that.globalData.openId = res.data.openId;
                wx.switchTab({
                  url: '/src/index/Index/Index',
                });
              }
            }
          });
        }
      }
    });
    wx.setTabBarBadge({
      index: 3,
      text: '1'
    });
  },

  /**
   * 当小程序从前台进入后台，会触发 onHide
   */
  onHide: function () {
    
  },

  /**
   * 当小程序发生脚本错误，或者 api 调用失败时，会触发 onError 并带上错误信息
   */
  onError: function (msg) {
    
  },
  showMessageDialog:function (res){
    wx.showToast({

      title: res,

      icon: 'none',

      duration: 5000,

    });
  },
  hasUser:function(array,user){
    var has = false;
    for(var x in array){
      if(array[x].id = user.id){
        has =  true;
      }
    }
    return has;
  }
})
