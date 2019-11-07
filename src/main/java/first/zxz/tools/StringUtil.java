/*
 *
 * FileName: StringUtil
 * Author:   zhangxz
 * Date:     2019/11/6
 */
package first.zxz.tools;

/**
 * 字符串工具类
 *
 * @author zhangxz
 * 2019/11/6
 */
public class StringUtil {

    /**
     * 判断字符串是否为空
     *
     * @param string 字符串
     * @return boolean
     * @author Zxz
     * @date 2019/11/7 11:42
     **/
    public static boolean isEmpty(String string) {
        return string == null || string.length() <= 0;
    }

    /**
     * 判断字符串是否为空，或者是否只包含空格
     *
     * @param string 字符串
     * @return boolean
     * @author Zxz
     * @date 2019/11/7 14:24
     **/
    public static boolean isEmptyAndBlank(String string) {
        return string == null || string.trim().length() <= 0;
    }

}
