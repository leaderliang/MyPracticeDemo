package com.java.practice.chain;

/**
 * TODO 链式写法
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/04/11 19:56
 */
public class Apple {

    private double height;
    private String color;
    private boolean flag;

    public double getHeight() {
        return height;
    }

    public Apple setHeight(double height) {
        this.height = height;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Apple setColor(String color) {
        this.color = color;
        return this;
    }

    public boolean isFlag() {
        return flag;
    }

    public Apple setFlag(boolean flag) {
        this.flag = flag;
        return this;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "height=" + height +
                ", color='" + color + '\'' +
                ", flag=" + flag +
                '}';
    }
}