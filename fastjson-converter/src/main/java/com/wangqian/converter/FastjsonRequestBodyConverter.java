package com.wangqian.converter;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * WQ on 2016/1/11
 * wendell.std@gmail.com
 */
public class FastjsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

    private final Type type;

    FastjsonRequestBodyConverter(Type type) {
        this.type = type;
    }

    @Override
    public RequestBody convert(T value) throws IOException {
        byte[] bytes = JSON.toJSONString(value).getBytes();
        return RequestBody.create(MEDIA_TYPE, bytes);
    }
}