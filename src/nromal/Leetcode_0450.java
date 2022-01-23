package nromal;

public class Leetcode_0450 {


    /**
     * 题目：删除二叉树的某个点
     *
     */

    /**
     * 删除一个点，可以改变值，不一定要真正删除它！
     */
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            TreeNode temp = root;
            TreeNode father = root;
            while (true) {
                if (temp == null) {
                    return root;
                }
                if (temp.val == key) {
                    break;
                }
                if (temp.val > key) {
                    father = temp;
                    temp = temp.left;
                } else {
                    father = temp;
                    temp = temp.right;
                }
            }
            boolean isLeft = false;
            if (father.left == temp) {
                isLeft = true;
            }

            // 如果节点是叶子节点
            if (temp.left == null && temp.right == null) {
                if (root == temp) {
                    return null;
                }
                if (isLeft) {
                    father.left = null;
                } else {
                    father.right = null;
                }
                return root;
            }

            // 左子树的最右节点
            if (temp.left != null) {
                TreeNode rightNode = temp.left;
                TreeNode fatherNode = temp.left;
                while (rightNode.right != null) {
                    fatherNode = rightNode;
                    rightNode = rightNode.right;
                }
                // 树的最右节点不一定是叶子节点！！！！！！！！！！！！！！！！！！！！！
                fatherNode.right = rightNode.left;
                if (fatherNode != rightNode) {
                    rightNode.left = temp.left;
                }
                rightNode.right = temp.right;
                if (isLeft) {
                    father.left = rightNode;
                } else {
                    father.right = rightNode;
                }
                if (root == temp) {
                    return rightNode;
                }
                return root;
            }

            // 右子树的最做节点
            if (temp.right != null) {
                TreeNode leftNode = temp.right;
                TreeNode fatherNode = temp.right;
                while (leftNode.left != null) {
                    fatherNode = leftNode;
                    leftNode = leftNode.left;
                }
                fatherNode.left = leftNode.right;
                if (fatherNode != leftNode) {
                    leftNode.right = temp.right;
                }
                if (isLeft) {
                    father.left = leftNode;
                } else {
                    father.right = leftNode;
                }
                if (root == temp) {
                    return leftNode;
                }
            }

            return root;

        }
    }

    /**
     * 官方解法
     */
    class Solution0 {
        /*
        One step right and then always left
        */
        public int successor(TreeNode root) {
            root = root.right;
            while (root.left != null) root = root.left;
            return root.val;
        }

        /*
        One step left and then always right
        */
        public int predecessor(TreeNode root) {
            root = root.left;
            while (root.right != null) {
                root = root.right;
            }
            return root.val;
        }

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;

            // delete from the right subtree
            if (key > root.val) root.right = deleteNode(root.right, key);
                // delete from the left subtree
            else if (key < root.val) root.left = deleteNode(root.left, key);
                // delete the current node
            else {
                // the node is a leaf
                if (root.left == null && root.right == null) root = null;
                    // the node is not a leaf and has a right child
                else if (root.right != null) {
                    root.val = successor(root);
                    root.right = deleteNode(root.right, root.val);
                }
                // the node is not a leaf, has no right child, and has a left child
                else {
                    root.val = predecessor(root);
                    root.left = deleteNode(root.left, root.val);
                }
            }
            return root;
        }
    }

}
