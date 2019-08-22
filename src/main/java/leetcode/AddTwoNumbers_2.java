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
     * [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1].length=31
     * [5,6,4]
     * <p>
     * Long的长度[9,2,2,3,3,7,2,0,3,6,8,5,4,7,7,5,8,0,7].length=18
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


    /**
     * 方法二
     * 遍历链表，完成计算，记录进位
     * <p>
     * 时间复杂度:O(max(m,n))
     * 空间复杂度:O(n)
     * <p>
     * 思路：
     * 两个指针指向l1、l2
     * 移动指针，获取值计算,如为null则表示已经移到的链表的结尾
     * 判断计算结构是否要进位
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode p = node, p1 = l1, p2 = l2;
        boolean flag = false;
        int carry = 0;
        while (true) {
            int val = 0;
            if (flag) {
                val++;
            }
            if (p1 == null && p2 == null) {
                if (flag) {
                    p.next = new ListNode(val);
                }
                break;
            } else {
                flag = false;
            }
            int v1 = (p1 == null) ? 0 : p1.val;
            int v2 = (p2 == null) ? 0 : p2.val;
            val = carry + v1 + v2;
            if (val >= 10) {
                carry = 1;
                flag = true;
            }
            p.next = new ListNode(val % 10);
            p = p.next;

            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }

        return node.next;
    }


    public static void main(String[] args) {


//        int[] num2 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        int[] num2 = {5};
        ListNode l2 = new ListNode(num2[0]);
        ListNode p = l2;
        for (int i = 1; i < num2.length; i++) {
            ListNode node = new ListNode(num2[i]);
            p.next = node;
            p = node;
        }
        int[] num1 = {5};
        ListNode l1 = new ListNode(num1[0]);
        ListNode k = l1;
        for (int i = 1; i < num1.length; i++) {
            ListNode node = new ListNode(num1[i]);
            k.next = node;
            k = node;
        }


        ListNode listNode = addTwoNumbers(l1, l2);
        ListNode read = addTwoNumbers(l1, l2);
        System.out.println(listNode.toString());
        while (true) {
            if (read != null) {
                System.out.print(read.val + "\t");
                read = read.next;
            } else {
                break;
            }
        }
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