package com.hongru.coder;
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


import com.blankj.utilcode.util.LogUtils;
import com.hongru.base.command.BindCommand;
import com.hongru.base.vm.BaseViewModule;

import io.reactivex.functions.Action;

/**
 * @author 彭鸿儒
 * @date 2018/1/15
 * 邮箱:peng_hongru@163.com
 */
public class SplashViewModule extends BaseViewModule {

    public BindCommand clickCommand = BindCommand.create(new Action() {
        @Override
        public void run() throws Exception {
            LogUtils.d("按钮被点击");
        }
    });




    @Override
    public void onRecycle() {

    }
}
