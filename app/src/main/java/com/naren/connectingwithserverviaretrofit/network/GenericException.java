package com.naren.connectingwithserverviaretrofit.network;

import java.net.SocketTimeoutException;

/**
 * Created by narendra on 15/3/17.
 */

public class GenericException extends SocketTimeoutException {
    String message;

    public GenericException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
