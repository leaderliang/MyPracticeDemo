package com.java.designmodel.adapter.class_adapter;

/**
 * TODO  类适配器，需要继承原有的系统，同时实现新的接口  功能
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/03/19 12:15
 */
class PowerAdapter extends Power220 implements Power12{
    @Override
    public void getPower12v() {
        // 获取原有的电压
        super.outputPower220();
        // 做 变压 操作
        transform();

        System.out.println("变压处理后，输出 12v 电压");

    }

    private void transform() {
        System.out.println("进行变压处理.....");
    }


}
