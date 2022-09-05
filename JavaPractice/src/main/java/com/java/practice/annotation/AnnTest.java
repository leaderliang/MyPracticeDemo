package com.java.practice.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * TODO
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/09/05 16:34
 */
public class AnnTest {
    //1.使用加载器加载类
    public static void main(String[] args) {
        Class c;
        try {
            c = Class.forName("com.java.practice.annotation.User");
            //2.找到类上面的注解
            boolean isExit = c.isAnnotationPresent(Description.class);
            if (isExit) {
                //3.拿到注解实例
                Description d = (Description) c.getAnnotation(Description.class);
                System.out.println(d.desc());
            }
            //4.找到方法上的注解
            Method[] ms = c.getMethods();
            for (Method method : ms) {
                boolean isMExit = method.isAnnotationPresent(Description.class);
                if (isMExit) {
                    //3.拿到注解实例
                    Description d = (Description) c.getAnnotation(Description.class);
                    System.out.println(d.author());
                }
            }
            //另外的解析方法
            for (Method method : ms) {
                Annotation[] as = method.getAnnotations();
                for (Annotation a : as) {
                    if (a instanceof Description) {
                        Description d = (Description) a;
                        System.out.println(d.author());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }
}
