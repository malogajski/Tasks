package com.umld.tasks.model;

import android.content.Context;


import com.umld.tasks.R;

import retrofit2.Response;

public class ModelErrorFactory {
    private Context context;

    public ModelErrorFactory(Context context){
        this.context = context;
    }

    public ModelError create(Response response) {
        switch (response.code()){
            case 409:
                if(response.message().equals("Barcode already exists.")) {
                    return new ModelError(response.message(),
                            context.getString(R.string.server_message_barcode_already_exists),
                            ModelError.ErrorCodes.BARCODE_ALREADY_EXISTS);
                }
                if(response.message().equals("Insufficient quantity.")) {
                    return new ModelError(response.message(),
                            context.getString(R.string.server_message_insufficient_quantity),
                            ModelError.ErrorCodes.INSUFFICIENT_QUANTITY);
                }
                break;
            case 401:
                if(response.message().equals("Bad credentials.")) {
                    return new ModelError(response.message(),
                            context.getString(R.string.server_message_bad_credentials),
                            ModelError.ErrorCodes.BAD_CREDENTIALS);
                }
        }
        return new ModelError(response.message(),
                response.message(), ModelError.ErrorCodes.UNKNOWN);
    }

    public ModelError createNetworkError(Throwable response) {
        return new ModelError(response.getMessage(),
                response.getLocalizedMessage(), ModelError.ErrorCodes.NETWORK_ERROR);
    }
}
