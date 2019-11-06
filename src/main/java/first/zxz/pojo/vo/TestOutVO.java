package first.zxz.pojo.vo;

import first.zxz.annotations.ValueOfEnum;
import first.zxz.enums.GenderEnum;
import lombok.Data;

/**
 * 测试类出参vo
 *
 * @author zhangxz
 * 2019/10/24
 */

@Data
public class TestOutVO {

    /**
     * 性别
     */
    @ValueOfEnum(GenderEnum.class)
    private FieldOutVO<Byte> gender;

    /**
     * 是否喜欢动漫
     */
    private FieldOutVO<Boolean> likeAnime;

}
