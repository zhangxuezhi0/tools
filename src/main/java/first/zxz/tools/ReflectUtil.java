package first.zxz.tools;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

/**
 * 反射工具
 *
 * @author Zxz
 * @version 1.0
 * @date Created at 2019/07/08
 **/
public class ReflectUtil {

    public static void main(String[] args) {

    }

    /**
     * 根据注解类型，获取该类上有该字节的域
     *
     * @param clazz      目标类
     * @param annotation 注解类型
     * @return java.util.List<java.lang.reflect.Field>
     * @author Zxz
     * @date 2019/10/14 18:20
     **/
    public static List<Field> getFieldList(Class clazz, Class annotation) {
        List<Field> list = new ArrayList<>();

        Field[] fields = clazz.getDeclaredFields();
        if (fields == null || fields.length <= 0) {
            return list;
        }

        for (Field field : fields) {
            Annotation fieldAnnotation = field.getAnnotation(annotation);
            if (fieldAnnotation != null) {
                list.add(field);
            }
        }

        Class superclass = clazz.getSuperclass();
        if (superclass == Object.class) {
            return list;
        } else {
            list.addAll(getFieldList(superclass, annotation));
            return list;
        }
    }

    //该方法有问题，可能会导致死循环
    /*public static List<Field> getAllFields(Object object) {
        List<Field> allFields = new ArrayList<>();
        Class<?> aClass = object.getClass();

        allFields.addAll(Arrays.asList(aClass.getDeclaredFields()));

        while (aClass.getSuperclass() != Object.class && aClass.getSuperclass() != null) {
            aClass = object.getClass().getSuperclass();
            allFields.addAll(Arrays.asList(aClass.getDeclaredFields()));
        }
        return allFields;
    }*/


    /**
     * 通过反射获取对象所有的字段Field列表
     *
     * @param object 目标对象
     * @return java.util.List<java.lang.reflect.Field>
     * @author Zxz
     * @date 2019/10/29 20:56
     **/
    public static List<Field> getAllFields(Object object) {
        List<Field> allFields = new ArrayList<>();
        Class<?> aClass = object.getClass();

        while (aClass != Object.class && aClass != null) {
            allFields.addAll(Arrays.asList(aClass.getDeclaredFields()));

            aClass = aClass.getSuperclass();
        }
        return allFields;
    }

    /**
     * 判断对象的所有字段是否都为null
     *
     * @param object 目标对象
     * @return boolean
     * @author Zxz
     * @date 2019/10/26 17:14
     **/
    public static boolean isAllFieldNull(Object object) throws IllegalAccessException {

        for (Field field : getAllFields(object)) {
            Object value = null;
            if (field.isAccessible()) {
                value = field.get(object);
            } else {
                field.setAccessible(true);
                value = field.get(object);
                field.setAccessible(false);
            }
            if (value != null) {
                return false;
            }
        }

        return true;
    }

    /**
     * 根据类型，创建一个类对象，赋予不同类型字段的自定义值
     *
     * @param clazz
     * @return T
     * @author Zxz
     * @date 2019/8/29 10:03
     **/
    public static <T> T generateFullInstance(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        Map<Class, Object> map = new HashMap<>();
        map.put(String.class, "default_Str");

        map.put(Integer.class, 47);
        map.put(int.class, 48);

        map.put(Double.class, 12.32);
        map.put(double.class, 12.33);

        map.put(Float.class, 13.43f);
        map.put(float.class, 13.44f);

        map.put(Byte.class, (byte) 8);
        map.put(byte.class, (byte) 9);

        map.put(Short.class, (short) 16);
        map.put(short.class, (short) 17);

        map.put(Long.class, 147L);
        map.put(long.class, 148L);

        map.put(Character.class, 'c');
        map.put(char.class, 'd');

        map.put(Boolean.class, true);
        map.put(boolean.class, true);

        map.put(Date.class, new Date(1396555444000L));

        T t = clazz.newInstance();

        for (Field field : getAllFields(clazz)) {
            Class<?> type = field.getType();
            if (field.isAccessible()) {
                Object instance = map.get(type);
                field.set(t, instance);
            } else {
                field.setAccessible(true);

                Object instance = map.get(type);
                field.set(t, instance);

                field.setAccessible(false);
            }
        }

        return t;
    }

}
