/*
 *
 * FileName: StringEmptyException
 * Author:   zhangxz
 * Date:     2019/11/6
 */
package first.zxz.exception;

/**
 * 字符串空异常
 *
 * @author zhangxz
 * 2019/11/6
 */

public class StringEmptyException extends BaseRtException {


    public StringEmptyException() {
        super("字符串不能为空！");
    }

}
