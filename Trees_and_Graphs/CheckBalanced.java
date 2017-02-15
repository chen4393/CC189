class Node {
	int val;
	Node left;
	Node right;
	Node (int n) {val = n;}
}

public class CheckBalanced {
	static int getHeight(Node node) {
		if (node == null)
			return -1;
		int leftHeight = getHeight(node.left);
		if (leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		int rightHeight = getHeight(node.right);
		if (rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		int heightDiff = Math.abs(leftHeight - rightHeight);
		if (heightDiff > 1)
			return Integer.MIN_VALUE;
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	static boolean isBalanced (Node node) {
		return (getHeight(node) != Integer.MIN_VALUE);
	}

	static void test() {
		Node root = new Node(0);
		root.left = new Node(1);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.left.right.right = new Node(2);
		System.out.println(isBalanced(root));
	}

	public static void main(String[] args) {
		test();
	}
}