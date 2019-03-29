package com.java.designmodel.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author liang
 * @date 2015/6/10
 */
public class CollectionUtils {
    public static boolean isEmpty(Collection<?> collection){
        return collection == null || collection.isEmpty();
    }

    public static String join(List<?> list, String separator){
        StringBuilder sb = new StringBuilder();

        for(Object obj : list){
            sb.append(obj.toString()).append(separator);
        }

        return sb.substring(0, sb.length() - 1);
    }

    public static <E> ArrayList<E> asList(E ...e){
        return new ArrayList<>(Arrays.asList(e));
    }
}
