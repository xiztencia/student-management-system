package se.iths.service;

import se.iths.entity.Subject;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    public Subject createSubject(Subject subject) {
        entityManager.persist(subject);
        return subject;
    }

    public Subject updateSubject(Subject subject) {
        entityManager.merge(subject);
        return subject;
    }

    public Subject findSubjectBySubjectName(String subjectName) {
        return entityManager.find(Subject.class,subjectName);
    }

    public void deleteSubject(String subjectName) {
        Subject deleteThisSubject = entityManager.find(Subject.class, subjectName);
        entityManager.remove(deleteThisSubject);
    }

    public List<Subject> getAllSubjects() {
        return entityManager.createQuery("SELECT su FROM Subject su", Subject.class).getResultList();
    }
}
