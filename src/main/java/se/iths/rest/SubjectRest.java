package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subject")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {

    @Inject
    SubjectService subjectService;

    @Path("new")
    @POST
    public Response creatSubject(Subject subject){
        subjectService.createSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("update")
    @PUT
    public Response updateSubject(Subject subject){
        subjectService.updateSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("{subjectName}")
    @GET
    public Response getSubject(@PathParam("subjectName") String subjectName){
        Subject foundSubject = subjectService.findSubjectBySubjectName(subjectName);
        if (foundSubject != null){
            return Response.ok(foundSubject).build();
        }else {
            throw new SubjectNotFoundException(subjectName);
        }
    }

    @Path("{subjectName}")
    @DELETE
    public Response deleteSubject(@PathParam("subjectName") String subjectName){
        Subject foundSubject = subjectService.findSubjectBySubjectName(subjectName);
        if (foundSubject != null){
            subjectService.deleteSubject(subjectName);
            return Response.ok().entity("Subject " + subjectName + " was successfully deleted.").build();
        }else {
            throw new SubjectNotFoundException(subjectName);
        }
    }

    @Path("getall")
    @GET
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }
}
