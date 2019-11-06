package first.zxz.tools;

import first.zxz.pojo.vo.FieldOutVO;
import lombok.Data;

import java.lang.reflect.Field;

/**
 * bean工具类
 *
 * @author zhangxz
 * 2019/10/22
 */
public class BeanUtil {

    /**
     * 把源对象的字段值拷贝到目标对象的同名字段值，如果目标字段的类型是{@link first.zxz.pojo.vo.FieldOutVO}，则key和value的值都进行填充
     *
     * @param src    源数据对象
     * @param target 目标数据对象
     * @return void
     * @author Zxz
     * @date 2019/10/22 14:21
     **/
    public static void copyProperties2FieldOutVO(Object src, Object target) throws IllegalAccessException {
        Field[] srcFields = src.getClass().getDeclaredFields();
        Field[] targetFields = target.getClass().getDeclaredFields();

        for (Field srcField : srcFields) {
            for (Field targetField : targetFields) {
                if (srcField.getName().equals(targetField.getName())) {
                    srcField.setAccessible(true);
                    targetField.setAccessible(true);
                    Object srcFieldVal = srcField.get(src);

                    if (FieldOutVO.class.isAssignableFrom(targetField.getType())) {
                        FieldOutVO fieldOutVO = new FieldOutVO();
                        fieldOutVO.setKey(srcFieldVal);
                        fieldOutVO.setValue(String.valueOf(srcFieldVal));

                        targetField.set(target, fieldOutVO);
                    } else {
                        targetField.set(target, srcFieldVal);
                    }

                }
            }
        }

    }

    @Data
    static class Test1 {
        private byte code;
        private String name;
    }

    @Data
    static class Test2 {
        private byte code;
        private FieldOutVO<String> name;
    }

    public static void main(String[] args) throws IllegalAccessException {
        Test1 test1 = new Test1();
        test1.setCode(((byte) 1));
        test1.setName("ok12");

        Test2 test2 = new Test2();

        copyProperties2FieldOutVO(test1, test2);
        System.out.println(test2);
    }

}
