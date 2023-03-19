package com.java.designmodel.adapter.object_adapter;

/**
 * TODO
 *
 * 对象适配器模式，使用  PowerAdapter 这个适配器，通过组合的方式，将 原来的 需要适配的 220v 电压，放到 适配器中，然后进行对应的调用，对外暴露新的，我们的目标接口 Power12
 * 将 原来 220v 的电压转换成了笔记本需要使用的 12v 电压，保证笔记本可以正常的工作；
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
        PowerAdapter powerAdapter = new PowerAdapter(new Power220());
        noteBook.usePowerOn(powerAdapter);

    }
}
