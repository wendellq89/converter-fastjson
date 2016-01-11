package com.wangqian.converter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * WQ on 2016/1/11
 * wendell.std@gmail.com
 */
public class FastjsonConverterFactory extends Converter.Factory {
    public static FastjsonConverterFactory create() {
        return new FastjsonConverterFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {

        return new FastjsonResponseBodyConverter<>(type);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new FastjsonRequestBodyConverter<>(type);
    }

}
