import java.util.Scanner;

public class Main {
    public static int getNumberOfSteps(int n)
    {
        int counter = 0;
        if (n == 1)
        {
            n = 3*n + 1;
            counter++;
        }
        while (n != 1)
        {
            if (n % 2 == 0)
            {
                n /= 2;
            }
            else
            {
                n = 3*n + 1;
            }
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getNumberOfSteps(sc.nextInt()));
    }
}
