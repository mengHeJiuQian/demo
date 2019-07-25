package yang.liu.dubbo.two.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yang.liu.dubbo.one.api.enums.StatusCode;
import yang.liu.dubbo.one.api.response.BaseResponse;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/25 14:07
 * 版本：1.0
 * 内容描述：
 */
@RestController
public class BaseController {

    public static final Logger log = LoggerFactory.getLogger(BaseController.class);

    private static final String prefix = "base";

    @RequestMapping(prefix + "/working")
    public BaseResponse<String> working(@RequestParam String param) {
        return new BaseResponse<>(StatusCode.SUCCESS, param);
    }

}
