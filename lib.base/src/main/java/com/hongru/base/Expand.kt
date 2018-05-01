package com.hongru.base

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hongru.base.utils.forceGetViewSize
import com.hongru.base.utils.onGetSizeListener
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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
 * View 拓展
 */
fun View.rxPost(runnable: Runnable) {
    Observable.just(runnable)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Runnable::run)
}

/**
 * ImageView拓展
 */

fun ImageView.loadUrl(url: String) {
    forceGetViewSize(this, object : onGetSizeListener {
        override fun onGetSize(view: View) {
            val options = RequestOptions()
                    .override(view.measuredWidth, view.measuredHeight)
                    .error(R.drawable.ic_load_error)
                    .placeholder(R.drawable.ic_loading)
                    .centerCrop()
            Glide.with(view)
                    .load(url)
                    .apply(options)
                    .into(view as ImageView)
        }
    })
}
