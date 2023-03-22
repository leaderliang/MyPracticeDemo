package com.java.designmodel.extends_;



/**
 * TODO
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/03/22 11:27
 */
class BlackPrinter extends Printer {

    @Override
    public void print() {

    }

    @Override
    public void needPaper() {
        System.out.println("我不需要纸");
    }
}
