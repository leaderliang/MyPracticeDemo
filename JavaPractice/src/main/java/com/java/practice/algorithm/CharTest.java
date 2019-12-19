package com.java.practice.algorithm;

import java.util.LinkedHashMap;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/10 18:08
 */
public class CharTest {


    public static String sort(String s) {

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String a = String.valueOf(s.charAt(i));
            if (linkedHashMap.containsKey(a)) {
                linkedHashMap.put(a, linkedHashMap.get(a) + 1);
            } else {
                linkedHashMap.put(a, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String entry : linkedHashMap.keySet()) {
            sb.append(entry);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "DDDDDADDBDACCCC";
        System.out.println(sort(str));
    }
}
