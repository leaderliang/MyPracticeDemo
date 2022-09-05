package com.java.practice.array;

/**
 * 二维数组的遍历，同一维数组一样，区别就是，我们首先在外循环，遍历每一个一维数组，内循环中的 I 就是每一个一维数组的内存伪地址
 *
 * for(int i=0; i<二维数组名.length; i++){
 *     for(int j=0; j<二维数组名[i].length; j++){
 *         System.out.print(二维数组名[i][j]);
 *     }
 *     System.out.println();
 * }
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/09/05 15:35
 */
public class Test {
    public static void main(String[] args) {
        //静态初始化
        int[][] a1 = {{1, 2, 3, 4}, {4, 5, 6, 7}, {8, 9, 10, 11}};
        //动态初始化
        String[][] b = new String[10][10];
        b[0] = new String[]{"zahngsan", "lisi", "wangwu"};
        b[1] = new String[]{"java", "python", "c++"};
        b[2] = new String[]{"java", "python", "c++","c++","c++"};
        System.out.println(b[0].length);
        System.out.println(b[2].length);


        //静态初始化
        int[][] a = {{1, 2, 3, 4}, {4, 5, 6, 7}, {8, 9, 10, 11}};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }
}
