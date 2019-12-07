package com.java.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/11/26 18:43
 */
public class CollectionTest {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("s1");
        arrayList.add("s3");
        arrayList.add("s4");
        arrayList.add("s5");
        arrayList.add("s2");
        System.out.println("ArrayList:==========================");
        for (String arrList : arrayList) {
            System.out.println(arrList);
        }
        List<String> linkedList = new LinkedList<>();
        linkedList.add("s1");
        linkedList.add("s3");
        linkedList.add("s4");
        linkedList.add("s5");
        linkedList.add("s2");
        System.out.println("LinkedList:===========================");
        for (String linkList : linkedList) {
            System.out.println(linkList);
        }

        Set<String> hashSet = new HashSet<>();
        hashSet.add("s1");
        hashSet.add("s3");
        hashSet.add("s4");
        hashSet.add("s5");
        hashSet.add("s2");
        System.out.println("HashSet:==============================");
        for (String hashst : hashSet) {
            System.out.println(hashst);
        }

        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("s1");
        linkedHashSet.add("s3");
        linkedHashSet.add("s4");
        linkedHashSet.add("s5");
        linkedHashSet.add("s2");
        System.out.println("LinkedHashSet:=========================");
        for (String linkedst : linkedHashSet) {
            System.out.println(linkedst);
        }

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("s1");
        treeSet.add("s3");
        treeSet.add("s4");
        treeSet.add("s5");
        treeSet.add("s2");
        System.out.println("TreeSet:============================== 根据元素的自然顺序排列");
        for (String treest : treeSet) {
            System.out.println(treest);
        }
    }
}
