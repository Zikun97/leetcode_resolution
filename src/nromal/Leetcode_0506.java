package nromal;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode_0506 {

    public static void main(String[] args) {

    }

    /**
     * 朴素做法，有点想复杂了
     */
    class Solution {
        public String[] findRelativeRanks(int[] score) {
            int[][] docker = new int[score.length][2];
            for (int i = 0; i < docker.length; ++i) {
                docker[i][0] = score[i];
                docker[i][1] = i;
            }

            Arrays.sort(docker, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });

            for (int i = 0; i < docker.length; ++i) {
                docker[i][0] = i;
            }

            Arrays.sort(docker, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });

            String[] rank = new String[score.length];
            for (int i = 0; i < score.length; ++i) {
                if (docker[i][0] == 0) {
                    rank[i] = "Gold Medal";
                } else if (docker[i][0] == 1) {
                    rank[i] = "Silver Medal";
                } else if (docker[i][0] == 2) {
                    rank[i] = "Bronze Medal";
                } else {
                    rank[i] = String.valueOf(docker[i][0] + 1);
                }
            }
            return rank;
        }

    }


    class Solution_0 {
        public String[] findRelativeRanks(int[] score) {
            int[][] docker = new int[score.length][2];
            for (int i = 0; i < docker.length; ++i) {
                docker[i][0] = score[i];
                docker[i][1] = i;
            }

            Arrays.sort(docker, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });

            String[] rank = new String[score.length];
            for (int i = 0; i < score.length; ++i) {
                if (i == 0) {
                    rank[docker[i][1]] = "Gold Medal";
                } else if (i == 1) {
                    rank[docker[i][1]] = "Silver Medal";
                } else if (i == 2) {
                    rank[docker[i][1]] = "Bronze Medal";
                } else {
                    rank[docker[i][1]] = String.valueOf(i + 1);
                }
            }
            return rank;
        }

    }
}
