package ru.test_shop.rest;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;
import ru.test_shop.exceptions.ArgumentException;

@Provider
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Throwable> {

  @Override
  public Response toResponse(Throwable exception) {
    Status status = null;

    if (exception instanceof ArgumentException) {
      status = Status.BAD_REQUEST;
    } else if (exception instanceof NotFoundException) {
      status = Status.NOT_FOUND;
    } else {
      status = Status.INTERNAL_SERVER_ERROR;
    }

    return Response.status(status).entity(exception.getMessage()).build();
  }
}
