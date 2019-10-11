package conclusion;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingPointers_II {

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};

	public Node connect(Node root) {
		if (root == null || (root.left == null && root.right == null))
			return root;

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int j;
		Node n1 = root, n2 = root;
		while (!q.isEmpty()) {
			j = q.size();
			for (int i = 0; i <= j; ++i) {
				if (i == j) {
					n2.next = null;
					break;
				}
				n1 = q.poll();
				if (i > 0) {
					n2.next = n1;
				}

				n2 = n1;
				if (n1.left != null)
					q.add(n1.left);
				if (n1.right != null)
					q.add(n1.right);
			}
		}
		return root;
	}
}
