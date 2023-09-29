import java.util.Scanner;

public class Main
{
	public static boolean isAnagram (String firstString, String secondString)
	{
		if (firstString.length() != secondString.length())
		{
			return false;
		}
		int lengthOfString = firstString.length();
		
		for (int i = 0; i < lengthOfString; i++)
		{
			if (firstString.charAt(i) != secondString.charAt(lengthOfString-i-1))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите номер 1-ую и 2-ую строки: \n");
		System.out.printf("Строки %s анаграммой", isAnagram(sc.next(), sc.next())? "являются" : "не являются");
	}
}