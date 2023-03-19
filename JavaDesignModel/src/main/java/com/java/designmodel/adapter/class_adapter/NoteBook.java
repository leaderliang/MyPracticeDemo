package com.java.designmodel.adapter.class_adapter;

/**
 * TODO
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/03/19 12:12
 */
class NoteBook {

    public void usePowerOn(Power12 power12){
        power12.getPower12v();
        System.out.println("笔记本使用 12v 电压，开始工作");
    }

}
