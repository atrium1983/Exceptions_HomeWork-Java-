//Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.
//        Метод arrayOutOfBoundsException - Ошибка, связанная с выходом за пределы массива
//        Метод divisionByZero - Деление на 0
//        Метод numberFormatException - Ошибка преобразования строки в число
//        Важно: они не должны принимать никаких аргументов

package HomeWork_1.Task_1;

public class Printer {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}

class Answer {
    public static void arrayOutOfBoundsException() {
        int [] array = {1,2,3};
        int sum = 0;
        for (int i = 0; i <= array.length; i++){
            sum+=array[i];
        }

    }

    public static void divisionByZero() {
        int dev = 10/0;

    }

    public static void numberFormatException() {
       String str = "one";
       int num = Integer.parseInt(str);
    }
}
