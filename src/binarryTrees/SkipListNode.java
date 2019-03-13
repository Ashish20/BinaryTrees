package binarryTrees;

public class SkipListNode {

	int val;

	SkipListNode left;
	SkipListNode right;
	SkipListNode down;
	SkipListNode up;

	public SkipListNode(int val) {

		this.val = val;

		this.left = null;
		this.right = null;
		this.down = null;
		this.up = null;
	}

	public SkipListNode(SkipListNode node) {

		this.val = node.val;

		this.left = null;
		this.right = null;
		this.up = null;
		
		this.down = node;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public SkipListNode getLeft() {
		return left;
	}

	public void setLeft(SkipListNode left) {
		this.left = left;
	}

	public SkipListNode getRight() {
		return right;
	}

	public void setRight(SkipListNode right) {
		this.right = right;
	}

	public SkipListNode getDown() {
		return down;
	}

	public void setDown(SkipListNode down) {
		this.down = down;
	}

	public SkipListNode getUp() {
		return up;
	}

	public void setUp(SkipListNode up) {
		this.up = up;
	}

}
