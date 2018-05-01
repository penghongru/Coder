package com.hongru.base.utils

import android.content.Intent
import com.hongru.base.ContextHolder

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
 * @date 2018/4/14
 * 邮箱:peng_hongru@163.com
 */

/**
 * 判断某个界面是否存在
 */
fun isActivityExists(packageName: String, className: String): Boolean {
    val intent = Intent()
    intent.setClassName(packageName, className)
    return when {
        ContextHolder.context()?.packageManager?.resolveActivity(intent, 0) == null -> false
        intent.resolveActivity(ContextHolder.context()?.packageManager) == null -> false
        ContextHolder.context()?.packageManager?.queryIntentActivities(intent, 0)?.size == 0 -> false
        else -> true
    }
}