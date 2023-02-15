package Dao;

import Dto.UserDto;

import java.sql.*;
import java.util.Scanner;

public class UserDao {
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    UserDto user = new UserDto();

    private final String url = "jdbc:mysql://127.0.0.1:3306/Book";
    private final String u = "root";
    private final String pw = "753698";


    public UserDao() {}

    public void insertUser() {

        Scanner sc = new Scanner(System.in);
        try{
            Connection con = null;
            con = DriverManager.getConnection(url,u,pw);


            System.out.println(">> 회원가입 메뉴를 선택하셨습니다..");
            System.out.println(">> 아이디를 입력해주세요.");
            user.setId(sc.nextLine());
            System.out.println(">> 비밀번호를 입력해주세요.");
            user.setPw(sc.nextLine());

            PreparedStatement ps = con.prepareStatement("insert into user value (?,?,?)");

            ps.setInt(1,0);
            ps.setString(2, user.getId());
            ps.setString(3, user.getPw());



            ps.executeUpdate();

            System.out.println(">> 회원가입이 완료되었습니다.");

            ps.close();


        } catch (SQLException sqpx){
            System.out.println("SQLException: "+ sqpx.getMessage());
            System.out.println("SQLState: " + sqpx.getSQLState());

        }

    }

    public void deleteData () throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        try{
            Connection con = null;
            con = DriverManager.getConnection(url,u,pw);


            System.out.println(">> 삭제메뉴를 선택하셨습니다.");

            selectData();

            System.out.println(">> 삭제하실 회원의 번호를 입력해주세요.");

            int num = sc.nextInt();

            PreparedStatement ps = con.prepareStatement("delete from user where user_num="+num);


            ps.executeUpdate();

            System.out.println(">> 회원탈퇴가 완료되었습니다.");

            ps.close();


        } catch (SQLException sqpx){
            System.out.println("SQLException: "+ sqpx.getMessage());
            System.out.println("SQLState: " + sqpx.getSQLState());

        }

    }

    public void selectData () throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        try{
            Connection con = null;
            con = DriverManager.getConnection(url,u,pw);


            PreparedStatement ps = con.prepareStatement("select * from user");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1)+" "+rs.getString(2) + " " + rs.getString(3) + " " );
            }

            rs.close();
            ps.close();



        } catch (SQLException sqpx){
            System.out.println("SQLException: "+ sqpx.getMessage());
            System.out.println("SQLState: " + sqpx.getSQLState());

        }

    }

    public void logIn() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        ResultSet rs;
        PreparedStatement ps ;

        try{
            Connection con = null;
            con = DriverManager.getConnection(url,u,pw);



            System.out.println(">> 로그인 메뉴를 선택하셨습니다.");
            System.out.println(">> 아이디를 입력해주세요.");
            user.setId(sc.nextLine());
            System.out.println(">> 비밀번호를 입력해주세요.");
            user.setPw(sc.nextLine());



            ps = con.prepareStatement("select pw from user where id=?");

            ps.setString(1, user.getId());
            rs = ps.executeQuery();

            if(rs.next()) {

                if(rs.getString(1).contentEquals(user.getPw())) {
                    System.out.println("로그인 성공");
                    ps = con.prepareStatement("select user_num from user where id = ?");
                    ps.setString(1, user.getId());
                    rs = ps.executeQuery();
                    while(rs.next()) {
                        user.setNum(rs.getInt(1));
                    }
                    if(user.getNum() == 1) {
                        System.out.println(">> 관리자 아이디입니다.");
                        user.setState(1);
                    } else {
                        System.out.println(">> 일반회원입니다.");
                        user.setState(0);
                    }


                } else{

                }
            }


        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
