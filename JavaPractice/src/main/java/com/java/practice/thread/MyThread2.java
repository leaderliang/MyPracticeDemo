package com.java.practice.thread;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/24 14:59
 */
public class MyThread2 implements Runnable {

    ThreadDemo threadDemo;

    public MyThread2(ThreadDemo threadDemo) {
        this.threadDemo = threadDemo;
    }

    @Override
    public void run() {
        threadDemo.demo2();
    }
}
