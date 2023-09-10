import java.util.Scanner;

public class Number {
    int number;

    public Number()
    {
        boolean check;
        int numberOfDigits = 0;
        Scanner sc = new Scanner(System.in);
        this.number = sc.nextInt();
        int tmp = this.number;
        while (tmp != 0)
        {
            numberOfDigits++;
            tmp /= 10;
        }
        if (numberOfDigits == 3)
        {
            if (isDoubleEvenFunc(getSumOfDigits(this.number), getMultiplicationOfDigits(this.number)))
            {
                System.out.print("Число является дважды чётным");
            }
            else
            {
                System.out.print("Число не является дважды чётным");
            }
        }
        else
        {
            System.out.print("Число не является трёхзначным. Проверка невозможна!");
        }
    }
    public static int getSumOfDigits(int number)
    {
        int sum = 0;
        while (number != 0)
        {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
    public static int getMultiplicationOfDigits(int number)
    {
        int mult = 1;
        while (number != 0)
        {
            mult *= number % 10;
            number /= 10;
        }
        return mult;
    }
    public static boolean isDoubleEvenFunc(int sum, int mult)
    {
        return mult == sum;
    }
}
