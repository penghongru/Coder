package com.hongru.base

import android.content.Context

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
 *
 */


/**
 * context 对象维护者
 */
object ContextHolder {

    var agent: ContextAgent? = null

    /**
     * 对外context对象
     */
    fun context(): Context? {
        return agent?.applyContext()
    }

    /**
     * 注册context代理人
     */
    fun applyContext(agent: ContextAgent) {
        this.agent = agent
    }


}

/**
 * context 对象代理人
 */
interface ContextAgent {

    /**
     * 提供context对象
     */
    fun applyContext(): Context?

}