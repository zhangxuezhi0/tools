/*
 *
 * FileName: DateUtil
 * Author:   zhangxz
 * Date:     2019/11/6
 */
package first.zxz.tools;

import first.zxz.Const.DateRegexConst;
import first.zxz.exception.DateFormatException;
import first.zxz.exception.StringEmptyException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期工具类
 *
 * @author zhangxz
 *         2019/11/6
 */
public class DateUtil {

    private static final String DATE_FORMAT_1 = "yyyy-MM-dd";
    private static final String DATE_FORMAT_2 = "yyyy/MM/dd";
    private static final String DATE_FORMAT_3 = "yyyyMMdd";
    private static final String DATE_TIME_FORMAT_1 = DATE_FORMAT_1 + " HH:mm:ss";
    private static final String DATE_TIME_FORMAT_2 = DATE_FORMAT_2 + " HH:mm:ss";
    private static final String DATE_TIME_FORMAT_3 = DATE_FORMAT_3 + "HHmmss";

    //key为正则表达式，value为对应的日期格式
    private static final HashMap<String, String> DATE_REGEX_FORMATTER_MAP = new HashMap<>();

    static {
        DATE_REGEX_FORMATTER_MAP.put(DateRegexConst.DATE_1, DATE_FORMAT_1);
        DATE_REGEX_FORMATTER_MAP.put(DateRegexConst.DATE_2, DATE_FORMAT_2);
        DATE_REGEX_FORMATTER_MAP.put(DateRegexConst.DATE_3, DATE_FORMAT_3);
        DATE_REGEX_FORMATTER_MAP.put(DateRegexConst.DATE_TIME_1, DATE_TIME_FORMAT_1);
        DATE_REGEX_FORMATTER_MAP.put(DateRegexConst.DATE_TIME_2, DATE_TIME_FORMAT_2);
        DATE_REGEX_FORMATTER_MAP.put(DateRegexConst.DATE_TIME_3, DATE_TIME_FORMAT_3);
    }

    //提示语：所有可用的日期格式
    public static final String ALL_USABLE_DATE_FORMATS = DATE_REGEX_FORMATTER_MAP.values().toString() + "，以及时间戳；";

    /**
     * 根据输入的字符串，进行格式化，并输入日期数据
     * 注意：格式化之前，会进行null和空字符串过滤；格式化时，会去除字符串两端的空字符串
     *
     * @param formattedDateStr 日期字符串数据
     * @return java.util.Date
     * @author Zxz
     * @date 2019/11/6 15:07
     **/
    public static Date parse(String formattedDateStr) {
        if (formattedDateStr == null || formattedDateStr.trim().length() <= 0) {
            throw new StringEmptyException();
        }

        for (Map.Entry<String, String> entry : DATE_REGEX_FORMATTER_MAP.entrySet()) {
            if (formattedDateStr.trim().matches(entry.getKey())) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(entry.getValue());
                try {
                    return simpleDateFormat.parse(formattedDateStr.trim());
                } catch (ParseException e) {
                    e.printStackTrace();
                    throw new DateFormatException();
                }
            }
        }

        try {
            Long aLong = Long.valueOf(formattedDateStr);
            return new Date(aLong);
        } catch (NumberFormatException e) {
            //格式不匹配
            throw new DateFormatException();
        }

    }

    /**
     * 获取当前时间的字符串格式
     *
     * @return java.lang.String
     * @author Zxz
     * @date 2019/11/6 17:46
     **/
    public static String getNow() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_FORMAT_1);
        return simpleDateFormat.format(new Date());
    }

    /**
     * 日期格式化成字符串格式
     *
     * @param date 日期数据
     * @return java.lang.String
     * @author Zxz
     * @date 2019/11/6 17:59
     **/
    public static String format(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_FORMAT_1);
        return simpleDateFormat.format(date);
    }

    public static void main(String[] args) {
        Date date = parse("123");
        System.out.println(date);

        String string = "123a";
        System.out.println(Long.valueOf(string));
    }

}
