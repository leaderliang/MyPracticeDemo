package com.java.practice.reflect;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/30 19:32
 */
public class Word implements Officeable {

    public String word = "language";

    @Override
    public void start() {
        System.out.println("Word ");
    }
}
