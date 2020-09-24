package com.ewan.str.permutation;

import com.ewan.str.SwapUtils;

/**
 * Desc：全排列
 * <p>
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc，则输出由字符a、b、c 所能排列出来的所有字符
 * abc、acb、bac、bca、cab 和 cba。
 *
 * @author ewan
 */
public class AllPermutaion {

    /**
     * 递归
     *
     * 固定a，求后面bc的排列：abc，acb，求好后，a和b交换，得到bac
     * 固定b，求后面ac的排列：bac，bca，求好后，c放到第一位置，得到cba
     * 固定c，求后面ba的排列：cba，cab。
     */
    public static void allPermution(char[] s, int from, int to) {

        if (from == to) {
            System.out.println(s);
        } else {
            for (int i = from; i <= to; i++) {
                SwapUtils.swap(s, i, from);
                allPermution(s, from + 1, to);
                SwapUtils.swap(s,from,i);
            }
        }
    }


    //====================================

    public static void main(String[] args) {
        String s = "abc";
        allPermution(s.toCharArray(),0,s.length()-1);
    }
}
