import Dao.UserDao;
import Dto.UserDto;

import java.sql.SQLException;
import java.util.Scanner;

public class BookMain {
    private Admin admin;
    private User user;
    private UserDao userDao;

    public BookMain() {
        this.admin = new Admin();
        this.user = new User();
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
                    login();
                    break;
                case 2:
                    signUp();
                    break;
                    }
    }

    public void login() throws SQLException, ClassNotFoundException {
        UserDto userDto = new UserDto();
        System.out.println(">> 로그인을 선택하셨습니다.");
        sc.nextLine();
        System.out.println(">> 아이디를 입력해주세요.");
        userDto.setId(sc.nextLine());
        System.out.println(">> 비밀번호를 입력해주세요.");
        userDto.setPw(sc.nextLine());
        userDao.logIn(userDto);
        System.out.println(userDto.getState());


        if(userDto.getState() == 1){
            admin.login();
            System.out.println(">> 메뉴를 선택해주세요.");
            System.out.println(">> 1. 추가  2. 삭제  3. 수정  4. 조회  5. 종료");
            int num =sc.nextInt();
            admin.menu(num);
        }
        else {
            user.login();
            System.out.println(">> 메뉴를 선택해주세요.");
            System.out.println(">> 1. 대여  2. 반납  3. 조회  4. 회원탈퇴  5. 종료");
            int num = sc.nextInt();
            user.menu(num);
        }
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
