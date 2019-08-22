package leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except
 * the number 0 itself.
 * <p>
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author ocean
 * @date 2019/8/22
 */
public class AddTwoNumbers_2 {
    /**
     * 第一个想到的方法(失败，因为数值溢出)
     * [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
     * [5,6,4]
     * <p>
     * 遍历list，获取被加数；计算；再将结果转为list
     * <p>
     * 时间复杂度:
     * 遍历n+转置n+构建节点n => O(n)+O(n)+O(n)=O(n)
     * 空间复杂度: O(n)
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbersBrutal(ListNode l1, ListNode l2) {
        long a = travel(l1);
        long b = travel(l2);
        long result = a + b;
        return buildListNode(result);
    }

    private static Long travel(ListNode l1) {
        char[] chars = new char[1024];
        int i = 0;
        ListNode firstNode = l1;
        ListNode node = firstNode;
        while (true) {
            if (node == null) {
                break;
            } else {
                //数字转char，先转为String，再转为char。
                //数字强转char，会被当成ASCII来处理
                chars[i] = String.valueOf(node.val).toCharArray()[0];
                node = node.next;
                i++;
            }
        }
        //转置char
        for (int j = 0, k = i - 1; j < i; j++, k--) {
            if (j <= k) {
                char temp = chars[j];
                chars[j] = chars[k];
                chars[k] = temp;
            }
        }
        return new Long(new String(chars, 0, i));
    }

    private static ListNode buildListNode(long n) {

        char[] chars = String.valueOf(n).toCharArray();
        ListNode result = new ListNode(Integer.valueOf(String.valueOf(chars[chars.length - 1])));
        ListNode p = result;
        for (int i = chars.length - 2; i >= 0; i--) {
            ListNode node = new ListNode(Integer.valueOf(String.valueOf(chars[i])));
            p.next = node;
            p = node;
        }
        return result;
    }

    public static void main(String[] args) {


        int[] num2 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        ListNode l2 = new ListNode(num2[0]);
        ListNode p = l2;
        for (int i = 1; i < num2.length; i++) {
            ListNode node = new ListNode(num2[i]);
            p.next = node;
            p = node;
        }
        int[] num1 = {5, 6, 4};
        ListNode l1 = new ListNode(num1[0]);
        ListNode k = l1;
        for (int i = 1; i < num1.length; i++) {
            ListNode node = new ListNode(num1[i]);
            k.next = node;
            k = node;
        }


        ListNode listNode = addTwoNumbersBrutal(l1, l2);
        System.out.println();
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}