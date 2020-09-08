package ru.repository.potyanikhin.range_main;

import ru.repository.potyanikhin.range.Range;

import java.util.Arrays;

//Реализация класса Range.

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(6, 11);
        Range range2 = new Range(8, 9);

        double number = 5.6;

        if (range1.isInside(number)) {
            System.out.println("Число " + number + " принадлежит заданному диапазону");
        } else {
            System.out.println("Число " + number + " не принадлежит заданному диапазону");
        }

        System.out.println("Длинна отрезка: " + range1.getLength());

        System.out.println("Пересечение данных интервалов: [" + range1.getIntersection(range2) + "]");

        System.out.println("Объединение данных интервалов: " + Arrays.toString(range1.getUnion(range2)));

        System.out.println("Разность данных интервалов: " + Arrays.toString(range1.getDifference(range2)));
    }
}