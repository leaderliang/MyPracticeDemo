package com.android.hencoder;

import android.util.SparseArray;

/**
 * TODO
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/11/15 08:41
 */
public class SparseArray_ {
    public static void main(String[] args) {
        SparseArray map = new SparseArray();
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);


        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.get(i));
        }
    }
}
