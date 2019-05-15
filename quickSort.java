import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
// Christian Enamorado
//Quick Sort Implementation
//11/26/2018
public class quickSort {
//This assumes the numbers.txt file is format as such " 1, 2, 3, 5, 6, 7"
	
	
	public static void main(String args[]) throws FileNotFoundException{
		
		// If this does not work, then use the next line with the correct file name. That should work.
		String list = args[0];
		//String list = "C:\Users\Christian\eclipse-workspace\QuickSort\src";
		//The algorithm should work, I'm just not sure if my path variables are set correctly
		// to check to see if the first argument is args[0] or args[1]
		
		
		File file = new File(list);
		Scanner console = new Scanner(file);
		ArrayList<Integer> numList = new ArrayList<Integer>();
		
		while(console.hasNext()) {
			String number = console.next();
			if(number.endsWith(",")) {
				number = number.substring(0, number.length()-1);
			}
			int num = Integer.parseInt(number);
			numList.add(num);
		}
		int numList2[] = new int[numList.size()];
		for( int i = 0; i < numList.size(); i++) {
			numList2[i] = numList.get(i);
		}
		System.out.println(Arrays.toString(numList2));
		
		quickSort(numList2, 0, numList2.length - 1);
		System.out.println(Arrays.toString(numList2));
		
		
	} 
	public static void quickSort(int list[], int p, int r) {	
		if( p < r) {
			int q = partition( list, p, r);
			quickSort(list, p, q-1);
			quickSort(list, q+1, r);
		}
	}
	public static int partition(int list[], int startIndex, int endIndex) {
		int x = list[endIndex];
		int partIndex = startIndex;
		int temp = 0;
		for(int j = startIndex; j <= endIndex - 1; j++) {
			if(list[j] <= x) {
				temp = list[partIndex];
				list[partIndex] = list[j];
				list[j] = temp;
				partIndex = partIndex + 1;
			}
		}
		temp = list[partIndex];
		list[partIndex] = list[endIndex];
		list[endIndex] = temp;
		return partIndex;
	}
}
