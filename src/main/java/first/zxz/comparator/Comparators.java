package first.zxz.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 各种比较器
 *
 * @author zhangxz
 * @date 2019-12-21 17:20
 */

public class Comparators {


    //整数自然排序的倒序
    public static class IntReverse implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o2 - o1;
        }
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 53, 1, 5, 23);
        Collections.sort(list, new IntReverse());
        System.out.println(list);
    }


}
