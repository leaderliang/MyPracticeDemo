package com.java.practice.test;

/**
 * TODO
 * <p>
 * Note:
 *  int num = (int) (Math.random() * n);            //返回大于等于0小于n之间的随机数
 *  int num0 = m + (int) (Matn.randon() * n);        //返回大于等于m小于m+n（不包括m+n）之间的随机数
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/11/12 17:44
 */
public class Random_ {


    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println((int) (Math.random() * 10 + 1));
        }
    }
}
