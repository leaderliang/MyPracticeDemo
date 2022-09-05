package com.java.practice.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 本类用于反射的测试
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/08/26 14:36
 */
public class TestReflect {


    //1.可以创建程序的入口函数main()--此处不用
    //2.通过单元测试方法，获取目标类Student对应的字节码对象
    @Test
    public void getClazz() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        //练习获取字节码对象的3种方式
//        Class<?> clazz1 = Class.forName("com.java.practice.reflection.Student");
//        Class<?> clazz2 = Student.class;
//        Class<?> clazz3 = new Student().getClass();
//
//        //打印的是Student类对应的字节码对象
//        System.out.println(clazz1);//class com.reflection.Student
//        //获取Student类对应的字节码对象clazz1的名字
//        System.out.println(clazz1.getName());//com.reflection.Student
//        //通过Student类对应的字节码对象，获取Student类的类名
//        System.out.println(clazz1.getSimpleName());
//        //通过Student类对应的字节码对象，获取Student类对应的包对象
//        System.out.println(clazz1.getPackage());
//        //通过Student类对应的字节码对象，先获取Student类对应的包对象，再获取这个包对象的名字
//        System.out.println(clazz1.getPackage().getName());



        Class<?> clazz1 = Class.forName("com.java.practice.reflection.Student");
        //反射调用成员方法
        Method m = clazz1.getDeclaredMethod("testInvoke",String.class);
        //使私有方法允许被调用
        m.setAccessible(true);
        Student student = new Student();
        //让指定实例来执行该方法
        m.invoke(student,"liangyanqiao");

    }


    //3.通过单元测试方法练习引用类型数组的定义与遍历
    @Test
    public void getStu() {
        //1.创建Student类的3个对象
        Student s1 = new Student("张三", 3);
        Student s2 = new Student("李四", 4);
        Student s3 = new Student("王五", 5);
        //2.创建数组将刚刚的3个对象存入数组中
        Student[] s = {s1, s2, s3};
        //3.直接打印数组，查看数组中的元素
        System.out.println(Arrays.toString(s));
        //4.遍历学生数组，拿到每一个学生对象，做进一步的操作
        for (Student stu : s) {
            //System.out.println(stu);
            stu.play();//通过遍历到的对象，执行play()
            System.out.println(stu.age);//通过遍历到的对象，打印age属性
        }
    }

    //4.通过单元测试方法，获取Student类中的成员变量
    @Test
    public void getFie() throws ClassNotFoundException {
        //1.获取Student类对应的字节码对象
        Class<?> clazz = Class.forName("com.java.practice.reflection.Student");
        //2.通过Student类对应的字节码对象获取Student类中的成员变量们
        Field[] fs = clazz.getFields();
        //3.遍历数组，获取Student类中的每个成员变量的具体信息
        /*注意！目前成员变量的修饰符必须是public的才能获取到*/
        for (Field f : fs) {
            System.out.println(f.getName());//通过本轮循环到的字段对象获取字段名
            System.out.println(f.getType());//通过本轮循环到的字段对象获取字段的类型
        }

    }


    //5.通过单元测试方法，获取Student类中的成员方法
    @Test
    public void getFunction() throws ClassNotFoundException {
        //1.获取Student类对应的字节码对象
        Class<?> clazz = Class.forName("com.java.practice.reflection.Student");
        //2.通过Student类对应的字节码对象获取Student类中的成员方法们
        Method[] ms = clazz.getMethods();
        //3.通过高效for循环遍历数组，拿到每一个方法对象
        for (Method m : ms) {
            System.out.println(m);//直接打印遍历到的方法对象
            System.out.println(m.getName());//通过方法对象获取方法名
            Class<?>[] pt = m.getParameterTypes();//通过方法对象获取方法所有参数的数组
            System.out.println(Arrays.toString(pt));//打印方法参数的数组
        }

    }


    //6.通过单元测试方法，获取Student类中的构造方法
    @Test
    public void getCons() throws ClassNotFoundException {
        //1.获取字节码对象
        Class<?> clazz = Class.forName("com.java.practice.reflection.Student");
        //2.通过字节码对象获取目标类Student的构造方法们
        Constructor<?>[] cs = clazz.getConstructors();
        //3.通过高效for循环遍历数组
        for (Constructor c : cs) {
            System.out.println(c.getName());//打印本轮遍历到的构造方法的名字
            Class[] pt = c.getParameterTypes();//通过本轮遍历到的构造函数对象获取构造函数的参数类型
            System.out.println(Arrays.toString(pt));//打印参数类型
        }
    }


    //7.通过单元测试方法，创建Student目标类的对象
    @Test
    public void getObject() throws Exception {
        //1.获取字节码对象
        Class<?> clazz = Class.forName("com.java.practice.reflection.Student");

        //2.通过反射技术创建目标类的对象,注意抛出异常
        /*反射创建对象方案1：
            使用 目标类 的 无参构造 创建对象
        */
        Object o = clazz.newInstance();
        System.out.println(o);//这一步已经获取到了对象Student{name='null', age=0}

        /*反射创建对象方案2：
            使用 目标类 的 全参构造 创建对象
        * 思路：
        * 1.先获取指定的构造函数对象,注意需要指定构造函数的参数，传入的是.class字节码对象
        * 2.通过刚刚获取到的构造函数对象创建Student目标类的对象，并且给对象的属性赋值
        * */

        //3.获取目标类中指定的全参构造
        Constructor<?> c = clazz.getConstructor(String.class, int.class);
        //System.out.println(c);

        //4.通过获取到的构造函数：创建对象 + 给对象的属性赋值
        Object o2 = c.newInstance("赵六", 6);
        System.out.println(o2);
    }


}
