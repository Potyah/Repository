package ru.repository.potyanikhin.quick_sort;

import java.util.Arrays;

//Реализация быстрой сортировки.
public class QuickSort {
    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        if (right - left == 1) {
            if (array[left] > array[right]) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }

            return;
        }

        int x = array[left];
        int i = left;
        int j = right;

        while (i <= j) {
            while (array[i] < x) {
                i++;
            }

            while (array[j] > x) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                i++;
                j--;
            }
        }

        if (i < right) {
            quickSort(array, i, right);
        }

        if (j > left) {
            quickSort(array, left, j);
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 6, 2, 1, 7, 5};
        System.out.println("Данный массив: " + Arrays.toString(array));

        quickSort(array, 0, array.length - 1);
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }
}