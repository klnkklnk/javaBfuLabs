import java.util.*;

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

    public static int[] getMaxHeight()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество дорог: ");
        int amountOfRoads = sc.nextInt();
        int amountOfTunnels;
        List<int[]> arrayOfRoads = new ArrayList<>();
        int[] minOfRoads = new int[amountOfRoads];
        Arrays.fill(minOfRoads, Integer.MAX_VALUE);
        int numberOfRoad = 0;
        for (int i = 0; i < amountOfRoads; i++)
        {
            System.out.printf("Введите количество туннелей и высоту этих туннелей на %d-й дороге: ", (i+1));
            amountOfTunnels = sc.nextInt();
            arrayOfRoads.add(new int[amountOfTunnels]);
            for (int j = 0; j < amountOfTunnels; j++)
            {
                arrayOfRoads.get(i)[j] = sc.nextInt();
                if (arrayOfRoads.get(i)[j] < minOfRoads[i])
                {
                    minOfRoads[i] = arrayOfRoads.get(i)[j];
                }
            }
            if (minOfRoads[i] > minOfRoads[numberOfRoad])
            {
                numberOfRoad = i;
            }
        }
        return new int[] {numberOfRoad, minOfRoads[numberOfRoad]};
    }

    public static void main(String[] args)
    {
        System.out.println("Пункт 1(Сиракузская последовательность):");
        System.out.printf("Потребовалось %d шага/шагов\n\n", getNumberOfSteps());

        System.out.println("Пункт 2(Сумма ряда):");
        System.out.printf("Сумма ряда равна %d\n\n", getSumOfSeries());

        System.out.println("Пункт 3(Ищем клад):");
        System.out.printf("Минимальное кол-во инструкций: %d\n\n", getNumberOfInstructions());

        System.out.println("Пункт 4(Логистический максимин):");
        int[] arrayOfAnswer = getMaxHeight();
        System.out.printf("Номер дороги: %d \t Максимальная высота: %d\n\n", (arrayOfAnswer[0]+1), arrayOfAnswer[1]);
    }
}
