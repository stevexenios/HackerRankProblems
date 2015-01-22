import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Project_Euler_Plus_Problem_4 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(stdin.nextLine());
		int[] input = new int[numberOfCases];
		for (int a = 0; a < numberOfCases; a++) {
			input[a] = stdin.nextInt();
			if (a != numberOfCases - 1) stdin.nextLine();
		}
		int[] sortedInput = input.clone();
		int[] maxPalindrome = new int[numberOfCases];
		for(int a = 0; a < maxPalindrome.length; a++){
			maxPalindrome[a] = 0;
		}
		Arrays.sort(sortedInput);
		for(int number1 = 100; number1 < 1000; number1++){
			for(int number2 = 100; number2 < 1000; number2++){
				if(number1*number2 > 100000){
					if(isPalindrome(number1*number2 + "")){
						for(int a = 0; a < sortedInput.length; a++){
							if (maxPalindrome[a] < number1*number2 && number1*number2 < sortedInput[a])
								maxPalindrome[a] = number1 * number2;
						}
						
					}
				}
			}
		}
			
		int[] answers = new int[numberOfCases];
		int index = 0;
		for(int a = 0; a < numberOfCases; a++){
			for(int b = 0;  b< numberOfCases; b++){
				if (input[a] == sortedInput[b]){
					index = b;
					break;
				}
			}
			answers[a] = maxPalindrome[index];
		}
		
		for(int a = 0; a < numberOfCases; a++){
			System.out.println(answers[a]);
		}
		
	}
	public static boolean isPalindrome(String input){
		for(int a = 0; a < input.length()/2; a++){
			if (input.charAt(a) != input.charAt(input.length()-a-1)){
				return false;
			}
		}
		return true;
	}
}
