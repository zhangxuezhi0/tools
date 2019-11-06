package first.zxz.pojo.vo;

import lombok.Data;

/**
 * 出参字段格式vo类
 *
 * @author zhangxz
 * 2019/10/21
 */

@Data
public class FieldOutVO<T> {

    //字段key，用于逻辑或运算的实际值
    private T key;
    //字段value，用于前端的展示
    private String value;

    public FieldOutVO() {
    }

    public FieldOutVO(T key) {
        this.key = key;
        this.value = String.valueOf(key);
    }

}

