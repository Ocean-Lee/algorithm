package algorithm.sort_algorithm.swap;

import static util.ArrayUtils.print;

/**
 * 比较相邻的元素，交换关键字较大的元素，每趟将最大的元素交换到最后的位置
 * <p>
 * 时间复杂度:n*(n-1)=O(n^2)，每趟需要比较n-1次
 * 空间复杂度:O(1)
 * 算法稳定性
 *
 * @author ocean
 * @date 2019/8/26
 */
public class BubbleSort {
    public static void bubbleSort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (j < num.length && num[i] > num[j]) {
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
        bubbleSort(num);
    }
}
