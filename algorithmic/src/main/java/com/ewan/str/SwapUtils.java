package com.ewan.str;

/**
 * Desc：
 *
 * @author ewan
 */
public class SwapUtils {

    public static void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
