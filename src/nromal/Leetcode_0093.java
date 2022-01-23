package nromal;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_0093 {

    public static void main(String[] args) {
        List<String> ans = new ArrayList<>(4);
        System.out.println(ans.size());
    }

    /**
     * 题目：复原ip地址
     */
    class Solution {

        List<String> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>(4);

        public List<String> restoreIpAddresses(String s) {
            backTracking(s, 0);
            return ans;
        }

        private void backTracking(String s, int idx) {
            if (temp.size() == 4 && idx == s.length()) {
                StringBuilder sb = new StringBuilder(temp.get(0));
                for (int i = 1; i < temp.size(); ++i) {
                    sb.append('.');
                    sb.append(temp.get(i));
                }
                ans.add(sb.toString());
                return;
            }

            if (s.charAt(idx) == '0') {
                temp.add("0");
                backTracking(s, idx + 1);
                temp.remove(temp.size() - 1);
                return;
            }

            for (int i = idx; i < s.length(); ++i) {
                if (Integer.parseInt(s.substring(idx, i + 1)) <= 255) {
                    temp.add(s.substring(idx, i + 1));
                    backTracking(s, i + 1);
                    temp.remove(temp.size() - 1);
                } else {
                    break;
                }
            }
        }
    }
}
