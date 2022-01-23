import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AllTry {


    public static void main(String[] args) {
        BigDecimal a = BigDecimal.valueOf(0.1f);
        System.out.println(a);

        int[] nums = {1, 2, 3, 4};
        List<Integer> list1 = Arrays.stream(nums).boxed().collect(Collectors.toList());
        String [] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = Arrays.asList(s);
        Collections.reverse(list);
        s=list.toArray(new String[0]);//没有指定类型的话会报错

    }
}
