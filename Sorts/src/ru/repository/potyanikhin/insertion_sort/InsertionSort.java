package ru.repository.potyanikhin.insertion_sort;

import java.util.Arrays;

//Реализация сортировки вставками.
public class InsertionSort {
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j;
            int temp = array[i];

            for (j = i - 1; j >= 0 && array[j] > temp; j--) {
                array[j + 1] = array[j];
            }

            array[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 6, 2, 1, 7, 5};
        System.out.println("Данный массив: " + Arrays.toString(array));

        insertionSort(array);
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }
}