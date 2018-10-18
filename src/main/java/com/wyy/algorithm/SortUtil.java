package com.wyy.algorithm;

/**
 * @author wyy
 * @date 18-10-18
 * @time 上午9:53
 */
public class SortUtil {

    /**
     * 原理：比较两个相邻的元素，将值大的元素交换至右端。
     * <p>
     * 思路：依次比较相邻的两个数，将小数放在前面，大数放在后面。即在第一趟：首先比较第1个和第2个数，将小数放前，大数放后。然后比较第2个数和第3个数，将小数放前，大数放后，如此继续，直至比较最后两个数，将小数放前，大数放后。重复第一趟步骤，直至全部排序完成。
     * <p>
     * 第一趟比较完成后，最后一个数一定是数组中最大的一个数，所以第二趟比较的时候最后一个数不参与比较；
     * <p>
     * 第二趟比较完成后，倒数第二个数也一定是数组中第二大的数，所以第三趟比较的时候最后两个数不参与比较；
     * <p>
     * 依次类推，每一趟比较次数-1；
     * <p>
     * 排序次数最多为n(n-1)/2,时间复杂度最差为O(n^2),平均为O(n^2),稳定,空间复杂度为O(1)
     *
     * @param numbers 需要排序的整型数组
     * @return
     */
    public static int[] bubbleSort1(int[] numbers) {
        int temp;
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {//循环length-1次
            for (int j = 0; j < length - i - 1; j++) {
                if (numbers[j] < numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        return numbers;
    }

    /**
     * 原理:假定第一个是最小的元素,与后面元素进行比较选出实际最小的值.
     * <p>
     * 思路:让第一个元素依次与剩余的元素比较,如果发现比第一个元素小,则交换位置,然后用新的第一个元素与剩余的元素进行比较,一趟结束后,第一个元素就是最小的元素,然后假定第二个元素是最小的元素,依次安装上面规则与剩余的元素进行比较.
     * </p>
     *
     * @param numbers 需要排序的整型数组
     */
    public static int[] bubbleSort2(int[] numbers) {
        int temp;
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {//循环length-1次
            for (int j = i + 1; j < length; j++) {
                if (numbers[j] < numbers[i]) {
                    temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        return numbers;
    }

    /**
     * 原理:每次远出一个最小的数放到未排序的前面
     * <p>
     * 思路:假定下标为0的数为最小的数,然后依次与后面的数比较,如果发现有更小的元素,那么该下标的元素为最小元素,然后用该元素依次与后面的元素比较,直到最后,然后进行第二次循环
     * </p>
     *
     * <p>
     * 该算法与上面的{@link SortUtil#bubbleSort2(int[])}很像
     * </p>
     *
     * <p>
     * 时间复杂度最差为O(n^2),平均为O(n^2),稳定
     * </p>
     *
     * @param numbers
     * @return
     */
    public static int[] selectionSort(int[] numbers) {

        int minIndex;
        int length = numbers.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;

            int j = i + 1;
            while (j < length) {
                if (numbers[minIndex] > numbers[j]) {
                    minIndex = j;
                }
                j++;
            }

            if (minIndex != i) {
                temp = numbers[minIndex];
                numbers[minIndex] = numbers[i];
                numbers[i] = temp;
            }
        }
        return numbers;
    }

    /**
     * 快速排序
     * <p>
     * 左右2边同时向中间推进,先从左往右推进,如果左小于右,继续向右推进,如果左大于右,交换2个元素的位置,则变成从右往左推进,如果左小于等于右,继续向左推进,如果左大于右,交换2个元素的位置,然后改为从左往右推进,直到左右相遇在某个下标,此时左边都比该元素小,右边都比该元素大,分成左右2个数组,递归进行上述步骤即可.
     * </p>
     * <p>
     * 时间复杂度最差为O(n^2),平均为O(n*log2n),不稳定,
     * </p>
     *
     * @param numbers
     * @return
     */
    public static int[] quickSort(int[] numbers) {
        return quickSortCore(numbers, 0, numbers.length - 1);

    }

    private static int[] quickSortCore(int[] numbers, int low, int high) {

        int start = low;
        int end = high;
        int temp;
        boolean leftToRight = true;

        while (start < end) {

            //从左往右
            while (leftToRight && start < end) {
                if (numbers[start] < numbers[end]) {
                    start++;
                } else {
                    temp = numbers[start];
                    numbers[start] = numbers[end];
                    numbers[end] = temp;
                    end--;
                    leftToRight = false;
                }
            }

            //从右往左
            while (!leftToRight && start < end) {
                if (numbers[end] >= numbers[start]) {
                    end--;
                } else {
                    temp = numbers[start];
                    numbers[start] = numbers[end];
                    numbers[end] = temp;
                    start++;
                    leftToRight = true;
                }
            }

        }
        int middle = start;

        if (low < middle) {
            quickSortCore(numbers, low, middle - 1);
        }
        if (middle < high) {
            quickSortCore(numbers, middle + 1, high);
        }
        return numbers;
    }

    /**
     * <p>
     * 插入排序
     * </p>
     *
     * <p>
     * 原理:将每个元素依次插入到前面有序的元素中
     * </p>
     * <p>
     * 思路:从第二个元素开始,依次与前面的元素进行比较,如果小于前一个的元素,则与前一个元素交换位置,否则固定该位置,对下一个元素进行插入排序
     * </p>
     *
     * <p>
     *     时间负责度最差为O(n^2),平均为O(n^2),稳定
     * </p>
     *
     * @param numbers
     * @return
     */
    public static int[] insertSort(int[] numbers) {

        int currentIndex;
        int length = numbers.length;

        int temp;
        for (int i = 1; i < length; i++) {
            currentIndex = i;
            while (currentIndex > 0 && numbers[currentIndex] < numbers[currentIndex - 1]) {
                temp = numbers[currentIndex];
                numbers[currentIndex] = numbers[currentIndex - 1];
                numbers[currentIndex - 1] = temp;
                currentIndex--;
            }
        }
        return numbers;
    }


}
