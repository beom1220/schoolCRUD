package service;

import information.Grade;
import user.Student;
import viewer.DefaultViewer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListStudentManagement{
    private List<Student> studentList = new ArrayList<>();
    private DefaultViewer dv = new DefaultViewer();
    public boolean checkRedundancyId(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                dv.redundancyIdMessage();
                return true;
            }
        }
        return false;
    }
    public boolean checkRedundancyStudentId(int studentId) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentId() == studentId) {
                dv.redundancyStudentIdMessage();
                return true;
            }
        }
        return false;
    }
    public void addGrade(Student student, Grade grade) {
        student.getGradeList().add(grade);
    }
    public List<Student> getStudentList() {
        return studentList;
    }
    public void addStudent(Student student) {
        studentList.add(student);
    }
}
