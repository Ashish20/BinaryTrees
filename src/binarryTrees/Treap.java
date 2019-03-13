package binarryTrees;

public class Treap {

	public TreapNode create(int val) {

		TreapNode root = new TreapNode(val);

		root.left = null;
		root.right = null;

		return root;

	}

	public TreapNode leftRotate(TreapNode root) {

		TreapNode rightChild = root.right;
		TreapNode leftGChild = rightChild.left;

		rightChild.left = root;
		root.right = leftGChild;

		return rightChild;

	}

	public TreapNode rightRotate(TreapNode root) {

		TreapNode leftChild = root.left;
		TreapNode rightGChild = leftChild.right;

		leftChild.right = root;
		root.left = rightGChild;

		return leftChild;

	}

	public TreapNode insert(TreapNode root, int val) {

		if (root == null) {
			root = create(val);
			return root;
		}

		if (val <= root.val) {

			root.left = insert(root.left, val);

			if (root.left.priority < root.priority)
				root = rightRotate(root);

		} else {
			root.right = insert(root.right, val);

			if (root.right.priority < root.priority)
				root = leftRotate(root);

		}

		return root;

	}

	public TreapNode search(TreapNode root, int val) {

		if (root == null)
			return null;

		if (root.val == val)
			return root;

		if (val < root.val)
			return search(root.left, val);
		else
			return search(root.right, val);

	}

	public TreapNode delete(TreapNode root, int val) {

		if (root == null)
			return root;

		if (val < root.val)
			root.left = delete(root.left, val);
		else if (val > root.val)
			root.right = delete(root.right, val);
		else {

			if (root.left == null || root.right == null) {

				TreapNode temp = null;

				if (temp == root.left)
					temp = root.right;
				else
					temp = root.left;

				if (temp == null) {
					temp = root;
					root = null;
				} else
					root = temp;
			} else {
				
				if(root.left.priority < root.right.priority) {
					
					root = leftRotate(root);
					root.left = delete(root.left, val);
				}else {
					
					root = rightRotate(root);
					root.right = delete(root.right, val);
				}
			}
		}
		
		return root;

	}

	public void inorder(TreapNode root) {

		if (root == null)
			return;
		
		inorder(root.left);

		System.out.print("Root - " + root.val + " ");
		System.out.print("(" + root.priority + ") -->");

		if (root.left != null)
			System.out.print(" Left - " + root.left.val + "(" + root.left.priority + ")");

		if (root.right != null)
			System.out.print(" Right - " + root.right.val + "(" + root.right.priority + ")");

		System.out.println();

		inorder(root.right);

	}

}
