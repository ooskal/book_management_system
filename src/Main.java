import Book.BookDao;
import User.Admin;
import User.Guest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        while (true) {



            Scanner sc = new Scanner(System.in);
            int num = 0;
            int user = 0;
            int state = 0;

            System.out.println("****************** 로그인 ******************");
            System.out.println(">> 1. 일반 사용자 2. 관리자");

            user = sc.nextInt();

            //일반
            if (user == 1) {
                state = 1;
                Guest guest = new Guest();

                System.out.println(">> 일반 사용자로 로그인");
                System.out.println("************** 도서 대여 시스템 **************");
                System.out.println(">> 1. 대여  2. 반납  3. 조회  4. 종료 ");
                System.out.println(">> 메뉴를 선택해주세요.");

                while (num != 4) {

                    num = sc.nextInt();

                    switch (num) {
                        case 1:
                            guest.rentBook();
                            break;
                        case 2:
                            guest.returnBook();
                            break;
                        case 3:
                            guest.readBook();
                            break;
                        case 4:
                            System.out.println(">> 종료 메뉴룰 선택하였습니다."); // 인터페이스로 넘길까?
                            System.out.println(">> 시스템을 종료합니다.");
                            break;
                    }

                }


            }

            if (user == 2) {

                Admin admin = new Admin();
                BookDao bookDao = new BookDao();
                state = 1;

                System.out.println(">> 관리자로 로그인");
                System.out.println("************** 도서 관리 시스템 **************");
                System.out.println(">> 1. 추가  2. 수정  3. 삭제  4. 조회  5. 종료");
                System.out.println(">> 메뉴를 선택해주세요.");

                while (num != 5) {


                    num = sc.nextInt();

                    switch (num) {
                        case 1:
                            bookDao.insertData();
                            break;
                        case 2:
                            bookDao.updateData();
                            break;
                        case 3:
                            bookDao.deleteData();
                            break;
                        case 4:
                            System.out.println(">> 조회 메뉴를 선택하셨습니다.");
                            bookDao.selectData();
                            break;
                        case 5:
                            System.out.println(">> 종료 메뉴룰 선택하였습니다.");
                            System.out.println(">> 시스템을 종료합니다.");
                            break;


                    }
                }
            }


        }
    }

}
