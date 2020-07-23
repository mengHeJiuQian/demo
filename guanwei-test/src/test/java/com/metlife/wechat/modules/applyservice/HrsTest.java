package com.metlife.wechat.modules.applyservice;

import com.metlife.wechat.common.result.BaseResponse;
import com.metlife.wechat.common.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Call;

/**
 * 创建人：yang.liu
 * 创建时间：2020/7/23 13:36
 * 版本：1.0
 * 内容描述：
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class HrsTest {

    @Autowired
    private HrsAPI hrsApi;

    @Test
    public void testHello() {
        String name = "liuyang";
        Call<BaseResponse> response = hrsApi.hello(name);
        ResponseUtil.printResponse(response);
    }
}
