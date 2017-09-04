package com.staybingo.account;


public final class AccountExistsException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    public AccountExistsException() {
        super();
    }

    public AccountExistsException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public AccountExistsException(final String message) {
        super(message);
    }

    public AccountExistsException(final Throwable cause) {
        super(cause);
    }

}
