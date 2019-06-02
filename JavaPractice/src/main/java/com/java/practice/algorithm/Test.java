package com.java.practice.algorithm;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/06/02 20:32
 */
class Test {


    public static void main(String[] args) {
//        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        int[] arr = {8,1,2,3,4,5,6,7};
        System.out.print("原数组元素:");
        printArr(arr);
        System.out.print("排序后数组元素:");
        bubbleSort(arr);
        printArr(arr);
    }

    private static void bubbleSort(int[] arr) {
        if (arr.length <= 0) {
            return;
        }
        int arrLength = arr.length - 1;
        boolean isNeedExchange;
        for (int i = 0; i < arrLength; i++) {
            isNeedExchange = false;
            System.out.println("\n\n" + "length "+ (arrLength - i) );
            for (int j = 0; j < arrLength - i; j++) {
                System.out.println("j="+j +"   arr[j]="+arr[j]+ "   arr[j + 1]="+arr[j + 1]);
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
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