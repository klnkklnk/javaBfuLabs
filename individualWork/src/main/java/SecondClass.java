import java.util.Scanner;

public class SecondClass
{
	public static int sumOfElemets(int[][] matrix)
	{
		int sum = 0;
		
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				sum += matrix[i][j];
			}
		}
		return sum;
	}
	
	public static int[][] copyOfMatrix(int[][] matrix, int numbersOfRows, int numbersOfColumns)
	{
		int iOfResult = 0;
		int jOfResult = 0;
		int[][] resultMatrix= new int[numbersOfRows][numbersOfColumns];
		for (int i = 0; i < matrix.length; i++)
		{
			if (i <= numbersOfRows - 1)
			{
				for (int j = 0; j < matrix[0].length; j++)
				{
					if (j <= numbersOfColumns - 1)
					{
						resultMatrix[iOfResult][jOfResult] = matrix[i][j];
						jOfResult++;
					}
				}
				jOfResult = 0;
				iOfResult++;
			}
		}
		return resultMatrix;
	}
	
	public static int[][] maxSumOfElemets(int[][] matrix)
	{
		int sum = sumOfElemets(matrix);
		int[][] temp = matrix;
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				if (sum < sumOfElemets(copyOfMatrix(matrix, i + 1, j + 1)))
				{
					temp = copyOfMatrix(matrix, i + 1, j + 1);
					sum = sumOfElemets(copyOfMatrix(matrix, i + 1, j + 1));
				}
			}
		}
		return temp;
	}
	
	public static void printMatrix(int[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				System.out.printf("\t %d",matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int[][] readMatrix()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите кол-во строк и столбцов: ");
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] matrix = new int[n][m];
		
		System.out.println("Введите матрицу: ");
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				matrix[i][j] = sc.nextInt();
			}
		}
		return matrix;
	}
	
	public static void main(String[] args)
	{
		int[][] matrix = {
				{3, 2, 1},
				{1, 2, -4},
		};
		/*int[][] matrix = readMatrix();*/
		System.out.println("Итоговая матрица:");
		printMatrix(maxSumOfElemets(matrix));
	}
}
