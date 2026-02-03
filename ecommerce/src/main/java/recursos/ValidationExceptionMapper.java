package recursos;

import dto.http.ApiError;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        ApiError err = new ApiError("Validation failed", uriInfo.getPath());
        for (ConstraintViolation<?> v : exception.getConstraintViolations()) {
            String field = v.getPropertyPath() == null ? "" : v.getPropertyPath().toString();
            err.errors.add(new ApiError.FieldError(field, v.getMessage()));
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(err).build();
    }
}
