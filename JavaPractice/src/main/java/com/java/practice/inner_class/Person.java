package com.java.practice.inner_class;

/**
 * 普通内部类持有外部类引用的原理
 *
 * 内部类虽然和外部类写在同一个文件中， 但是编译完成后， 还是生成各自的class文件，内部类通过this访问外部类的成员。
 *
 * 1、编译器自动为内部类添加一个成员变量， 这个成员变量的类型和外部类的类型相同， 这个成员变量就是指向外部类对象(this)的引用；
 *
 * 2、编译器自动为内部类的构造方法添加一个参数， 参数的类型是外部类的类型， 在构造方法内部使用这个参数为内部类中添加的成员变量赋值；
 *
 * 3、在调用内部类的构造函数初始化内部类对象时，会默认传入外部类的引用。
 *
 * 静态内部类的不会持有外部类的引用。
 *
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/02 11:16
 */
public class Person {

    public class Man{
        private String name;
        private String getName(String str){
            this.name = str;
            return name;
        }

    }

    public class Woman{
        private String name;

        private Woman(String str) {
            this.name = str;
        }

        String readWomanName(){
            return name;
        }
    }

    public static class Other{
        private String name;

        public Other(String name) {
            this.name = name;
        }
    }

    public void doSomeThing(){
        Man man = new Man();
        Woman woman = new Woman("Lina");
        Other other = new Other("kevin");

        System.out.println(woman.readWomanName());
    }

    public static void main(String[] args) {
//        Person p = new Person();
//        p.doSomeThing();

        takeSurplus();
    }


    /**
     * 求余操作
     *
     * 再来一个一个分析：
     * a = 13 / 5，a = 2，其实就是数学上的13 / 5 ，结果为2。
     * b = 13 % 5，b = 3，这也是数学上的运算，得出余数为3。
     * c = 5 / 13，c = 0，因为被除数小于除数，结果可以看成0.x，但是int类型是整数类型，所以结果只为0。
     * d = 5 % 13，d = 5，数学上规定：如果被除数比除数小,商是0,余数就是被除数本身。
     * e和f不用说了，结果都为-2。
     * 但是h和j怎么是一个-3一个3呢，因为取余运算的符号是根据第一个运算数决定的，-13 % 5结果是-3，而13 % -5结果则是3。
     *
     *
     */
     public static void takeSurplus(){
        int a = 13 / 5;
        int b = 13 % 5;
        int c = 5 / 13;
        int d = 5 % 13;
        int e = 13 / -5;
        int f = -13 / 5;
        int h = -13 % 5;
        int j = 13 % -5;
        System.out.println(a + "，" + b);
        System.out.println(c + "，" + d);
        System.out.println(e + "，" + f);
        System.out.println(h + "，" + j);
    }


}
