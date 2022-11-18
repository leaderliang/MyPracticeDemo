package com.java.practice.thread_;

/**
 * TODO
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/11/06 23:25
 */
class Thread2 implements Runnable {
    @Override
    public void run() {
        synchronized (TestThread.class) {
            System.out.println("enter thread2....");
            System.out.println("thread2 is sleep....");
            //只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
            TestThread.class.notify();
            //==================
            //区别
            //如果我们把代码：TestD.class.notify();给注释掉，即TestD.class调用了wait()方法，但是没有调用notify()
            //方法，则线程永远处于挂起状态。
            try {
                //sleep()方法导致了程序暂停执行指定的时间，让出cpu 该其他线程，
                //但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
                //在调用sleep()方法的过程中，线程不会释放对象锁。
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("thread2 is going on....");
            System.out.println("thread2 is over!!!");
        }
    }
}
