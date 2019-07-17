package org.kafka.springboot.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.util.List;

public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @SneakyThrows()
    public static <T> List<T> fromJsonArray(String json, Class<T> tClass) {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, tClass);
        List<T> list = mapper.readValue(json, javaType);
        return list;
    }

    @SneakyThrows()
    public static String toJson(Object object) {
        return mapper.writeValueAsString(object);
    }

    @SneakyThrows()
    public static <T> T fromJson(String jsonContent, Class<T> classT) {
        if (jsonContent == null) {
            return null;
        }
        if (String.class == classT) {
            return (T) jsonContent;
        }
        return mapper.readValue(jsonContent, classT);

    }

    /**
     * T 不能是 String
     *
     * @param jsonContent
     * @param ref
     * @param <T>
     * @return
     */
    @SneakyThrows()
    public static <T> T fromJsonByRef(String jsonContent, TypeReference<T> ref) {
        if (jsonContent == null) {
            return null;
        }

        return mapper.readValue(jsonContent, ref);
    }

}
