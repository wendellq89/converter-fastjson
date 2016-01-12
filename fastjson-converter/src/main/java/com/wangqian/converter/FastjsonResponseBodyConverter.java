package com.wangqian.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * WQ on 2016/1/11
 * wendell.std@gmail.com
 */
public class FastjsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Type type;

    FastjsonResponseBodyConverter(Type type) {
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        try {
            return JSON.parseObject(new String(value.bytes(), "UTF-8"), type);
        } catch (UnsupportedEncodingException exception) {
            throw new JSONException("parseObject error", exception);
        }
    }


}