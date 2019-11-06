package first.zxz.enums;

/**
 * 性别枚举类
 *
 * @author Zxz
 * @version 1.0
 * @date Created at 2019/10/25
 **/
public enum GenderEnum implements BaseEnum {

    MALE(1,"男"),
    FEMALE(2, "女"),
    ;

    private int code;
    private String name;

    GenderEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
