package com.metlife.wechat.modules.applyservice;

import com.metlife.wechat.common.result.BaseResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HrsAPI {

    @GET("hello")
    Call<BaseResponse> hello(@Query("name") String name);


}
