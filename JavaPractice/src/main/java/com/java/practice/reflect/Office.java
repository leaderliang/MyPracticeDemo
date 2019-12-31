package com.java.practice.reflect;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/30 19:33
 */
public class Office {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        String str = "Word";
        if (("Word").equals(str)) {
            Class c1 = Class.forName("com.java.practice.reflect.Word");
            Officeable e = (Officeable) c1.newInstance();
        }


    }
}
