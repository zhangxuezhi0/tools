package first.zxz.enums;


public enum AITypeEnum {

    SMART(1, "聪明"),
    DUMB(0, "笨"),
    ;

    AITypeEnum(int code, String description){
        this.code = code;
        this.description = description;
    }

    private int code;
    private String description;
}
