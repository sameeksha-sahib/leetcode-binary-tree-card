package conclusion;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingPointers_I {

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
		if (root == null)
			return null;
		if (root.left == null && root.right == null) {
			return root;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(root.left);
		q.add(root.right);
		int level = 0, j;
		Node tmp = root, l = root, r = root;
		while (!q.isEmpty()) {
			j = 1 << level;
			for (int i = 0; i <= j; ++i) {
				if (i == j) {
					r.next = null;
					break;
				}
				l = q.poll();
				if (i > 0)
					tmp.next = l;
				r = q.poll();
				tmp = r;
				l.next = r;
				if (l.left != null) {
					q.add(l.left);
					q.add(l.right);
					q.add(r.left);
					q.add(r.right);
				}
			}
			++level;
		}
		return root;
	}
}
