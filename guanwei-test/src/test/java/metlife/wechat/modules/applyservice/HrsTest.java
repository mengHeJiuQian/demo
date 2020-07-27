package metlife.wechat.modules.applyservice;

import com.alibaba.fastjson.JSONObject;
import com.metlife.wechat.common.utils.AesTool;
import com.metlife.wechat.modules.model.applyservice.VhsApplyServiceEntity;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;

/**
 * 创建人：yang.liu
 * 创建时间：2020/7/23 13:36
 * 版本：1.0
 * 内容描述：
 */
//@Slf4j
//@RunWith(SpringRunner.class)
////@ContextConfiguration(locations = "classpath:application.properties")
////@TestPropertySource(locations = "classpath:application.properties")
//@SpringBootTest
public class HrsTest {

    private String AES_KEY = "MetLife&VHS.2020";
    private MediaType MEDIA_TYPE_MARKDOWN = MediaType.get("text/x-markdown; charset=utf-8");

    @Test
    public void testReceiveVhsOrderInfo1() throws IOException {
        VhsApplyServiceEntity entity = new VhsApplyServiceEntity();
        String encryptStr = AesTool.encrypt(JSONObject.toJSONString(entity), AES_KEY);

        Request request = new Request.Builder()
                .url("http://localhost:8080/wechatmobile/receiveVhsOrderInfo")
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, encryptStr))
                .build();
        OkHttpClient client = new OkHttpClient();
        try ( Response response = client.newCall(request).execute() ) {
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);
            System.out.println(AesTool.decrypt(response.body().string(), "MetLife&VHS.2020"));
        }
    }
}
