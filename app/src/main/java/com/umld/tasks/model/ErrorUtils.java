package com.umld.tasks.model;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ErrorUtils {

    public static ModelError parseError(Response<?> response,Retrofit retrofit) {
        Converter<ResponseBody, ModelError> converter =
                retrofit.responseBodyConverter(ModelError.class, new Annotation[0]);

        ModelError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new ModelError("","", ModelError.ErrorCodes.UNKNOWN);
        }

        return error;
    }
}