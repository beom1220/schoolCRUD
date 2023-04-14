package service;

import information.Grade;
import user.Student;
import viewer.DefaultViewer;
import viewer.StudentViewer;
import viewer.TeacherViewer;

import java.util.ArrayList;
import java.util.List;

public class ListStudentManageService {
    private DefaultService ds = new DefaultService();
    private List<Student> studentList = new ArrayList<>();
    private ListStudentManageService(){};
    private static ListStudentManageService lsm = new ListStudentManageService();
    public static ListStudentManageService getInstance() {
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
    public int selectStudentMenu(Student student) {
        switch (ds.tryIntException()) {
            case 0:
                DefaultViewer.signOut();
                return 0;
            case 1:
                StudentViewer.inquiryStudentInfo(student);
                return 1;
            case 2:
                int season = selectSeason(student);
                if (season == 0) {
                    return 0;
                }
                StudentViewer.inquiryGrade(seasonToString(season), student, season - 1);
                return 1;
            default:
                DefaultViewer.failFunctionMessage();
                return 1;
        }
    } // 학생 로그인 시 기능 선택창
    public int selectSeason(Student student) {
        StudentViewer.selectExamSeason();
        int season;
        boolean seasonYN;
        do {
            season = inputSeason(); // 1~12로 받아서 0~11번 인덱스에 접근해야.
            seasonYN = (student.getGradeList().size() >= season);
            if (!seasonYN) {
                TeacherViewer.failSeasonMessage();
            }
        } while (!seasonYN);
        return season;
    } // 시험 시기 선택. 저장돼 있는 시험 시기보다 작은 수를 받을 때까지.
    public String seasonToString(int season) {
        String midOrFinal;
        if (season % 2 == 0) {
            midOrFinal = "기말고사";
        } else {
            midOrFinal = "중간고사";
        }
        int level = ((season - 1) / 4) + 1;
        String semester;
        if (season % 2 != 0) {
            season += 1;
        }
        if (season % 4 == 0) {
            semester = "2";
        } else {
            semester = "1";
        }
        return semester + "학년 " + level + "학기 " + midOrFinal;
    } // 선택한 시험 시기가 숫자로 저장돼 있으서, 출력하기 위해 문자로 바꿔주는.
    public int inputSeason() {
        while (true) {
            int input = DefaultService.tryIntException();
            if (input >= 0 && input < 13) {
                return input;
            } else {
                DefaultViewer.errorMessage();
            }
        }
    } // 시험 시기 선택 시 0~12 중에 넣었는지 확인해주는.
    public int[] inputStudentId() {
        int level, schoolClass, classNum;
        do {
            StudentViewer.levelMessage();
            level = ds.inputRange(3); // 이하 3개 입력에 입력값 제한 넣어야 함.
            StudentViewer.schoolClassMessage();
            schoolClass = ds.inputRange(10);
            StudentViewer.classNumMessage();
            classNum = ds.inputRange(30);
        } while (checkRedundancyStudentId(level * 10000 + schoolClass * 100 + classNum));
        int[] stdId = {level, schoolClass, classNum};
        return stdId;
    }
    public void studentInfo() {
        Student student = selectStudent();
        StudentViewer.inquiryStudentInfo(student);
        TeacherViewer.addOnMessage();
        switch (ds.tryIntException()) {
            case 0 :
                break;
            case 1:
                // 학년, 반, 번호 수정 -> 이때 중복 학번 없게 검사해야.
                changeStudentId(student);
                break;
            case 2:
                // 이름 수정
                TeacherViewer.changeNameMessage();
                student.setName(ds.inputName());
                break;
            case 3:
                // 성별 수정
                TeacherViewer.changeGenderMessage();
                student.setGender(ds.inputGender());
                break;
            case 4:
                // 생년월일 수정
                TeacherViewer.changeBirthdayMessage();
                student.setBirthday(ds.inputBirthday());
                break;
            case 5:
                // id 수정 -> 중복 검사 필요
                TeacherViewer.changeIdMessage();
                student.setId(ds.inputId());
                break;
            default:
                DefaultViewer.failFunctionMessage();
                break;
        }
    } // 학생 정보 조회 및 수정
    public void changeStudentId(Student student) {
        int [] stdId = inputStudentId();
        student.setLevel(stdId[0]);
        student.setSchoolClass(stdId[1]);
        student.setClassNum(stdId[2]);
        student.setStudentId(stdId[0] * 10000 + stdId[1] * 100 + stdId[2]);
    }
    public Student selectStudent() {
        TeacherViewer.selectStudent();
        int exist = 0;
        do {
            if (exist == -1) {
                TeacherViewer.noStudentMessage();
            }
            exist = existStudent(ds.tryIntException());
        } while (exist == -1);
        return getStudentList().get(exist);
    }
    public int existStudent(int studentId) {
        for (int i = 0; i < getStudentList().size(); i++) {
            if (getStudentList().get(i).getStudentId() == studentId) {
                return i;
            }
        }
        return -1;
    }
}
