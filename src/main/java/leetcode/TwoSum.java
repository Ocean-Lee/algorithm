package leetcode;

/**
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * @author ocean
 * @date 2019/8/22
 */
public class TwoSum {
    /**
     * 暴力搜索法
     * 时间复杂度:
     * 基本操作执行次数n*(n-1) => O(n^2)
     * <p>
     * 空间复杂度:
     * O(1)
     * <p>
     * <p>
     * 问题:如何能降低时间复杂度？
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j < nums.length && nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = new TwoSum().twoSum(nums, 26);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
