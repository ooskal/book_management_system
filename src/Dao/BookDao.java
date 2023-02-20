package Dao;

import Dto.BookDto;

import java.sql.*;
import java.util.Scanner;

public class BookDao  {
    private Connection con = null;
    private Statement stmt = null;

    BookDto book = new BookDto();

    private final String url = "jdbc:mysql://127.0.0.1:3306/Book";
    private final String u = "root";
    private final String pw = "753698";



    // 추가
    public void insertData (BookDto book) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        try{
            Connection con = null;
            con = DriverManager.getConnection(url,u,pw);

            PreparedStatement ps = con.prepareStatement("insert into book(title, author, publisher, price) value (?,?,?,?)");

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3,book.getPublisher());
            ps.setInt(4,book.getPrice());


            ps.executeUpdate();

            ps.close();


        } catch (SQLException sqpx){
            System.out.println("SQLException: "+ sqpx.getMessage());
            System.out.println("SQLState: " + sqpx.getSQLState());

        }

    }

    //삭제
    public void deleteData () throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        try{
            Connection con = null;
            con = DriverManager.getConnection(url,u,pw);

            int num = sc.nextInt();

            PreparedStatement ps = con.prepareStatement("delete from book where book_num="+num);

            ps.executeUpdate();
            ps.close();


        } catch (SQLException sqpx){
            System.out.println("SQLException: "+ sqpx.getMessage());
            System.out.println("SQLState: " + sqpx.getSQLState());

        }

    }

    //수정
    public void updateData (BookDto book, int num) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        PreparedStatement ps=null;
        String sql = null;

        try{
            Connection con = null;
            con = DriverManager.getConnection(url,u,pw);

            sql = "select * from book where book_num=";
            ps = con.prepareStatement(sql+num);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                sql = "update book set title=?, author=?,publisher=?,price=? where book_num=";
                ps = con.prepareStatement(sql+num);
                ps.setString(1,book.getTitle());
                ps.setString(2,book.getAuthor());
                ps.setString(3,book.getPublisher());
                ps.setInt(4,book.getPrice());
            } else {
                System.out.println("번호가 존재하지 않습니다.");
            }

            sql = ("delete from book where book_num="+num);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException sqpx){
            System.out.println("SQLException: "+ sqpx.getMessage());
            System.out.println("SQLState: " + sqpx.getSQLState());
        }
    }

    //조회
    public void selectData () throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        try{
            Connection con = null;
            con = DriverManager.getConnection(url,u,pw);


            PreparedStatement ps = con.prepareStatement("select * from book");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1)+" "+rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " +rs.getInt(5) );
            }
            rs.close();
            ps.close();
        } catch (SQLException sqpx){
            System.out.println("SQLException: "+ sqpx.getMessage());
            System.out.println("SQLState: " + sqpx.getSQLState());

        }

    }







}
