package sort.select;

import static util.ArrayUtils.print;

/**
 * 每趟从未排序的数据中选择最小的元素
 * 第一趟从n个元素中选出最小的，与第一个元素交换
 * 第二趟从n-1个元素中选出最小的，与第二个元素交换
 * 第三趟从n-2个元素中选出最小的，与第三个元素交换
 * ~
 * 第n趟从1个元素中选出最小的，与第n个元素交换
 * <p>
 * 时间复杂度:O(n^2)
 * 空间复杂度:O(1)
 * 算法稳定性:
 *
 * @author ocean
 * @date 2019/8/26
 */
public class SelectionSort {
    public static void selectionSort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < num[i]) {
                   int temp = num[j];
                    num[j] = num[i];
                    num[i] = temp;
                }
            }
        }
        print(num);
    }

    public static void main(String[] args) {
        int[] num = {64, 34, 25, 12, 22, 11, 90};
        selectionSort(num);
    }
}
