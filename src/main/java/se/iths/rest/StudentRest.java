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

    @Path("new")
    @POST
    public Response createStudent(Student student) {
        StudentService.createStudent(student);
        return Response.ok(student).build();
    }

    @Path("update")
    @PUT
    public Response updateTodo(Student student) {
        StudentService.updateTodo(student);
        return Response.ok(student).build();
    }

    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") long id){
        Student foundStudent = StudentService.findStudentById(id);
        if(foundStudent != null){
            return Response.ok(foundStudent).build();
        }else{
            throw new StudentNotFoundException("Student with ID " + id + " not found.");
        }
    }

    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @DELETE
    public Response deleteStudent(@PathParam("id") long id){
        Student foundStudent = StudentService.findStudentById(id);
        if(foundStudent != null){
            StudentService.deleteStudent(id);
            return Response.ok().entity("Student with ID " + id + " was successfully deleted.").build();
        }else{
            throw new StudentNotFoundException("Student with ID " + id + " not found.");
        }
    }

    @Path("getall")
    @GET
    public List<Student> getAllStudents() {
        return StudentService.getAllStudents();
    }
}

