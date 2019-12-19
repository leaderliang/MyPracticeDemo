package com.leaderliang.myapplication.test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/18 15:35
 */
public class AndroidTest {

    public static void main(String[] args) {
        testLinkedHashMap();

         
    }

    /**
     * 最近访问的最后输出
     * true 访问顺序
     * false 插入顺序
     */
    private static void testLinkedHashMap() {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(10, 0.75f, true);

        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 7);
        map.put(8, 8);
        map.put(9, 9);

        map.get(1);
        map.get(2);

        map.put(10, 10);

        System.out.println();

        Map.Entry<Integer, Integer> toEvict = map.entrySet().iterator().next();

        if (toEvict == null) {
            return;
        }

        map.remove(toEvict.getKey());



        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());

        }

//        System.out.println();
//
//        map.remove(0);
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }

    }


}
