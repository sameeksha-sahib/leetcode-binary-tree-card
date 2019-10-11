package recusrionSolution;

public class PathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null) {
			return root.val == sum;
		}

		return helper(root.left, root.val, sum) || helper(root.right, root.val, sum);
	}

	public boolean helper(TreeNode root, int pre, int sum) {
		if (root == null)
			return false;
		int cur = pre + root.val;
		if (root.right == null && root.left == null) {
			return cur == sum;
		}

		return helper(root.left, cur, sum) || helper(root.right, cur, sum);
	}
}
