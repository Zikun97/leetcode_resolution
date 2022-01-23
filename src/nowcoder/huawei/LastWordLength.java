package nowcoder.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class LastWordLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int len = 0;
            char[] chars = sc.nextLine().toCharArray();
            boolean flag = false;
            for (int i = chars.length - 1; i >= 0; --i) {
                if (flag) {
                    if (chars[i] == ' ') {
                        break;
                    } else {
                        len++;
                    }
                } else {
                    if (chars[i] != ' ') {
                        flag = true;
                        len ++;
                    }
                }
            }
            System.out.println(len);
        }
    }

}
