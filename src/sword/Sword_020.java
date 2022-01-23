package sword;

import java.util.LinkedList;
import java.util.Queue;

public class Sword_020 {

    public static void main(String[] args) {
        String s = " ";
        Solution solution = new Solution();
        boolean result = solution.isNumber(s);
        System.out.println(result);
    }

    static class Solution {
        public boolean isNumber(String s) {
            if (s.length() == 0 || s == null) {
                return false;
            }

            char[] chars = s.toCharArray();
            int start = 0;
            int end  = chars.length - 1;
            while ( (start < chars.length) && chars[start] == ' ' ) start ++;
            while ((end >=0) && chars[end] == ' ') end--;
            if (start > end)
                return false;

            boolean oneSign = false;
            boolean onePoint = false;
            boolean oneNum = false;
            boolean oneNum_aft = false;
            boolean twoSign = false;
            boolean twoNum = false;
            boolean hasTwoPart = false;
            for (int i = start; i <= end; ++i) {
                if (hasTwoPart) {

                    if (!twoSign) {
                        if (chars[i] == '+' || chars[i] == '-') {
                            twoSign = true;
                        } else if ((int) '0' <= (int) chars[i] && (int) chars[i] <= (int) '9') {
                            twoSign = true;
                            twoNum = true;
                        } else
                            return false;
                    } else {
                        if ((int) '0' <= (int) chars[i] && (int) chars[i] <= (int) '9') {
                            twoNum = true;
                        } else {
                            return false;
                        }
                    }

                } else{
                    if (!oneSign) {
                        if (chars[i] == '+' || chars[i] == '-') {
                            oneSign = true;
                        } else if (chars[i] == '.') {
                            oneSign = true;
                            onePoint = true;
                        } else if ((int) '0' <= (int) chars[i] && (int) chars[i] <= (int) '9') {
                            oneSign = true;
                            oneNum = true;
                        } else {
                            return false;
                        }
                    } else {
                        if ((int) '0' <= (int) chars[i] && (int) chars[i] <= (int) '9') {
                            if (onePoint) {
                                oneNum_aft = true;
                            }
                        } else if (chars[i] == '.') {
                            if (!onePoint) {
                                onePoint = true;
                            } else {
                                return false;
                            }
                        } else if (chars[i] == 'e' || chars[i] == 'E') {
                            hasTwoPart = true;
                        } else {
                            return false;
                        }
                    }

                }
            }
            if (oneNum && (!onePoint || (onePoint && oneNum_aft)) && (!hasTwoPart || (hasTwoPart && twoNum)) ) {
                return true;
            } else {
                return false;
            }
        }

    }

}
