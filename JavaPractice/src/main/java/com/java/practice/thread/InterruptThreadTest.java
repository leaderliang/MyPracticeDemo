package com.java.practice.thread;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/30 11:34
 */
public class InterruptThreadTest {


    /**
     * step 1
     * @param args
     */
   /* public static void main(String[] args) {
        Thread thread = new InterruptThread();
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println( "InterruptThreadTest Exception " );
        }
        thread.interrupt();
    }*/



    /**
     * step 2 中断不好使，真实场景可能是在下载文件
     * @param args
     */
   /* public static void main(String[] args) {
        Thread thread = new InterruptThread();
        thread.start();

        thread.interrupt();
    }*/


    /**
     * step 3
     * @param args
     */
    public static void main(String[] args) {
        Thread thread = new InterruptThread();
        thread.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println( "InterruptThreadTest Exception " );
        }
        thread.interrupt();
    }
}
