package nromal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode_0235 {

    /***
     * 题目描述：二叉搜索树的最近公共父节点
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Set<TreeNode> pset = new HashSet<>();

            // 查找p的位置
            TreeNode temp = root;
            while (true) {
                pset.add(temp);
                if (temp.val == p.val) {
                    break;
                }
                if (temp.val > p.val) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }

            temp = root;
            TreeNode ans = root;
            while (true) {
                if (pset.contains(temp)) {
                    ans = temp;
                } else {
                    break;
                }

                if (temp.val > q.val) {
                    temp = temp.left;
                } else if (temp.val < q.val){
                    temp = temp.right;
                } else {
                    break;
                }
            }
            return ans;
        }
    }

}
