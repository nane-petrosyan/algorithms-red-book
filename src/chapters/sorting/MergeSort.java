package chapters.sorting;

import java.util.Arrays;

/**
 * @author Nane Petrosyan
 * 22.07.24
 */
public class MergeSort {

    private void sort(int[] array, int low, int high) {
        if (low >= high) return;

        int mid = low + (high - low)/2;

        sort(array, low, low + (high - low)/2);
        sort(array, low + (high - low)/2 + 1, high);

        merge(array, low, mid, high);
    }

    private int[] merge(int[] array, int low, int mid, int high) {
        int[] tmp = Arrays.copyOf(array, array.length);
        int i = low;
        int j = mid + 1;


        for (int k = low; k <= high; ++k) {
            if (j > high) array[k] = tmp[i++];
            else if (i > mid) array[k] = tmp[j++];
            else if (tmp[i] < tmp[j]) array[k] = tmp[i++];
            else array[k] = tmp[j++];
        }

        return array;
    }

    public static void main(String[] args) {
        int[] input = { 2, 3, 9, 2, 5, 1, 7 };

        new MergeSort().sort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }
}
