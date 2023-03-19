package com.java.practice.algorithm.search;

import java.util.Scanner;

/**
 * TODO 二分搜索算法
 * <p>
 * Note:
 * Scanner 下的next和nextLine方法区别
 * next() 读取数据时如果遇到 空格，tab,回车 就停止读取了，不读取符号
 * nextLine() 读取数据时如果遇到回车，才停止读取 读取回车符 并且丢掉回车符
 * 所有的输入都只在键入回车符的时候会停止
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/11/25 15:13
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 10, 11, 13, 15, 17, 19};
        System.out.println("当前数组数据为：");
        for (int i = 0; i < arr.length; i++){
            System.out.print( arr[i] + "\t");
        }
        System.out.println("\n请输入您想查找的数字，查询该数字在数组中的索引位置...");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String nextLine = scanner.nextLine();
//        System.out.println("next=" + next);
//        System.out.println("nextLine="+ nextLine);
        binarySearch(arr, Integer.parseInt(next));
    }

    private static void binarySearch(int[] arr, int target) {
        if (arr.length == 0) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        boolean isFounded = false;

        while (left <= right) {
            int middle = (left + right) / 2;
            int middleValue = arr[middle];
            if (target < middleValue) {
                right = middle - 1;
            } else if (target > middleValue) {
                left = middle + 1;
            } else {
                System.out.println("找到了 " + target + " 索引为：" + middle);
                isFounded = true;
                break;
            }
        }
        if (!isFounded) {
            System.out.println("未找到数字：" + target);
        }

    }


}
