package first.zxz.enums;


public enum YesNoEnum {

    YES(1, "是"),
    NO(0, "否"),
    ;

    YesNoEnum(int code, String description){
        this.code = code;
        this.description = description;
    }

    private int code;
    private String description;


    private String description_andy_3;
    private String description_zhangxz_2;

}
