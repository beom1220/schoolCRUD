package service;

import information.Gender;
import information.Grade;
import information.Subject;
import viewer.DefaultViewer;
import user.Student;
import user.Teacher;
import viewer.StudentViewer;
import viewer.TeacherViewer;

import java.util.*;

import static information.Gender.FEMALE;
import static information.Gender.MALE;
import static information.Subject.*;

public final class Service {
    private Scanner sc = new Scanner(System.in);
    public boolean selectSign() {
        DefaultViewer.exeMessage();
        return (tryIntException() == 1);
    } //로그인인지 회원가입인지 선택

    public int selectStudentFunction(Student student) {
        switch (tryIntException()) {
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
    } // 선택한 시험 시기가 숫자로 저장돼 있으서, 출력하기 위해 문자로 바꿔주는.

    private int selectSeason(Student student) {
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

    private int inputSeason() {
        while (true) {
            int input = tryIntException();
            if (input >= 0 && input < 13) {
                return input;
            } else {
                DefaultViewer.errorMessage();
            }
        }
    } // 시험 시기 선택 시 0~12 중에 넣었는지 확인해주는.

    public int selectTeacherFunction(Teacher teacher) {
        switch (tryIntException()) {
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
                Student student = selectStudent();
                TeacherViewer.selectGradeFunction(student);
                manageGrade(student);
                return 1;
            case 4:
                return 1;
            default:
                DefaultViewer.failFunctionMessage();
                return 0;
        }
    } // 교사 로그인 시 기능 선택창.

    private void manageGrade(Student student) {
        ListStudentManagement lsm = ListStudentManagement.getInstance();
        switch (tryIntException()) {
            case 0:
                break;
            case 1:
                // 열람
                int season = selectSeason(student);
                if (season == 0) {
                    break;
                }
                StudentViewer.inquiryGrade(seasonToString(season), student, season-1);
                break;
            case 2:
                // 수정
                season = selectSeason(student);
                if (season == 0) {
                    break;
                }
                changeGrade(student.getGradeList().get(season-1));
                break;
            case 3:
                // 삭제
                season = selectSeason(student);
                if (season == 0) {
                    break;
                }
                deleteGrade(student, season-1);
                //student.getGradeList().remove(season-1);
                break;
            case 4:
                // 등록
                lsm.addGrade(student, newGrade());
                break;
            default:
                DefaultViewer.failFunctionMessage();
                break;
        }
    } // 학생 성적 관리 선택창.

    private void deleteGrade(Student student, int season) {
        Grade empty = new Grade(0, 0, 0,0,0,0);
        student.getGradeList().set(season, empty);
    } // 학생 성적 삭제. 근데 아예 지워버리면 나중에 시기 확인 같은 거 할 때 문제 생길 수 있어서 전부 0인 거 만들어서 넣음.

    private void changeGrade(Grade grade) {
        TeacherViewer.selectChangeGradeSubjectFunction();
        int sub = tryIntException() - 1;
        int score;
        do {
            inputGrade(sub);
            score = tryIntException();
        } while (!(score >= 0 && score <= 100));
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
                DefaultViewer.errorMessage();
                break;
        }
    } // 성적 수정. 고른 시기에서 고른 과목 성적을 변경할 수 있음.

    public void teacherInfo(Teacher teacher) {
        TeacherViewer.inquiryTeacherInfo(teacher);
        switch (tryIntException()) {
            case 0:
                break;
            case 1:
                // 이름 수정
                TeacherViewer.changeNameMessage();
                teacher.setName(inputName());
                break;
            case 2:
                // 과목 변경
                TeacherViewer.inputSubjectMessage();
                teacher.setSubject(selectSubject());
                break;
            case 3:
                // 성별 변경
                TeacherViewer.changeGenderMessage();
                teacher.setGender(inputGender());
                break;
            case 4:
                // 생년월일 변경
                TeacherViewer.changeBirthdayMessage();
                teacher.setBirthday(inputBirthday());
                break;
            case 5:
                // 아이디 변경 -> 중복 검사 필요함.
                TeacherViewer.changeIdMessage();
                teacher.setId(inputId());
                break;
        }
    } // 교사 정보 조회 및 수정
    public void studentInfo() {
        Student student = selectStudent();
        StudentViewer.inquiryStudentInfo(student);
        TeacherViewer.addOnMessage();
        switch (tryIntException()) {
            case 0 :
                break;
            case 1:
                // 학년, 반, 번호 수정 -> 이때 중복 학번 없게 검사해야.
                changeStudentId(student);
                break;
            case 2:
                // 이름 수정
                TeacherViewer.changeNameMessage();
                student.setName(inputName());
                break;
            case 3:
                // 성별 수정
                TeacherViewer.changeGenderMessage();
                student.setGender(inputGender());
                break;
            case 4:
                // 생년월일 수정
                TeacherViewer.changeBirthdayMessage();
                student.setBirthday(inputBirthday());
                break;
            case 5:
                // id 수정 -> 중복 검사 필요
                TeacherViewer.changeIdMessage();
                student.setId(inputId());
                break;
            default:
                DefaultViewer.failFunctionMessage();
                break;
        }
    } // 학생 정보 조회 및 수정

    private void changeStudentId(Student student) {
        int [] stdId = inputStudentId();
        student.setLevel(stdId[0]);
        student.setSchoolClass(stdId[1]);
        student.setClassNum(stdId[2]);
        student.setStudentId(stdId[0] * 10000 + stdId[1] * 100 + stdId[2]);
    }
    private int[] inputStudentId() {
        ListStudentManagement lsm = ListStudentManagement.getInstance();
        int level, schoolClass, classNum;
        do {
            StudentViewer.levelMessage();
            level = inputRange(3); // 이하 3개 입력에 입력값 제한 넣어야 함.
            StudentViewer.schoolClassMessage();
            schoolClass = inputRange(10);
            StudentViewer.classNumMessage();
            classNum = inputRange(30);
        } while (lsm.checkRedundancyStudentId(level * 10000 + schoolClass * 100 + classNum));
        int[] stdId = {level, schoolClass, classNum};
        return stdId;
    }
    private int inputRange(int range) {
        while (true) {
            int input = tryIntException();
            if (input>0 && input<=range) {
                return input;
            } else {
                DefaultViewer.errorMessage();
            }
        }
    }

    public Student selectStudent() {
        ListStudentManagement lsm = ListStudentManagement.getInstance();
        TeacherViewer.selectStudent();
        int exist = 0;
        do {
            if (exist == -1) {
                TeacherViewer.noStudentMessage();
            }
            exist = existStudent(tryIntException());
        } while (exist == -1);
        return lsm.getStudentList().get(exist);
    }
    private int existStudent(int studentId) {
        ListStudentManagement lsm = ListStudentManagement.getInstance();
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
            grades.add(inputScore());
        }
        Grade grade = new Grade(grades.get(0), grades.get(1), grades.get(2), grades.get(3), grades.get(4), grades.get(5));
        return grade;
    }
    private int inputScore() {
        while (true) {
            int score = tryIntException();
            if (score >= 0 && score <=100) {
                return score;
            } else {
                DefaultViewer.errorMessage();
            }
        }
    }
    private void inputGrade(int sub) {
        List<String> subNames = new ArrayList<>(Arrays.asList("국어", "수학", "영어", "사회", "과학", "역사"));
        TeacherViewer.inputGradeMessage(subNames.get(sub));
    }
    public static int tryIntException() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int num = sc.nextInt();
                sc.nextLine();
                return num;
            } catch (InputMismatchException ime) {
                DefaultViewer.errorMessage();
                sc = new Scanner(System.in);
            }
        }
    }
    public String inputName() {
        while (true) {
            String input = sc.nextLine();
            if (!input.matches("[\\p{L}]+$")) {
                DefaultViewer.errorMessage();
                continue;
            }
            return input;
        }
    }

    public int inputJob() {
        while (true) {
            int input = tryIntException();
            if (input == 1 || input == 2) {
                return input;
            } else {
                DefaultViewer.errorMessage();
            }
        }
    }

    public int inputBirthday() {
        int birth;
        while (true) {
            String input = sc.nextLine();
            if(!input.matches("\\d{8}")) {
                DefaultViewer.errorMessage();
                continue;
            }
            try {
                birth = Integer.parseInt(input);
                break;
            } catch (NumberFormatException nfe) {
                DefaultViewer.errorMessage();
            }
        }
        return birth;
    }
    public Gender inputGender() {
        while (true) {
            switch (tryIntException()) {
                case 1:
                    return MALE;
                case 2:
                    return FEMALE;
                default:
                    DefaultViewer.errorMessage();
                    break;
            }
        }
    }
    public String inputId() {
        String id;
        do {
            DefaultViewer.inputIdMessage();
            id = sc.nextLine();
        } while (checkRedundancyId(id));
        return id;
    }
    public boolean checkRedundancyId(String id) {
        ListTeacherManagement ltm = ListTeacherManagement.getInstance();
        ListStudentManagement lsm = ListStudentManagement.getInstance();
        if (lsm.checkRedundancyId(id) || ltm.checkRedundancyId(id)) {
            return true;
        }
        DefaultViewer.okayId();
        return false;
    }
    public void signUp() {
        DefaultViewer.selectJob();
        int selectJob = inputJob();
        DefaultViewer.inputNameMessage();
        String name = inputName();
        DefaultViewer.inputGenderMessage();
        Gender gender = inputGender();
        DefaultViewer.inputBirthdayMessage();
        int birthday = inputBirthday();
        String id = inputId();
        DefaultViewer.inputPasswordMessage();
        String password = sc.nextLine();
        if (selectJob == 1) {
            ListStudentManagement lsm = ListStudentManagement.getInstance();
            lsm.addStudent(signUpStudent(name, gender, birthday, id, password));
        } else {
            ListTeacherManagement ltm = ListTeacherManagement.getInstance();
            ltm.addTeacher(signUpTeacher(name, gender, birthday, id, password));
        }
        DefaultViewer.successRegistration();
    }

    public Teacher signUpTeacher(String name, Gender gender, int birthday, String id, String password) {
        TeacherViewer.inputSubjectMessage();
        Teacher teacher = new Teacher(selectSubject(), name, gender, birthday, id, password);
        return teacher;
    }

    public Student signUpStudent(String name, Gender gender, int birthday, String id, String password) {
        int[] stdId = inputStudentId();
        Student student = new Student(name, gender, birthday, id, password, stdId[0], stdId[1], stdId[2]);
        return student;
    }

    public Subject selectSubject() {
        while (true) {
            switch (tryIntException()) {
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
}
