package viewer;

import user.Student;
import user.Teacher;

public final class DefaultViewer {
    public void exeMessage() {
        System.out.println("*********************************");
        System.out.println("****학생 및 교사 지원시스템입니다.****");
        System.out.println("***원하시는 실행번호를 입력해주세요.***");
        System.out.println("******* 1.로그인 2.회원가입 *******");
        System.out.println("*********************************");
    }
    public void selectJob() {
        System.out.print("당신의 직업은 무엇입니까? (1.학생 / 2.교사) : ");
    }

    public void inputNameMessage() {
        System.out.print("당신의 이름을 입력해주세요. : ");
    }

    public void inputGenderMessage() {
        System.out.print("당신의 성별은 무엇입니까? (1.남성 / 2.여성) : ");
    }

    public void inputBirthdayMessage() {
        System.out.print("당신의 생년월일을 8자리로 입력해주세요.(ex:20001220) : ");
    }

    public void inputIdMessage() {
        System.out.print("당신이 사용할 ID를 입력해주세요. : ");
    }

    public void inputPasswordMessage() {
        System.out.print("당신이 사용할 비밀번호를 입력해주세요. : ");
    }

    public void redundancyIdMessage() {
        System.out.println("중복된 아이디입니다.");
    }

    public void okayId() {
        System.out.println("사용 가능한 아이디입니다.");
    }

    public void redundancyStudentIdMessage() {
        System.out.println("이미 등록된 학번입니다.");
    }

    public void failSignIn() {
        System.out.println("아이디 혹은 비밀번호가 잘못되었습니다.");
    }

    public void checkPwMessage() {
        System.out.print("비밀번호를 입력해주세요. : ");
    }

    public void checkIdMessage() {
        System.out.print("아이디를 입력해주세요. : ");
    }

    public void teacherSignIn() {
        System.out.println("교사 로그인에 성공했습니다.");
    }

    public void studentSignIn() {
        System.out.println("학생 로그인에 성공했습니다.");
    }

    public void adminSignIn() {
        System.out.println("어드민 로그인에 성공했습니다.");
    }

    public void selectExamSeason() {
        // 이거 이렇게 받지 말고, (학년, 학기, 중간/기말) 받아와서 보여주는 걸로 고치자.
        System.out.println("1. 1학년 1학기 중간고사 / 2. 1학년 1학기 기말고사");
        System.out.println("3. 1학년 2학기 중간고사 / 4. 1학년 2학기 기말고사");
        System.out.println("5. 2학년 1학기 중간고사 / 6. 2학년 1학기 기말고사");
        System.out.println("7. 2학년 2학기 중간고사 / 8. 2학년 2학기 기말고사");
        System.out.println("9. 3학년 1학기 중간고사 / 10. 3학년 1학기 기말고사");
        System.out.println("11. 3학년 2학기 중간고사 / 12. 3학년 2학기 기말고사");
        System.out.print("열람을 원하는 시험 시기의 번호를 입력해주세요. : ");
    }

    public void inquiryGrade(String seasonString, Student student, int season) {
        System.out.println(student.getName() + " 학생의 " + seasonString + " 성적은 다음과 같습니다.");
        System.out.println("국어 : " + student.getGradeList().get(season).getKor());
        System.out.println("영어 : " + student.getGradeList().get(season).getEng());
        System.out.println("수학 : " + student.getGradeList().get(season).getMath());
        System.out.println("사회 : " + student.getGradeList().get(season).getSociety());
        System.out.println("과학 : " + student.getGradeList().get(season).getScience());
        System.out.println("역사 : " + student.getGradeList().get(season).getHistory());
        System.out.println("평균 : " + student.getGradeList().get(season).getAverage());
    }

    public void inquiryStudentInfo(Student student) {
        System.out.println(student.getName() + " 학생의 개인 정보입니다.");
        System.out.println("1.학번(학,반,번호) : " + student.getStudentId());
        System.out.println("2.이름 : " + student.getName());
        System.out.println("3.성별 : " + student.getGender());
        System.out.println("4.생년월일 : " + student.getBirthday());
        System.out.println("5.아이디 : " + student.getId());
        System.out.println("6.성적 : 시험 시기별 별도 열람");
    }
    public void addOnMessage() {
        System.out.print("* 성적을 열람하려면 숫자 6을, 정보 수정을 원하시면 수정할 정보에 맞는 번호를 입력하세요. (뒤로가기 : 0번) : ");
    }

    public void signOut() {
        System.out.println("로그아웃되었습니다.");
    }

    public void selectStudent() {
        System.out.print("원하는 학생의 학번을 입력하세요. : ");
    }

    public void inquiryTeacherInfo(Teacher teacher) {
        System.out.println("교사 " + teacher.getName() + " 님의 개인 정보입니다.");
        System.out.println("1.이름 : " + teacher.getName());
        System.out.println("2.과목 : " + teacher.getSubject());
        System.out.println("3.성별 : " + teacher.getGender());
        System.out.println("4.생년월일 : " + teacher.getBirthday());
        System.out.println("5.아이디 : " + teacher.getId());
        System.out.print("정보 수정을 원하시면 수정할 정보에 해당되는 번호를 입력하세요. : ");
    }

    public void noStudentMessage() {
        System.out.print("해당 학번의 학생에 대한 데이터가 없습니다. 학번을 다시 입력해주세요. : ");
    }

    public void failFunctionMessage() {
        System.out.println("잘못된 입력입니다.");
    }

    public void inputGradeMessage(String sub) {
        System.out.print(sub + " 과목의 점수를 입력해주세요. : ");
    }

    public void failSeasonMessage() {
        System.out.print("해당 시기의 점수가 없습니다. 다시 입력해주세요. : ");
    }

    public void changeNameMessage() {
        System.out.print("변경할 이름을 입력하세요. : ");
    }

    public void changeGenderMessage() {
        System.out.print("변경할 성별을 입력하세요. (1-남/2-여) : ");
    }

    public void changeBirthdayMessage() {
        System.out.print("변경할 생년월일을 8자리로 입력하세요. (ex-20001220) : ");
    }

    public void selectGradeFunction(Student student) {
        System.out.println(student.getName() + " 학생의 성적에 관하여 실행할 기능의 번호를 입력해주세요.");
        System.out.println("1.조회 2.수정 3.삭제 4.등록 (0.뒤로가기)");
    }

    public void delGrade() {
        System.out.println("해당되는 성적을 삭제했습니다.");
    }

    public void selectChangeGradeSubjectFunction() {
        System.out.println("성적 중 변경을 원하는 과목을 선택해주세요.");
    }
}
