package com.wyy.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyy
 * @date 18-10-17
 * @time 下午7:16
 */
public class StringUtilTest {


    private String prepareStr() {
        int length = 100;
        char str[] = new char[length];
        while (length-- > 0) {
            str[length] = (char) (Math.random() * 26 + 97);
        }
        return new String(str);
    }

    @Test
    public void testReverse1() {
        String str = prepareStr();
        System.out.println("before reverse str = " + str);
        str = StringUtil.reverse1(str);
        System.out.println("after reverse str = " + str);

        int length = 100000;
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < length; i++) {

            strList.add(prepareStr());
        }
        long start = System.currentTimeMillis();
        for (String s : strList) {
            StringUtil.reverse1(s);
        }
        long end = System.currentTimeMillis();
        System.out.println("(end-start) = " + (end - start));
    }

    @Test
    public void testReverse2() {
        String str = prepareStr();
        System.out.println("before reverse str = " + str);
        str = StringUtil.reverse1(str);
        System.out.println("after reverse str = " + str);

        int length = 100000;
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < length; i++) {

            strList.add(prepareStr());
        }
        long start = System.currentTimeMillis();
        for (String s : strList) {
            StringUtil.reverse2(s);
        }
        long end = System.currentTimeMillis();
        System.out.println("(end-start) = " + (end - start));
    }
}
