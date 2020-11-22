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
        .createQuery("SELECT DISTINCT su FROM Subject su INNER JOIN FETCH su.teacher t INNER JOIN FETCH su.students st WHERE t.firstName = :teacherName AND su.subjectName = :subjectName")
        .setParameter("teacherName", teacherName).setParameter("subjectName", subjectName).getSingleResult();

        Set<Student> studentResult = subject.getStudents();

        return studentResult;
    }
}
