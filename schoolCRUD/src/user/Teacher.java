package user;

import information.Gender;
import information.Subject;

public class Teacher extends User {
    private Subject subject;
    public Teacher(Subject subject, String name, Gender gender, int birthday, String id, String password) {
        this.subject = subject;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.id = id;
        this.password = password;
    }
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}