package com.java.practice.reflect;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/29 10:38
 */
public class Test {
    static int b = 2;
    public static void main(String[] args) {
         new Thread(){
             int c = b;
             @Override
             public void run() {
                 super.run();
             }
         };
    }
}
