package com.java.test;

import java.util.Hashtable;

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

        /*
        String a = "abc";
        String d = "abc";
        String b = new String("abc");
        *//*引用传递*//*
        String c = b;

        System.out.println(a == d);
        System.out.println("a == b:" + a == b);
        //false
        System.out.println("a == b:" + a == b);
        //true
        System.out.println("b == c:" + (b == c));
        //false
        System.out.println("a == c:" + (a == c));
        System.out.println("a.equals(b):" + a.equals(b));   //true
        System.out.println("b.equals(c):" + b.equals(c));   //true
        System.out.println("a.equals(c):" + a.equals(c));   //true

        Integer i1 = 100, i2 = 100;
        System.out.println(i1 == i2);   //true
        Integer i3 = 1000, i4 = 1000;
        System.out.println(i3 == i4);   //fales
        */


//        HashMap hashMap = new HashMap();
        Hashtable hashMap = new Hashtable();

//        hashMap.put(null, null);
//        hashMap.put(1, 2);
//        hashMap.put(1, null);
//        hashMap.put(1, null);
//        hashMap.put(2, null);
//        hashMap.put(null, 2);

        System.out.println(hashMap.toString());

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