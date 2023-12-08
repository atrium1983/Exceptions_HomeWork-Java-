/*
Напишите программу, которая вычисляет значение выражения intArray[8] / d, где intArray- массив целых чисел, а d - делитель.
Программа проверяет, имеется ли в массиве intArray элемент с индексом 8, и если нет, выводит сообщение о невозможности
выполнения операции.
Также программа проверяет, равен ли делитель d нулю, и если да, выводит соответствующее сообщение.
На входе:
'1 2 3 4 5 6 7 8 9'
'1'
На выходе:
intArray[8] / d = 9 / 1 = 9.0
9.0
 */
package HomeWork_2.Task_2;

import java.util.Arrays;

public class Printer {
    public static void main(String[] args) {
        int[] intArray;
        int d;

        if (args.length == 0) {
            intArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            d = 1; // По умолчанию используем 0, если аргумент не передан
        } else {
            intArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
            d = Integer.parseInt(args[1]); // Можно использовать значение по умолчанию или передать его как аргумент.
        }

        double result = Expr.expr(intArray, d);
        System.out.println(result);
    }
}

class Expr {

    public static double expr(int[] intArray, int d) {
        // Введите свое решение ниже
        double result = Double.NaN;
        if (intArray.length < 9) {
            System.out.println("It's not possible to evaluate the expression - intArray[8] / d as there is no 8th element in the given array.");
        } else if (d == 0) {
            System.out.println("It's not possible to evaluate the expression - intArray[8] / d as d = 0.");
        } else {
            result = (double)intArray[8]/d;
            System.out.printf("intArray[8] / d = %d / %d = %s", intArray[8], d, result);
            System.out.println();
        }
        return result;
    }
}
