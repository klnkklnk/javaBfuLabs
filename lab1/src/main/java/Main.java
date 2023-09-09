import java.util.Scanner;

public class Main {
    public static int getNumberOfSteps()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = sc.nextInt();
        int counter = 0;
        if (number == 1)
        {
            number = 3*number + 1;
            counter++;
        }
        while (number != 1)
        {
            if (number % 2 == 0)
            {
                number /= 2;
            }
            else
            {
                number = 3*number + 1;
            }
            counter++;
        }
        return counter;
    }

    public static int getSumOfSeries()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int amountOfNumbers = sc.nextInt();
        int sumOfSeries = 0;
        for (int i = 0; i < amountOfNumbers; i++)
        {
            if (i % 2 == 0)
            {
                sumOfSeries += sc.nextInt();
            }
            else
            {
                sumOfSeries -= sc.nextInt();
            }
        }
        return sumOfSeries;
    }

    public static void main(String[] args)
    {
        System.out.println("Пункт 1(Сиракузская последовательность):");
        System.out.printf("Потребовалось %d шага/шагов\n\n", getNumberOfSteps());

        System.out.println("Пункт 2(Сумма ряда):");
        System.out.printf("Сумма ряда равна %d\n\n", getSumOfSeries());

        System.out.println("Пункт 3(Ищем клад):");
    }
}
