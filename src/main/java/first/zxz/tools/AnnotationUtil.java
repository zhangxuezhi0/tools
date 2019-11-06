package first.zxz.tools;

import first.zxz.annotations.ValueOfEnum;
import first.zxz.enums.BaseEnum;
import first.zxz.pojo.vo.FieldOutVO;
import first.zxz.pojo.vo.TestOutVO;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 注解工具类
 *
 * @author zhangxz
 * 2019/10/15
 */

public class AnnotationUtil {

    /**
     * 对象需要满足的条件：
     * 1. 字段上有注解：{@link first.zxz.annotations.ValueOfEnum}，注解中的value必须是枚举，并且该枚举实现了接口：{@link BaseEnum}
     * 2. 字段类型为：{@link first.zxz.pojo.vo.FieldOutVO<Number>}
     * <p>
     * 产生的效果：根据字段的key值，通过枚举类获取到name，然后把该值设置到该字段的value
     * <p>
     * 遍历对象每个字段，解析注解上的value值，获取到对应的枚举类，
     * 然后根据字段的key值，从枚举中获取对应key的name，把值设置到字段的value字段
     *
     * @param object 目标对象
     * @return void
     * @author Zxz
     * @date 2019/10/22 9:32
     **/
    public static void setFieldValByEnum(Object object) throws IllegalAccessException, InvocationTargetException {
        if (object == null) {
            return;
        }
        List<Field> allFields = ReflectUtil.getAllFields(object);

        for (Field field : allFields) {
            if (FieldOutVO.class.isAssignableFrom(field.getType())) {
                field.setAccessible(true);
                Object fieldVal = field.get(object);

                if (fieldVal == null) {
                    FieldOutVO<Number> numberFieldOutVO = new FieldOutVO<>();
                    field.set(object, numberFieldOutVO);
                } else {
                    if (field.isAnnotationPresent(ValueOfEnum.class)) {
                        FieldOutVO fieldOutVO = (FieldOutVO) fieldVal;
                        ValueOfEnum annotation = field.getAnnotation(ValueOfEnum.class);
                        Class value = annotation.value();
                        if (fieldOutVO.getKey() instanceof Number) {
                            String nameByCode = EnumUtil.getNameByCode(value, Integer.valueOf(String.valueOf(fieldOutVO.getKey())));
                            if (nameByCode != null) {
                                fieldOutVO.setValue(nameByCode);
                            }
                        }
                    }
                }
                field.setAccessible(false);
            }
        }
    }


    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {

        TestOutVO testOutVO = new TestOutVO();

        FieldOutVO<Byte> gender = new FieldOutVO<>();
        gender.setKey(((byte) 1));
        gender.setValue("male");
        testOutVO.setGender(gender);

        FieldOutVO<Boolean> likeAnime = new FieldOutVO<>();
        likeAnime.setKey(true);
        likeAnime.setValue("喜欢anime");
        testOutVO.setLikeAnime(likeAnime);

        System.out.println(testOutVO);
        setFieldValByEnum(testOutVO);
        System.out.println(testOutVO);


    }

}
