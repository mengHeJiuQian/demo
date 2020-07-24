package metlife.wechat.modules.applyservice;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HrsApi {

    @GET("hello")
    Call<ResponseBody> hello(@Query("name") String name);



}
