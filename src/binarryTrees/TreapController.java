package binarryTrees;

import java.util.Random;

public class TreapController {
	
	public static void main(String args[]) {
		
		Treap obj = new Treap();
		
		TreapNode root = null;
		
		int noOfElements = 1000;
		int arr[] = new int[noOfElements];

		for (int k = 0; k < noOfElements; k++) {
			
			Random rand = new Random();
			arr[k] = rand.nextInt(2000);
//			arr[k] = k;
			
		}
		
		System.out.println("======Inserting Elements=======");
		
		long startTime = System.nanoTime();
		for(int i =0; i<arr.length; i++)
			root = obj.insert(root, arr[i]);
		
		long endTime = System.nanoTime();
		System.out.println("Time taken for inserting elements = " + (endTime - startTime));
		System.out.println("======Elements inserted =======");
		
		
		obj.inorder(root);
		System.out.println();
		
		System.out.println("======Searching Elements=======");
		startTime = System.nanoTime();
		for(int i =0; i<arr.length; i++) {
			 TreapNode temp = obj.search(root, arr[i]);
			
			if(temp == null)
			{
				System.out.println("Element " + arr[i] + " Not found");
			}
		}
		
		endTime = System.nanoTime();
		System.out.println("Time taken for searching elements = " + (endTime - startTime));
		
		System.out.println("======Deleting Half elements=======");
		startTime = System.nanoTime();
		for(int i =0; i<arr.length; i+=2)
			root = obj.delete(root, arr[i]);
		
		endTime = System.nanoTime();
		
		System.out.println("Time taken for deleting half elements = " + (endTime - startTime));
		
		obj.inorder(root);
		
	}

}
