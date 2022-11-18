package com.java.practice.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/11/12 08:26
 */
@SuppressWarnings("all")
public class MapFor {
    public static void main(String[] args) {
        collectionsTest();

        /*Map map = new HashMap();
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("孙喆", "马蓉");
        map.put(null, "孙俪");
        map.put("阿拉蕾", null);


        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next.getClass());
            Map.Entry entry = (Map.Entry)next;
            System.out.println(entry.getKey() + ":" + entry.getValue());

//            HashMap.Node entry = (HashMap.Node) next;
//            System.out.println(entry.getKey() + ":" + entry.getValue());

//            Test.TestClass t = new Test.TestClass();
        }*/



    }

    /**
     * 返回自然顺序最大值
     */
    static void collectionsTest(){
        List list = new ArrayList();
        list.add("liang");
        list.add("li");
        list.add("bai");
        list.add("tom");
        list.add("king");
        list.add("smith");
        list.add("milan");
        list.add("zhang");


        System.out.println("自然顺序最大元素=" + Collections.max(list));
    }
}
