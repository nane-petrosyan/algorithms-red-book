package chapters.sorting;

import java.util.Arrays;

/**
 * @author Nane Petrosyan
 * 20.07.24
 */
public class ShellSort {
    private int[] sort(int[] array) {
        int n = array.length;
        int gap = 1;
        while(gap < n / 3) gap = 3 * gap + 1;

        while(gap > 0) {
            hSort(array, gap);
            gap /= 3;
        }

        return array;
    }

    private int[] hSort(int[] array, int h) {
        for(int i = h; i < array.length; ++i) {
            for (int j = i; j >= h && array[j] < array[j - h]; j -= h) {
                swap(array, j, j - h);
            }
        }

        return array;
    }

    private int[] swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;

        return array;
    }

    public static void main(String[] args) {
        int[] input = { 2, 3, 9, 2, 5, 1, 7 };

        System.out.println(Arrays.toString(new ShellSort().sort(input)));
    }
}
