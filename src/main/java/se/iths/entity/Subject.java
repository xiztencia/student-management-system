package se.iths.entity;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

public class Subject {

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }
}
