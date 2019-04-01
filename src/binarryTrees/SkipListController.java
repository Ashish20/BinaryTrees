package binarryTrees;

import java.util.Random;

public class SkipListController {
	
	public static void main(String args[]) {
		
		SkipList obj = new SkipList();
		
		int noOfElements = 1000;
		int arr[] = new int[noOfElements];

		for (int k = 0; k < noOfElements; k++) {
			
			Random rand = new Random();
			arr[k] = rand.nextInt(2000);
//			arr[k] = k;
			
		}
		
		System.out.println("======Inserting elements=======");
		
		long startTime = System.nanoTime();
		for(int i =0; i<arr.length; i++)
			 obj.insert( arr[i]);
		
		long endTime = System.nanoTime();
		System.out.println("Time taken for inserting elements = " + (endTime - startTime));
		System.out.println("======Elements inserted =======");
		
		
		obj.printList();
		System.out.println();
		
		System.out.println("======Searching elements=======");
		startTime = System.nanoTime();
		for(int i =0; i<arr.length; i++) {
			 boolean result = obj.search(arr[i]);
			
			if(result == false)
			{
				System.out.println("Element " + arr[i] + " Nor found");
			}
		}
		
		endTime = System.nanoTime();
		System.out.println("Time taken for searching elements = " + (endTime - startTime));
		
		System.out.println("======Deleting Half elements=======");
		startTime = System.nanoTime();
		for(int i =0; i<arr.length; i+=2)
			obj.delete(arr[i]);
		
		endTime = System.nanoTime();
		
		System.out.println("Time taken for deleting half elements = " + (endTime - startTime));
		
		obj.printList();
	}

}
