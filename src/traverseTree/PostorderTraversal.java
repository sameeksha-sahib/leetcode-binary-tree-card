package traverseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		if (root == null)
			return new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(null);

		while (root != null) {
			if (root.left != null) {
				stack.push(root);
				root = root.left;
			} else if (root.right != null) {
				stack.push(root);
				root = root.right;
			} else {
				list.add(root.val);
				root = stack.pop();
				if (root != null) {
					if (root.left != null)
						root.left = null;
					else
						root.right = null;
				}
			}
		}

		return list;
	}

}
