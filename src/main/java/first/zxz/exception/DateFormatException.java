/*
 *
 * FileName: DateFormatException
 * Author:   zhangxz
 * Date:     2019/11/6
 */
package first.zxz.exception;

import static first.zxz.tools.DateUtil.ALL_USABLE_DATE_FORMATS;

/**
 * 日期格式错误
 *
 * @author zhangxz
 * 2019/11/6
 */
public class DateFormatException extends BaseRtException {

    public DateFormatException() {
        super("日期格式错误！可用的格式为：" + ALL_USABLE_DATE_FORMATS);
    }

}
