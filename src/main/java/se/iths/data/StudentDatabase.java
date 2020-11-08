package se.iths.data;

import se.iths.entity.Student;

import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentDatabase {

    List<Student> studentList = new ArrayList<>();

    @Produces
    List<Student> getStudentList(){
        studentList = students();
        return studentList;
    }

    private List<Student> students() {
        var studentOne = new Student("Elena","Ten","elena@iths.se","0700-000 007");
        var studentTwo = new Student("Halim","Dakir","halim@iths.se","0700-000 001");
        List<Student> list = Collections.synchronizedList(new ArrayList<>());
        list.add(studentOne);
        list.add(studentTwo);
        return list;
    }
}
