package com.hongru.base;
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


import android.app.Application;
import android.support.annotation.CallSuper;

import com.blankj.utilcode.util.Utils;
import com.hongru.base.callbacks.ActivityLifecycleCallback;
import com.hongru.base.callbacks.MemoryRecycleCallBack;

/**
 * @author 彭鸿儒
 * @date 2018/1/13
 * 邮箱:peng_hongru@163.com
 */
public class BaseApplication extends Application {


    /**
     * 调用时刻： Application 实例创建时调用
     * Android系统的入口是Application类的 onCreate（），默认为空实现
     * 作用:
     * 1.初始化 应用程序级别 的资源，如全局对象、环境配置变量、图片资源初始化、推送服务的注册等(注：请不要执行耗时操作，否则会拖慢应用程序启动速度)
     * 2.数据共享、数据缓存设置全局共享数据，如全局共享变量、方法等(注：这些共享数据只在应用程序的生命周期内有效，当该应用程序被杀死，这些数据也会被清空，所以只能存储一些具备 临时性的共享数据)
     */
    @CallSuper
    @Override
    public void onCreate() {
        super.onCreate();
        registerComponentCallbacks(new MemoryRecycleCallBack());
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallback());
        Utils.init(this);

    }

}
