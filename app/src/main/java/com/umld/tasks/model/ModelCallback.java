package com.umld.tasks.model;

public interface ModelCallback<T> {
    void onResult(T result);
    void onError(ModelError error);
}
