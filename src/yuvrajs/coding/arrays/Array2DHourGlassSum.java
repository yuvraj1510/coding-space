/**
 * Function Description

Complete the function hourglassSum in the editor below.

hourglassSum has the following parameter(s):

int arr[6][6]: an array of integers
Returns

int: the maximum hourglass sum
Input Format

Each of the  lines of inputs  contains  space-separated integers .

 */

package yuvrajs.coding.arrays;

import java.util.Scanner;

public class Array2DHourGlassSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int rowSize = sc.nextInt();
		int colSize = sc.nextInt();
		
		int input[][] = new int[rowSize][colSize];
		
		
		for(int row=0; row < rowSize; row++) {
			for(int col=0; col < colSize; col++) {
				input[row][col] = sc.nextInt();
			}
		}
		
		printArray(input, rowSize, colSize);
		
		int sum = hourglassSum(input, rowSize, colSize);
		
		System.out.println("OUTPUT SUM is : "+sum);
		sc.close();
		

	}
	
	private static int hourglassSum(int[][] input, int rowSize, int colSize) {
		int sum = Integer.MIN_VALUE;
		
		for(int row = 1; row < rowSize - 1; row++) {
			for(int col = 1; col < colSize -1; col++) {
				int hourGlassSum = getHourGlassSum(input, row, col);
				if(hourGlassSum > sum) {
					sum = hourGlassSum;
				}
			}
		}
		
		return sum;
	}

	private static int getHourGlassSum(int[][] input, int row, int col) {
		printHourGlass(input, row, col);
		return input[row-1][col-1] + input[row-1][col] + input[row-1][col+1]
								   + input[row][col] +
			   input[row+1][col-1] + input[row+1][col] + input[row+1][col+1];
		
	}

	private static void printArray(int input[][], int rowSize, int colSize) {
		
		for(int row=0; row < rowSize; row++) {
			for(int col=0; col < colSize; col++) {
				System.out.print(input[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	private static void printHourGlass(int[][] input, int row, int col) {
		System.out.println();
		System.out.print(input[row-1][col-1] +" "+ input[row-1][col] +" "+ input[row-1][col+1]);
		System.out.println();
		System.out.print("  "+ input[row][col]+"  ");
		System.out.println();
		System.out.print(input[row+1][col-1] +" "+ input[row+1][col] +" "+ input[row+1][col+1]);
		System.out.println();
		
	}

}
