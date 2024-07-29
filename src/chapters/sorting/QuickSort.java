package chapters.sorting;

import java.util.Arrays;

/**
 * @author Nane Petrosyan
 * 28.07.24
 */
public class QuickSort {

    private void sort(int[] array, int low, int high) {
        if (high <= low) return;

        int pivot = partition(array, low, high);
        sort(array, low, pivot - 1);
        sort(array, pivot + 1, high);
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int p1 = low - 1;
        int p2 = low;

        while (p2 <= high) {

            if (array[p2] < pivot) {
                swap(array, ++p1, p2);
            }

            p2++;
        }

        swap(array, high, ++p1);
        return p1;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] input = { 2, 3, 9, 2, 5, 1, 7 };

        new QuickSort().sort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));

    }
}
