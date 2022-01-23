package sword;

import com.sun.deploy.security.CredentialManager;

import java.util.Deque;
import java.util.LinkedList;

public class Sword_032_1 {

      static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

      static class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null)
                return new int[]{};
            Deque<TreeNode> list_node = new LinkedList<>();
            Deque<Integer> list_val = new LinkedList<>();
            list_node.add(root);
            TreeNode treeNode;
            while (!list_node.isEmpty()) {
                treeNode = list_node.getFirst();
                list_node.removeFirst();
                if (treeNode.left != null) {
                    list_node.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    list_node.addLast(treeNode.right);
                }
                list_val.add(treeNode.val);
            }
            Integer[] arr = list_val.toArray(new Integer[list_val.size()]);
            int[] res = new int[arr.length];
            for(int i = 0; i < arr.length; i ++)
                res[i] = arr[i];
            return res;
        }
    }
}
