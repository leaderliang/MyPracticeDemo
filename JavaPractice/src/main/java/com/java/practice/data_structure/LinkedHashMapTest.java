package com.java.practice.data_structure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * 我们的每次 put 或者get都可以看做一次访问，由于 LinkedHashMap 的特性，会将每次访问到的元素放置到尾部。
 *
 * TODO LinkedHashMap
 *
 * LruCache 中将 LinkedHashMap 的顺序设置为 LRU 顺序来实现 LRU 缓存，每次调用 get（也就是从内存中取图片），则将该对象移 到 链表尾端。
 *
 * 调用 put 插入新的对象也是存储在链表尾端，这样当内存 缓存达到设定的最大值时，将链表头部的对象（近期最少用到的）移除
 *
 *
 * jdk1.8 所以打印出来是尾插法，你们可以用下 jdk1.7 就是头插法了！！！
 * jdk1.8 所以打印出来是尾插法，你们可以用下 jdk1.7 就是头插法了！！！
 * jdk1.8 所以打印出来是尾插法，你们可以用下 jdk1.7 就是头插法了！！！
 *
 * 最近访问的最后输出，那么这就正好满足的 LRU 缓存算法的思想
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/06/06 14:21
 */
public class LinkedHashMapTest {

    public static void main(String[] args) throws InterruptedException {


        /**
         * 其中accessOrder设置为 true 则为访问顺序
         * 为false，则为插入顺序
         */
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
//            Thread.sleep(1000);
            System.out.println(entry.getKey() + ":" + entry.getValue());

        }


    }


}
