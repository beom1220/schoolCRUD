package service;

import information.Subject;
import user.Student;
import user.Teacher;
import viewer.AdminViewer;
import viewer.DefaultViewer;
import viewer.TeacherViewer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static information.Subject.*;

public class ListTeacherManageService {
    private DefaultService ds = new DefaultService();
    private List<Teacher> teacherList = new ArrayList<>();
    private static ListTeacherManageService ltm = new ListTeacherManageService();
    private ListTeacherManageService(){};
    public static ListTeacherManageService getInstance() {
        return ltm;
    }
    public boolean checkRedundancyId(String id) {
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getId().equals(id)) {
                DefaultViewer.redundancyIdMessage();
                return true;
            }
        }
        return false;
    }
    public List<Teacher> getTeacherList() {
        return teacherList;
    }
    public void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }
    public int selectTeacherMenu(Teacher teacher) {
        ListStudentManageService lsm = ListStudentManageService.getInstance();
        switch (ds.tryIntException()) {
            case 0:
                return 0;
            case 1: // 교사 본인 정보 조회 및 수정
                teacherInfo(teacher);
                //dv.inquiryTeacherInfo(teacher);
                return 1;
            case 2: // 학생 정보 조회 및 수정
                lsm.studentInfo();
                return 1;
            case 3: // 성적 열람, 수정, 삭제, 등록
                GradeService gs = new GradeService();
                Student student = lsm.selectStudent();
                TeacherViewer.selectGradeFunction(student);
                gs.manageGrade(student);
                return 1;
            case 4:
                return 1;
            default:
                DefaultViewer.failFunctionMessage();
                return 0;
        }
    } // 교사 로그인 시 기능 선택창.
    public void teacherInfo(Teacher teacher) {
        TeacherViewer.inquiryTeacherInfo(teacher);
        TeacherViewer.addOnTeacherInfo();
        switch (ds.tryIntException()) {
            case 0:
                break;
            case 1:
                // 이름 수정
                TeacherViewer.changeNameMessage();
                teacher.setName(ds.inputName());
                break;
            case 2:
                // 과목 변경
                TeacherViewer.inputSubjectMessage();
                teacher.setSubject(selectSubject());
                break;
            case 3:
                // 성별 변경
                TeacherViewer.changeGenderMessage();
                teacher.setGender(ds.inputGender());
                break;
            case 4:
                // 생년월일 변경
                TeacherViewer.changeBirthdayMessage();
                teacher.setBirthday(ds.inputBirthday());
                break;
            case 5:
                // 아이디 변경 -> 중복 검사 필요함.
                TeacherViewer.changeIdMessage();
                teacher.setId(ds.inputId());
                break;
        }
    } // 교사 정보 조회 및 수정
    public Subject selectSubject() {
        while (true) {
            switch (ds.tryIntException()) {
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
                case 7:
                    return OTHER;
                default:
                    DefaultViewer.errorMessage();
                    break;
            }
        }
    }
    public Teacher selectTeacher() {
        Scanner sc = new Scanner(System.in);
        AdminViewer.selectTeacher();
        int exist = 0;
        do {
            if (exist == -1) {
                AdminViewer.noTeacherMessage();
            }
            exist = existTeacher(sc.nextLine());
        } while (exist == -1);
        return getTeacherList().get(exist);
    }

    public int existTeacher(String id) {
        for (int i = 0; i < getTeacherList().size(); i++) {
            if (getTeacherList().get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
