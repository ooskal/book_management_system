import Dao.BookDao;
import Dao.UserDao;
import Dto.BookDto;
import Dto.UserDto;

import java.sql.SQLException;
import java.util.Scanner;

public class Admin implements UserManagement {
    UserDto userDto = new UserDto();
    String url = "jdbc:mysql://127.0.0.1:3306/Book";
    String u = "root";
    String pw = "753698";
    UserDao userDao = new UserDao();
    BookDao bookDao = new BookDao();
    BookDto bookDto = new BookDto();

    int num = 0;
    Scanner sc = new Scanner(System.in);
    @Override
    public void menu(int choice) throws SQLException, ClassNotFoundException {


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
                System.out.println("시스템을 종료합니다.");
                break;
        }
    }


    @Override
    public void rentalCheck() {}
    @Override
    public void login() {
        System.out.println(">> 관리자용 메뉴입니다.");
    }
    @Override
    public void logout() {}

    public void insertData() throws SQLException, ClassNotFoundException {
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

    public void deleteData() {}

    public void updateData() {}

}
