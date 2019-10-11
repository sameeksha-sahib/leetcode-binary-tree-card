package recusrionSolution;

import java.util.Stack;

public class SymmetricTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode l, r;
		stack.push(root.left);
		stack.push(root.right);
		while (!stack.isEmpty()) {
			r = stack.pop();
			l = stack.pop();
			if (l == null && r == null)
				continue;
			if (l == null || r == null || l.val != r.val)
				return false;
			stack.push(l.left);
			stack.push(r.right);
			stack.push(l.right);
			stack.push(r.left);

		}
		return true;

	}
}
