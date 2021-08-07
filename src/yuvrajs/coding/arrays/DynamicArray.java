/**
 * Declare a 2-dimensional array, n, of  empty arrays. All arrays are zero indexed.
Declare an integer, lastAnswer, and initialize it to zero.

There are  types of queries, given as an array of strings for you to parse:

Query: 1 x y
Let idx = ((x ^ lastAnswer) % n).
Append the integer y to arr[idx].

Query: 2 x y
Let idx = ((x ^ lastAnswer) % n).
Assign the value arr[idx][y % size(arr[idx])] to lastAnswer.
Store the new value of lastAnswer to an answers array.

Function Description

Complete the dynamicArray function below.

dynamicArray has the following parameters:
- int n: the number of empty arrays to initialize in 
- string queries[q]: query strings that contain 3 space-separated integers

Returns

int[]: the results of each type 2 query in the order they are presented

 */

package yuvrajs.coding.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int noOfQueries = sc.nextInt();
		
		List<List<Integer>> queries = new ArrayList<>(noOfQueries);
		
		for(int i=0; i<noOfQueries; i++) {
			List<Integer> query = new ArrayList<>();
			query.add(sc.nextInt());
			query.add(sc.nextInt());
			query.add(sc.nextInt());
			queries.add(query);
		}
		
		List<Integer> finalList = dynamicArray(n, queries);
		
		finalList.stream().forEach(t -> System.out.println(t));
		
		sc.close();

	}

	private static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
		
		List<List<Integer>> inputList = new ArrayList<>(n);
		List<Integer> finalList = new ArrayList<>();
		int lastAnswer = 0;
		
		for(int i=0; i<n; i++) {
			inputList.add(new ArrayList<>());
		}
		
		for(int i=0; i<queries.size(); i++) {
			int queryType = queries.get(i).get(0);
			int x = queries.get(i).get(1);
			int y = queries.get(i).get(2);
			
			if(queryType == 1) {
				int idx = ((x ^ lastAnswer) % n);
				if(inputList.get(idx) != null) {
					inputList.get(idx).add(y);
				} else {
					inputList.set(idx, new ArrayList<>(y));
				}
			} else if(queryType == 2) {
				int idx = ((x ^ lastAnswer) % n);
				lastAnswer = inputList.get(idx).get(y % inputList.get(idx).size());
				finalList.add(lastAnswer);
			}
		}
		
		return finalList;
		
	}

}
