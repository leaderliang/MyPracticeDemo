package com.java.designmodel.adapter.class_adapter;

/**
 * TODO
 *
 * 类适配器模式，通过使用  PowerAdapter 这个适配器，将 原来 220v 的电压转换成了笔记本需要使用的 12v 电压，保证笔记本可以正常的工作；
 *
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/03/19 12:08
 */
class TestClient {
    public static void main(String[] args) {
        NoteBook noteBook = new NoteBook();
        noteBook.usePowerOn(new PowerAdapter());

    }
}
