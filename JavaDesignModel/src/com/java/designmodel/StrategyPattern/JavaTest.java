package com.java.designmodel.StrategyPattern;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liangyanqiao
 */
public class JavaTest {

    public static void main(String[] args) {

        /**
         * 其中accessOrder设置为true则为访问顺序
         * 为false，则为插入顺序
         */
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(0, 0.75f, true);
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.get(1);
        map.get(2);

        /*最近访问的最后输出，那么这就正好满足的LRU缓存算法的思想*/
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }
}
