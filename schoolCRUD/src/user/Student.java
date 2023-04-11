package user;

import information.Gender;
import information.Grade;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private List<Grade> gradeList = new ArrayList<>();
    private int studentId;
    private int schoolClass;
    private int level;
    private int classNum;
    public Student(String name, Gender gender, int birthday, String id, String password, int level, int schoolClass, int classNum) {
        this.studentId = 10000 * level + 100 * schoolClass + classNum;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.id = id;
        this.password = password;
        this.level = level;
        this.schoolClass = schoolClass;
        this.classNum = classNum;
    }
    public int getStudentId() {
        return studentId;
    }
    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setSchoolClass(int schoolClass) {
        this.schoolClass = schoolClass;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }
}
