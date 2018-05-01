package com.hongru.base.utils

import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import com.hongru.base.ContextHolder
import com.hongru.base.rxPost


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
 * dp 与 px 转换
 */
fun dp2px(dpValue: Float): Int {
    val scale = ContextHolder.context()?.resources?.displayMetrics?.density?:return 0
    return (dpValue * scale + 0.5f).toInt()
}

fun px2dp(pxValue: Float): Int {
    val scale = ContextHolder.context()?.resources?.displayMetrics?.density?:return 0
    return (pxValue / scale + 0.5f).toInt()
}

/**
 * sp 与 px 转换
 */
fun sp2px(spValue: Float): Int {
    val fontScale = ContextHolder.context()?.resources?.displayMetrics?.scaledDensity ?: return 0
    return (spValue * fontScale + 0.5f).toInt()
}

fun px2sp(pxValue: Float): Int {
    val fontScale = ContextHolder.context()?.resources?.displayMetrics?.scaledDensity ?: return 0
    return (pxValue / fontScale + 0.5f).toInt()
}


fun applyDimension(value: Float, unit: Int): Float {
    val metrics = ContextHolder.context()?.resources?.displayMetrics ?: return 0f
    return when (unit) {
        TypedValue.COMPLEX_UNIT_PX -> return value
        TypedValue.COMPLEX_UNIT_DIP -> return value * metrics.density
        TypedValue.COMPLEX_UNIT_SP -> return value * metrics.scaledDensity
        TypedValue.COMPLEX_UNIT_PT -> return value * metrics.xdpi * (1.0f / 72)
        TypedValue.COMPLEX_UNIT_IN -> return value * metrics.xdpi
        TypedValue.COMPLEX_UNIT_MM -> return value * metrics.xdpi * (1.0f / 25.4f)
        else -> 0f
    }
}


fun forceGetViewSize(view: View, listener: onGetSizeListener?) {
    view.rxPost(Runnable { listener?.onGetSize(view) })
}

fun getMeasuredWidth(view: View): Int {
    return measureView(view)[0]
}


fun getMeasuredHeight(view: View): Int {
    return measureView(view)[1]
}


fun measureView(view: View): IntArray {
    var lp = view.layoutParams
    if (lp == null) {
        lp = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
    val widthSpec = ViewGroup.getChildMeasureSpec(0, 0, lp.width)
    val lpHeight = lp.height
    val heightSpec: Int
    heightSpec = if (lpHeight > 0) {
        View.MeasureSpec.makeMeasureSpec(lpHeight, View.MeasureSpec.EXACTLY)
    } else {
        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    }
    view.measure(widthSpec, heightSpec)
    return intArrayOf(view.measuredWidth, view.measuredHeight)
}


interface onGetSizeListener {
    fun onGetSize(view: View)
}


