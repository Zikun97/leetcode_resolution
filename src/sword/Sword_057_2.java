package sword;

import com.sun.xml.internal.ws.transport.http.HttpAdapter;

import java.util.LinkedList;
import java.util.List;

public class Sword_057_2 {


    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        solution.findContinuousSequence(9);
    }

    static class Solution {
        public int[][] findContinuousSequence(int target) {
            List<List<Integer>> res = new LinkedList<>();
            List<Integer> temp = new LinkedList<>();
            int n = (int)Math.sqrt(target);
            for (int i = 2; i <= n; ++i) {
                if (target % i == 0) {
                    int a = target / i;
                    if (a < 2 || (i == 2 && a == 2 ) || ((a & 1)==0 && ((i & 1) == 0)))
                        continue;
                    if ((a & 1) == 0) {
                        int end =  i / 2 + a / 2 + 1 ;
                        for (int k = end - a; k < end; k++) {
                            temp.add(k);
                        }
                    } else if ((i & 1) == 0) {
                        int end = a / 2 + i / 2 + 1;
                        for (int k = end - i; k < end; k++) {
                            temp.add(k);
                        }
                    } else {

                    }
                }
            }

            return new int[][]{{}};
        }
    }


    static class Solution_1 {
        public int[][] findContinuousSequence(int target) {
            List<int[]> result = new LinkedList<>();
            int l = 1, r = 2;
            while (l < r) {
                System.out.println("l:" + String.valueOf(r));
                int sum = (r + l) * (r - l + 1) / 2;
                if (sum == target) {
                    int[] temp = new int[r - l + 1];
                    int index = 0;
                    for (int i = l; i <= r; ++i) {
                        temp[index++] = i;
                    }
                    result.add(temp);
                    ++l;
                } else if (sum < target) {
                    ++r;
                } else {
                    ++l;
                }
            }
            return result.toArray(new int[result.size()][]);
        }
    }
}

