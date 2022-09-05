package com.java.practice.annotation;

/**
 * TODO
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/09/05 16:28
 */

@Description(desc = "is parent interface class", author = "devliang")
public class Person {
    @Description(desc = "is parent interface method", author = "devliang")
    public String name() {
        return "";
    }

    public int age() {
        return 29;
    }
}

