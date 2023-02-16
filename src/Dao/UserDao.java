package Dao;

import Dto.UserDto;

import java.sql.*;
import java.util.Scanner;

public class UserDao {
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private Scanner sc = new Scanner(System.in);
    private PreparedStatement ps;

    private final String url = "jdbc:mysql://127.0.0.1:3306/Book";
    private final String u = "root";
    private final String pw = "753698";


    public UserDao() {}

    public void insertUser(UserDto user) {

        Scanner sc = new Scanner(System.in);
        try{
            Connection con = null;
            con = DriverManager.getConnection(url,u,pw);

            PreparedStatement ps = con.prepareStatement("insert into user value (?,?,?,?)");

            ps.setInt(1,user.getNum());
            ps.setString(2, user.getId());
            ps.setString(3, user.getPw());
            ps.setInt(4,user.getState());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException sqpx){
            System.out.println("SQLException: "+ sqpx.getMessage());
            System.out.println("SQLState: " + sqpx.getSQLState());
        }

    }

    public void deleteData (UserDto user) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        try{
            Connection con = null;
            con = DriverManager.getConnection(url,u,pw);

            ps = con.prepareStatement("select user_num from user where pw=?");

            ps.setString(1, user.getPw());
            rs = ps.executeQuery();

            while (rs.next()) {
                user.setNum(rs.getInt(1));
            }


            PreparedStatement ps = con.prepareStatement("delete from user where user_num=?");

            ps.setInt(1,user.getNum());

            ps.executeUpdate();

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

    public int logIn(UserDto user) throws ClassNotFoundException, SQLException {
        ResultSet rs;

        try {
            Connection con = null;
            con = DriverManager.getConnection(url, u, pw);


            ps = con.prepareStatement("select pw from user where id=?");

            ps.setString(1, user.getId());
            rs = ps.executeQuery();

            if (rs.next()) {

                if (rs.getString(1).contentEquals((CharSequence) user.getPw())) {
                    System.out.println("로그인 성공");
                    ps = con.prepareStatement("select user_num from user where id = ?");
                    ps.setString(1, user.getId());
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        user.setNum(rs.getInt(1));
                    }

                    if (user.getNum() == 1) {
                        System.out.println(">> 관리자 아이디입니다.");
                        user.setState(1);
                        return user.getState();

                    } else {
                        System.out.println(">> 일반회원입니다.");
                        user.setState(0);
                        return user.getState();
                    }


                } else {

                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return 0;
    }

    public void logOut() {

    }
}
