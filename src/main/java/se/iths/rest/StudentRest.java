package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.json.stream.JsonParsingException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("create")
    @POST
    public Response createStudent(Student student) {
        try {
            studentService.createStudent(student);
            return Response.ok(student).build();
        } catch (JsonParsingException j) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("update")
    @PUT
    public Response updateStudent(Student student) {
        try{
            studentService.updateStudent(student);
            return Response.ok(student).build();
        } catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("{lastName}")
    @GET
    public Response getStudent(@PathParam("lastName") String lastName){
        Student foundStudent = studentService.findStudentByLastname(lastName);
        if(foundStudent != null){
            return Response.ok(foundStudent).build();
        }else{
            throw new StudentNotFoundException(lastName);
        }
    }

    @Path("{lastName}")
    @DELETE
    public Response deleteStudent(@PathParam("lastName") String lastName){
        Student foundStudent = studentService.findStudentByLastname(lastName);
        if(foundStudent != null){
            studentService.deleteStudent(lastName);
            return Response.ok().entity("Student with lastName " + lastName + " was successfully deleted.").build();
        }else{
            throw new StudentNotFoundException(lastName);
        }
    }

    @Path("getall")
    @GET
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}

