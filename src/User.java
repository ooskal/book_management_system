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
    public void menu() throws SQLException, ClassNotFoundException {
        int choice = sc.nextInt();

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
                logout();
                break;
        }
    }
    @Override
    public void rentalCheck() throws SQLException, ClassNotFoundException {
        UserDto user = new UserDto();
        sc.nextLine();
        System.out.println(">> 아이디를 입력해주세요.");
        user.setId(sc.nextLine());
        System.out.println(">> 대여하신 책의 목록입니다.");
        rentalDao.userRentHistory(user);

    }
    @Override
    public void login() throws SQLException, ClassNotFoundException {
        menuPick();
        menu();
    }

    @Override
    public void logout() throws SQLException, ClassNotFoundException {
        BookMain bookMain = new BookMain();
        System.out.println(">> 로그아웃을 합니다.");
        bookMain.start();
    }

    @Override
    public void menuPick() {
        System.out.println(">> 메뉴를 선택해주세요.");
        System.out.println(">> 1. 대여  2. 반납  3. 조회  4. 회원탈퇴  5. 로그아웃");
    }

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
        sc.nextLine();
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

    public void signUp() {
        UserDto userDto = new UserDto();
        System.out.println(">> 회원가입을 선택하셨습니다.");
        sc.nextLine();
        System.out.println(">> 아이디를 입력해주세요.");
        userDto.setId(sc.nextLine());
        System.out.println(">> 비밀번호를 입력해주세요.");
        userDto.setPw(sc.nextLine());
        userDto.setState(0);
        userDto.setNum(0);
        userDao.insertUser(userDto);
        System.out.println(">> 회원가입이 완료되었습니다.");
    }

}
