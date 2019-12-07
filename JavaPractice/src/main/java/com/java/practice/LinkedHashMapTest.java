package com.java.practice;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/06/06 14:21
 */
public class LinkedHashMapTest {

    public static void main(String[] args) throws InterruptedException {

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap(0, 0.75f, true);
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.get(1);
        map.get(2);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Thread.sleep(1000);
            System.out.println(entry.getKey() + ":" + entry.getValue());

        }
    }


}
