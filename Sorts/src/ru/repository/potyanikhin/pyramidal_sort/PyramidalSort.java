package ru.repository.potyanikhin.pyramidal_sort;

import java.util.Arrays;

//Реализация пирамидальной сортировки.
public class PyramidalSort {
    public static void pyramidalSort(int[] array) {
        int length = array.length;

        for (int parentIndex = length / 2 - 1; parentIndex >= 0; parentIndex--) {
            siftElement(array, length, parentIndex);
        }

        for (int lastElementIndex = length - 1; lastElementIndex > 0; lastElementIndex--) {
            int temp = array[0];
            array[0] = array[lastElementIndex];
            array[lastElementIndex] = temp;

            siftElement(array, lastElementIndex, 0);
        }
    }

    public static void siftElement(int[] array, int length, int index) {
        int maxIndex = index;

        while (maxIndex * 2 + 1 < length) {
            int firstChildIndex = maxIndex * 2 + 1;
            int secondChildIndex = maxIndex * 2 + 2;

            if (array[firstChildIndex] > array[maxIndex]) {
                maxIndex = firstChildIndex;
            }

            if (secondChildIndex < length && array[secondChildIndex] > array[maxIndex]) {
                maxIndex = secondChildIndex;
            }

            if (maxIndex != index) {
                int temp = array[index];
                array[index] = array[maxIndex];
                array[maxIndex] = temp;

                index = maxIndex;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 6, 2, 1, 7, 5};
        System.out.println("Данный массив: " + Arrays.toString(array));

        pyramidalSort(array);
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }
}