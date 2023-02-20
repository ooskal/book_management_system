import Dao.BookDao;
import Dao.RentalDao;
import Dao.UserDao;
import Dto.BookDto;
import Dto.UserDto;

import java.sql.SQLException;
import java.util.Scanner;

public class Admin implements UserManagement {

    private UserDao userDao;
    private BookDao bookDao;

    private RentalDao rentalDao;

    public Admin() {
        this.userDao = new UserDao();
        this.bookDao = new BookDao();
        this.rentalDao = new RentalDao();
    }

    int num = 0;
    Scanner sc = new Scanner(System.in);
    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                insertData();
                break;
            case 2:
                deleteData();
                break;
            case 3:
                updateData();
                break;
            case 4:
                rentalCheck();
                break;
            case 5:
                logout();
                break;
        }
    }


    @Override
    public void rentalCheck() throws SQLException, ClassNotFoundException {
        System.out.println(">> 조회메뉴를 선택하셨습니다.");
        System.out.println(" ID    책번호     유저번호         대여일           반납일        ");
        rentalDao.selectData();
    }
    @Override
    public void login() throws SQLException, ClassNotFoundException {
        User user = new User();
        UserDto userDto = new UserDto();
     //   System.out.println(">> 로그인을 선택하셨습니다.");
     //   sc.nextLine();
     //   System.out.println(">> 아이디를 입력해주세요.");
//        System.out.println(">> 비밀번호를 입력해주세요.");
      //  userDto.setPw(sc.nextLine());
     //   userDao.logIn(userDto);
     //   System.out.println(userDto.getState());
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
        System.out.println(">> 1. 추가  2. 삭제  3. 수정  4. 조회  5. 로그아웃");

    }

    public void insertData() throws SQLException, ClassNotFoundException {
        BookDto bookDto = new BookDto();
        UserDto userDto = new UserDto();
        System.out.println(">> 추기메뉴를 선택하셨습니다.");
        sc.nextLine();
        System.out.println(">> 제목를 입력해주세요.");
        bookDto.setTitle(sc.nextLine());
        System.out.println(">> 작가를 입력해주세요.");
        bookDto.setAuthor(sc.nextLine());
        System.out.println(">> 출판사를 입력해주세요.");
        bookDto.setPublisher(sc.nextLine());
        System.out.println(">> 가격을 입력해주세요.");
        bookDto.setPrice(sc.nextInt());
        userDto.setNum(0);
        bookDao.insertData(bookDto);
        System.out.println(">> 책 등록이 완료되었습니다.");
    }

    public void deleteData() throws SQLException, ClassNotFoundException{
        System.out.println(">> 삭제메뉴를 선택하셨습니다.");
        bookDao.selectData();
        System.out.println(">> 삭제하실 책의 번호를 입력해주세요,");
        bookDao.deleteData();

    }

    public void updateData() throws SQLException, ClassNotFoundException{
        BookDto bookDto = new BookDto();

        System.out.println(">> 수정메뉴를 선택하셨습니다.");
        bookDao.selectData();
        System.out.println(">> 수정하실 책 번호를 입력해주세요.");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.println(">> 제목");
        bookDto.setTitle(sc.nextLine());
        System.out.println(">> 작가");
        bookDto.setAuthor(sc.nextLine());
        System.out.println(">> 출판사");
        bookDto.setPublisher(sc.nextLine());
        System.out.println(">> 가격");
        bookDto.setPrice(sc.nextInt());
        bookDao.updateData(bookDto,num);

        System.out.println(">> 책 수정이 완료되었습니다.");

    }

}
