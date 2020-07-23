package com.metlife.wechat.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * @author raven
 * @date 2019-04-12 15:51
 */
@Slf4j
public class ResponseUtil {

    public static <T> void printResponse(Call<T> call) {
        try {
            log.info("成功sdfas");
            Response<T> response = call.execute();
            printResponse(response);
        } catch (IOException e) {
            log.error(e.getMessage());
        }

    }

    public static <T> void printResponse(Response<T> response) {
        try {
            if (response.isSuccessful()) {
                log.info("成功");
                T result = response.body();
                log.info("request : {}", response.raw().request());
                log.info("result : {}", JSONObject.toJSON(result));

//                if (result instanceof DataResult) {
//                    if (!((DataResult) result).getCode().equals("200")) {
//                        throw new RuntimeException("接口返回失败");
//                    }
//                }
            } else {
                log.info("失败");
                log.error("request : {}", response.raw().request());
                log.error("code : {}, message : {}", response.code(), response.message());
                log.error("response : {}", response.errorBody().string());

                throw new RuntimeException("调用接口失败");
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
