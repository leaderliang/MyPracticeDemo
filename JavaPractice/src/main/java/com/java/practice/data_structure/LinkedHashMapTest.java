package com.java.practice.data_structure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * TODO LinkedHashMap
 *
 * LruCache 中将 LinkedHashMap 的顺序设置为 LRU 顺序来实现 LRU 缓存，每次调用 get（也就是从内存中取图片），则将该对象移 到 链表尾端。
 *
 * 调用 put 插入新的对象也是存储在链表尾端，这样当内存 缓存达到设定的最大值时，将链表头部的对象（近期最少用到的）移除
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/06/06 14:21
 */
public class LinkedHashMapTest {

    public static void main(String[] args) throws InterruptedException {

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap(0, 0.75f, true);
        // head
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        // tail
        map.get(1);
        map.get(2);

        // 调用 put 插入新的对象也是存储在链表尾端
        map.put(7, 7);
        map.put(8, 8);

        // tail

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Thread.sleep(1000);
            System.out.println(entry.getKey() + ":" + entry.getValue());

        }
    }


}
