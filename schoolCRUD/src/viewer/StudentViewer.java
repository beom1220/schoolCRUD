package viewer;

public class StudentViewer {
    public void exeMessage() {
        System.out.println("********************************");
        System.out.println("****** 학생 지원 시스템입니다.******");
        System.out.println("*** 원하는 기능 번호를 입력하세요.***");
        System.out.println("**** 1.학생정보조회  2.성적조회 ****");
        System.out.println("*********** 0.로그아웃 ***********");
        System.out.println("********************************");
    }
    public void levelMessage() {
        System.out.print("학년을 입력해주세요. : ");
    }

    public void schoolClassMessage() {
        System.out.print("반을 입력해주세요. : ");
    }

    public void classNumMessage() {
        System.out.print("반에서의 번호를 입력해주세요. : ");
    }
}
