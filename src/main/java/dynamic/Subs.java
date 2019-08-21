package dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * 子序列相关的问题
 * 1.子序列的定义(什么是子序列)
 * 2.子序列的个数
 * 3.求一个字符串的子序列
 * 4.求两个字符串的最长公共子序列
 * 5.写递归程序的方法
 *
 * @author ocean
 * @date 2019/8/21
 */
public class Subs {
    public static void main(String[] args) {

        char[] chars = "ABCDEFGHIKHHJJJJJJJJ0000000000".toCharArray();
        List list = new ArrayList();
//        char[] sub = new char[5];
//        getLenNofSequence(sub, 0, chars, 0, list);
        getAllSequence(chars.length, chars, list);
//        getLen3ofSequence(chars);
        System.out.println(chars.length + "\t\t" + Math.pow(2, chars.length) + "\t\t" + (list.size() + 1));
        System.out.println();
    }

    /**
     * 1.求一个字符串的子序列
     * 枚举法
     */
    public static void subsequence(String seq) {
        char[] chars = seq.toCharArray();
        //字符串的长度
        int n = seq.length();

        //求一个长度为n的子序列
        getLen3ofSequence(chars);
    }

    /**
     * 求解一个字符串长度为3的子序列
     * 一个长度为n的字符串，它长度为3的子序列的个数是多少
     *
     * @param chars
     */
    public static List<String> getLen3ofSequence(char[] chars) {
        List<String> result = new ArrayList();
        //1.构建一个数组用来存放长度为len的子序列
        char[] sub = new char[3];
        //2.以第i个位置开头的，n-i个元素依次构成的长度为len的子序列
        //使用i来记录开头元素的位置，j来记录要获取元素的位置，k来记录长度为len的数组中的元素
        for (int i = 0; i < chars.length; i++) {
            sub[0] = chars[i];
            for (int j = i + 1; j < chars.length; j++) {
                sub[1] = chars[j];
                for (int k = j + 1; k < chars.length; k++) {
                    sub[2] = chars[k];
                    result.add(new String(sub));
//                    System.out.println(new String(sub));
                }
            }
        }
        System.out.println("3层\t\t" + chars.length + "\t\t" + result.size());
        return result;
    }


    /**
     * 递归求解
     * 求解一个字符串长度为n的长为m的子序列
     * 核心：如何构建递归函数
     * 从实际的例子中寻找找递推关系
     *
     * @param sub
     * @param subIndex
     * @param chars
     * @param charIndex
     * @return
     */
    public static void getLenNofSequence(char[] sub, int subIndex, char[] chars, int charIndex, List list) {
        if (subIndex == sub.length - 1) {
            //易错点
            int lastIndex = subIndex;
            for (int i = charIndex; i < chars.length; i++) {
                sub[lastIndex] = chars[i];
                list.add(new String(sub));
//                System.out.println(new String(sub));
            }
        } else {
            //递归
            //易错点
            int midIndex = subIndex;
            for (int i = charIndex; i < chars.length; i++) {
                sub[midIndex] = chars[i];
                getLenNofSequence(sub, midIndex + 1, chars, i + 1, list);
            }
        }
    }

    /**
     * 求解长为n的字符串的所有子序列
     */
    public static void getAllSequence(int n, char[] chars, List list) {
        for (int i = 1; i <= n; i++) {
            char[] sub = new char[i];
            getLenNofSequence(sub, 0, chars, 0, list);
        }


    }
}
