package com.java.practice;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Test extends Male {

    public Test(String name) {
        super(name);
    }


    /**
     * 任何子类必须重写父类的抽象方法，或者声明自身为抽象类。
     *
     * @return double
     */
    @Override
    public double coding() {
        return 0;
    }

    /**
     * 对于抽象类，如果我们添加非抽象方法，其子类只会享受到能力扩展...
     *
     * @return
     */
    @Override
    public double codings() {
        return super.codings();
    }

    public static void main(String[] args) {
        /* 以下是不允许的 抽象类不能被实例化*/
//        Male male = new Male("name");

        /*String str = ",你好我//是/中/文/逗号，/%%%%%%";
        System.out.println(str);
        System.out.println(StringFilter(str));*/


        /*判断字符串是否是连续字母或者是连续的数字可以用截取字符串然后比较ascii码的值判断连续的次数*/
        /*String str = "ab1234567ab你好好";
        boolean ll = hasLH(str, 3);
        System.out.println(ll);*/


        /*String pwd ="0。0。0";
        String regEx = "^.*(.)\\1{2}.*$";
        if (Pattern.matches(regEx, pwd)) {
            System.out.println("有相同的 3个连续相同字符");
        }*/

/*        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(pwd);
        System.out.println(m.replaceAll("").trim());*/


    }

    private void stringToDate(String time) {
        try {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM");
            Date date = ft.parse(time);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            System.out.println("year " + year + " month " + (month + 1));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void switchCase() {
        int i = 1;
        switch (i) {
            case 0:
                System.out.println("0");
                break;
            case 1:
                System.out.println("1");
                break;
            default:
                System.out.println("default");
        }
    }

    /**
     * i++ 与 ++i 的主要区别有两个：
     * <p>
     * i++ 返回原来的值，++i 返回加1后的值。  i 本身都会加 1
     * i++ 不能作为左值，而++i 可以。
     */
    public static void testPlusSign() {
        int i = 0;
        System.out.println(i++);
        System.out.println(i);
        int j = 0;
        System.out.println(++j);
        System.out.println(i);
    }

    /**
     * 过滤特殊字符
     */
    public static String StringFilter(String str) throws PatternSyntaxException {
        // 只允许字母和数字
        // String   regEx  =  "[^a-zA-Z0-9]";
        // 清除掉所有特殊字符
//        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        String regEx = "[`~!@#$%^&*()+=|{}':;'\\[\\].<>?~！@#￥%……&*（）——+|{}【】‘；：”“’。、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }


    /**
     * 判断字符串是否是连续字母或者是连续的数字可以用截取字符串然后比较ascii码的值判断连续的次数
     *
     * @param str
     * @param count
     * @return
     */
    private static boolean hasLH(String str, int count) {
        int pre = 0;
        int len = 1;
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);
            char c = s.charAt(0);
            if (i == 0) {
                pre = c;
            }
            if (c - 1 == pre) {
                len++;
                if (len >= count) {
                    return true;
                }
            } else {
                len = 1;
            }
            pre = c;
        }
        return false;
    }


    @Override
    public void teach() {

    }

    @Override
    public void travel() {

    }

    @Override
    public void dance() {

    }

    @Override
    public void pregnancy() {

    }


}