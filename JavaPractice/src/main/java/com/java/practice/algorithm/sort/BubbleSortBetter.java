package com.java.practice.algorithm.sort;


/**
 * TODO
 * <p>
 * Note: 冒泡排序
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/11/23 13:45
 */
public class BubbleSortBetter {
    public static void main(String[] args) {
        int[] arr = {300, -100, 234, 67, 5, 998, 1, 345};
        int[] arr1 = {9,1,2,3,4,5,6,7,8};
//        bubbleSort(arr);
        bubbleSort1(arr1);
    }


    /**
     * 从小到大排列
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr.length <= 0) {
            throw new NullPointerException("arr is null");
        }
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 大的数字，右移
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("\n第" + i + "轮");
            for (int j = 0; j < length; j++) {
                System.out.print(arr[j] + "\t");
            }
        }
    }

    /**
     * 优化，检测数组里面元素 监控一趟过程有没有进行数据交换
     * @param arr
     */
    public static void bubbleSort1(int[] arr) {
        if (arr.length <= 0) {
            throw new NullPointerException("arr is null");
        }
        int length = arr.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            boolean tag = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 大的数字，右移
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    tag = true;
                }
            }
            System.out.println("\n第" + i + "轮");
            if (!tag) {
                System.out.println("i=" + i);
                return;
            }
            for (int j = 0; j < length; j++) {
                System.out.print(arr[j] + "\t");
            }
        }
    }
}
