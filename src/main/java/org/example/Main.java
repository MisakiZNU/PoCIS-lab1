package org.example;
import java.math.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Оберіть варіант:");
        System.out.println("1.Обчислення функції");
        System.out.println("2.Робота з текстом");
        System.out.println("В іншому випадку, програма буде завершена");
        int choice = scanner.nextInt();

        if (choice == 1) {
            Lab1Numeric lab1Numeric = new Lab1Numeric();
            lab1Numeric.run();
        } else if (choice == 2) {
            Lab1String lab1String = new Lab1String();
            lab1String.run();
        } else {
            System.out.println("Невірний вибір.");
        }
    }
}
class Lab1Numeric {

    public float y1f(float x) {
        return (float) Math.log(1 / (2 + 2 * x + x * x));
    }

    public float y2f(float x, int k) {
        int n = 1;
        float a = 1;
        float sum = 0;
        while (n <= k) {
            a *= (-1) * (1 + x) * (1 + x) / n;
            sum += a;
            if (n > 1)
                a *= n - 1;
            n++;
        }
        return sum;
    }

    public float y3f(float x, float e) {
        int n = 1;
        float a = 1;
        float sum = 0;
        while (Math.abs(a) >= e) {
            a *= (-1) * (1 + x) * (1 + x) / n;
            sum += a;
            if (n > 1)
                a *= n - 1;
            n++;
        }
        return sum;
    }

    public void tabPrint(float x, float y1, float y2, float y3, float er1, float er2) {
        System.out.print("|");
        System.out.printf("%.3e", x);
        System.out.print("|");
        System.out.printf("%.3e", y1);
        System.out.print("|");
        System.out.printf("%.3e", y2);
        System.out.print("|");
        System.out.printf("%.3e", y3);
        System.out.print("|");
        System.out.printf("%.3e", er1);
        System.out.print("|");
        System.out.printf("%.3e", er2);
        System.out.print("|");
        System.out.print("\n");
    }

    public void run() {
        Scanner read = new Scanner(System.in);
        float a = -2.0e0f;
        float b = -0.1e0f;
        float h = (b - a) / 40f;
        System.out.print("k = ");
        int k = read.nextInt();     // 40
        System.out.print("e = ");
        float e = read.nextFloat(); // 0.00001->1e-5
        System.out.println("|-----X----|----Y1----|----Y2----|-----Y3---|---ER1---|---ER2---|");
        for (float x = a; x <= b; x += h) {
            float y1 = y1f(x);
            float y2 = y2f(x, k);
            float y3 = y3f(x, e);
            float er1 = Math.abs((y1 - y2) / y1 * 100);
            float er2 = Math.abs((y1 - y3) / y1 * 100);
            tabPrint(x, y1, y2, y3, er1, er2);
        }
    }
}
class Lab1String {

    static boolean check(String a) {
        // перевірка першого символа
        if (!((a.charAt(0) >= 'a' && a.charAt(0) <= 'z') || (a.charAt(0) >= 'A' && a.charAt(0) <= 'Z') || a.charAt(0) == '_'))
            return false;

        // перевірка всіх інших символів
        for (int i = 1; i < a.length(); i++) {
            if (!((a.charAt(i) >= 'a' && a.charAt(i) <= 'z') || (a.charAt(i) >= 'A' && a.charAt(i) <= 'Z') || (a.charAt(i) >= '0' && a.charAt(i) <= '9') || a.charAt(i) == '_'))
                return false;
        }
        // якщо пройшли перевірки
        return true;
    }

    static void checkWrite(boolean a) {
        if (a) {
            System.out.println("Ім'я можна використовувати");
        } else {
            System.out.println("Ім'я неможливо використовувати");
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть ім'я для перевірки:");
        String userInput = scanner.nextLine();

        checkWrite(check(userInput));
    }
}

