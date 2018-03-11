package com.hongru.base.callbacks;
//<pre>
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG
//</pre>


import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.hongru.base.ui.BaseActivity;

import org.greenrobot.eventbus.EventBus;

/**
 * @author 彭鸿儒
 * @date 2018/1/13
 * 邮箱:peng_hongru@163.com
 */
public class ActivityLifecycleCallback implements Application.ActivityLifecycleCallbacks {


    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
        EventBus.getDefault().register(activity);
    }

    @Override
    public void onActivityResumed(Activity activity) {
        if (activity instanceof BaseActivity) {
            ((BaseActivity)activity).setViewOnStackTop(true);
        }
    }

    @Override
    public void onActivityPaused(Activity activity) {
        if (activity instanceof BaseActivity) {
            ((BaseActivity)activity).setViewOnStackTop(false);
        }

    }

    @Override
    public void onActivityStopped(Activity activity) {
        EventBus.getDefault().unregister(activity);
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
