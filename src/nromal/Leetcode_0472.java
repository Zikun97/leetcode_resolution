package nromal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode_0472 {



    /**
     * 官方题解： 排序 + 字典树 + 深度优先搜索
     */

    // todo 可以再做一次

    class Solution {

        class Tire {
            public Tire[] next;
            public boolean isEnd;

            public Tire() {
                next = new Tire[26];
                isEnd = false;
            }
        }

        public Tire root = new Tire();

        public List<String> findAllConcatenatedWordsInADict(String[] words) {

            //  先对words的长度排序
            Arrays.sort(words, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });

            List<String> ans = new ArrayList<>();
            // 遍历每一个string，如果word是复合词，则加入ans，否则加入字典树
            for (String ele : words) {
                if (ele.length() == 0) {
                    continue;
                }
                if (dfs(ele, 0)) {
                    ans.add(ele);
                } else {
                    insert(ele);
                }

            }
            return ans;
        }

        public void insert(String word) {
            Tire node = root;
            for (int i = 0; i < word.length(); ++i) {
                int idx = word.charAt(i) - 'a';
                if (node.next[idx] == null) {
                    node.next[idx] = new Tire();
                }
                node = node.next[idx];
            }
            node.isEnd = true;
        }


        // 这一部分想了半天不知道怎么写，还是基本功不行啊
        public boolean dfs(String words, int start) {
            Tire node = root;
            if (start == words.length()) {
                return true;
            }
            for (int i = start; i < words.length(); ++i) {
                int idx = words.charAt(i) - 'a';
                if (node.next[idx] == null) {
                    return false;
                }
                if (node.next[idx].isEnd) {
                    if (dfs(words, i + 1)) {
                        return true;
                    }
                }
                node = node.next[idx];
            }
            return false;
        }
    }
}
