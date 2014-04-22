/*
 * 
 */
import java.util.Scanner;

public class EditDistance {
	
	public static boolean editDistance(String str1,String str2) {
		//initialize the dynamic table
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i <= str1.length(); i++)
			dp[i][0] = i;
		for (int j = 1; j <= str2.length(); j++)
			dp[0][j] = j;
 
		for (int i = 1; i <= str1.length(); i++)
			for (int j = 1; j <= str2.length(); j++)
				dp[i][j] = minimum(
						dp[i - 1][j] + 1,
						dp[i][j - 1] + 1,
						dp[i - 1][j - 1]+ ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1));
 
		if (dp[str1.length()][str2.length()]<=1){
			return true;
		}
		else {
			return false;
		}
	}
	
	private static int minimum(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

	
	public static void main(String[] args) {
		
		System.out.println("Please Enter the Strings for chkec:");				
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		System.out.println(editDistance(s1,s2));
	}
}
