package com.java.practice.data_structure;

/**
 * 递归数组求和
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/04 13:27
 */
public class Recursive {

    static int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        System.out.println(sum(num));
    }

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        return arr[index] + sum(arr, index + 1);
    }

}
