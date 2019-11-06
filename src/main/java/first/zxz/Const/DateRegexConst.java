/*
 *
 * FileName: DateRegexConst
 * Author:   zhangxz
 * Date:     2019/11/6
 */
package first.zxz.Const;

/**
 * 正则常数定义
 *
 * @author zhangxz
 * 2019/11/6
 */
public class DateRegexConst {

    //日期格式1： 2019-01-01
    public static final String DATE_1 = "\\d{4}-\\d{2}-\\d{2}";

    //日期时间格式1： 2019-01-01 12:12:12
    public static final String DATE_TIME_1 = DATE_1 + " \\d{2}:\\d{2}:\\d{2}";

    //日期格式2： 2019/01/01
    public static final String DATE_2 = "\\d{4}/\\d{2}/\\d{2}";

    //日期时间格式2： 2019/01/01  12:12:12
    public static final String DATE_TIME_2 = DATE_2 + " \\d{2}:\\d{2}:\\d{2}";

    //日期格式3： 20190101
    public static final String DATE_3 = "\\d{8}";

    //日期时间格式1： 20190101121212
    public static final String DATE_TIME_3 = "\\d{14}";


    public static void main(String[] args) {
        {
            String str1 = "2019-01-01";
            String str2 = "2019/01/01";
            String str3 = "20190101";

            System.out.println(str1.matches(DATE_1));
            System.out.println(str2.matches(DATE_2));
            System.out.println(str3.matches(DATE_3));
        }

        {
            String str1 = "2019-01-01 12:12:12";
            String str2 = "2019/01/01 12:12:12";
            String str3 = "20190101121212";

            System.out.println(str1.matches(DATE_TIME_1));
            System.out.println(str2.matches(DATE_TIME_2));
            System.out.println(str3.matches(DATE_TIME_3));
        }

    }


}
