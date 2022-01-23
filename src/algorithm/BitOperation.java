package algorithm;
import java.lang.Cloneable;

public class BitOperation {

    public static void main(String[] args) {
        System.out.println(reduce(1, 3));
        int a = -122341234;
        System.out.println(a >> 31);
        System.out.println(negate(-2147483648));
        System.out.println(isPositive(-2147483648));
        System.out.println(divide(-2147483648,-2));
        System.out.println(a / -1);
    }


    public static int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        return add(a^b, (a&b)<<1);
    }


    // TODO: 2021/4/1 减法
    public static int reduce(int a, int b) {
        return add(a, (~b + 1));
    }

    // TODO: 2021/4/1 取反
    public static int negate(int x) {
        return add(~x, 1);
    }

    public static boolean isPositive(int x) {
        return x >> 31 >= 0;
    }

    public static int abs(int x) {
        if (!isPositive(x))
            return negate(x);
        return x;
    }



    public static int multiply(int a, int b) {
        boolean flags = false;
        if (isPositive(a) == isPositive(b)) {
            flags = true;
        }

        a = abs(a);
        b = abs(b);

        int ans = 0;
        while (b > 0) {
            if ((b & 1) > 0) {
                ans = add(ans, a);
            }
            a = (a << 1);
            b = (b >> 1);
        }
        if (!flags) {
            ans = negate(ans);
        }
        return ans;
    }

    public static int divide(int dividend, int divisor) {
        boolean flags = false;
        if (isPositive(dividend) == isPositive(divisor)) {
            flags = true;
        }

        int x = abs(dividend);
        int y = abs(divisor);
        int i = 31;
        int ans = 0;
        while (i >= 0) {
            System.out.println("x>>i: "+ (x >> i));
            if ((x >> i) >= y) {
                ans = add(ans, (1<<i));
                x = reduce(x, y<<i);
            }
            i = reduce(i, 1);
        }
        if (!flags)
            ans = negate(ans);
        return ans;
    }


    
}
