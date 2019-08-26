package algorithm.sort_algorithm.insert;

import static util.ArrayUtils.print;

/**
 * 基本思想
 * 每一趟将一个元素，按照关键字的大小插入到已排序的序列中
 *
 * @author ocean
 * @date 2019/8/26
 */
public class StraightInsertionSort {
    public static void straightInsertionSort(int[] num) {
        //1.选择第一个元素为有序序列
        //2.每趟选一个新元素，查询在有序序列中的位置
        //3.移动元素，插入新元素
        int index = 0;
        for (int i = 1; i < num.length; i++) {
            int ele = num[i];
            int j = 0;
            for (j = index; j >= 0; j--) {
                //判断元素大小，移动元素,从index上的元素往后移动一位
                if (ele < num[j]) {
                    //移动元素,从index上的元素往后移动一位
                    num[i] = num[j];
                    break;
                    //插入元素，将新的元素插入到index的位置
                }
            }
            index++;
            num[j] = ele;
        }

        print(num);
    }

    public static void main(String[] args) {
        int[] num = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        straightInsertionSort(num);
//        method();
    }

    /**
     * 将数组第i位后的所有元素往后移动一位
     * 从最后一个元素开始移动，将第i-1位上的元素移动到第i位上
     * 每次循环只往后移动一个元素
     */
    public static void method() {
        int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int index = 0;
        //{9, 8, 7, 6, '', 5, 4, 3, 2};
        for (int i = num.length - 1; i >= index; i--) {
            if (i - 1 >= 0) {
                num[i] = num[i - 1];
            }

        }

        //将第i位置为0
        if (index - 1 < 0) {
            num[0] = 0;
        } else {
            num[index - 1] = 0;
        }
        print(num);
    }
}
