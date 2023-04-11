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
                func.signUp();
            }
        }
    }
    public void runStudent(Student student) {
        while (true) {
            StudentViewer.exeMessage();
            if (func.selectStudentFunction(student) == 0) {
                break;
            }
        }
    }
    public void runTeacher(Teacher teacher) {
        while (true) {
            TeacherViewer.exeMessage();
            if (func.selectTeacherFunction(teacher) == 0) {
                break;
            }
        }
    }
    public void runAdmin(Admin admin) {

    }
}
