package se.iths.rest;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class DoubleSearchResultException extends WebApplicationException {

    public DoubleSearchResultException(String lastName){
        super(Response.status(Response.Status.TOO_MANY_REQUESTS)
                .entity("This name ["+lastName+"] is available more than once.").type(MediaType.TEXT_PLAIN).build());
    }
}
