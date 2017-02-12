class Node {
	int val;
	Node left;
	Node right;
	Node (int n) {val = n;}
}

public class CheckBalanced {
	static int getHeight (Node node) {
		if (node == null)
			return -1;
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	static boolean isBalanced (Node node) {
		if (node == null)
			return true;
		if (Math.abs(getHeight(node.left) - getHeight(node.right)) > 1)
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
		System.out.println(isBalanced(root));
	}

	public static void main(String[] args) {
		test();
	}
}