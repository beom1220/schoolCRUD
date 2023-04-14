package viewer;

import user.Student;
import user.Teacher;

public class DefaultViewer {
    public static void exeMessage() {
        System.out.println("*********************************");
        System.out.println("****학생 및 교사 지원시스템입니다.****");
        System.out.println("***원하시는 실행번호를 입력해주세요.***");
        System.out.println("******* 1.로그인 2.회원가입 *******");
        System.out.println("*********************************");
    }
    public static void selectJob() {
        System.out.print("직업을 선택해주세요. (1.학생 / 2.교사) : ");
    }

    public static void inputNameMessage() {
        System.out.print("이름을 입력해주세요. : ");
    }

    public static void inputGenderMessage() {
        System.out.print("성별을 입력해주세요. (1.남성 / 2.여성) : ");
    }

    public static void inputBirthdayMessage() {
        System.out.print("생년월일을 8자리로 입력해주세요.(ex:20001220) : ");
    }

    public static void inputIdMessage() {
        System.out.print("사용할 ID를 입력해주세요. : ");
    }

    public static void inputPasswordMessage() {
        System.out.print("사용할 비밀번호를 입력해주세요. : ");
    }

    public static void redundancyIdMessage() {
        System.out.println("중복된 아이디입니다.");
    }

    public static void okayId() {
        System.out.println("사용 가능한 아이디입니다.");
    }

    public static void failSignIn() {
        System.out.println("아이디 혹은 비밀번호가 잘못되었습니다.");
    }
    public static void successRegistration() {
        System.out.println("회원가입에 성공했습니다.");
    }
    public static void checkPwMessage() {
        System.out.print("비밀번호를 입력해주세요. : ");
    }

    public static void checkIdMessage() {
        System.out.print("아이디를 입력해주세요. : ");
    }

    public static void signOut() {
        System.out.println("로그아웃되었습니다.");
    }

    public static void failFunctionMessage() {
        System.out.println("잘못된 입력입니다.");
    }

    public static void errorMessage() {
        System.out.print("잘못된 입력입니다. 주어진 조건에 맞는 입력값을 입력해주세요. : ");
    }
}
