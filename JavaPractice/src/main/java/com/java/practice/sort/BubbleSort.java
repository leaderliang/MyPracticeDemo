package com.java.practice.sort;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/11/28 14:26
 */
public class BubbleSort {

    //打印数组
    public static void printArr(int[] arr) {
        for (int temp : arr) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    //交换数组元素
    public static void swapArr(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {

                if(arr[j] > arr[j + 1]){
//                    swapArr(arr, j, j + 1);
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                System.out.println(" i= " + i + " j= " + j);
//                printArr(arr);
            }
            System.out.println(" i========== " + i);
            printArr(arr);
        }
    }


    //主方法
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1}; //数组初始化 6, 5, 3, 1, 8, 7, 2, 4
        System.out.print("原数组元素：");
        printArr(arr); //打印数组
        System.out.print("排序后数组元素：");
        System.out.println();
        bubbleSort(arr); //冒泡排序
        printArr(arr); //打印数组
    }


//    Object 类的方法,垃圾回收之前会调用此方法,子类可以重写finalize()方法实现对资源的回收；
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }


}
