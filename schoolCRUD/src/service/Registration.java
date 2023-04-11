package service;

import information.Gender;
import information.Subject;
import user.Student;
import user.Teacher;
import user.User;
import viewer.DefaultViewer;
import viewer.StudentViewer;
import viewer.TeacherViewer;

import java.util.Scanner;

import static information.Gender.FEMALE;
import static information.Gender.MALE;
import static information.Subject.*;


public class Registration {
    DefaultViewer dv = new DefaultViewer();
    Scanner sc = new Scanner(System.in);
    public void signUp() {
        dv.selectJob();
        int selectJob = sc.nextInt();
        sc.nextLine();
        dv.inputNameMessage();
        String name = sc.nextLine();
        dv.inputGenderMessage();
        Gender gender = inputGender();
        dv.inputBirthdayMessage();
        int birthday = sc.nextInt();
        sc.nextLine();
        String id = inputId();
        dv.inputPasswordMessage();
        String password = sc.nextLine();
        if (selectJob == 1) {
            ListStudentManagement lsm = ListStudentManagement.getInstance();
            lsm.addStudent(signUpStudent(name, gender, birthday, id, password));
        } else {
            ListTeacherManagement ltm = ListTeacherManagement.getInstance();
            ltm.addTeacher(signUpTeacher(name, gender, birthday, id, password));
        }
    }
    public Gender inputGender() {
        if (sc.nextInt() == 1) {
            return MALE;
        } else {
            return FEMALE;
        }
    }
    public String inputId() {
        String id;
        do {
            dv.inputIdMessage();
            id = sc.nextLine();
        } while (checkRedundancyId(id));
        return id;
    }

    public Teacher signUpTeacher(String name, Gender gender, int birthday, String id, String password) {
        TeacherViewer tv = new TeacherViewer();
        tv.inputSubjectMessage();
        Teacher teacher = new Teacher(selectSubject(sc.nextInt()), name, gender, birthday, id, password);
        return teacher;
    }

    public Student signUpStudent(String name, Gender gender, int birthday, String id, String password) {
        StudentViewer sv = new StudentViewer();
        ListStudentManagement lsm = ListStudentManagement.getInstance();
        int level, schoolClass, classNum;
        do {
            sv.levelMessage();
            level = sc.nextInt(); // 이하 3개 입력에 입력값 제한 넣어야 함.
            sv.schoolClassMessage();
            schoolClass = sc.nextInt();
            sv.classNumMessage();
            classNum = sc.nextInt();
        } while (lsm.checkRedundancyStudentId(level * 10000 + schoolClass * 100 + classNum));
        Student student = new Student(name, gender, birthday, id, password, level, schoolClass, classNum);
        return student;
    }

    public boolean checkRedundancyId(String id) {
        ListTeacherManagement ltm = ListTeacherManagement.getInstance();
        ListStudentManagement lsm = ListStudentManagement.getInstance();
        if (lsm.checkRedundancyId(id) || ltm.checkRedundancyId(id)) {
            return true;
        }
        dv.okayId();
        return false;
    }

    public Subject selectSubject(int num) {
        switch (num) {
            case 1:
                return KOR;
            case 2:
                return MATH;
            case 3:
                return ENG;
            case 4:
                return SCIENCE;
            case 5:
                return SOCIETY;
            case 6:
                return HISTORY;
            default:
                return OTHER;
        }
    }
}