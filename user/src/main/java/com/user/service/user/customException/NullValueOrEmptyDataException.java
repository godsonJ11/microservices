package com.user.service.user.customException;

import org.springframework.stereotype.Component;

@Component
public class NullValueOrEmptyDataException extends Exception{
    public NullValueOrEmptyDataException() {
        super();
    }

    public NullValueOrEmptyDataException(String message) {
        super(message);
    }

    public NullValueOrEmptyDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullValueOrEmptyDataException(Throwable cause) {
        super(cause);
    }
}
