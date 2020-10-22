package json;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WechatUserInfo {

    private int total;

    private int count;

    private WechatOpenId data;

    @JSONField(name = "next_openid")
    private String nextOpenId;
}
