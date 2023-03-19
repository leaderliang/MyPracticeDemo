package com.java.designmodel.adapter.object_adapter;

/**
 * TODO  对象适配器，需要继承原有的系统
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/03/19 12:15
 */
class PowerAdapter implements Power12 {
    Power220 mPower220;

    public PowerAdapter(Power220  power220) {
        this.mPower220 = power220;
    }

    @Override
    public void getPower12v() {
        mPower220.outputPower220();
        // 做 变压 操作
        transform();
        System.out.println("变压处理结束，输出 12v 电压");

    }

    private void transform() {
        System.out.println("进行 220v ->  12v 变压处理.....");
    }


}
