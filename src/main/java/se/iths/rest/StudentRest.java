package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
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
        studentService.createStudent(student);
        return Response.ok(student).build();
    }

    @Path("update")
    @PUT
    public Response updateStudent(Student student) {
        studentService.updateStudent(student);
        return Response.ok(student).build();
    }

    @Path("{lastname}")
    @GET
    public Response getStudent(@PathParam("lastname") String lastname){
        Student foundStudent = studentService.findStudentByLastname(lastname);
        if(foundStudent != null){
            return Response.ok(foundStudent).build();
        }else{
            throw new StudentNotFoundException(lastname);
        }
    }

    @Path("{lastname}")
    @DELETE
    public Response deleteStudent(@PathParam("lastname") String lastname){
        Student foundStudent = studentService.findStudentByLastname(lastname);
        if(foundStudent != null){
            studentService.deleteStudent(lastname);
            return Response.ok().entity("Student with lastname " + lastname + " was successfully deleted.").build();
        }else{
            throw new StudentNotFoundException(lastname);
        }
    }

    @Path("getall")
    @GET
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}

