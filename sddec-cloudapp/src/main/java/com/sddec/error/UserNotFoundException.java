package com.sddec.error;

/**
 * Created by Trevor on 4/6/2018.
 */
public class UserNotFoundException extends RuntimeException {
    private String message;

    private String url;

    public UserNotFoundException(String message, String url) {
        this.message = message;
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public String getUrl() {
        return url;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
