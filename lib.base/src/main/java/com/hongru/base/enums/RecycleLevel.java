package com.hongru.base.enums;
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
 * @author 彭鸿儒
 * @date 2018/1/13
 * 邮箱:peng_hongru@163.com
 */
public enum RecycleLevel {

    /**
     * 内存回收级别：5
     */
    TRIM_MEMORY_RUNNING_MODERATE(5),
    /**
     * 内存回收级别：10
     */
    TRIM_MEMORY_RUNNING_LOW(10),
    /**
     * 内存回收级别：15
     */
    TRIM_MEMORY_RUNNING_CRITICAL(15),
    /**
     * 内存回收级别：20
     */
    TRIM_MEMORY_UI_HIDDEN(20),
    /**
     * 内存回收级别：40
     */
    TRIM_MEMORY_BACKGROUND(40),
    /**
     * 内存回收级别：60
     */
    TRIM_MEMORY_MODERATE(60),
    /**
     * 内存回收级别：80
     */
    TRIM_MEMORY_COMPLETE(80);


    private int level;

    public int getLevel() {
        return level;
    }


    RecycleLevel(int level) {
        this.level = level;
    }
}
