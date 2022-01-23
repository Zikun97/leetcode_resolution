package sword;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Sword_049 {

    public static void main(String[] args) {
//        Solution solution = new Solution();
        Solution_a solution = new Solution_a();
        System.out.println(solution.nthUglyNumber(1690));

    }

    /**
     * 小根堆解法！
     * Java借助PriorityQueue来实现该功能
     * 效率：7.46; 13.53
     */
    static class Solution {
        public int nthUglyNumber(int n) {
            // 小根堆维护最小值
            PriorityQueue<Long> smallHeap = new PriorityQueue<>();
            // set保证元素不重复
            Set<Long> integerSet = new HashSet<>();
            smallHeap.add(1L);
            integerSet.add(1L);
            long res = 0;
            for (int i = 0; i < n; ++i) {
                res = smallHeap.poll();
                integerSet.remove(res);
                if (!integerSet.contains(res * 2)) {
                    integerSet.add(res * 2);
                    smallHeap.add(res * 2);
                }
                if (!integerSet.contains(res * 3)) {
                    integerSet.add(res * 3);
                    smallHeap.add(res * 3);
                }
                if (!integerSet.contains(res * 5)) {
                    integerSet.add(res * 5);
                    smallHeap.add(res * 5);
                }
            }
            return (int) res;
        }
    }


    /**
     * 动态规划：永远的神！
     * 思想：  让我说俺也说不出来，我直接copy一个通俗易懂的解释。
     *
     * 在已有的丑数序列上每一个数都必须乘2， 乘3， 乘5， 这样才不会漏掉某些丑数。假设已有的丑数序列为[1, 2, 3, ..., n1, n2], 如果单纯的让每个丑数乘2， 乘3， 乘5顺序排列的话肯定会有问题，
     *
     * 比如如果按照这样的顺序排列下去肯定有问题[1*2, 1*3, 1*5, 2*2, 2*3, 2*5, 3*2, 3*3, 3*5, ... , n1 *2, n1 * 3, n1 * 5, n2 * 2, n3* 3, n2 * 5]，因为后面乘2的数据可能会比前面乘3乘5的数据要小，那这个乘2的数应该排在他们的前面， 后面乘3的数据也可能比前面乘5的数据要小，那这个乘3的数应该排在他们的前面。
     *
     * 那怎么办呢，每个数都必须乘2， 乘3， 乘5这样才能保证求出所有的丑数，而且还要保证丑数的顺序，这个改如何同时实现呢？
     *
     * 通过观察网上的各个题解，终于找到了办法，那就是记录每个丑数是否已经被乘2， 乘3， 乘5了， 具体的做法是
     *
     * 设置3个索引a, b, c，分别记录前几个数已经被乘2， 乘3， 乘5了，比如a表示前(a-1)个数都已经乘过一次2了，下次应该乘2的是第a个数；b表示前(b-1)个数都已经乘过一次3了，下次应该乘3的是第b个数；c表示前(c-1)个数都已经乘过一次5了，下次应该乘5的是第c个数；
     *
     * 对于某个状态下的丑数序列，我们知道此时第a个数还没有乘2(有没有乘3或者乘5不知道）， 第b个数还没有乘3(有没有乘2或者乘5不知道），第c个数还没有乘5(有没有乘2或者乘3不知道), 下一个丑数一定是从第a丑数乘2， 第b个数乘3， 第c个数乘5中获得，他们三者最小的那个就是下个丑数。
     *
     * 求得下个丑数后就得判断这个丑数是谁，是某个数通过乘2得到的，还是某个数乘3得到的，又或是说某个数通过乘5得到的。我们可以比较一下这个新的丑数等于究竟是等于第a个丑数乘2, 还是第b个数乘3， 还是第c个数乘5， 通过比较我们肯定可以知道这个新的丑数到底是哪个数通过乘哪个数得到的。假设这个新的丑数是通过第a个数乘2得到的，说明此时第a个数已经通过乘2得到了一个新的丑数，那下个通过乘2得到一个新的丑数的数应该是第(a+1)个数，此时我们可以说前 a 个数都已经乘过一次2了，下次应该乘2的是第 （a+1） 个数, 所以a++；如果新的丑数是通过第b个数乘3得到的, 说明此时第 b个数已经通过乘3得到了一个新的丑数，那下个需要通过乘3得到一个新的丑数的数应该是第(b+1)个数，此时我们可以说前 b 个数都已经乘过一次3了，下次应该乘3的是第 （b+1） 个数, 所以 b++；同理，如果这个这个新的丑数是通过第c个数乘5得到的, 那么c++;
     *
     * 但是注意，如果第a个数乘2后等于第b个数乘3，或者等于第c个数乘5， 说明这个新的丑数是有两种或者三种方式可以得到，这时应该给得到这个新丑数的组合对应的索引都加一，比如新丑数是第a个数乘2后和第b个数乘3得到的，那么 a 和 b都应该加一， 因为此时第a个数已经通过乘2得到了一个新的丑数，第b个数已经通过乘3得到了一个新的丑数, 只不过这两个数相等而已。所以我们给计数器加一的时候不能使用 if else else if， 而应该使用if, if, if, 这样才不会把应该加一的计数器漏掉
     *
     * 经过n次循环，就能得到第n 个丑数了。
     */

    static class Solution_a {
        public int nthUglyNumber(int n) {
//            if (n <= 0) { // 就这一句能让LeetCode判题快1ms，我ri，人傻了
//                return -1;
//            }
            int[] dp = new int[n];
            dp[0] = 1;
            int p = 0, q = 0, v = 0;
            int pv, qv, vv;
            for (int i = 1; i < n; ++i) {
                pv = dp[p] * 2;
                qv = dp[q] * 3;
                vv = dp[v] * 5;
                dp[i] = Math.min(Math.min(pv, qv), vv);
                if (dp[i] == pv) {
                    ++p;
                }
                if (dp[i] == qv) {
                    ++q;
                }
                if (dp[i] == vv) {
                    ++v;
                }
            }
            return dp[n - 1];
        }

    }



}
