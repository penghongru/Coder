package com.hongru.base.command;
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
import com.hongru.base.enums.LogTag;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * @author 彭鸿儒
 * @date 2018/1/14
 * 邮箱:peng_hongru@163.com
 */
public class BindCommand<T> {

    private Action action;
    private Consumer<T> actionWithType;


    private BindCommand() {

    }

    public static BindCommand create(Action action) {
        BindCommand command = new BindCommand();
        command.action = action;
        return command;
    }


    public void execute() {
        try {
            action.run();
        } catch (Exception e) {
            LogUtils.eTag(LogTag.COMMAND.getDesc(),e);

        }
    }
}
