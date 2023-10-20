package seminar6.cw;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Task2 {
    /*
    1. Напишите метод, который заполнит массив из 1000 элементов случайными цифрами от 0 до 24.
2. Создайте метод, в который передайте заполненный выше массив и
с помощью Set вычислите процент уникальных значений в данном массиве и
верните его в виде числа с плавающей запятой.
Для вычисления процента используйте формулу:
процент уникальных чисел = количество уникальных чисел * 100 / общее количество чисел в массиве.
     */
    public static void main(String[] args) {
           Integer[] arr = createArr(0,24,10);
        System.out.println(Arrays.toString(arr));
        double res = procent(arr);
        System.out.println(res);
    }


    public static Integer[] createArr(int minValue, int maxValue, int n) {
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(minValue,maxValue+1);
        }
        return arr;
    }

    public static double procent (Integer[] arr) {
        Set<Integer> list = new HashSet<>(Arrays.asList(arr));
        int size = list.size();
        double result = (size * 100.0/ arr.length);
        return result;
    }
}
