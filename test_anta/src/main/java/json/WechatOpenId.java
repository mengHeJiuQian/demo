package json;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import lombok.ToString;

/**
 * 这个类用于接收微信接口返回数据，除了微信调用接口的返回值可以用这个类，其他业务场景不建议使用。
 */
@Getter
@Setter
@ToString
public class WechatOpenId {

    private List<String> openid;
}
