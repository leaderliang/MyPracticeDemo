package com.java.practice.thread_;

import java.util.Scanner;

/**
 * TODO
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/11/13 10:09
 */
public class PracticeThreadControl {
    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        a.setName("ThreadA");
        ThreadB b = new ThreadB(a);
        b.setName("ThreadB");
//        new Thread(a, "ThreadA").start();
//        new Thread(b, "ThreadB").start();
        a.start();
        b.start();
    }


   /* public static void main(String[] args) {        //程序运行的入口
        Scanner input=new Scanner(System.in);//键盘录入的入口，第2步
        //第3步，接收录入
        System.out.print("请输入姓名：");
        String name=input.next();//接收输入的下一个字符串
        System.out.print("请输入年龄：");
        int age=input.nextInt();//接收int
        System.out.print("请输入成绩：");
        double score=input.nextDouble();//接收double
        int i=1;
        while(input.hasNext()){
            System.out.println("第"+i+"个字符串"+input.next());
            i++;
        }

    }*/



}

class ThreadA extends Thread {


    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            System.out.println((int) (Math.random() * 100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ThreadA 退出了");

    }
}


class ThreadB extends Thread {

    private ThreadA a;
    private Scanner scanner = new Scanner(System.in);


    public ThreadB(ThreadA a) {
        this.a = a;
    }


    @Override
    public void run() {
        while (true) {
            System.out.println("请输入指令 Q 来退出当前两个线程");
            char input = scanner.next().toUpperCase().charAt(0);
            if (input == 'Q') {
                a.setLoop(false);
                break;
            }
        }
        System.out.println("ThreadB 退出了");

    }
}
