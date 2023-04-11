import service.Client;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
// 회원가입한 뒤에 로그인이 안 되는 문제
// 문제점 : lsm이나 ltm을 매번 new로 만들어대니까
// 새로운 애가 나온 거라서 저장된 studentList나 teacherList가 있는 게 아니라
// 그냥 또 새로운 애가 탄생한 거 뿐임.
// 아니 그럼 이걸 구조를 어케 해야하지
// 정무가 파라미터로 리스트 주고받고 하지 말랬는데..
// 고민.