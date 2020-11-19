package com.ewan.thought.dc;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc：leetcode题目78:子集
 *
 * @author ewan
 * @date 20/11/18
 */
public class Subsets {

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
    }


    /**
     * 注意j = res.size(),避免res无限循环
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(1 << nums.length);
        //先添加一个空的集合
        res.add(new ArrayList<Integer>());
        for (int num : nums) {
            //每遍历一个元素就在之前子集中的每个集合追加这个元素，让他变成新的子集
            for (int i = 0, j = res.size(); i < j; i++) {
                //遍历之前的子集，重新封装成一个新的子集
                List<Integer> list = new ArrayList<Integer>(res.get(i));
                //然后在新的子集后面追加这个元素
                list.add(num);
                //把这个新的子集添加到集合中
                res.add(list);
            }
        }
        return res;
    }


}
