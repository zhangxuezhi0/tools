package first.zxz.tools;

import first.zxz.enums.BaseEnum;

/**
 * 枚举工具
 *
 * @author zhangxz
 * 2019/10/22
 */
public class EnumUtil {

    /**
     * 从枚举类中，根据code值获取name
     *
     * @param clazz 枚举类
     * @param code  枚举中的code值
     * @return java.lang.String
     * @author Zxz
     * @date 2019/10/22 12:05
     **/
    public static String getNameByCode(Class<? extends BaseEnum> clazz, int code) {
        for (BaseEnum anEnum : clazz.getEnumConstants()) {
            if (anEnum.getCode() == code) {
                return anEnum.getName();
            }
        }
        return null;
    }

    public static void main(String[] args) {


    }

}
