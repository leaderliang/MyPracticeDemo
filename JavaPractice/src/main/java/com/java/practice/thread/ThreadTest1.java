package com.java.practice.thread;

/**
 * TODO
 *
 * yield 和 sleep 的异同
 *
 * 1）yield, sleep 都能暂停当前线程，sleep 可以指定具体休眠的时间，而 yield 则依赖 CPU 的时间片划分。
 * 2）yield, sleep 两个在暂停过程中，如已经持有锁，则都不会释放锁资源。
 * 3）yield 不能被中断，而 sleep 则可以接受中断。
 *
 * 总结：
 * 如果一定要用它的话，一句话解释就是：yield 方法可以很好的控制多线程，如执行某项复杂的任务时，如果担心占用资源过多，
 * 可以在完成某个重要的工作后使用 yield 方法让掉当前 CPU 的调度权，等下次获取到再继续执行，这样不但能完成自己的重要工作，
 * 也能给其他线程一些运行的机会，避免一个线程长时间占有 CPU 资源。
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0IntentService
 * @since 2020/06/22 11:19
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + "-----" + i);
                System.out.println("i % 20   "+i % 20);
                if (i % 20 == 0) {
                    Thread.yield();
                }
            }
        };

        new Thread(runnable, "-----栈长").start();
        new Thread(runnable, "小蜜").start();
    }
}
