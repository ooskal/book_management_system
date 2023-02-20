import Dao.UserDao;
import Dto.UserDto;

import java.sql.SQLException;
import java.util.Scanner;

public class BookMain {
    private UserDao userDao;
    private UserManagement userManagement;

    public BookMain() {
        this.userDao = new UserDao();
    }

    private Scanner sc = new Scanner(System.in);


    public void start() throws SQLException, ClassNotFoundException {
        System.out.println("--------------- 도서 정보 관리 시스템 ---------------");
        choice(); //로그인 회원가입 선택

        UserManagement userManagement = new User();

        userManagement.login();
    }

    public void choice() throws SQLException, ClassNotFoundException {
        System.out.println(">> 1. 로그인  2. 회원가입");
        int num = 0;
        num = sc.nextInt();
        switch (num) {
                case 1:
                UserDto userDto = new UserDto();

                int userCheck = login();
                System.out.println(userDto.getState());

                if (userCheck == 1) {
                    this.userManagement = new Admin();
                    userManagement.login();
                } else if (userCheck == 0) {
                    this.userManagement = new User();
                    userManagement.login();
                }
                userManagement.login();
                break;
                case 2:
                User user = new User();
                user.signUp();
                break;
        }


    }

    public int login() throws SQLException, ClassNotFoundException {
        UserDto userDto = new UserDto();
        System.out.println(">> 로그인을 선택하셨습니다.");
        sc.nextLine();
        System.out.println(">> 아이디를 입력해주세요.");
        userDto.setId(sc.nextLine());
        System.out.println(">> 비밀번호를 입력해주세요.");
        userDto.setPw(sc.nextLine());
        userDao.logIn(userDto);


        return userDto.getState();
    }


}
