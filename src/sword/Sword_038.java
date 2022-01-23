package sword;

import javax.swing.*;
import java.util.*;

public class Sword_038 {

    public static void main(String[] args) {
        Solution_a solution = new Solution_a();
        String input = "asfds";
        String[] ans = solution.permutation(input);
        System.out.println(ans.length);
        for (String item : ans) {
            System.out.println(item);
        }

    }

    /**
     * 参考题解写出来代码，回溯+剪枝。
     * 这里借助Set来判别是否存在重复，可以使用排序 or visted数组来判别是否重复。推荐visited数组。
     * 效率不高：65；41
     */
    static class Solution {
        List<String> result = new LinkedList<>();
        char[] chars;
        public String[] permutation(String s) {
            chars = s.toCharArray();
            dfs(0);
            return result.toArray(new String[result.size()]);
        }

        private void dfs(int index) {
            if (index == chars.length - 1) {
                result.add(String.copyValueOf(chars));
                return ;
            }
            Set<Character> set = new HashSet<>();
            for (int i = index; i < chars.length; ++i) {
                if (!set.contains(chars[i])) {
                    set.add(chars[i]);
                    swap(index, i);
                    dfs(index + 1);
                    swap(index, i);
                }
            }
        }

        private void swap(int idx1, int idx2) {
            char temp = chars[idx1];
            chars[idx1] = chars[idx2];
            chars[idx2] = temp;
        }
    }


    /**
     * 使用visited数组来实现剪枝。效率应该更高。
     * 效率： 98.72， 52.12
     */
    static class Solution_a {
        List<String> result = new LinkedList<>();
        char[] chars;
        public String[] permutation(String s) {
            chars = s.toCharArray();
            dfs(0);
            return result.toArray(new String[result.size()]);
        }

        private void dfs(int index) {
            if (index == chars.length - 1) {
                result.add(String.copyValueOf(chars));
                return ;
            }
            // 前面的都一样，这里要改动一下
            // 声明visited数组
            boolean[] visited = new boolean[128];
            for (int i = index; i < chars.length; ++i) {
                if (!visited[(int)chars[i]]) {
                    visited[(int)chars[i]] = true;
                    swap(index, i);
                    dfs(index + 1);
                    swap(index, i);
                }
            }
        }

        private void swap(int idx1, int idx2) {
            char temp = chars[idx1];
            chars[idx1] = chars[idx2];
            chars[idx2] = temp;
        }
    }




}
