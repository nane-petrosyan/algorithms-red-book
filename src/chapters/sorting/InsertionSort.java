package chapters.sorting;

import java.util.Arrays;

/**
 * @author Nane Petrosyan
 * 20.07.24
 */
public class InsertionSort {

    private int[] sort(int[] array) {
        if (array.length == 0)
            return array;

        for (int i = 1; i < array.length; ++i) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; --j) {
                swap(array, j, j - 1);
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

        System.out.println(Arrays.toString(new InsertionSort().sort(input)));
    }
}
