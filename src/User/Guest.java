package User;

import java.util.Scanner;

public class Guest extends User{


    Scanner sc = new Scanner(System.in);
    Admin admin = new Admin();

    public void rentBook() {

        System.out.println(">> 대여 메뉴를 선택하셨습니다.");
        System.out.println(">> 대여하실 책을 선택해주세요.");
        admin.readInfo();
        System.out.println(">> 대여하실 책 번호를 선택해주세요.");
        int i = sc.nextInt();

        System.out.println(">> 대여를 완료하였습니다.");

    }

    public void readBook() {

        System.out.println(">> 조회 메뉴를 선택하셨습니다.");
        admin.readInfo();

    }

    public void returnBook() {

        System.out.println(">> 반납 메뉴를 선택하셨습니다.");
        System.out.println(">> 현재 대여 중인 책");

    }

}
