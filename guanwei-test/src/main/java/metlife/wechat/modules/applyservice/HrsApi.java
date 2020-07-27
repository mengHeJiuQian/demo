package metlife.wechat.modules.applyservice;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface HrsApi {

    @GET("hello")
    Call<ResponseBody> hello(@Query("name") String name);

    /**
     * 提供给好人生调用的接口.
     * @param encryptData 加密后的请求数据
     * @return
     */
    @POST("receiveVhsOrderInfo")
    Call<ResponseBody> receiveVhsOrderInfo(@Body String encryptData);



}
