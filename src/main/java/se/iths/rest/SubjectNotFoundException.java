package se.iths.rest;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class SubjectNotFoundException extends WebApplicationException {
    public SubjectNotFoundException(String subjectName) {
        super(Response.status(Response.Status.NOT_FOUND)
        .entity("This subject ["+subjectName+"] does not exist.")
        .type(MediaType.TEXT_PLAIN).build());
    }
}
