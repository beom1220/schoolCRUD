package viewer;

import user.Student;

public class StudentViewer {
    public static void exeMessage() {
        System.out.println("********************************");
        System.out.println("****** 학생 지원 시스템입니다.******");
        System.out.println("*** 원하는 기능 번호를 입력하세요.***");
        System.out.println("**** 1.학생정보조회  2.성적조회 ****");
        System.out.println("*********** 0.로그아웃 ***********");
        System.out.println("********************************");
    }
    public static void levelMessage() {
        System.out.print("학년을 입력해주세요.(1~3) : ");
    }

    public static void schoolClassMessage() {
        System.out.print("반을 입력해주세요.(1~10) : ");
    }

    public static void classNumMessage() {
        System.out.print("반에서의 번호를 입력해주세요.(1~30) : ");
    }

    public static void redundancyStudentIdMessage() {
        System.out.println("이미 등록된 학번입니다.");
    }

    public static void studentSignIn() {
        System.out.println("학생 로그인에 성공했습니다.");
    }
    public static void selectExamSeason() {
        // 이거 이렇게 받지 말고, (학년, 학기, 중간/기말) 받아와서 보여주는 걸로 고치자.
        System.out.println("1. 1학년 1학기 중간고사 / 2. 1학년 1학기 기말고사");
        System.out.println("3. 1학년 2학기 중간고사 / 4. 1학년 2학기 기말고사");
        System.out.println("5. 2학년 1학기 중간고사 / 6. 2학년 1학기 기말고사");
        System.out.println("7. 2학년 2학기 중간고사 / 8. 2학년 2학기 기말고사");
        System.out.println("9. 3학년 1학기 중간고사 / 10. 3학년 1학기 기말고사");
        System.out.println("11. 3학년 2학기 중간고사 / 12. 3학년 2학기 기말고사");
        System.out.print("열람을 원하는 시험 시기의 번호를 입력해주세요. (0.뒤로가기) : ");
    }
    public static void inquiryGrade(String seasonString, Student student, int season) {
        System.out.println(student.getName() + " 학생의 " + seasonString + " 성적은 다음과 같습니다.");
        System.out.println("국어 : " + student.getGradeList().get(season).getKor());
        System.out.println("영어 : " + student.getGradeList().get(season).getEng());
        System.out.println("수학 : " + student.getGradeList().get(season).getMath());
        System.out.println("사회 : " + student.getGradeList().get(season).getSociety());
        System.out.println("과학 : " + student.getGradeList().get(season).getScience());
        System.out.println("역사 : " + student.getGradeList().get(season).getHistory());
        System.out.println("평균 : " + student.getGradeList().get(season).getAverage());
    }
    public static void inquiryStudentInfo(Student student) {
        System.out.println(student.getName() + " 학생의 개인 정보입니다.");
        System.out.println("1.학번(학,반,번호) : " + student.getStudentId());
        System.out.println("2.이름 : " + student.getName());
        System.out.println("3.성별 : " + student.getGender());
        System.out.println("4.생년월일 : " + student.getBirthday());
        System.out.println("5.아이디 : " + student.getId());
        System.out.println("6.성적 : 시험 시기별 별도 열람");
    }
}
