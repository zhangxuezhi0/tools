/*
 *
 * FileName: BaseRtException
 * Author:   zhangxz
 * Date:     2019/11/6
 */
package first.zxz.exception;

/**
 * 运行时异常基类
 *
 * @author zhangxz
 * 2019/11/6
 */

public class BaseRtException extends RuntimeException {

    protected BaseRtException(String message) {
        super(message);
    }


}
