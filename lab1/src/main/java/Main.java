import java.util.Objects;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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

    private static int getNumberOfInstructions()
    {
        Scanner sc = new Scanner(System.in);
        String instruction = "";
        int x = 0, y = 0;
        int numberOfInstructions = 0;
        List<String> listOfDirections = new ArrayList<>();
        List<Integer> listOfSteps = new ArrayList<>();

        System.out.println("Введите координаты клада:");
        int xOfTreasure = sc.nextInt();
        int yOfTreasure = sc.nextInt();

        System.out.println("Введите инструкции карты(направление - кол-во шагов):");
        while (!Objects.equals(instruction, "стоп"))
        {
            instruction = sc.next();
            if (Objects.equals(instruction, "стоп"))
            {
                break;
            }
            listOfDirections.add(instruction);
            listOfSteps.add(sc.nextInt());
        }

        for (int i = 0; i < listOfDirections.size(); i++)
        {
            if (x == xOfTreasure && y == yOfTreasure)
            {
                break;
            }
            switch (listOfDirections.get(i))
            {
                case ("север"):
                    y += listOfSteps.get(i);
                    break;
                case ("юг"):
                    y -= listOfSteps.get(i);
                    break;
                case ("восток"):
                    x += listOfSteps.get(i);
                    break;
                case ("запад"):
                    x -= listOfSteps.get(i);
                    break;
            }
            numberOfInstructions++;
        }
        return numberOfInstructions;
    }

    public static void main(String[] args)
    {
        System.out.println("Пункт 1(Сиракузская последовательность):");
        System.out.printf("Потребовалось %d шага/шагов\n\n", getNumberOfSteps());

        System.out.println("Пункт 2(Сумма ряда):");
        System.out.printf("Сумма ряда равна %d\n\n", getSumOfSeries());

        System.out.println("Пункт 3(Ищем клад):");
        System.out.printf("Минимальное кол-во инструкций: %d\n\n", getNumberOfInstructions());
    }
}
