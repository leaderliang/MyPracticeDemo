package com.java.practice.thread;

/**
 * TODO
 * 控制多线程的执行顺序
 *
 * 这种方式的原理其实就是将线程用排队的方式扔进一个线程池里，让所有的任务以单线程的模式，按照FIFO先进先出、LIFO后进先出、优先级等特定顺序执行，
 * 但是这种方式也是存在缺点的，就是当一个线程被阻塞时，其它的线程都会受到影响被阻塞，不过依然都会按照自身调度来执行，只是会存在阻塞延迟。
 * ————————————————
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0.0
 * @since 2022/05/06 09:18
 */
public class ThreadOrder {

    static Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread01");
        }
    });

    static Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread02");
        }
    });

    static Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread03");
        }
    });

    static Thread thread4 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread04");
        }
    });

    static Thread thread5 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread05");
        }
    });

    public static void main(String[] args) throws InterruptedException {
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
        thread4.start();
        thread4.join();
        thread5.start();
        thread5.join();

    }
}
