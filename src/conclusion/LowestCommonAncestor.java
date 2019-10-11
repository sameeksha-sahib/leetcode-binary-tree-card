package conclusion;

import java.util.HashMap;

public class LowestCommonAncestor {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	HashMap<TreeNode, TreeNode> pMap = new HashMap<TreeNode, TreeNode>();
	boolean isFound = false;
	TreeNode pParent, child;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if ((p != null && root.val == p.val) || (q != null && root.val == q.val))
			return root;
		if (root.left == null && root.right == null)
			return null;
		pMap.put(root, null);
		fillParentMap(root);

		isChildOf(p, q);
		if (isFound)
			return p;
		isChildOf(q, p);
		if (isFound)
			return q;
		pParent = pMap.get(p);
		child = p;
		while (!isFound) {
			while (pParent.left == null || pParent.right == null) {
				child = pParent;
				pParent = pMap.get(pParent);
			}

			if (pParent.left.val == child.val)
				isChildOf(pParent.right, q);
			else
				isChildOf(pParent.left, q);
			if (!isFound) {
				child = pParent;
				pParent = pMap.get(pParent);
			}
		}

		return pParent;
	}

	public void fillParentMap(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;
		if (root.left != null) {
			pMap.put(root.left, root);
			fillParentMap(root.left);
		}
		if (root.right != null) {
			pMap.put(root.right, root);
			fillParentMap(root.right);
		}
	}

	public void isChildOf(TreeNode p, TreeNode q) {
		if (p == null)
			return;
		if (p.val == q.val) {
			isFound = true;
			return;
		}
		if (p.left == null && p.right == null)
			return;
		isChildOf(p.left, q);
		isChildOf(p.right, q);
	}

}
