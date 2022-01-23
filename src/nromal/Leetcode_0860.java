package nromal;

public class Leetcode_0860 {

    /**
     * 题目：柠檬水找零
     */


    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int fives = 0;
            int tens = 0;
            for (int ele : bills) {
                if (ele == 5) {
                    ++fives;
                } else if (ele == 10) {
                    if (fives > 0) {
                        --fives;
                        ++tens;
                    } else {
                        return false;
                    }
                } else {
                    int all = 15;
                    if (tens > 0) {
                        all = 5;
                        --tens;
                    }
                    if (all == 15) {
                        if (fives >= 3) {
                            fives -= 3;
                        } else {
                            return false;
                        }
                    } else {
                        if (fives > 0) {
                            --fives;
                        } else {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
}
