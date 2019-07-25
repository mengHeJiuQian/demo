package yang.liu.dubbo.one.api.response;

import lombok.Data;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/25 13:55
 * 版本：1.0
 * 内容描述：
 */
@Data
public class BaseResponse<T> {

    private Integer code; // 状态码
    private String msg; // 状态描述信息
    private T data;

    public BaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
