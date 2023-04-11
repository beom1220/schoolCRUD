import service.Client;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}

// 어드민 추가하기
// 서비스 클래스에 있는 것들 기능마다 좀 구분해서 다른 클래스로 나누기
// 뷰어 중에 보면, static으로 했는데도 전에 생성해둔 객체 있는 곳이 아직 있던데, 다 찾아서 지우기