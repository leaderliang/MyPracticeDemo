package com.java.practice.algorithm.sort;

/**
 * 选择排序
 *
 * 选择排序(Selection sort)是一种简单直观的排序算法。
 * 其基本思想是：首先在未排序的数列中找到最小(or最大)元素，
 * 然后将其存放到数列的起始位置；接着，再从剩余未排序的元素中继续寻找最小(or最大)元素，
 * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 *
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/06/02 20:32
 */
class SelectionSort {


    public static void main(String[] args) {
//        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        int[] arr = {8, 1, 2, 3, 4, 5, 6, 7};

        System.out.print("原数组元素:");
        printArr(arr);
        System.out.print("排序后数组元素:");
//        bubbleSort(arr);
//        selectionSort(arr);
        selectionSort2(arr);
        printArr(arr);
    }

    /**
     * 选择排序 从小到大排序
     *
     * @param arr
     */
    private static void selectionSort(int[] arr) {
        if (arr.length <= 0) {
            return;
        }
        int arrLength = arr.length;
        for (int i = 0; i < arrLength - 1; i++) {
            int minValues = i;
            for (int j = i + 1; j < arrLength; j++) {
                if (arr[minValues] > arr[j]) {
                    //比较 minValues 和 j 对应的值大小，把小的值付给 minValues
                    minValues = j;
                }
            }
            if (minValues != i) {
                int temp = arr[minValues];
                arr[minValues] = arr[i];
                arr[i] = temp;
            }
        }

    }


    /**
     * 选择排序，由大到小
     *
     * @param arr
     */
    private static void selectionSort2(int[] arr) {
        if (arr.length <= 0) {
            return;
        }
        int arrLength = arr.length;
        for (int i = 0; i < arrLength - 1; i++) {
            int maxValues = i;
            for (int j = i + 1; j < arrLength; j++) {
                if (arr[maxValues] < arr[j]) {
                    maxValues = j;
                }
            }
            if (maxValues != i) {
                int temp = arr[i];
                arr[i] = arr[maxValues];
                arr[maxValues] = temp;
            }
        }

    }


    private static void bubbleSort(int[] arr) {
        if (arr.length <= 0) {
            return;
        }
        int arrLength = arr.length - 1;
        boolean isNeedExchange;
        for (int i = 0; i < arrLength; i++) {
            isNeedExchange = false;
            System.out.println("\n\n" + "length " + (arrLength - i));
            for (int j = 0; j < arrLength - i; j++) {
                System.out.println("j=" + j + "   arr[j]=" + arr[j] + "   arr[j + 1]=" + arr[j + 1]);
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isNeedExchange = true;
                }
            }
            if (!isNeedExchange) {
                return;
            }

        }

    }

    private static void printArr(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }


}