package chapters.sorting;

import java.util.Arrays;

/**
 * @author Nane Petrosyan
 * 20.07.24
 */
public class SelectionSort {
    private int[] sort(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            int min = i;
            for (int j = i; j < array.length; ++j) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
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

        System.out.println(Arrays.toString(new SelectionSort().sort(input)));
    }
}
