package com.hongru.base.vm;
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


import com.hongru.base.enums.RecycleLevel;
import com.hongru.base.interfaces.IRecycleSource;
import com.hongru.base.maps.RecycleMap;

/**
 * @author 彭鸿儒
 * @date 2018/1/13
 * 邮箱:peng_hongru@163.com
 */
public abstract class BaseViewModule implements IRecycleSource {


    protected BaseViewModule() {
        super();
        RecycleMap.getInstance().registerSource(this);
    }

    @Override
    public RecycleLevel getRecycleLevel() {
        return RecycleLevel.TRIM_MEMORY_RUNNING_MODERATE;
    }
}
