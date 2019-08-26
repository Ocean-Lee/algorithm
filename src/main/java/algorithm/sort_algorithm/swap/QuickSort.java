package algorithm.sort_algorithm.swap;

import static util.ArrayUtils.print;

/**
 * 快速排序是一种划分交换的排序方法
 * 采用分治策略
 * <p>
 * 基本思想:
 * 1.在数据集中找一个元素作为基准
 * 2.将所有比基准小的元素放到左边，所有比基准大的元素放到右边
 * 3.对于基准左右两边的子集重复第一步和第二步，直到所有子集只剩一个元素
 * <p>
 * 找基准的策略
 *
 * @author ocean
 * @date 2019/8/26
 */
public class QuickSort {
    /**
     * 递归的方式
     * 以中间元素做基准
     *
     * @param num
     */
    public static void quickSort(int[] num) {
        int low = 0;
        int high = num.length - 1;
        int pivot = high;
        for (int i = 0, j = high - 1; i < j; i++, j--) {
            if (num[i] > num[pivot]) {
                int temp = num[pivot];
                num[pivot] = num[i];
                num[i] = temp;
                pivot = i;
            }
            if (num[j] < num[pivot]) {
                int temp = num[pivot];
                num[pivot] = num[i];
                num[i] = temp;
                pivot = j;
            }
        }

        print(num);
    }

    public static void main(String[] args) {
        int[] num = {64, 34, 25, 12, 22, 11, 90};
        quickSort(num);
    }
}
