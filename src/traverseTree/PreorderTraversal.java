package traverseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null)
			return new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (root != null) {
			stack.push(root);
			list.add(stack.peek().val);
			root = root.left;
			while (root == null && !stack.isEmpty())
				root = stack.pop().right;
		}

		return list;
	}
}
