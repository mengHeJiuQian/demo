package json;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

/**
 * @Description
 * @Author yang.liu
 * @Date 2019/4/28 15:43
 */
public class JsonTest {

    @Test
    public void testStringJson() {
        String str = "12312 1 123";
        Gson gson = new Gson();
        String json = gson.toJson(str);
        System.out.println("-" + json + "-");
    }

}
