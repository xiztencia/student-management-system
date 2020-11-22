package se.iths.util;

import se.iths.entity.Student;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Singleton
@Startup
public class InputDatabase {

    @PersistenceContext
    EntityManager entityManager;




    private List<Student> students() {
        var studentOne = new Student("Elena","Ten","elena@iths.se","0700-000 007");
        var studentTwo = new Student("Halim","Dakir","halim@iths.se","0700-000 001");
        List<Student> list = Collections.synchronizedList(new ArrayList<>());
        list.add(studentOne);
        list.add(studentTwo);
        return list;
    }
}
