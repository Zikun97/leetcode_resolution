package sword;
import java.util.ArrayList;
import java.util.List;

public class Sword_006 {


    static public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    static class Solution {
        public int[] reversePrint(ListNode head) {
            List<Integer> nums = new ArrayList<>();
            while (head != null) {
                nums.add(head.val);
                head = head.next;
            }
            int len = nums.size();
            int[] res = new int[len];
            for (int i = 0; i < len; ++i) {
                res[i] = nums.get(len - 1 - i);
            }
            return res;
        }
    }
}
