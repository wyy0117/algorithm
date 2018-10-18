package com.wyy.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyy
 * @date 18-10-17
 * @time 下午7:16
 */
public class StringReverseUtilTest {


    private int testCount = 100000;

    private String prepareStr(int length) {
        char[] str = new char[length];
        while (length-- > 0) {
            str[length] = (char) (Math.random() * 26 + 97);
        }
        return new String(str);
    }

    private String prepareStr() {
        int length = 1000;
        char str[] = new char[length];
        while (length-- > 0) {
            str[length] = (char) (Math.random() * 26 + 97);
        }
        return new String(str);
    }

    @Test
    public void testReverse1() {
        System.out.println("StringReverseUtilTest.testReverse1");
        String str = prepareStr(10);
        System.out.println("before reverse str = " + str);
        str = StringReverseUtil.reverse1(str);
        System.out.println("after reverse str = " + str);

        List<String> strList = new ArrayList<>();
        for (int i = 0; i < testCount; i++) {

            strList.add(prepareStr());
        }
        long start = System.currentTimeMillis();
        for (String s : strList) {
            StringReverseUtil.reverse1(s);
        }
        long end = System.currentTimeMillis();
        System.out.println("(end-start) = " + (end - start));
    }

    @Test
    public void testReverse2() {
        System.out.println("StringReverseUtilTest.testReverse2");
        String str = prepareStr(10);
        System.out.println("before reverse str = " + str);
        str = StringReverseUtil.reverse2(str);
        System.out.println("after reverse str = " + str);

        List<String> strList = new ArrayList<>();
        for (int i = 0; i < testCount; i++) {

            strList.add(prepareStr());
        }
        long start = System.currentTimeMillis();
        for (String s : strList) {
            StringReverseUtil.reverse2(s);
        }
        long end = System.currentTimeMillis();
        System.out.println("(end-start) = " + (end - start));
    }

    @Test
    public void testReverse3() {
        System.out.println("StringReverseUtilTest.testReverse3");
        String str = prepareStr(10);
        System.out.println("before reverse str = " + str);
        str = StringReverseUtil.reverse3(str);
        System.out.println("after reverse str = " + str);

        List<String> strList = new ArrayList<>();
        for (int i = 0; i < testCount; i++) {

            strList.add(prepareStr());
        }
        long start = System.currentTimeMillis();
        for (String s : strList) {
            StringReverseUtil.reverse3(s);
        }
        long end = System.currentTimeMillis();
        System.out.println("(end-start) = " + (end - start));
    }

    @Test
    public void testReverse4() {
        System.out.println("StringReverseUtilTest.testReverse4");
        String str = prepareStr(10);
        System.out.println("before reverse str = " + str);
        str = StringReverseUtil.reverse4(str);
        System.out.println("after reverse str = " + str);

        List<String> strList = new ArrayList<>();
        for (int i = 0; i < testCount; i++) {

            strList.add(prepareStr());
        }
        long start = System.currentTimeMillis();
        for (String s : strList) {
            StringReverseUtil.reverse4(s);
        }
        long end = System.currentTimeMillis();
        System.out.println("(end-start) = " + (end - start));
    }

    @Test
    public void testReverse5() {
        System.out.println("StringReverseUtilTest.testReverse5");
        String str = prepareStr(10);
        System.out.println("before reverse str = " + str);
        str = StringReverseUtil.reverse5(str);
        System.out.println("after reverse str = " + str);

        List<String> strList = new ArrayList<>();
        for (int i = 0; i < testCount; i++) {

            strList.add(prepareStr());
        }
        long start = System.currentTimeMillis();
        for (String s : strList) {
            StringReverseUtil.reverse5(s);
        }
        long end = System.currentTimeMillis();
        System.out.println("(end-start) = " + (end - start));
    }

    @Test
    public void testReverse6() {
        System.out.println("StringReverseUtilTest.testReverse6");
        String str = prepareStr(10);
        System.out.println("before reverse str = " + str);
        str = StringReverseUtil.reverse6(str);
        System.out.println("after reverse str = " + str);

        List<String> strList = new ArrayList<>();
        for (int i = 0; i < testCount; i++) {

            strList.add(prepareStr());
        }
        long start = System.currentTimeMillis();
        for (String s : strList) {
            StringReverseUtil.reverse6(s);
        }
        long end = System.currentTimeMillis();
        System.out.println("(end-start) = " + (end - start));
    }
}
