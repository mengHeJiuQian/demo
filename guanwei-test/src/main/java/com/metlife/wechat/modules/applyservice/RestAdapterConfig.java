package com.metlife.wechat.modules.applyservice;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * 创建人：yang.liu
 * 创建时间：2020/7/23 13:06
 * 版本：1.0
 * 内容描述：
 */
@Configuration
public class RestAdapterConfig {

    private String baseUrl = "http://localhost:8080/wechatmobile/";

    @Bean
    public Retrofit hrsRetrofit() {

        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .callTimeout(3, TimeUnit.MINUTES)
                .connectTimeout(3, TimeUnit.MINUTES)
                .readTimeout(3, TimeUnit.MINUTES)
                .writeTimeout(3, TimeUnit.MINUTES)
                .addInterceptor(chain -> {
                    Request original = chain.request();

//                    Map<String, String> headerMap = SignConvertUtil.generateHeader(original.url().encodedPath(),
//                            auth,
//                            caller,
//                            secret
//                    );

//                    Headers headers = Headers.of(headerMap);

                    Request request = original.newBuilder()
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }).build();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client)
                .build();
    }

    @Bean
    public HrsAPI hrsAPI(Retrofit hrsRetrofit) {
        return hrsRetrofit.create(HrsAPI.class);
    }

}
