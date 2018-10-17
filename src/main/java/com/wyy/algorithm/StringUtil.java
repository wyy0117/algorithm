package com.wyy.algorithm;

/**
 * @author wyy
 * @date 18-10-17
 * @time 下午6:59
 */
public class StringUtil {

    /**
     * 将字符串反转
     * 思路:将字符串拆分成数组,然后将最后一个和第一个交换,倒数第二个和第二个交换...
     *
     * https://blog.csdn.net/m0_37961948/article/details/72235216
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
     * @deprecated 性能没有 {@link StringUtil#reverse1(java.lang.String)}好
     */
    public static String reverse2(String s) {

        StringBuilder stringBuilder = new StringBuilder();
        if (s.length() == 1) {
            return s;
        }
        String front = s.substring(0, s.length() - 1);
        String end = s.substring(s.length() - 1);
        return stringBuilder.append(end).append(reverse2(front)).toString();

    }
}
