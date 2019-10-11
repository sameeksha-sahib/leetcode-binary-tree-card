package traverseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null)
			return new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (root != null) {
			stack.push(root);
			root = root.left;
			while (root == null && !stack.isEmpty()) {
				list.add(stack.peek().val);
				root = stack.pop().right;
			}
		}

		return list;
	}
}
