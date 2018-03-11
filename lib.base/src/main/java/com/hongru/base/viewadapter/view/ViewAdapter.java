package com.hongru.base.viewadapter.view;
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


import android.databinding.BindingAdapter;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.hongru.base.command.BindCommand;
import com.hongru.base.enums.LogTag;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;

/**
 * @author 彭鸿儒
 * @date 2018/1/15
 * 邮箱:peng_hongru@163.com
 */
public class ViewAdapter {


    /**
     * 防重复点击间隔(秒)
     */
    public static final int CLICK_INTERVAL = 1;

    /**
     *  requireAll 是意思是是否需要绑定全部参数, false为否
     * @param view 绑定的view
     * @param clickCommand 绑定的命令
     * @param isThrottleFirst 是否去抖
     */
    @BindingAdapter(value = {"onClickCommand", "isThrottleFirst"}, requireAll = false)
    public static void onClickCommand(View view, final BindCommand clickCommand, final boolean isThrottleFirst) {
        if (isThrottleFirst) {
            RxView.clicks(view)
                    .subscribe(new Consumer<Object>() {
                        @Override
                        public void accept(Object o) throws Exception {
                            if (clickCommand != null) {
                                clickCommand.execute();
                            }
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            LogUtils.eTag(LogTag.CLICK.getDesc(),throwable);
                        }
                    });

        } else {
            RxView.clicks(view)
                    .throttleFirst(CLICK_INTERVAL, TimeUnit.SECONDS)
                    .subscribe(new Consumer<Object>() {
                        @Override
                        public void accept(Object o) throws Exception {
                            if (clickCommand != null) {
                                clickCommand.execute();
                            }
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            LogUtils.eTag(LogTag.CLICK.getDesc(),throwable);
                        }
                    });

        }
    }




}
