/** Function Description
		1. Complete the function reverseArray in the editor below.
		2. reverseArray has the following parameter(s):
			int A[n]: the array to reverse
			Returns
			int[n]: the reversed array 
*/


package yuvrajs.coding.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDS {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		int input[] = new int[size];
		
		for(int i=0; i<size; i++) {
			input[i] = sc.nextInt();
		}
		
		System.out.println("Before Reverse :");
		printArray(input);
		
		reverseArray(input);
		
		System.out.println("After Reverse : ");
		printArray(input);
		
		sc.close();

	}
	
	private static void reverseArray(int[] input) {
		
		int start = 0;
		int end = input.length - 1;
		
		while(start < end) {
			int temp = input[start];
			input[start] = input[end];
			input[end] = temp;
			start++;
			end--;
		}
		
		
	}

	private static void printArray(int input[]) {
		Arrays.stream(input).forEach(n -> System.out.print(n + " "));
	}

}
