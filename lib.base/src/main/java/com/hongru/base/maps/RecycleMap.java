package com.hongru.base.maps;
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


import com.hongru.base.interfaces.IRecycleSource;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author 彭鸿儒
 * @date 2018/1/13
 * 邮箱:peng_hongru@163.com
 */
public class RecycleMap {

    private static volatile RecycleMap map;

    private RecycleMap() {

    }

    public static RecycleMap getInstance() {
        if (map == null) {
            synchronized (RecycleMap.class) {
                if (map == null) {
                    map = new RecycleMap();
                }
            }
        }
        return map;
    }

    private HashSet<IRecycleSource> sources = new HashSet<>();

    public void registerSource(IRecycleSource source) {
        sources.add(source);
    }

    public void recycle(int level) {
        Iterator<IRecycleSource> iterator = sources.iterator();
        while (iterator.hasNext()) {
            IRecycleSource source = iterator.next();
            if (level == source.getRecycleLevel().getLevel()) {
                iterator.remove();
                source.onRecycle();
            }
        }
    }


}
