class Node {
	int val;
	Node left;
	Node right;
	Node (int n) {val = n;}
	int leftHeight;
	int rightHeight;
}

public class CheckBalanced {
	static int getHeight (Node node) {
		if (node == null)
			return -1;
		node.leftHeight = getHeight(node.left);
		node.rightHeight = getHeight(node.right);
		return 1 + Math.max(node.leftHeight, node.rightHeight);
	}

	static boolean isBalanced (Node node) {
		if (node == null)
			return true;
		if (Math.abs(node.leftHeight - node.rightHeight) > 1)
			return false;
		return (isBalanced(node.left) && isBalanced(node.right));
	}

	static void test() {
		Node root = new Node(0);
		root.left = new Node(1);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.left.right.right = new Node(2);
		getHeight(root);
		System.out.println(isBalanced(root));
	}

	public static void main(String[] args) {
		//new CheckBalanced().test();
		test();
	}
}