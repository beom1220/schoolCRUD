package service;

import information.Gender;
import user.Student;
import user.Teacher;
import viewer.DefaultViewer;
import viewer.TeacherViewer;

import java.util.Scanner;

public class RegistrationService {
    private DefaultService ds = new DefaultService();
    private Scanner sc = new Scanner(System.in);
    public void signUp() {
        DefaultViewer.selectJob();
        int selectJob = ds.inputJob();
        signUpJob(selectJob);
    }
    public void signUpJob(int job) {
        DefaultViewer.inputNameMessage();
        String name = ds.inputName();
        DefaultViewer.inputGenderMessage();
        Gender gender = ds.inputGender();
        DefaultViewer.inputBirthdayMessage();
        int birthday = ds.inputBirthday();
        String id = ds.inputId();
        DefaultViewer.inputPasswordMessage();
        String password = sc.nextLine();
        if (job == 1) {
            ListStudentManageService lsm = ListStudentManageService.getInstance();
            lsm.addStudent(signUpStudent(name, gender, birthday, id, password));
        } else {
            ListTeacherManageService ltm = ListTeacherManageService.getInstance();
            ltm.addTeacher(signUpTeacher(name, gender, birthday, id, password));
        }
        DefaultViewer.successRegistration();
    }

    public Teacher signUpTeacher(String name, Gender gender, int birthday, String id, String password) {
        ListTeacherManageService ltm = ListTeacherManageService.getInstance();
        TeacherViewer.inputSubjectMessage();
        Teacher teacher = new Teacher(ltm.selectSubject(), name, gender, birthday, id, password);
        return teacher;
    }

    public Student signUpStudent(String name, Gender gender, int birthday, String id, String password) {
        ListStudentManageService lsm = ListStudentManageService.getInstance();
        int[] stdId = lsm.inputStudentId();
        Student student = new Student(name, gender, birthday, id, password, stdId[0], stdId[1], stdId[2]);
        return student;
    }
    public boolean checkRedundancyId(String id) {
        ListTeacherManageService ltm = ListTeacherManageService.getInstance();
        ListStudentManageService lsm = ListStudentManageService.getInstance();
        if (lsm.checkRedundancyId(id) || ltm.checkRedundancyId(id)) {
            return true;
        }
        DefaultViewer.okayId();
        return false;
    }
}
