package com.ewan.str.sort;

/**
 * Desc：变位词
 * <p>
 * 在英语中，如果两个单词中出现的字母相同，并且每个字母出现的次数也相同，那么这两个单词互为变位词（Anagram），
 * 例如，silent与listen，evil与live等互为变位词。请完成一个函数，判断输入的两个字符串是否互为变位词。
 *
 * @author ewan
 */
public class Anagrams {

    /**
     * 1.创建一个数组依次存储26个字母的数量
     * 2.扫描字符串a，命中则将value值加1
     * 3.扫描字符串b，命中则将value值减一
     * 4.判断数组中的value值是否全部为0，true则是变位词，反之则不是
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(26)
     */
    public static boolean isAnagram(String a, String b) {
        //校验
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }

        //1. 初始化数组
        int[] letters = new int[26];

        for (int i = 0; i < a.toCharArray().length; i++) {
            //2.扫描第一个字符串，记录出现字母的次数+1
            int aindex = a.toCharArray()[i] - (char) 'a';
            letters[aindex] = letters[aindex]++;

            //3.扫描第二个字符串，记录出现字母的次数-1
            int bindex = b.toCharArray()[i] - (char) 'a';
            letters[bindex] = letters[bindex]--;
        }

        //最后判断哈希表中元素是否都等于0
        for (int k = 0; k < letters.length; k++) {
            if (letters[k] != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        boolean result = isAnagram("abcdaa", "aabcad");
        System.out.println(result);
    }
}
