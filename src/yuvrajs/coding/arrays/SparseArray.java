/**
 * Complete the function matchingStrings in the editor below. The function must return an array of integers representing the frequency of occurrence of each query string in strings.

matchingStrings has the following parameters:

string strings[n] - an array of strings to search
string queries[q] - an array of query strings
Returns

int[q]: an array of results for each query

 */


package yuvrajs.coding.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SparseArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int noOfStrings = sc.nextInt();
		int noOfQueryStrings = sc.nextInt();
		
		List<String> strings = new ArrayList<>(noOfStrings);
		List<String> queries = new ArrayList<>(noOfQueryStrings);
		
		for(int i=0; i<noOfStrings; i++) {
			strings.add(sc.next());
		}
		
		for(int i=0; i<noOfQueryStrings; i++) {
			queries.add(sc.next());
		}
		
		printList(strings);
		printList(queries);
		sc.close();
		
		List<Integer> results = matchingStrings(strings, queries); 
		printList(results);
	}
	
	private static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
		
		Map<String, Integer> stringToCountMap = new HashMap<>();
		
		for(String s : strings) {
			stringToCountMap.put(s, stringToCountMap.get(s) != null ? stringToCountMap.get(s) + 1 : 1);
		}
		
		List<Integer> results = new ArrayList<>(queries.size());
	
		for(String q : queries) {
			if(stringToCountMap.containsKey(q)) {
				results.add(stringToCountMap.get(q));
			} else {
				results.add(0);
			}
		}
		
		return results;
	}

	private static <T> void printList(List<T> input) {
		System.out.println();
		input.stream().forEach(t -> System.out.print(t + " "));
	}

}
