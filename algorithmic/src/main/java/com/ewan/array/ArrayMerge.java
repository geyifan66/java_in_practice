package com.ewan.array;

import org.checkerframework.checker.units.qual.A;

/**
 * leetCode 88. 合并两个有序数组
 */
public class ArrayMerge {

    public void merge(int[] numA, int[] numB) {
        int[] result = new int[numA.length + numB.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < numA.length && j < numB.length) {
            result[k++] = numA[i] <= numB[j] ? numA[i++] : numB[j++];
        }

        if (i < numA.length) {
            for (; i < numA.length; i++) {
                result[k++] = numA[i];
            }
        }

        if (j < numB.length) {
            for (; j < numB.length; j++) {
                result[k++] = numB[j];
            }
        }

        for (int m = 0; m < result.length; m++) {
            System.out.println(result[m]);
        }

    }

    public static void main(String[] args) {
        int[] numA = new int[]{1, 3, 7, 9};
        int[] numB = new int[]{2, 4, 6};
        new ArrayMerge().merge(numA, numB);
    }


}
