import Dao.BookDao;
import Dao.RentalDao;
import Dao.UserDao;
import Dto.BookDto;
import Dto.UserDto;

import java.sql.SQLException;
import java.util.Scanner;

public class User implements UserManagement {
    private BookDao bookDao;
    private Scanner sc = new Scanner(System.in);
    private UserDao userDao;
    private RentalDao rentalDao;
    User() {
        this.bookDao = new BookDao();
        this.userDao = new UserDao();
        this.rentalDao = new RentalDao();
    }

    @Override
    public void menu(int choice) throws SQLException, ClassNotFoundException {
        switch (choice) {
            case 1:
                rentBook();
                break;
            case 2:
                returnBook();
                break;
            case 3:
                rentalCheck();
                break;
            case 4:
                deleteAccount();
                break;
            case 5:
                System.out.println("시스템을 종료합니다.");
                break;
        }
    }
    @Override
    public void rentalCheck() throws SQLException, ClassNotFoundException {
        UserDto user = new UserDto();
        System.out.println(">> 아이디를 입력해주세요.");
        user.setId(sc.nextLine());
        System.out.println(">> 대여하신 책의 목록입니다.");
        rentalDao.userRentHistory(user);

    }
    @Override
    public void login() {
        System.out.println(">> 회원용 메뉴입니다.");
    }
    @Override
    public void logout() {}

    public void rentBook() throws SQLException, ClassNotFoundException {
        UserDto user = new UserDto();
        BookDto book = new BookDto();
        System.out.println(">> 대여메뉴를 선택하셨습니다.");
        bookDao.selectData();
        System.out.println(">> 대여하실 책 번호를 선택해주세요.");
        book.setBookNum(sc.nextInt());
        sc.nextLine();
        System.out.println(">> 아이디를 입력해주세요.");
        user.setId(sc.nextLine());
        rentalDao.rentBook(book,user);
        System.out.println(">> 책 대여가 완료되었습니다.");

    }

    public void returnBook() throws SQLException, ClassNotFoundException {
        UserDto user = new UserDto();
        BookDto book = new BookDto();
        System.out.println(">> 반납메뉴를 선택하셨습니다.");
        rentalCheck();
        System.out.println(">> 반납하실 책 번호를 입력해주세요.");
        book.setBookNum(sc.nextInt());
        sc.nextLine();
        System.out.println(">> 아이디를 입력해주세요.");
        user.setId(sc.nextLine());
        rentalDao.returnBook(user,book);
        System.out.println(">> 책 반납이 완료되었습니다.");
    }

    public void deleteAccount() throws SQLException, ClassNotFoundException {
        UserDto user = new UserDto();
        System.out.println(">> 회원탈퇴메뉴를 선택하셨습니다.");
        System.out.println(">> 회원확인을 위해 비밀번호를 입력해주세요.");
        user.setPw(sc.nextLine());
        userDao.deleteData(user);

        System.out.println(">> 회원탈퇴가 완료되었습니다.");


    }

}
