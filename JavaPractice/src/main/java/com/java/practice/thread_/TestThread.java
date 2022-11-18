package com.java.practice.thread_;

/**
 * TODO
 * <p>
 * Note:
 * 1. sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。在调用sleep()方法的过程中，线程不会释放对象锁。
 * <p>
 * 2. 调用wait()方法的时候，线程会放弃对象锁，进入等待此对象的等待锁定池，只有针对此对象调用notify()方法后本线程才进入对象锁定池准备
 * <p>
 * <p>
 * enter thread1...
 * thread1 is waiting...
 * <p>
 * <p>
 * enter thread2....
 * thread2 is sleep....
 * <p>
 * <p>
 * thread2 is going on....
 * thread2 is over!!!
 * thread1 is going on ....
 * thread1 is over!!!
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/11/06 23:23
 */
public class TestThread {
    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(new Thread2()).start();


    }


}
