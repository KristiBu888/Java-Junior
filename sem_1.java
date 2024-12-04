/*
Напишите программу, которая использует Stream API для обработки списка чисел.
Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */
package hw;

import java.util.ArrayList;
import java.util.List;


public class sem_1 {
    public static void main(String[] args) {
        // Создание массива целых чисел
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= 10; i++){
            numbers.add(i);
        }

        // В массиве numbers находим четные числа и записываем их в новый массив evenNumbers
        List<Integer> evenNumbers  = numbers.stream().filter(number -> number % 2 == 0).toList();

        // Считаем сумму всех четных чисел массива evenNumbers и разделим ее на количество четных чисел в этом массиве
        int average = evenNumbers.stream().mapToInt(i -> i).sum() / evenNumbers.size();
        System.out.println("\nСреднее значение четных чисел: " + average);
    }
}