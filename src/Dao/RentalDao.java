package Dao;

import Dto.BookDto;
import Dto.UserDto;
import Dto.RentalDto;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class RentalDao {
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private Scanner sc = new Scanner(System.in);
    private PreparedStatement ps;

    private final String url = "jdbc:mysql://127.0.0.1:3306/Book";
    private final String u = "root";
    private final String pw = "753698";

    public RentalDao() {
        BookDao bookDao = new BookDao();
    }

    public void selectData() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        try{
            Connection con = null;
            con = DriverManager.getConnection(url,u,pw);


            PreparedStatement ps = con.prepareStatement("select * from rental");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("  "+rs.getInt(1)+"     "+rs.getInt(2) + "          " + rs.getInt(3) + "          " + rs.getString(4) + "      " +rs.getString(5) );
            }

            rs.close();
            ps.close();



        } catch (SQLException sqpx){
            System.out.println("SQLException: "+ sqpx.getMessage());
            System.out.println("SQLState: " + sqpx.getSQLState());

        }

    }
    public void rentBook(BookDto book, UserDto user) throws ClassNotFoundException {
        LocalDate now = LocalDate.now();


        try{
            Connection con = null;
            con = DriverManager.getConnection(url,u,pw);



            ps = con.prepareStatement("select user_num from user where id = ?");
            ps.setString(1, user.getId());
            rs = ps.executeQuery();

            while(rs.next()) {
                user.setNum(rs.getInt(1));
            }

            ps = con.prepareStatement("insert into rental value (?,?,?,?,?)");

            ps.setInt(1,0);
            ps.setInt(2, book.getBookNum());
            ps.setInt(3, user.getNum());
            ps.setString(4, String.valueOf(now));
            ps.setString(5, null);

            ps.executeUpdate();

            ps.close();


        } catch (SQLException sqpx){
            System.out.println("SQLException: "+ sqpx.getMessage());
            System.out.println("SQLState: " + sqpx.getSQLState());

        }


    }

    public void returnBook(UserDto user,BookDto book) throws ClassNotFoundException {
        RentalDto rentalDto = new RentalDto();
        Scanner sc = new Scanner(System.in);
        LocalDate now = LocalDate.now();
        ResultSet rs;
        PreparedStatement ps ;



        try{
            Connection con = null;
            con = DriverManager.getConnection(url,u,pw);

            ps = con.prepareStatement("select user_num from user where id = ?");
            ps.setString(1, user.getId());
            rs = ps.executeQuery();

            while(rs.next()) {
                user.setNum(rs.getInt(1));
            }

            ps = con.prepareStatement("select book_num from rental where user_num=?" );
            ps.setInt(1,user.getNum());
            rs = ps.executeQuery();

            while (rs.next()) {
                book.setBookNum(rs.getInt(1));
            }

            ps = con.prepareStatement("select id from rental where user_num = ? and book_num = ?");

            ps.setInt(1,user.getNum());
            ps.setInt(2,book.getBookNum());
            rs = ps.executeQuery();

            while (rs.next()) {
                RentalDto.setId(rs.getInt(1));
            }

            ps = con.prepareStatement("update rental set return_date =? where id =?");

            ps.setString(1, String.valueOf(now));
            ps.setInt(2, RentalDto.getId());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException sqpx){
            System.out.println("SQLException: "+ sqpx.getMessage());
            System.out.println("SQLState: " + sqpx.getSQLState());

        }

    }

    public void userRentHistory (UserDto user) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        ResultSet rs;
        PreparedStatement ps ;
        try{
            Connection con = null;
            con = DriverManager.getConnection(url,u,pw);


            ps = con.prepareStatement("select user_num from user where id = ?");
            ps.setString(1, user.getId());
            rs = ps.executeQuery();

            while(rs.next()) {
                user.setNum(rs.getInt(1));
            }


            ps = con.prepareStatement("select a.book_num,a.title,a.author,a.publisher from book as a inner join rental as b on a.book_num = b.book_num where b.user_num=?");
            ps.setInt(1, user.getNum());

            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1)+" "+rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }

            rs.close();
            ps.close();



        } catch (SQLException sqpx){
            System.out.println("SQLException: "+ sqpx.getMessage());
            System.out.println("SQLState: " + sqpx.getSQLState());

        }

    }
}
