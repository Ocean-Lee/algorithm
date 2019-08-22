package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * @author ocean
 * @date 2019/8/22
 */
public class TwoSum_1 {
    /**
     * 暴力搜索法
     * 时间复杂度:
     * 基本操作执行次数n*(n-1) => O(n^2)
     * <p>
     * 空间复杂度:
     * O(1)
     * <p>
     * <p>
     * 问题:对于每个元素，试图通过遍历数组其余部分来找对应的目标元素
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumBrutal(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j < nums.length && nums[i] + nums[j] == target) {
                    //int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 以空间换时间
     * <p>
     * 将数组的元素保存到Map中，在不发生碰撞的情况下，将查找对应元素的次数降低到1次
     * 如果发生碰撞，则查找次数退化到n次。因此这种方法的核心是设计合理的hash函数，以减少碰撞
     * <p>
     * 时间复杂度:O(n)  遍历两边map
     * 空间复杂度:O(n)  需要一个map存放n个元素
     * <p>
     * 问题:如何避免初始化Map消耗了额外的时间
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null && index != i) {
                int[] result = new int[2];
                result[0] = i;
                result[1] = index;
                return result;
            }
        }
        return null;
    }

    /**
     * 只需要遍历一遍map
     * <p>
     * 时间复杂度:O(n)  遍历一遍map，节省了初始化map的时间
     * 空间复杂度:O(n)  需要一个map存放n个元素
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumMapOnce(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null && index != i) {
                int[] result = new int[2];
                result[0] = index;
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }


    /**
     * leetcode上耗时最短的算法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] test = new int[2048];
        for (int i = 0; i < nums.length; i++) {
            //计算num=target - nums[i]的下标
            int temp = (target - nums[i]) & 2047;
            //判断num是否在test数组中，若不存在将num放入test数组中
            if (test[temp] != 0) {
                return new int[]{test[temp] - 1, i};
            }
            test[nums[i] & 2047] = i + 1;
        }
        return null;
    }

    public static void method() {
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 11};
        method();
        int[] result = new TwoSum_1().twoSum(nums, 6);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
