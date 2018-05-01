package com.hongru.basic_support

import android.annotation.SuppressLint
import android.os.Bundle
import com.hongru.base.view.BaseActivity
import com.yanzhenjie.sofia.Sofia
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

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


/**
 *@author 彭鸿儒
 * @date 2018/4/29
 * 邮箱:peng_hongru@163.com
 */
class SplashActivity : BaseActivity() {

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Sofia.with(this)
                .statusBarBackground(resources.getColor(R.color.colorPrimary))

        Observable.just("Hello")
                .delay(2, TimeUnit.SECONDS)
                .subscribe {
                    MainActivity.launcher(this@SplashActivity)
                    finish()
                }

    }

}