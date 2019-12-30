package com.java.practice.thread;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/24 15:00
 */
public class ThreadMain {
   private int lala = 3;

    Object method(){
        int localVariable = 0;
        class Inner{
            void println(){
                System.out.println("localVariable " + localVariable);
            }
        }
        Object in = new Inner();
        return in;
    }



    public static void main(String[] args) {


//        ThreadDemo demo1 = new ThreadDemo();
//        ThreadDemo demo2 = new ThreadDemo();
//        Thread thread2 = new Thread(new MyThread2(demo1), "thread2--->");
//        Thread thread1 = new Thread(new MyThread1(demo1), "thread1");
//        thread2.start();
//        thread1.start();

        ThreadMain out = new ThreadMain();
        Object obj = out.method();
    }


}
