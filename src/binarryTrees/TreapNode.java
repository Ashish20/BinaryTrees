package binarryTrees;

import java.util.Random;

public class TreapNode {
	
	int val;
	int priority;
	
	TreapNode left;
	TreapNode right;
	
	public TreapNode(int data) {
		
		val = data;
		
		Random rand = new Random();
		priority = rand.nextInt(2000);
		
		left = null;
		right = null;
	}

}
