package viewer;

import user.Student;
import user.Teacher;

public class TeacherViewer {
    public static void exeMessage() {
        System.out.println("********************************");
        System.out.println("****** 교사 지원 시스템입니다.******");
        System.out.println("*** 원하는 기능 번호를 입력하세요.***");
        System.out.println("***** 1.내 정보 2.학생정보관리 *****");
        System.out.println("***** 3.학생성적관리 0.로그아웃 *****");
        System.out.println("********************************");
    }
    public static void inputSubjectMessage() {
        System.out.println("당신의 교과목은 무엇입니까?");
        System.out.println("1.국어 2.수학 3.영어 4.과학 5.사회 6.역사 7.그외");
    }
    public static void teacherSignIn() {
        System.out.println("교사 로그인에 성공했습니다.");
    }
    public static void addOnMessage() {
        System.out.print("정보 수정을 원하시면 수정할 정보에 맞는 번호를 입력하세요. (뒤로가기 : 0번) : ");
    }
    public static void selectStudent() {
        System.out.print("원하는 학생의 학번을 입력하세요. : ");
    }

    public static void inquiryTeacherInfo(Teacher teacher) {
        System.out.println("교사 " + teacher.getName() + " 님의 개인 정보입니다.");
        System.out.println("1.이름 : " + teacher.getName());
        System.out.println("2.과목 : " + teacher.getSubject());
        System.out.println("3.성별 : " + teacher.getGender());
        System.out.println("4.생년월일 : " + teacher.getBirthday());
        System.out.println("5.아이디 : " + teacher.getId());
        System.out.print("정보 수정을 원하시면 수정할 정보에 해당되는 번호를 입력하세요.(0.뒤로가기) : ");
    }

    public static void noStudentMessage() {
        System.out.print("해당 학번의 학생에 대한 데이터가 없습니다. 학번을 다시 입력해주세요. : ");
    }
    public static void inputGradeMessage(String sub) {
        System.out.print(sub + " 과목의 점수를 입력해주세요. : ");
    }
    public static void failSeasonMessage() {
        System.out.print("해당 시기의 점수가 없습니다. 다시 입력해주세요. : ");
    }
    public static void changeIdMessage() {
        System.out.print("변경할 아이디를 입력하세요. : ");
    }
    public static void changeNameMessage() {
        System.out.print("변경할 이름을 입력하세요. : ");
    }

    public static void changeGenderMessage() {
        System.out.print("변경할 성별을 입력하세요. (1-남/2-여) : ");
    }

    public static void changeBirthdayMessage() {
        System.out.print("변경할 생년월일을 8자리로 입력하세요. (ex-20001220) : ");
    }

    public static void selectGradeFunction(Student student) {
        System.out.println(student.getName() + " 학생의 성적에 관하여 실행할 기능의 번호를 입력해주세요.");
        System.out.println("1.조회 2.수정 3.삭제 4.등록 (0.뒤로가기)");
    }
    public static void delGrade() {
        System.out.println("해당되는 성적을 삭제했습니다.");
    }

    public static void selectChangeGradeSubjectFunction() {
        System.out.println("성적 중 변경을 원하는 과목을 선택해주세요.");
        System.out.println("1.국어 2.수학 3.영어 4.사회 5.과학 6.역사");
    }
}
