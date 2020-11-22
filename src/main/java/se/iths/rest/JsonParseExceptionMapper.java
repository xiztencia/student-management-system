package se.iths.rest;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class JsonParseExceptionMapper implements ExceptionMapper<ProcessingException> {

    @Override
    public Response toResponse(ProcessingException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity("Input is incorrect. The request can not be parsed.")
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}


