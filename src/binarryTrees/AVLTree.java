package binarryTrees;

public class AVLTree {

	public AVLNode create(int val) {

		AVLNode node = new AVLNode();

		node.val = val;
		node.left = null;
		node.right = null;

		return node;
	}

	public int getHeight(AVLNode node) {

		if (node == null)
			return 0;

		return node.height;

	}

	public AVLNode leftRotate(AVLNode node) {

		AVLNode rightChild = node.right;
		AVLNode leftGChild = rightChild.left;

		rightChild.left = node;
		node.right = leftGChild;

		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		rightChild.height = Math.max(getHeight(rightChild.left), getHeight(rightChild.right)) + 1;

		return rightChild;
	}

	public AVLNode rightRotate(AVLNode node) {

		AVLNode leftChild = node.left;
		AVLNode rightGChild = leftChild.right;

		leftChild.right = node;
		node.left = rightGChild;

		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		leftChild.height = Math.max(getHeight(leftChild.left), getHeight(leftChild.right)) + 1;

		return leftChild;

	}

	public AVLNode insert(AVLNode node, int val) {

		if (node == null) {
			node = create(val);
			node.height = 1;

			return node;
		}

		if (val < node.val)
			node.left = insert(node.left, val);
		else if (val > node.val)
			node.right = insert(node.right, val);
		else
			return node;

		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

		int balance = 0;

		if (node != null)
			balance = getHeight(node.left) - getHeight(node.right);

		if (balance > 1 && val < node.left.val)
			return rightRotate(node);

		if (balance < -1 && val > node.right.val)
			return leftRotate(node);

		if (balance > 1 && val > node.left.val) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		if (balance < -1 && val < node.right.val) {
			node.right = rightRotate(node.right);
			return leftRotate(node);

		}

		return node;
	}

	public AVLNode findInOrderSucc(AVLNode root) {

		AVLNode curr = root;

		while (curr.left != null) {
			curr = curr.left;
		}

		return curr;

	}
	
	public int getBalance(AVLNode node) {
		
		if(node == null)
			return 0;
		
		return getHeight(node.left) - getHeight(node.right);
		
	}

	public AVLNode delete(AVLNode node, int val) {

		if (node == null)
			return node;

		if (val < node.val)
			node.left = delete(node.left, val);
		else if (val > node.val)
			node.right = delete(node.right, val);

		else {

			if (node.left == null || node.right == null) {

				AVLNode temp = null;

				if (temp == node.left)
					temp = node.right;
				else
					temp = node.left;

				if (temp == null) {
					temp = node;
					node = null;
				} else
					node = temp;

			} else {

				AVLNode temp = findInOrderSucc(node.right);
				
				node.val = temp.val;
				
				node.right = delete(node.right, node.val);

			}

		}
		
		if(node == null)
			return node;
		
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		
		int balance = 0;

		if (node != null)
			balance = getHeight(node.left) - getHeight(node.right);
		
		if (balance > 1 && getBalance(node.left) >=0)
			return rightRotate(node);

		if (balance < -1 && getBalance(node.right) <=0)
			return leftRotate(node);

		if (balance > 1 && getBalance(node.left) < 0) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		if (balance < -1 && getBalance(node.right) > 0) {
			node.right = rightRotate(node.right);
			return leftRotate(node);

		}

		return node;

	}

	public AVLNode search(AVLNode root, int val) {

		if (root == null)
			return null;

		if (root.val == val)
			return root;

		if (val < root.val)
			return search(root.left, val);
		else
			return search(root.right, val);
	}

	public void inorder(AVLNode root) {

		if (root == null)
			return;

		inorder(root.left);
		
		System.out.print(root.val + " ");

		inorder(root.right);

	}

}
