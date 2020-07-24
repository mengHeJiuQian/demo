package metlife.wechat.modules.applyservice;

import metlife.wechat.common.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
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
//@ContextConfiguration(locations = "classpath:application.properties")
//@TestPropertySource(locations = "classpath:application.properties")
@SpringBootTest
public class HrsTest {

    @Autowired
    private HrsApi hrsApi;

    @Test
    public void testHello() {
        String name = "liuyang";
        Call<ResponseBody> response = hrsApi.hello(name);
        ResponseUtil.printResponse(response);
    }
}
