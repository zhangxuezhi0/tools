package first.zxz.consts;

/**
 * @description: 通用正则表达式定义
 * @author: zhangxz
 * @create: 2019-11-12 20:28
 */
public class CommRegexConst {

    public static final String ONE_NUMBER_OR_MORE = "\\d+";

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "123bc";
        String s3 = "1";
        String s4 = "";

        System.out.println(s1.matches(ONE_NUMBER_OR_MORE));
        System.out.println(s2.matches(ONE_NUMBER_OR_MORE));
        System.out.println(s3.matches(ONE_NUMBER_OR_MORE));
        System.out.println(s4.matches(ONE_NUMBER_OR_MORE));
    }

}
