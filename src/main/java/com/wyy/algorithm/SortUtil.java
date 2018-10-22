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
    public static void bubbleSort1(int[] numbers) {
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
    }

    /**
     * 原理:假定第一个是最小的元素,与后面元素进行比较选出实际最小的值.
     * <p>
     * 思路:让第一个元素依次与剩余的元素比较,如果发现比第一个元素小,则交换位置,然后用新的第一个元素与剩余的元素进行比较,一趟结束后,第一个元素就是最小的元素,然后假定第二个元素是最小的元素,依次安装上面规则与剩余的元素进行比较.
     * </p>
     *
     * @param numbers 需要排序的整型数组
     */
    public static void bubbleSort2(int[] numbers) {
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
    public static void selectionSort(int[] numbers) {

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
    public static void quickSort(int[] numbers) {
        quickSortCore(numbers, 0, numbers.length - 1);

    }

    private static void quickSortCore(int[] numbers, int low, int high) {

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
     * 时间负责度最差为O(n^2),平均为O(n^2),稳定
     * </p>
     *
     * @param numbers
     * @return
     */
    public static void insertSort(int[] numbers) {

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
    }


    /**
     * <p>
     * 希尔排序
     * </p>
     *
     * <p>
     * 原理:根据需求，如果你想要结果从大到小排列，它会首先将数组根据increment进行分组分成increment组，对每个数组进行插入排序，
     * 这样比起一开始就用插入排序减少了数据交换和移动的次数，可以说希尔排序是加强版的插入排序,
     * 拿数组5, 2, 8, 9, 1, 3，4来说，数组长度为7，当increment为3时，数组分为3组,第0,3,6一组,第1,4,7一组,第2,5一组，
     * 第一次排序，9,5,4比较，2,1比较，8,3比较，
     * 此例子是按照从大到小排列，所以大的会排在前面，第一次排序后数组为9, 2, 8, 5, 1, 3，4
     * 第一次后increment的值变为3/2=1,此时对数组进行插入排序，
     * 实现数组从大到小排
     * </p>
     *
     * @param numbers
     * @return
     */
    public static void shellSort(int[] numbers) {


        int length = numbers.length;
        int increment = length / 2;
        int temp;

        while (increment > 1) {

            for (int i = 0; i < increment; i++) {
                for (int j = i; j < length - increment; j += increment) {
                    if (numbers[j] < numbers[j + increment]) {
                        temp = numbers[j];
                        numbers[j] = numbers[j + increment];
                        numbers[j + increment] = temp;
                    }
                }
            }
            increment = increment / 2;
        }

    }

}
