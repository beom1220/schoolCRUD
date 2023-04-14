package service;

import viewer.AdminViewer;
import user.Student;
import user.Teacher;
import user.User;
import viewer.StudentViewer;
import viewer.TeacherViewer;

public class Client {
    public void run() {
        DefaultService ds = new DefaultService();
        while (true) {
            if (ds.selectSign()) {
                LoginService ls = new LoginService();
                User user = ls.signIn();
                if (user instanceof Student) {
                    runStudent((Student) user);
                } else if (user instanceof Teacher) {
                    runTeacher((Teacher) user);
                } else {
                    runAdmin();
                }
            } else {
                RegistrationService rs = new RegistrationService();
                rs.signUp();
            }
        }
    }
    public void runStudent(Student student) {
        ListStudentManageService lsm = ListStudentManageService.getInstance();
        while (true) {
            StudentViewer.exeMessage();
            if (lsm.selectStudentMenu(student) == 0) {
                break;
            }
        }
    }
    public void runTeacher(Teacher teacher) {
        ListTeacherManageService ltm = ListTeacherManageService.getInstance();
        while (true) {
            TeacherViewer.exeMessage();
            if (ltm.selectTeacherMenu(teacher) == 0) {
                break;
            }
        }
    }
    public void runAdmin() {
        AdminService as = new AdminService();
        while (true) {
            AdminViewer.exeMessage();
            if (as.selectAdminMenu() == 0) {
                break;
            }
        }
    }
}
