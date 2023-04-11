package service;

import viewer.DefaultViewer;
import user.Admin;
import user.Student;
import user.Teacher;
import user.User;
import viewer.StudentViewer;
import viewer.TeacherViewer;

public final class Client {
    private Service serv = new Service();
    public void run() {
        while (true) {
            if (serv.selectSign()) {
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
                serv.signUp();
            }
        }
    }
    public void runStudent(Student student) {
        while (true) {
            StudentViewer.exeMessage();
            if (serv.selectStudentFunction(student) == 0) {
                break;
            }
        }
    }
    public void runTeacher(Teacher teacher) {
        while (true) {
            TeacherViewer.exeMessage();
            if (serv.selectTeacherFunction(teacher) == 0) {
                break;
            }
        }
    }
    public void runAdmin(Admin admin) {

    }
}
