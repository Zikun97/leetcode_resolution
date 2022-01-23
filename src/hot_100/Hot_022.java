package hot_100;

import java.util.*;

public class Hot_022 {
    public static void main(String[] args) {
//        String s = "123456";
//        StringBuilder sb = new StringBuilder(s);
//        sb.insert(s.length() - 1, "()");
//        sb.delete(s.length() - 1, s.length() + 1);
//        System.out.println(sb);
        Solution_1 solution = new Solution_1();
        List<String> res = solution.generateParenthesis(8);
        for (String s : res) {
            System.out.println(s);
        }

    }

    // TODO: 2021/3/31 题解前，两种想法：1.插入 2. 迭代生成
    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            if (n == 1) {
                result.add("()");
                return result;
            }

            Set<String> set = new HashSet<>();
            set.add("()");
            Set<String> tempSet = new HashSet<>();
            for (int i = 1; i < n; ++i) {
                tempSet.clear();
                for (String s : set) {
                    StringBuilder sb = new StringBuilder(s);
                    for (int k = 0; k <= s.length(); ++k) {
                        sb.insert(k, "()");
                        tempSet.add(sb.toString());
                        sb.delete(k, k + 2);
                    }
                }
                set.clear();
                set.addAll(tempSet);
            }
            result.addAll(set);

            return result;
        }
    }

    static class Solution_1 {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            generate(res, "", 0, 0, n);
            return res;
        }

        private void generate(List<String> res, String s, int left, int right, int n) {
            if (left > n || right > n) {
                return;
            }
            if (left == n && right == n) {
                res.add(s);
            }
            if (left >= right) {
                generate(res, s + "(", left + 1, right, n);
                generate(res, s + ")", left, right + 1, n);
            }
        }
    }
}
