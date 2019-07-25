package yang.liu.dubbo.one.api.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/25 14:00
 * 版本：1.0
 * 内容描述：
 */
@Getter
@AllArgsConstructor
public enum  StatusCode {

    SUCCESS(200, "成功"),
    FAILURE(500, "错误"),
    InvalidParams(50001, "无效的参数"),
    ItemNotExist(50002, "商品不存在!");

    private Integer code;
    private String msg;

}
