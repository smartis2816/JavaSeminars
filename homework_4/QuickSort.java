package homework_4;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] myArray = {8, 6, 2, 4, 1, 0, 9, 7};
        System.out.println(Arrays.toString(myArray));
        sortHoare(myArray, 0, myArray.length - 1);
        System.out.println(Arrays.toString(myArray));
    }

    public static void sortHoare(int[] array, int minIndex, int maxIndex) {
        if (minIndex >= maxIndex) return;
        int pivot = getPivot(array, minIndex, maxIndex);
        sortHoare(array, minIndex, pivot - 1);
        sortHoare(array, pivot + 1, maxIndex);
    }

    public static int getPivot(int[] array, int minIndex, int maxIndex) {
        int pivotIndex = minIndex - 1;
        for (int i = minIndex; i <= maxIndex; i++) {
            if (array[i] < array[maxIndex]) {
                pivotIndex++;
                swap(array, i, pivotIndex);
            }
        }
        pivotIndex++;
        swap(array, pivotIndex, maxIndex);
        return pivotIndex;
    }

    public static void swap(int[] array, int leftValue, int rightValue) {
        int temp = array[leftValue];
        array[leftValue] = array[rightValue];
        array[rightValue] = temp;
    }
}