/**
 * Function Description

Complete the function arrayManipulation in the editor below.

arrayManipulation has the following parameters:

int n - the number of elements in the array
int queries[q][3] - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k.
Returns

int - the maximum value in the resultant array

 */

package yuvrajs.coding.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayManipulation {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		int querySize = sc.nextInt();
		
		List<List<Integer>> queries = new ArrayList<>(querySize);
		
		for(int i=0; i<querySize; i++) {
			List<Integer> query = new ArrayList<>(3);
			query.add(sc.nextInt());
			query.add(sc.nextInt());
			query.add(sc.nextInt());
			queries.add(query);
		}
		
		sc.close();
		
		System.out.println("Input Queries are : ");
		for(int i=0; i<querySize; i++) {
			queries.get(i).stream().forEach(t -> System.out.print(t + " "));
			System.out.println();
		}
		
		int result = arrayManipulation(size, queries);	
		System.out.println(result);

	}

	private static int arrayManipulation(int size, List<List<Integer>> queries) {
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<size; i++) {
			list.add(0);
		}
		
		for(List<Integer> q : queries) {
			int a = q.get(0)-1;
			int b = q.get(1)-1;
			int k = q.get(2);
			
			list.set(a, list.get(a)+k);
			
			if(b+1 < size) {
				list.set(b+1, list.get(b+1)-k);
			}
		}
		
		int prefixSum = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<list.size(); i++) {
			prefixSum = prefixSum + list.get(i);
			
			if(max < prefixSum) {
				max = prefixSum;
			}
		}
		
		return max;
	}

}
