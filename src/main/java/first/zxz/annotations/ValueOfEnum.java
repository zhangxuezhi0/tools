package first.zxz.annotations;

import java.lang.annotation.*;

/**
 * 状态枚举
 *
 * @author Zxz
 * @version 1.0
 * @date Created at 2019/10/21
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
@Inherited
public @interface ValueOfEnum {

    Class value();

}
