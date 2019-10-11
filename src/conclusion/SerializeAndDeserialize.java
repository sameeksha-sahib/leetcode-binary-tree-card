package conclusion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return "N";
		if (root.left == null && root.right == null)
			return root.val + ",N,N";

		return serialize(new StringBuilder(), root).toString();
	}

	public StringBuilder serialize(StringBuilder sb, TreeNode root) {
		if (root == null)
			return sb.append("N,");
		sb.append(root.val + ",");
		serialize(sb, root.left);
		serialize(sb, root.right);

		return sb;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.equals("N"))
			return null;
		return deserialize(new LinkedList<>(Arrays.asList(data.split(","))));
	}

	public TreeNode deserialize(Queue<String> q) {
		String val = q.poll();
		if (val.equals("N"))
			return null;
		TreeNode root = new TreeNode(Integer.valueOf(val));
		root.left = deserialize(q);
		root.right = deserialize(q);

		return root;
	}

}
