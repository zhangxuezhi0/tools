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

public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 6971034575631650065L;

    protected BaseException(String message) {
        super(message);
    }


}
