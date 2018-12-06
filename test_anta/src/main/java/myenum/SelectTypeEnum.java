package myenum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 该枚举表示上传文件选择的id是什么类型的，店铺-SHOP，还是商品-PRODUCT
 * @Author yangliu
 * @Date 2018/11/1 16:27
 */
@AllArgsConstructor
@Getter
public enum SelectTypeEnum {

    SHOP("shop", "店铺"),   // 上传的是店铺id
    PRODUCT("product", "商品");    // 上传的是商品id

    private String type;
    private String name;

}
