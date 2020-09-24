package com.ewan.str.permutation;

import com.ewan.str.SwapUtils;

/**
 * Desc：全组合
 * <p>
 * 已知字符串里的字符是互不相同的，现在任意组合，比如ab，则输出aa，ab，ba，bb，编程按照字典序输出所有的组合。
 *
 * 没有解出来，如何让前面的与后面的换呢？
 * @author ewan
 */
public class AllCombination {

    static int index = 0;
    /**
     * 递归
     */
    public static void allCombinate(char[] s, int from, int to) {
        if (from == to) {
            for (int i = 0; i < s.length; i++) {
                char tmp = s[s.length - 1];
                s[s.length - 1]=s[i];
                //System.out.println("index:"+ ++index+"" +s);
                System.out.println(s);
                s[s.length - 1]=tmp;
            }
        } else {
            for (int i = from; i <= to; i++) {
                SwapUtils.swap(s, i, from);
                allCombinate(s, from + 1, to);
                SwapUtils.swap(s, from, i);
            }
        }
    }


    public static void main(String[] args) {
        String s = "abc";
        allCombinate(s.toCharArray(), 0,s.length()-1);
    }
}
