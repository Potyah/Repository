package ru.repository.potyanikhin.binary_search;

//Реализация бинарного поиска.

public class BinarySearch {
    public static int recursionBinarySearch(int[] array, int left, int right, int x) {
        if (left > right) {
            return -1;
        }

        int middle = (right + left) / 2;

        if (array[middle] == x) {
            return middle;
        }

        if (array[middle] < x) {
            return recursionBinarySearch(array, middle + 1, right, x);
        }

        return recursionBinarySearch(array, left, middle - 1, x);
    }

    public static int binarySearch(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (array[middle] < x) {
                left = middle + 1;
            } else if (array[middle] > x) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 5, 6, 7, 8, 9, 10};

        int left = 0;
        int right = array.length - 1;

        int x = 9;

        int index = recursionBinarySearch(array, left, right, x);
        System.out.println("Индекс числа в массиве (найден с помощью рекурсивной функции): " + index);

        index = binarySearch(array, x);
        System.out.println("Индекс числа в массиве: " + index);
    }
}