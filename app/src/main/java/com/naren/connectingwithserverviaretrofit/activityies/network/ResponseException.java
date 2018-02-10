package com.naren.connectingwithserverviaretrofit.activityies.network;

import java.io.IOException;

/**
 * Created by narendra on 1/23/17.
 */

public class ResponseException extends IOException {
    String message;

    public ResponseException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
