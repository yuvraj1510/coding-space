package yuvrajs.coding.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class RotateDAmountLeft {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int d = sc.nextInt();
		int input[] = new int[n];
 		
		
		for(int i=0; i<n; i++) {
			input[i] = sc.nextInt();
		}
		
		reverseArray(input, 0, d-1);
		reverseArray(input, d, n-1);
		reverseArray(input, 0, n-1);
		
		System.out.println();
		Arrays.stream(input).forEach(t -> System.out.print(t + " "));
		
		sc.close();
		
	}
	
	private static void reverseArray(int input[], int start, int end) {
		System.out.println("Start : "+start+" End - "+end);
		while(start < end) {
			int temp = input[start];
			input[start] = input[end];
			input[end] = temp;
			start++;
			end--;
		}
		System.out.println();
		Arrays.stream(input).forEach(t -> System.out.print(t + " "));
	}

}
