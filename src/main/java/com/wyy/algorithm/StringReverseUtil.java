package com.wyy.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wyy
 * @date 18-10-17
 * @time 下午6:59
 * <p>
 * 将字符串反转的思路大概分2类
 * 1.将字符串的charArray进行反转，拼一个新的charArray，然后new一个新的字符串
 * 2.将字符串的charArray倒序拼到StringBuilder中，然后toString。
 * 3.利用StringBuilder提供的reverse（）方法直接反转。
 * 4.利用递归，将charArray一次拆分成单个char和子charArray，最后拼成一个反转的charArray，由于创建子charArray需要申请内存空间，所以性能较低。
 * 5.利用递归，将字符串拆分一个字符和一个子字符串，最后拼成一个反转的string，由于创建子字符串需要申请新的内存空间，所以性能较低。
 */
public class StringReverseUtil {

    /**
     * 将字符串反转
     * 思路:将字符串拆分成数组,然后将数组最后一个和第一个交换,倒数第二个和第二个交换...
     *
     * @param s 要反转的字符串
     * @return
     */
    public static String reverse1(String s) {
        char[] charArray = s.toCharArray();
        int size = charArray.length;
        int end = size;
        int middle = end / 2;

        char temp;

        while (end-- > middle) {
            int front = size - end - 1;
            temp = charArray[end];
            charArray[end] = charArray[front];
            charArray[front] = temp;
        }

        return new String(charArray);
    }

    /**
     * 使用递归
     * 思路:将最后一个字符放到前面的字符串前面,进行递归
     *
     * @param s 要反转的字符串
     * @return
     * @deprecated 由于每次subString都需要申请新的内存空间，所以性能不好
     */
    public static String reverse2(String s) {

        StringBuilder stringBuilder = new StringBuilder();
        return doReverse2(stringBuilder, s).toString();
    }

    private static StringBuilder doReverse2(StringBuilder stringBuilder, String s) {
        if (s.length() == 1) {
            return stringBuilder.append(s);
        } else {
            stringBuilder.append(s.substring(s.length() - 1));
            return doReverse2(stringBuilder, s.substring(0, s.length() - 1));
        }
    }

    /**
     * 调用StringBuffer自带的的reverse方法
     *
     * @param s 要反转的字符串
     * @return
     */
    public static String reverse3(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * 将字符串转char数组，然后倒序append成一个字符串。
     *
     * @param s 要反转的字符串
     * @return
     */
    public static String reverse4(String s) {
        char[] charArray = s.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for (int length = charArray.length; length > 0; length--) {
            char c = charArray[length - 1];
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    /**
     * 利用栈的先进后出特性，依次pop append成一个字符串。
     *
     * @param s 要反转的字符串
     * @return
     */
    public static String reverse5(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            stack.push(c);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    /**
     * 使用递归
     * 思路：将字符串的charArray最后一位放在最前面，剩下的放到后面。
     *
     * @param s 要反转的字符串
     * @return
     * @deprecated 由于在做数组拷贝的时候，需要申请新的内存空间，所以性能有问题
     */
    public static String reverse6(String s) {
        char[] charArray = s.toCharArray();
        List<Character> characterList = doReverse6(new ArrayList<>(), charArray);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < characterList.size(); i++) {
            Character character = characterList.get(i);
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }

    private static List<Character> doReverse6(List<Character> result, char[] charArray) {
        int size = charArray.length;
        if (size == 1) {
            result.add(charArray[0]);
        } else {
            char[] subArray = new char[size - 1];
            System.arraycopy(charArray, 0, subArray, 0, size - 1);
            result.add(charArray[size - 1]);
            doReverse6(result, subArray);
        }
        return result;
    }
}
