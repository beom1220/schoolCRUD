package service;

import information.Grade;
import user.Student;
import viewer.DefaultViewer;
import viewer.StudentViewer;

import java.util.ArrayList;
import java.util.List;

public class ListStudentManagement{
    private List<Student> studentList = new ArrayList<>();
    private ListStudentManagement(){};
    private static ListStudentManagement lsm = new ListStudentManagement();
    public static ListStudentManagement getInstance() {
        return lsm;
    }
    public boolean checkRedundancyId(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                DefaultViewer.redundancyIdMessage();
                return true;
            }
        }
        return false;
    }
    public boolean checkRedundancyStudentId(int studentId) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentId() == studentId) {
                StudentViewer.redundancyStudentIdMessage();
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
