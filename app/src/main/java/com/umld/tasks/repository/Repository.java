package com.umld.tasks.repository;


import com.umld.tasks.controler.RetrofitClient;
import com.umld.tasks.model.ErrorUtils;
import com.umld.tasks.model.ModelCallback;
import com.umld.tasks.model.ModelError;
import com.umld.tasks.model.ModelErrorFactory;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Repository {
    private Retrofit retrofit = RetrofitClient.initializeRetrofit(); //TODO menjati nekad :D
//    private RetrofitClient retrofit = RetrofitClient.getInstance();
    private ModelErrorFactory modelErrorFactory;

    public ModelErrorFactory getModelErrorFactory(){
        return modelErrorFactory;
    }

    public void setModelErrorFactory(ModelErrorFactory modelErrorFactory){
        this.modelErrorFactory = modelErrorFactory;
    }


    public void setRetrofit(Retrofit retrofit){
        this.retrofit = retrofit;
    }

    public <E> void executeModelResult(ModelCallback<E> callback, E result){
        if(callback != null){
            callback.onResult(result);
        }
    }

    public <E> void executeModelResult(ModelCallback<E> callback, Response<E> result){
        if(callback != null){
            callback.onResult(result.body());
        }
    }

    public void executeModelResult(ModelCallback<Void> callback){
        if(callback != null){
            callback.onResult(null);
        }
    }

    public void executeModelError(ModelCallback callback, ModelError error){
        if(callback != null){
            callback.onError(error);
        }
    }

    protected <E> Callback<E> generateCallback(final ModelCallback<E> callback){
        return new Callback<E>() {
            @Override
            public void onResponse(Call<E> call, Response<E> response) {
                if(response.isSuccessful()) {
                    executeModelResult(callback, response);
                }else{
                    executeModelError(callback, ErrorUtils.parseError(response,retrofit));
                }
            }

            @Override
            public void onFailure(Call<E> call, Throwable t) {
                executeModelError(callback, modelErrorFactory.createNetworkError(t));
            }

        };
    }

    protected Callback<ResponseBody> generateVoidCallback(final ModelCallback<Void> callback){
        return new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()) {
                    executeModelResult(callback);
                }else{
                    executeModelError(callback,  ErrorUtils.parseError(response,retrofit));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                executeModelError(callback, modelErrorFactory.createNetworkError(t));
            }
        };
    }

    protected <E> E createFacade(Class<E> facade){
        return retrofit.create(facade);
    }
}
