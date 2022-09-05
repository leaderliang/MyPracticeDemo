package com.java.practice.hashOrder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0.0
 * @since 2022/04/01 10:44
 */
public class HashsetOrder {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        System.out.println("hashset的输出：");
        for (int i = 0; i < 10; i++) {
            for (Integer integer : set) {
                System.out.print(integer);
            }
            System.out.println();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        System.out.println("hashmap的输出：");
        for (int i = 0; i < 10; i++) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.print(entry.getValue());
            }
            System.out.println();
        }
    }
}
