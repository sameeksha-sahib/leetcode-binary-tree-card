package recusrionSolution;

public class MaximumDepthofBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
	}
}
