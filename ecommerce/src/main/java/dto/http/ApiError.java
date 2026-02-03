package dto.http;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ApiError {
    public String message;
    public String path;
    public OffsetDateTime timestamp = OffsetDateTime.now();
    public List<FieldError> errors = new ArrayList<>();

    public ApiError() {}

    public ApiError(String message, String path) {
        this.message = message;
        this.path = path;
    }

    public static class FieldError {
        public String field;
        public String error;

        public FieldError() {}

        public FieldError(String field, String error) {
            this.field = field;
            this.error = error;
        }
    }
}
