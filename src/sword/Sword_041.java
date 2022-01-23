package sword;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Sword_041 {

    public static void main(String[] args) {

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());

        for (int i : medianFinder.nums) {
            System.out.println(i);
        }
    }



    static class MedianFinder {

        private List<Integer> nums = new LinkedList<>();
        int max = Integer.MIN_VALUE;

        /** initialize your data structure here. */
        public MedianFinder() {

        }

        public void addNum(int num) {
            if (nums.isEmpty()) {
                nums.add(num);
                max = num;
                return;
            }
            if (num >= max) {
                max = num;
                nums.add(max);
                return;
            }
            ListIterator<Integer> listIterator = nums.listIterator();
            while (listIterator.hasNext()) {
                if (listIterator.next() >= num) {
                    listIterator.previous();
                    listIterator.add(num);
                    break;
                }
            }
        }

        public double findMedian() {
            int m = nums.size() / 2;
            if ((nums.size() & 1) == 1) {
                return nums.get(m);
            } else {
                return (nums.get(m) + nums.get(m - 1)) / 2.;
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
