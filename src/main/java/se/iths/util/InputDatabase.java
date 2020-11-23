package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class InputDatabase {
    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void inputData(){
        Teacher teacherOne = new Teacher("Pontus","Pontare","pontus@iths.se","0700-000 001");
        Teacher teacherTwo = new Teacher("Anders","Andersson","anders@iths.se","0700-000 002");
        Teacher teacherThree = new Teacher("Johanna","Johanesson","johanna@iths.se","0700-000 003");

        Student studentOne = new Student("One","Guy","one@iths.se","0700-000 010");
        Student studentTwo = new Student("Two","Guy","two@iths.se","0700-000 020");
        Student studentThree = new Student("Three","Guy","three@iths.se","0700-000 030");
        Student studentFour = new Student("Four","Guy","four@iths.se","0700-000 040");
        Student studentFive = new Student("Five","Guy","five@iths.se","0700-000 050");

        Subject subjectOne = new Subject("English");
        Subject subjectTwo = new Subject("French");
        Subject subjectThree = new Subject("Spanish");
        Subject subjectFour = new Subject("German");

        teacherOne.addSubject(subjectOne);
        teacherOne.addSubject(subjectFour);
        teacherThree.addSubject(subjectTwo);
        teacherTwo.addSubject(subjectThree);

        entityManager.persist(teacherOne);
        entityManager.persist(teacherTwo);
        entityManager.persist(teacherThree);

        studentOne.addSubject(subjectFour);
        studentOne.addSubject(subjectOne);
        studentTwo.addSubject(subjectFour);
        studentTwo.addSubject(subjectThree);
        studentThree.addSubject(subjectFour);
        studentFour.addSubject(subjectFour);
        studentFour.addSubject(subjectTwo);
        studentFive.addSubject(subjectFour);
        studentFive.addSubject(subjectOne);
        studentFive.addSubject(subjectThree);

        entityManager.persist(studentOne);
        entityManager.persist(studentTwo);
        entityManager.persist(studentThree);
        entityManager.persist(studentFour);
        entityManager.persist(studentFive);
    }

    /*
        private List<Student> students() {
        var studentOne = new Student("Elena","Ten","elena@iths.se","0700-000 007");
        var studentTwo = new Student("Halim","Dakir","halim@iths.se","0700-000 001");
        List<Student> list = Collections.synchronizedList(new ArrayList<>());
        list.add(studentOne);
        list.add(studentTwo);
        return list;*/
}
