package service;

import information.Gender;
import information.Grade;
import viewer.DefaultViewer;
import user.Student;
import user.Teacher;
import user.User;
import viewer.StudentViewer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class Function {
    private DefaultViewer dv = new DefaultViewer();
    private Scanner sc = new Scanner(System.in);
    public boolean selectSign() {
        dv.exeMessage();
        return (sc.nextInt() == 1);
    }

    public int selectStudentFunction(Student student) {
        switch (sc.nextInt()) {
            case 0:
                dv.signOut();
                return 0;
            case 1:
                dv.inquiryStudentInfo(student);
                return 1;
            case 2:
                int season = selectSeason(student);
                dv.inquiryGrade(seasonToString(season), student, season-1);
                return 1;
            default:
                dv.failFunctionMessage();
                return 1;
        }
    }

    private String seasonToString(int season) {
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
    }

    private int selectSeason(Student student) {
        dv.selectExamSeason();
        int season;
        boolean seasonYN;
        do {
            season = sc.nextInt(); // 1~12로 받아서 0~11번 인덱스에 접근해야.
            seasonYN = (student.getGradeList().size() >= season && season > 0);
            if (!seasonYN) {
                dv.failSeasonMessage();
            }
        } while (!seasonYN);
        return season;
    }

    public int selectTeacherFunction(Teacher teacher) {
        switch (sc.nextInt()) {
            case 0:
                return 0;
            case 1: // 교사 본인 정보 조회 및 수정 -> 아직 수정 안 드감.
                teacherInfo(teacher);
                //dv.inquiryTeacherInfo(teacher);
                return 1;
            case 2: // 학생 정보 조회 및 수정
                studentInfo();
                return 1;
            case 3: // 성적 열람, 수정, 삭제, 등록
                ListStudentManagement lsm = new ListStudentManagement();
                dv.selectStudent();
                Student student = selectStudent();
                dv.selectGradeFunction(student);
                manageGrade(student);
                return 1;
            case 4:
                return 1;
            default:
                dv.failFunctionMessage();
                return 0;
        }
    }

    private void manageGrade(Student student) {
        ListStudentManagement lsm = new ListStudentManagement();
        switch (sc.nextInt()) {
            case 0:
                break;
            case 1:
                // 열람
                int season = selectSeason(student);
                dv.inquiryGrade(seasonToString(season), student, season-1);
                break;
            case 2:
                // 수정
                season = selectSeason(student);
                changeGrade(student.getGradeList().get(season-1));
                break;
            case 3:
                // 삭제
                season = selectSeason(student);
                student.getGradeList().remove(season-1);
                dv.delGrade();
                break;
            case 4:
                // 등록
                lsm.addGrade(selectStudent(), newGrade());
                break;
            default:
                dv.failFunctionMessage();
                break;
        }
    }

    private void changeGrade(Grade grade) {
        dv.selectChangeGradeSubjectFunction();
        int sub = sc.nextInt() - 1;
        int score;
        do {
            inputGrade(sub);
            score = sc.nextInt();
        } while (score >= 0 && score <= 100);
        switch (sub) {
            case 0: //국수영사과역
                grade.setKor(score);
                break;
            case 1:
                grade.setMath(score);
                break;
            case 2:
                grade.setEng(score);
                break;
            case 3:
                grade.setSociety(score);
                break;
            case 4:
                grade.setScience(score);
                break;
            case 5:
                grade.setHistory(score);
                break;
            default:
                break;
        }
    }

    public void teacherInfo(Teacher teacher) {
        dv.inquiryTeacherInfo(teacher);
        switch (sc.nextInt()) {
            case 0:
                break;
            case 1:
                // 이름 수정
                changeName(teacher);
                break;
            case 2:
                // 과목 변경
                changeSubject(teacher);
                break;
            case 3:
                // 성별 변경..? 입력할 때 잘못할 수도 있으니까,,
                changeGender(teacher);
                break;
            case 4:
                // 생년월일 변경..?
                changeBirthday(teacher);
                break;
            case 5:
                // 아이디 변경 -> 중복 검사 필요함.
                changeId(teacher);
                break;
        }
    }
    private void changeId(User user) {
        Registration rg = new Registration();
        user.setId(rg.inputId());
    }
    private void changeBirthday(User user) {
        dv.changeBirthdayMessage();
        user.setBirthday(sc.nextInt());
    }

    private void changeGender(User user) {
        dv.changeGenderMessage();
        if (sc.nextInt() == 1) {
            user.setGender(Gender.MALE);
        } else {
            user.setGender(Gender.FEMALE);
        }
    }
    public void changeName(User user) {
        dv.changeNameMessage();
        user.setName(sc.nextLine());
    }
    public void changeSubject(Teacher teacher) {
        Registration rg = new Registration();
        teacher.setSubject(rg.selectSubject(sc.nextInt()));
    }
    public void studentInfo() {
        Student student = selectStudent();
        dv.inquiryStudentInfo(student);
        dv.addOnMessage();
        switch (sc.nextInt()) {
            case 0 :
                break;
            case 1:
                // 학년, 반, 번호 수정 -> 이때 중복 학번 없게 검사해야.
                changeStudentId(student);
                break;
            case 2:
                // 이름 수정
                changeName(student);
                break;
            case 3:
                // 성별 수정
                changeGender(student);
                break;
            case 4:
                // 생년월일 수정
                changeBirthday(student);
                break;
            case 5:
                // id 수정 -> 중복 검사 필요
                changeId(student);
                break;
            default:
                dv.failFunctionMessage();
                break;
        }
    }

    private void changeStudentId(Student student) {
        StudentViewer sv = new StudentViewer();
        ListStudentManagement lsm = new ListStudentManagement();
        int level, schoolClass, classNum;
        do {
            sv.levelMessage();
            level = sc.nextInt(); // 이하 3개 입력에 입력값 제한 넣어야 함.
            sv.schoolClassMessage();
            schoolClass = sc.nextInt();
            sv.classNumMessage();
            classNum = sc.nextInt();
        } while (lsm.checkRedundancyStudentId(level * 10000 + schoolClass * 100 + classNum));
        student.setLevel(level);
        student.setSchoolClass(schoolClass);
        student.setClassNum(classNum);
        student.setStudentId(level * 10000 + schoolClass * 100 + classNum);
    }

    public Student selectStudent() {
        ListStudentManagement lsm = new ListStudentManagement();
        dv.selectStudent();
        int exist = 0;
        do {
            if (exist == -1) {
                dv.noStudentMessage();
            }
            exist = existStudent(sc.nextInt());
        } while (exist == -1);
        return lsm.getStudentList().get(exist);
    }
    private int existStudent(int studentId) {
        ListStudentManagement lsm = new ListStudentManagement();
        for (int i = 0; i < lsm.getStudentList().size(); i++) {
            if (lsm.getStudentList().get(i).getStudentId() == studentId) {
                return i;
            }
        }
        return -1;
    }
    private Grade newGrade() {
        List<Integer> grades = new ArrayList<>();
        for (int sub = 0; sub < 6; sub++) {
            inputGrade(sub);
            grades.add(sc.nextInt());
        }
        Grade grade = new Grade(grades.get(0), grades.get(1), grades.get(2), grades.get(3), grades.get(4), grades.get(5));
        return grade;
    }
    private void inputGrade(int sub) {
        List<String> subNames = new ArrayList<>(Arrays.asList("국어", "수학", "영어", "사회", "과학", "역사"));
        dv.inputGradeMessage(subNames.get(sub));
    }
}
