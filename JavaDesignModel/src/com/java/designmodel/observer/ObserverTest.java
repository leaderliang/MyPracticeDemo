package com.java.designmodel.observer;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/03/24 17:01
 */
public class ObserverTest {
//    public static void main(String[] str) {
//        ConcreteSubject concreteSubject = new ConcreteSubject();
//        Observer observerLiang = new ConcreteObserver("老梁");
//        Observer observerWang = new ConcreteObserver("老王");
//        concreteSubject.attach(observerLiang);
//        concreteSubject.attach(observerWang);
//        concreteSubject.notify("今天发工资~");
//        /*老梁没发工资*/
//        concreteSubject.detach(observerLiang);
//        concreteSubject.notify("发了工资~");
//    }

    public static int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p < 1 + l; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }


    static int getBinaryPeriodForInt(int n) {
        int[] d = new int[30];
        int l = 0, res = -1;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }

        for (int p = 1; p < l; p++) {
            if (p <= l / 2) {
                boolean ok = true;
                for (int i = 0; i < l - p; i++) {
                    if (d[i] != d[i + p]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    res = p;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println("\nEx1: " + solution(955));
//        System.out.println("\nEx1: " + getBinaryPeriodForInt(955));

//        System.out.println("\nEx2: " + solution(1651));
//        System.out.println("\nEx3: " + solution(955));


        int[][] i = {{1, 3, -3}, {1, 3, -3}};

        System.out.println("\nEx1: " + getMax(i));

    }



//    public static int solution(int[] A) {
//        // write your code in Java SE 8
//
//        int i, left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;
//        for (i = 0; i < A.length; i++) {
//            sum += A[i];
//        }
//        left = A[0];
//        for (i = 1; i < A.length; i++) {
//            right = sum - left;
//            min = Math.min(min, Math.abs(right - left));
//            left += A[i];
//        }
//        return min;
//    }

    static int getMax(int[][] A) {
        int max = 0;
        boolean maxValid = false;
        if (A != null) {
            for (int i = 0; i < A.length; i++) {
                if (A[i] != null) {
                    for (int j = 0; j < A[i].length; j++) {
                        if (!maxValid || max < A[i][j]) {
                            max = A[i][j];
                            maxValid = true;
                        }
                    }
                }
            }
        }
        if (!maxValid) throw new IllegalArgumentException("no elements in the array");
        return max;
    }
}