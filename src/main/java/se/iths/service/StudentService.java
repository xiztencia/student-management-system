package se.iths.service;

import se.iths.entity.Student;
import se.iths.rest.StudentNotFoundException;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public Student createStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    public Student updateStudent(Student student) {
        entityManager.merge(student);
        return student;
    }

    public void deleteStudent(String lastname) {
        Student deleteThisStudent = entityManager.createQuery("SELECT s from Student s WHERE s.lastname LIKE : lastname", Student.class)
                .setParameter("lastname", lastname)
                .getSingleResult();
        entityManager.remove(deleteThisStudent);
    }

    public Student findStudentByLastname(String lastname) {
        if(lastname != null){
        return entityManager.createQuery("SELECT s from Student s WHERE s.lastname LIKE : lastname", Student.class)
                .setParameter("lastname", lastname)
                .getSingleResult();
        }else{
            throw new StudentNotFoundException("Student with lastname " + lastname + " not found.");
        }
    }

    public List<Student> getAllStudents() {
        return entityManager.createQuery("SELECT s from Student s", Student.class)
                .getResultList();
    }

}
