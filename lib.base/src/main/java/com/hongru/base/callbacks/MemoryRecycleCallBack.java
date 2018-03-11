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


import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

import com.hongru.base.maps.RecycleMap;

/**
 * app 内存状态回调监听
 * @author 彭鸿儒
 * @date 2018/1/13
 * 邮箱:peng_hongru@163.com
 */
public class MemoryRecycleCallBack implements ComponentCallbacks2 {

    /**
     * 作用：通知 应用程序 当前内存使用情况（以内存级别进行识别）
     * @param level
     */
    @Override
    public void onTrimMemory(int level) {
        switch (level) {
            /**
             * 内存不足级别：5
             * 状态：应用程序处于前台运行
             * 含义：应用程序正常运行，不会被杀掉，但当前内存有点低，系统开始杀死其他进程后台应用程序
             */
            case TRIM_MEMORY_RUNNING_MODERATE:
                RecycleMap.getInstance().recycle(TRIM_MEMORY_RUNNING_MODERATE);
                break;
            /**
             * 内存不足级别：10
             * 状态：应用程序处于前台运行
             * 含义：应用程序正常运行，不会被杀掉，但当前内存非常低了，请必须释放你自身不必要的内存，否则会影响应用程序的性能（如相应速度等等）
             */
            case TRIM_MEMORY_RUNNING_LOW:
                RecycleMap.getInstance().recycle(TRIM_MEMORY_RUNNING_LOW);
                break;
            /**
             * 内存不足级别：15
             * 状态：应用程序处于前台运行
             * 含义：应用程序正常运行，但大部分后台程序已被杀死，请务必释放你自身不必要的内存，否则你也会被杀死
             */
            case TRIM_MEMORY_RUNNING_CRITICAL:
                RecycleMap.getInstance().recycle(TRIM_MEMORY_RUNNING_CRITICAL);
                break;
            /**
             * 内存不足级别：20
             * 状态：应用程序处于前台运行
             * 含义：系统内存已经非常低了，并将该应用从前台切换到后台，即回收UI资源
             */
            case TRIM_MEMORY_UI_HIDDEN:
                RecycleMap.getInstance().recycle(TRIM_MEMORY_UI_HIDDEN);
                break;
            /**
             * 内存不足级别：40
             * 状态：应用程序处于后台缓存
             * 含义：系统内存已经较低了，该应用程序处于LRU缓存列表的最近位置，但不会被清理掉。
             * 此时应该释放掉一些容易恢复的资源让手机内存变得充足，从而让程序更长时间的保留在缓存当中
             */
            case TRIM_MEMORY_BACKGROUND:
                RecycleMap.getInstance().recycle(TRIM_MEMORY_BACKGROUND);
                break;
            /**
             * 内存不足级别：60
             * 状态：应用程序处于后台缓存
             * 含义：系统内存已经非常低了，该应用程序处于LRU缓存列表的中间位置，若手机内存再得不到释放，该应用程序有被系统杀死的风险
             */
            case TRIM_MEMORY_MODERATE:
                RecycleMap.getInstance().recycle(TRIM_MEMORY_MODERATE);
                break;
            /**
             * 内存不足级别：80
             * 状态：应用程序处于后台缓存
             * 含义：系统内存严重不足，该应用程序已处于LRU缓存列表的最边缘位置，应用程序随时都有被回收的风险，此时应该把一切可以释放的资源都释放从而避免被杀死
             */
            case TRIM_MEMORY_COMPLETE:
                RecycleMap.getInstance().recycle(TRIM_MEMORY_COMPLETE);
                break;
            default:
                break;
        }
    }

    /**
     * 作用：监听 应用程序 配置信息的改变，如屏幕旋转等
     * 调用时刻：应用程序配置信息 改变时调用
     * <pre>
     *     <activity android:name=".MainActivity"
     *         android:configChanges="keyboardHidden|orientation|screenSize">
     *          //设置该配置属性会使 Activity在配置改变时不重启，只执行onConfigurationChanged（）
     *          //上述语句表明，设置该配置属性可使 Activity 在屏幕旋转时不重启
     *     </activity>
     * </pre>
     * @param newConfig 该配置信息是指 ：Manifest.xml文件下的 Activity标签属性android:configChanges的值
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }

    /**
     * 作用：监听 Android系统整体内存较低时刻
     * 调用时刻：Android系统整体内存较低时
     * 特别注意：OnTrimMemory（） & OnLowMemory（） 关系
     * 1.OnTrimMemory（）是 OnLowMemory（） Android 4.0后的替代 API
     * 2.OnLowMemory（） = OnTrimMemory（）中的TRIM_MEMORY_COMPLETE级别
     * 3.若想兼容Android 4.0前，请使用OnLowMemory（）；否则直接使用OnTrimMemory（）即可
     */
    @Override
    public void onLowMemory() {

    }

}
