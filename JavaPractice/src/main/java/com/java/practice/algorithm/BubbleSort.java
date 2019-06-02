package com.java.practice.algorithm;

/**
 * TODO 冒泡排序
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/06/02 20:32
 */
public class BubbleSort {

    /**
     * 冒泡排序 从小到大排序
     * int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        boolean isNeedExchange;
        for (int i = 0; i < arr.length - 1; i++) {
            isNeedExchange = false;
            int length = arr.length - i - 1;
            System.out.println("\n\n" + "length "+length );
            for (int j = 0; j < length; j++) {
                System.out.println("j="+j +"   arr[j]="+arr[j]+ "   arr[j + 1]="+arr[j + 1]);
                if (arr[j] > arr[j + 1]) {

                    swapArr(arr, j, j + 1);
                    isNeedExchange = true;
                    /*int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;*/
                }
            }
            // 优化，检测数组里面元素 监控一趟过程有没有进行数据交换
            if(!isNeedExchange){
                return;
            }
        }
    }

    /**
     * 从大到小
     * @param arr
     */
    private static void bubbleSort2(int[] arr) {
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

        /**
         * 交换数组元素
         *
         * @param arr
         * @param i
         * @param j
         */
    public static void swapArr(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(int[] arr) {
        for (int temp : arr) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        int[] arr = {8,1,2,3,4,5,6,7};
        System.out.print("原数组元素:");
        printArr(arr);
        System.out.print("排序后数组元素:");
        bubbleSort(arr);
        printArr(arr);
    }

}
