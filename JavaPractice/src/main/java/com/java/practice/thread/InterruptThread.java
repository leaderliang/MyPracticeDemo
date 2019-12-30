package com.java.practice.thread;

/**
 * TODO
 * <p>
 * 线程中断
 *
 *
 * interrupted() 静态方法，获取当前线程中断状态，并清空（第一次获取是 true，第二次就是 false）
 * isInterrupted() 非静态方法，简单的状态获取，不清空
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/30 11:30
 */
public class InterruptThread extends Thread {


    // step 1  系统原生支持
   /* @Override
    public void run() {
        super.run();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("-- " + "interrupted!" + " --");
        }
    }*/


    // step 2
    /*@Override
    public void run() {
        super.run();
        for (int i = 0; i < 10000; i++) {
            System.out.println("-- " + i + " --");
        }
    }*/


    // step 3
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10000; i++) {
//            if(interrupted()){
//                break;
//            }
            System.out.println("-- " + i + " --");
            if(interrupted()){// 返回 true 表示接收到中断，也可以不中断，看逻辑怎么写
                break;
            }
        }
    }
}
