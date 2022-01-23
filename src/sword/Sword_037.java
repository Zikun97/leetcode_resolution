package sword;

import javafx.util.Pair;
import java.util.*;

public class Sword_037 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(11);
        Codec_b codec = new Codec_b();
        String data = codec.serialize(root);
        System.out.println(data);
        TreeNode new_root = codec.deserialize(data);
        System.out.println(codec.serialize(new_root));


    }

     static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    /**
     * 自己的做法：讲二叉树作为完全二叉树来处理，占用了大量的空间，导致存储爆炸
     */
    static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return "[]";
            Deque<Pair<Integer, TreeNode>> queue = new LinkedList<>();
            Deque<Pair<Integer, TreeNode>> list = new LinkedList<>();
            queue.add(new Pair<>(1, root));
            while (!queue.isEmpty()) {
                Pair<Integer, TreeNode> temp = queue.pollFirst();
                if (temp.getValue().left != null)
                    queue.addLast(new Pair<>(temp.getKey() * 2, temp.getValue().left));
                if (temp.getValue().right != null)
                    queue.addLast(new Pair<>(temp.getKey() * 2 + 1, temp.getValue().right));
                list.addLast(temp);
            }

            StringBuilder result = new StringBuilder("[");
            int j = 1;
            list.addLast(list.getLast());
            Pair<Integer, TreeNode> temp = list.pollFirst();
            while (!list.isEmpty()) {
                if (j == temp.getKey()) {
                    result.append(temp.getValue().val);
                    temp = list.pollFirst();
                    j++;
                } else {
                    j++;
                    result.append("null");
                }
                result.append(',');
            }
            result.deleteCharAt(result.length() - 1);
            result.append("]");
            return result.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            data = data.substring(1, data.length() - 1);
            if (data.length() == 0)
                return null;
            String[] nodes = data.split(",");
            return getRoot(0, nodes);
        }

        private TreeNode getRoot(int index, String[] nodes) {
            if (index >= nodes.length || nodes[index].equals("null"))
                return null;
            int val = Integer.parseInt(nodes[index]);
            TreeNode temp = new TreeNode(val);
            temp.left = getRoot(index * 2 + 1, nodes);
            temp.right = getRoot(index * 2 + 2, nodes);
            return temp;
        }

    }


    /**
     * leetcode 官方题解： 使用先序遍历完成序列化。
     */
    static class Codec_a {
        public String serialize(TreeNode root) {
            if (root == null) {
                return "X,";
            }
            String s = String.valueOf(root.val) + ",";
            return s + serialize(root.left) + serialize(root.right);
        }

        public TreeNode deserialize(String data) {
            LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
            System.out.println(nodes.size());
            return trueDeserialize(nodes);
        }

        private TreeNode trueDeserialize(List<String> nodes) {
            if (nodes.get(0).equals("X")){
                nodes.remove(0);
                return null;
            }
            int val = Integer.parseInt(nodes.get(0));
            nodes.remove(0);
            TreeNode node = new TreeNode(val);
            node.left = trueDeserialize(nodes);
            node.right = trueDeserialize(nodes);
            return node;
        }
    }


    /**
     *   高手题解： 使用BFS完成序列化
     */

    static class Codec_b {
        public String serialize(TreeNode root) {
            if (root == null)
                return "X,";
            StringBuilder stringBuilder = new StringBuilder();
            LinkedList<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            //  Collections可以添加null元素
            while (!nodes.isEmpty()){
                TreeNode node = nodes.pollFirst();
                if (node == null) {
                    stringBuilder.append("X,");
                } else {
                    stringBuilder.append(node.val);
                    stringBuilder.append(",");

                    nodes.addLast(node.left);
                    nodes.addLast(node.right);
                }
            }
            return stringBuilder.toString();
        }

        public TreeNode deserialize(String data) {
            String[] nodes = data.split(",");
            if (nodes[0].equals("X")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            LinkedList<TreeNode> treeNodes = new LinkedList<>();
            treeNodes.addLast(root);
            int idx = 1;
            while (idx < nodes.length) {
                TreeNode temp = treeNodes.pollFirst();
                if (nodes[idx].equals("X")) {
                    temp.left = null;
                } else {
                    temp.left = new TreeNode(Integer.parseInt(nodes[idx]));
                    treeNodes.addLast(temp.left);
                }
                ++idx;


                if (nodes[idx].equals("X")) {
                    temp.right = null;
                } else {
                    temp.right = new TreeNode(Integer.parseInt(nodes[idx]));
                    treeNodes.addLast(temp.right);
                }
                ++idx;
            }
            return root;
        }
    }


    /**
     * 官方解法：使用了词法分析。算是一种最优解
     */
    // TODO: 2021/6/16 回来再看





}
