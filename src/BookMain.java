import java.util.Scanner;

public class BookMain {
    public BookMain() {}
    Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("--------------- 도서 정보 관리 시스템 ---------------");
        choice(); //로그인 회원가입 선택

    }

    public void choice() {
        System.out.println(">> 1. 로그인  2. 회원가입");
        int num = 0;
        num = sc.nextInt();

            switch (num) {
                case 1:
                    System.out.println(" >> 로그인 메뉴 선택 ");
                    break;
                case 2:
                    System.out.println(" >> 회원가입 메뉴 선택");
                    break;
                    }
    }

    public void login() {

    }

}
