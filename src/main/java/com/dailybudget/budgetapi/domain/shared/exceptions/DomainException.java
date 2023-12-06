package com.dailybudget.budgetapi.domain.shared.exceptions;
import com.dailybudget.budgetapi.domain.shared.utils.StatusCode;

import static org.apache.logging.log4j.util.Strings.EMPTY;

public class DomainException extends RuntimeException {

    private final StatusCode statusCode;

    public DomainException(StatusCode statusCode) {
        super(EMPTY);
        this.statusCode = statusCode;
    }

    public DomainException(String message, StatusCode statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public DomainException(String message, StatusCode statusCode, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public StatusCode getErrorCode() {
        return statusCode;
    }
}
