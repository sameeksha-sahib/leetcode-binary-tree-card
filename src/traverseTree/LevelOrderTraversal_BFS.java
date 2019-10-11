package traverseTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal_BFS {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	@SuppressWarnings("serial")
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<List<Integer>>();
		List<List<Integer>> ls = new ArrayList<List<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode tmp = new TreeNode(0);

		q.add(root);
		ls.add(new ArrayList<Integer>() {
			{
				add(root.val);
			}
		});
		int level = 0;

		while (!q.isEmpty()) {
			List<Integer> list = new ArrayList<Integer>();
			level = q.size();
			for (int i = 0; i < level; ++i) {
				tmp = q.poll();
				if (tmp != null) {
					if (tmp.left != null) {
						q.add(tmp.left);
						list.add(tmp.left.val);
					}
					if (tmp.right != null) {
						list.add(tmp.right.val);
						q.add(tmp.right);
					}
				}
			}
			ls.add(list);
		}

		ls.remove(ls.size() - 1);
		return ls;
	}
}
