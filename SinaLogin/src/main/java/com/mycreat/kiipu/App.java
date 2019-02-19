package com.mycreat.kiipu;

import android.app.Application;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.common.QueuedWork;


public class App extends Application {

    @Override
    public void onCreate() {

        super.onCreate();
        //开启debug模式，方便定位错误，具体错误检查方式可以查看http://dev.umeng.com/social/android/quick-integration的报错必看，正式发布，请关闭该模式
        Config.DEBUG = true;
        QueuedWork.isUseThreadPool = false;
//        UMShareAPI.get(this);
    }

    //各个平台的配置，建议放在全局Application或者程序入口
    {
        PlatformConfig.setSinaWeibo("3763012369", "70ca7f8be6f87b1157ced83e67d27a48","http://sns.whalecloud.com");

    }
}
