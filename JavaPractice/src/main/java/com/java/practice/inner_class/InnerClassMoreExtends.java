package com.java.practice.inner_class;

/**
 * TODO
 * 定义两个内部类，他们分别继承父亲Father类、母亲类Mother类，且都可以非常获取各自父类的行为，这是内部类一个重要的特性：
 * 内部类可以继承一个与外部类无关的类，保证了内部类的独立性，正是基于这一点，多重继承才会成为可能。
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2020/06/01 15:11
 */
public class InnerClassMoreExtends {


    class Father {
        public int str() {
            return 2;
        }
    }

    class Mother {
        public int can() {
            return 2;
        }
    }

    class Son {
        class Father_1 extends Father {
            @Override
            public int str() {
                return super.str() + 1;
            }
        }

        class Mother_1 extends Mother {
            @Override
            public int can() {
                return super.can() - 2;
            }
        }

        public int get() {
            return new Father_1().str();
        }

        public int getcan() {
            return new Mother_1().can();
        }
    }


    public class Outer {


//        public static void main(String[] args) {
//            Son son = new Son();
//            System.out.println(son.get());
//            System.out.println(son.getcan());
//        }


    }


}
