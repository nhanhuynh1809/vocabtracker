package com.example.vocabtracker.enumfolder;

public enum error {

    // success
    SUCCESS(200, "Success"),
    CREATED(201, "Created successfully!"),
    BAD_REQUEST(400, "Bad Request!"),
    // basic error
    UNAUTHORIZED(401, "Unauthorized!"),
    FORBIDDEN(403, "Forbidden!"),
    NOT_FOUND(404, "Not Found!"),
    CONFLICT(409, "Conflict!"),
    VALIDATION_ERROR(422, "Unprocessable Entity!"),
    // Server error
    INTERNAL_ERROR(500, "Internal Server Error!"),
    BAD_GATEWAY(502, "Bad Gateway!"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable!"),
    // data
    EMPTY_LIST(600, "Do not have any value!");

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private final int code;
    private final String message;

    private error(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
