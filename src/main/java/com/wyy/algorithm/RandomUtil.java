package com.wyy.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyy
 * @date 18-10-17
 * @time 下午5:32
 */
public class RandomUtil<T> {

    /**
     * 将一个集合完全随机的打乱
     * 思路:倒序进行,将最后一个元素与前面的n-1一个元素交换位置,将倒数第二个元素与前面n-2个元素交换位置....
     *
     * @param list 需要打乱的集合
     */

    public List<T> upsetList(List<T> list) {

        List<T> result = new ArrayList<>(list);

        int index = result.size();

        T temp = null;

        while (index-- > 0) {
            int exchangeIndex = new Double(Math.random() * index).intValue();
            temp = result.get(index);
            result.set(index, result.get(exchangeIndex));
            result.set(exchangeIndex, temp);
        }
        return result;
    }

    /**
     * 从一个集合中随机取其中的若干个元素
     *
     * @param list  源集合
     * @param count 数量
     * @return
     */
    public List<T> randomSubList(List<T> list, int count) {

        List<T> sourceList = new ArrayList<>(list);
        int index = 0;
        int totalSize = sourceList.size();
        T temp = null;


        while (index++ < count) {
            int size = totalSize - index;
            int exchangeIndex = new Double(Math.random() * size).intValue();
            temp = sourceList.get(size);
            sourceList.set(size, sourceList.get(exchangeIndex));
            sourceList.set(exchangeIndex, temp);
        }
        return sourceList.subList(totalSize - count, totalSize);
    }

}
