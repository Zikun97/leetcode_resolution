package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SelectPrime {

    public static void main(String[] args) {
        final int max = 10005;
        boolean[] visited = new boolean[max];
        List<Integer> primes = new LinkedList<>();
        Arrays.fill(visited, true);
        for (int i = 2; i < max; i++) {
            if (visited[i]) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size(); ++j) {
                if (i * primes.get(j) >= max)
                    break;
                visited[i * primes.get(j)] = false;

                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        for (int i = 0; i < primes.size(); ++i) {
            System.out.print(primes.get(i));
            System.out.print(", ");
        }

    }

}
