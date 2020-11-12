package se.iths.service;

import se.iths.entity.Student;
import se.iths.rest.StudentNotFoundException;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

    public void deleteStudent(String lastName) {
        Student deleteThisStudent = entityManager.createQuery("SELECT s from Student s WHERE s.lastName LIKE : lastName", Student.class)
                .setParameter("lastName", lastName)
                .getSingleResult();
        entityManager.remove(deleteThisStudent);
    }

    public Student findStudentByLastname(String lastName) {
        try{
            return entityManager.createQuery(
                    "SELECT s from Student s WHERE s.lastName LIKE :lastName", Student.class)
                        .setParameter("lastName", lastName)
                        .setMaxResults(1)
                        .getSingleResult();
            }catch(NoResultException e){
            return null;
           }
    }

    public List<Student> getAllStudents() {
        return entityManager.createQuery("SELECT s from Student s", Student.class)
                .getResultList();
    }

}
