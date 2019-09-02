package com.forezp.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建人：yang.liu
 * 创建时间：2019/9/3 1:46
 * 版本：1.0
 * 内容描述：
 */
@RestController
public class ConfigClientController {

    @Value("${foo}")
    String foo;
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }

}
