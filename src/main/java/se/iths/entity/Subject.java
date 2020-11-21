package se.iths.entity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {
    public Subject(@NotEmpty String subjectName){
        this.subjectName = subjectName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String subjectName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    @ManyToMany(mappedBy = "subjects", cascade = CascadeType.PERSIST)
    private Set<Student> students = new HashSet<>();
    @JsonbTransient
    public Set<Student> getStudents(){
        return students;
    }

    public Subject(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}

