package binarryTrees;

import java.util.ArrayList;
import java.util.List;

public class SkipList {

	SkipListNode min;
	SkipListNode max;

	public SkipList() {

		this.min = new SkipListNode(Integer.MIN_VALUE);
		this.max = new SkipListNode(Integer.MAX_VALUE);

		this.min.setRight(max);
		this.max.setLeft(min);

	}

	private boolean getProbability() {

		if (Math.random() >= 0.5)
			return true;

		return false;
	}

	private void createNewLevel() {

		SkipListNode newMin = new SkipListNode(Integer.MIN_VALUE);
		SkipListNode newMax = new SkipListNode(Integer.MAX_VALUE);

		newMin.right = newMax;
		newMax.left = newMin;

		this.min.up = newMin;
		newMin.down = this.min;

		this.max.up = newMax;
		newMax.down = this.max;

		this.min = newMin;
		this.max = newMax;

	}

	public void insert(int data) {

		SkipListNode newNode = null;

		SkipListNode currNode = this.min;
		List<SkipListNode> nodesToUpdate = new ArrayList<>();

		while (currNode != null) {

			while (currNode.right != null && data > currNode.right.val) {
				currNode = currNode.right;
			}

			nodesToUpdate.add(currNode);
			currNode = currNode.down;
		}

		int level = 0;

		while (level == 0 || getProbability()) {

			if (newNode == null) {
				newNode = new SkipListNode(data);
			} else {
				newNode = new SkipListNode(newNode);
			}

			SkipListNode nodeToBeUpdated = null;

			if (nodesToUpdate.size() <= level) {

				createNewLevel();
				nodeToBeUpdated = this.min;

			} else {

				nodeToBeUpdated = nodesToUpdate.get(nodesToUpdate.size() - level - 1);
			}

			newNode.right = nodeToBeUpdated.right;
			newNode.left = nodeToBeUpdated;

			newNode.right.left = newNode;
			nodeToBeUpdated.right = newNode;

			++level;

		}
	}

	public boolean search(int key) {

		SkipListNode currNode = this.min;

		int level = 0;
		while (currNode != null) {

//			System.out.print("Level " + level + " - ");
			while (currNode.right != null && key >= currNode.right.val) {

				currNode = currNode.right;

			}
			if (currNode.val == key)
				return true;
//			System.out.println();
			currNode = currNode.down;
			++level;
		}

		return false;	

	}

	public boolean delete(int key) {

		SkipListNode currNode = this.min;
		List<SkipListNode> nodesToUpdate = new ArrayList<>();

		while (currNode != null) {

			while (currNode.right != null && key > currNode.right.val) {
				currNode = currNode.right;
			}

			if (key == currNode.right.val)
				nodesToUpdate.add(currNode);

			currNode = currNode.down;
		}

		if (nodesToUpdate.size() == 0)
			return false;

		for (SkipListNode node : nodesToUpdate) {

			SkipListNode nodeToDel = node.right;

			node.right = nodeToDel.right;
			nodeToDel.right.left = node;

			nodeToDel.up = null;
			nodeToDel.down = null;
		}

		return true;

	}

	public void printList() {

		SkipListNode currNode = this.min;

		int level = 0;
		while (currNode != null) {

			System.out.print("Level " + level + " - ");
			SkipListNode currLevel = currNode;
			while (currLevel.right != null) {

				if (currLevel.val != Integer.MIN_VALUE && currLevel.val != Integer.MAX_VALUE)
					System.out.print(" " + currLevel.val);

				currLevel = currLevel.right;
			}
			System.out.println();
			currNode = currNode.down;
			++level;
		}
	}

}
