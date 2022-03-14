package nromal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_0658 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        [1,1,2,3,3,3,4,6,8,8]
//        6
//        1

//        [1,1,2,2,3,3,6,7,8,9,9,11,11,12,12,12,13,15,18,18,21,22,22,23,25,25,32,33,34,37,37,38,38,39,39,40,41,43,43,45,45,46,46,48,48,49,50,50,53,53,54,54,56,57,57,58,58,60,60,61,62,63,63,66,69,70,71,71,71,74,75,75,76,76,80,81,81,82,84,86,86,87,87,87,88,90,91,93,93,93,94,94,94,95,96,97,98,98,98,99]
//        3
//        13
        int[] nums = {1,1,2,2,3,3,6,7,8,9,9,11,11,12,12,12,13,15,18,18,21,22,22,23,25,25,32,33,34,37,37,38,38,39,39,40,41,43,43,45,45,46,46,48,48,49,50,50,53,53,54,54,56,57,57,58,58,60,60,61,62,63,63,66,69,70,71,71,71,74,75,75,76,76,80,81,81,82,84,86,86,87,87,87,88,90,91,93,93,93,94,94,94,95,96,97,98,98,98,99};
        int k = 3;
        int x = 13;
        List<Integer> results = solution.findClosestElements(nums, k, x);
        System.out.println(results);
    }


    static class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int start = 0, end = arr.length - 1;
            int media = 0;
            while (start <= end) {
                media = (start + end) / 2;
                if (media == 0 || (arr[media - 1] < x && arr[media] >= x)) {
                    break;
                } else if (arr[media - 1] >= x) { // 这里少了个等于号，调试了好长时间
                    end = media - 1;
                } else {
                    start = media + 1;
                }
            }
            System.out.println(media);

            Deque<Integer> results = new LinkedList<>();
            if (k == 1) {
                results.add(media);
            } else {
                int left = media, right = media;
                if (media > 0) {
                    left = media - 1;
                } else {
                    right = media + 1;
                }

                int total = 0;
                while (total < k) {
                    if (left < 0) {
                        results.addLast(arr[right++]);
                    } else if (right >= arr.length) {
                        results.addFirst(arr[left--]);
                    }else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                        results.addFirst(arr[left--]);
                    } else {
                        results.addLast(arr[right++]);
                    }
                    ++total;
                }
            }
            return (List<Integer>) results;
        }
    }
}
