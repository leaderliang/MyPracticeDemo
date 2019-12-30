package com.java.practice.thread;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/24 14:57
 */
public class ThreadDemo {

    private Object lock1 = new Object();
   private Object lock2 = new Object();

    public void demo1() {
        synchronized (lock1) {
            while (true) {  //死循环目的是为了让线程一直持有该锁
                System.out.println(Thread.currentThread());
            }
        }
    }

    public void demo2() {
        synchronized (lock2) {
            while (true) {
                System.out.println(Thread.currentThread());
            }
        }
    }
}
