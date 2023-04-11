package service;

import viewer.DefaultViewer;
import user.Admin;
import user.Student;
import user.Teacher;
import user.User;
import viewer.StudentViewer;
import viewer.TeacherViewer;

public final class Client {
    Function func = new Function();
    public void run() {
        DefaultViewer dv = new DefaultViewer();
        while (true) {
            if (func.selectSign()) {
                Login lg = new Login();
                User user = lg.signIn();
                if (user instanceof Student) {
                    runStudent((Student) user);
                } else if (user instanceof Teacher) {
                    runTeacher((Teacher) user);
                } else {
                    runAdmin((Admin) user);
                }
            } else {
                Registration rg = new Registration();
                rg.signUp();
            }
        }
    }
    public void runStudent(Student student) {
        StudentViewer sv = new StudentViewer();
        while (true) {
            sv.exeMessage();
            if (func.selectStudentFunction(student) == 0) {
                break;
            }
        }
    }
    public void runTeacher(Teacher teacher) {
        TeacherViewer tv = new TeacherViewer();
        while (true) {
            tv.exeMessage();
            if (func.selectTeacherFunction(teacher) == 0) {
                break;
            }
        }
    }
    public void runAdmin(Admin admin) {

    }
}
