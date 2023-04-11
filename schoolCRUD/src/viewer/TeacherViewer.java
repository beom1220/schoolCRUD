package viewer;

public class TeacherViewer {
    public void exeMessage() {
        System.out.println("********************************");
        System.out.println("****** 학생 지원 시스템입니다.******");
        System.out.println("*** 원하는 기능 번호를 입력하세요.***");
        System.out.println("***** 1.내 정보 2.학생정보조회 *****");
        System.out.println("*** 3.학생성적조회 4.학생성적추가 ***");
        System.out.println("*** 5.학생성적수정 4.학생성적삭제 ***");
        System.out.println("*********** 0.로그아웃 ***********");
        System.out.println("********************************");
    }
    public void inputSubjectMessage() {
        System.out.println("당신의 교과목은 무엇입니까?");
        System.out.println("1.국어 2.수학 3.영어 4.과학 5.사회 6.역사 7.그외");
    }
}
