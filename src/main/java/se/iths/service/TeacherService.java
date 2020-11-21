package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Set;

@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    public Set<Student> getSpecificStudentsForSubject(String teacherName, String subjectName) {

        Subject subject = (Subject) entityManager
        .createQuery("SELECT DISTINCT i FROM Subject i INNER JOIN FETCH i.teacher b INNER JOIN FETCH i.students u WHERE b.firstName = :teacherName AND i.name = :subjectName")
        .setParameter("teacherName", teacherName).setParameter("studentName", studentName).getSingleResult();

        Set<Student> studentResult = subject.getStudents();

        return studentResult;
    }
}
