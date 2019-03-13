package binarryTrees;

public class BinarySearchTree {

	public TreeNode create() {

		TreeNode root = new TreeNode();

		root.left = null;
		root.right = null;

		return root;

	}

	public TreeNode insert(TreeNode root, int val) {

		if (root == null) {
			root = create();
			root.val = val;
			return root;
		}

		if (val < root.val)
			root.left = insert(root.left, val);
		else
			root.right = insert(root.right, val);

		return root;
	}

	public TreeNode search(TreeNode root, int val) {

		if (root == null)
			return null;

		if (root.val == val)
			return root;

		if (val < root.val)
			return search(root.left, val);
		else
			return search(root.right, val);

	}

	public void inorder(TreeNode root) {

		if (root == null)
			return;

		inorder(root.left);

		System.out.print(root.val + " ");

		inorder(root.right);

	}

	public Integer findInOrderSucc(TreeNode root) {

		int succValue = root.val;

		while (root.left != null) {

			succValue = root.left.val;
			root = root.left;
		}

		return succValue;

	}

	public TreeNode delete(TreeNode root, int val) {

		if (root == null)
			return null;

		if (val < root.val)
			root.left = delete(root.left, val);
		else if (val > root.val)
			root.right = delete(root.right, val);

		else {

			if (root.left == null) {

				return root.right;

			} else if (root.right == null) {

				return root.left;

			}

			root.val = findInOrderSucc(root.right);

			root.right = delete(root.right, root.val);

		}

		return root;

	}

}
