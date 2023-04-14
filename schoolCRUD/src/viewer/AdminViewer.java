package viewer;

public class AdminViewer {
    public static void adminSignIn() {
        System.out.println("어드민 로그인에 성공했습니다.");
    }

    public static void exeMessage() {
        System.out.println("********************************");
        System.out.println("*******  관리자 화면입니다. *******");
        System.out.println("*** 원하는 기능 번호를 입력하세요.***");
        System.out.println("***** 1.교사 관리 2.학생 관리 *****");
        System.out.println("**********  0.로그아웃 **********");
        System.out.println("********************************");
    }

    public static void showTeacherMenu() {
        System.out.println("********************************");
        System.out.println("******** [교사 관리 메뉴] ********");
        System.out.println("*** 원하는 기능 번호를 입력하세요.***");
        System.out.println("*** 1.교사정보조회 2.교사정보등록 ***");
        System.out.println("*** 3.교사정보수정 4.교사정보삭제 ***");
        System.out.println("*********** 0.뒤로가기 ***********");
        System.out.println("********************************");
    }

    public static void showStudentMenu() {
        System.out.println("********************************");
        System.out.println("******** [학생 관리 메뉴] ********");
        System.out.println("*** 원하는 기능 번호를 입력하세요.***");
        System.out.println("*** 1.학생정보관리 2.학생성적관리 ***");
        System.out.println("*********** 0.뒤로가기 ***********");
        System.out.println("********************************");
    }

    public static void showStudentInfoMenu() {
        System.out.println("********************************");
        System.out.println("******** [학생 관리 메뉴] ********");
        System.out.println("*** 원하는 기능 번호를 입력하세요.***");
        System.out.println("*** 1.학생정보조회 2.학생정보등록 ***");
        System.out.println("*** 3.학생정보수정 4.학생정보삭제 ***");
        System.out.println("*********** 0.뒤로가기 ***********");
        System.out.println("********************************");
    }

    public static void showStudentGradeMenu() {
        System.out.println("********************************");
        System.out.println("******** [성적 관리 메뉴] ********");
        System.out.println("*** 원하는 기능 번호를 입력하세요.***");
        System.out.println("*** 1.학생성적조회 2.학생성적등록 ***");
        System.out.println("*** 3.학생성적수정 4.학생성적삭제 ***");
        System.out.println("*********** 0.뒤로가기 ***********");
        System.out.println("********************************");
    }

    public static void noTeacherMessage() {
        System.out.print("해당 아이디의 교사가 없습니다. 아이디를 다시 입력해주세요. : ");
    }

    public static void selectTeacher() {
        System.out.print("원하는 교사의 아이디를 입력하세요. : ");
    }
}
