package service;

import user.Student;
import user.Teacher;
import user.User;
import viewer.DefaultViewer;
import viewer.StudentViewer;
import viewer.TeacherViewer;

import java.util.Scanner;

public class Login {
    private Scanner sc = new Scanner(System.in);
    private ListStudentManagement lsm = ListStudentManagement.getInstance();
    private ListTeacherManagement ltm = ListTeacherManagement.getInstance();
    public User signIn() {
        String id, pw;
        int studentAccountIndex = -1;
        int teacherAccountIndex = -1;
        do {
            DefaultViewer.checkIdMessage();
            id = sc.nextLine();
            DefaultViewer.checkPwMessage();
            pw = sc.nextLine();
            studentAccountIndex = matchStudentId(id, pw);
            teacherAccountIndex = matchTeacherId(id, pw);
            if (studentAccountIndex * teacherAccountIndex == 1) {
                DefaultViewer.failSignIn();
            }
        } while (studentAccountIndex == -1 && teacherAccountIndex == -1);

        if (studentAccountIndex != -1) {
            StudentViewer.studentSignIn();
            Student student = lsm.getStudentList().get(studentAccountIndex);
            return student;
        } else {
            TeacherViewer.teacherSignIn();
            Teacher teacher = ltm.getTeacherList().get(teacherAccountIndex);
            return teacher;
        }
    }
    private int matchTeacherId(String id, String pw) {
        for (int i = 0; i < ltm.getTeacherList().size(); i++) {
            if (ltm.getTeacherList().get(i).getId().equals(id)) {
                if (ltm.getTeacherList().get(i).getPassword().equals(pw)) {
                    return i;
                }
            }
        }
        return -1;
    }
    private int matchStudentId(String id, String pw) {
        for (int i = 0; i < lsm.getStudentList().size(); i++) {
            if (lsm.getStudentList().get(i).getId().equals(id)) {
                if (lsm.getStudentList().get(i).getPassword().equals(pw)) {
                    return i;
                }
            }
        }
        return -1;
    }

}