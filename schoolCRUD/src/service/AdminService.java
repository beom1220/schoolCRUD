package service;

import viewer.AdminViewer;
import viewer.DefaultViewer;
import viewer.StudentViewer;
import viewer.TeacherViewer;

public class AdminService {
    private DefaultService ds = new DefaultService();
    public int selectAdminMenu() {
        switch (ds.tryIntException()) {
            case 0:
                return 0;
            case 1:
                while (true) {
                    AdminViewer.showTeacherMenu();
                    if (manageTeacherMenu() == 0) {
                        break;
                    }
                }
                return 1;
            case 2:
                while (true) {
                    AdminViewer.showStudentMenu();
                    if (manageStudentMenu() == 0) {
                        break;
                    }
                }
                return 1;
            default:
                DefaultViewer.failFunctionMessage();
                return 0;
        }
    }

    public int manageStudentMenu() {
        switch (ds.tryIntException()) {
            case 0:
                return 0;
            case 1:
                while (true) {
                    AdminViewer.showStudentInfoMenu();
                    if (manageStudentInfoMenu() == 0) {
                        break;
                    }
                }
                return 1;
            case 2:
                AdminViewer.showStudentGradeMenu();
                GradeService gs = new GradeService();
                ListStudentManageService lsm = ListStudentManageService.getInstance();
                gs.manageGrade(lsm.selectStudent());
                return 1;
            default:
                DefaultViewer.failFunctionMessage();
                return 0;
        }
    }

    public int manageStudentInfoMenu() {
        ListStudentManageService lsm = ListStudentManageService.getInstance();
        switch (ds.tryIntException()) {
            case 0:
                return 0;
            case 1: // 조회
                StudentViewer.inquiryStudentInfo(lsm.selectStudent());
                return 1;
            case 2: // 등록
                RegistrationService rs = new RegistrationService();
                rs.signUpJob(1);
                return 1;
            case 3: // 수정
                lsm.studentInfo();
                return 1;
            case 4: // 삭제
                lsm.getStudentList().remove(lsm.selectStudent());
                return 1;
            default:
                DefaultViewer.failFunctionMessage();
                return 0;
        }
    }

    public int manageTeacherMenu() {
        ListTeacherManageService ltm = ListTeacherManageService.getInstance();
        switch (ds.tryIntException()) {
            case 0:
                return 0;
            case 1: // 조회
                TeacherViewer.inquiryTeacherInfo(ltm.selectTeacher());
                return 1;
            case 2: // 등록
                RegistrationService rs = new RegistrationService();
                rs.signUpJob(2);
                return 1;
            case 3: // 수정
                ltm.teacherInfo(ltm.selectTeacher());
                return 1;
            case 4: // 삭제
                ltm.getTeacherList().remove(ltm.selectTeacher());
                return 1;
            default:
                DefaultViewer.failFunctionMessage();
                return 0;
        }
    }
}
