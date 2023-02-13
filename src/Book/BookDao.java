package Book;

import java.sql.*;
import java.util.Scanner;

public class BookDao  {
    private Connection con = null;
    private Statement stmt = null;

    Book book = new Book();



    // 추가
    public void insertData () throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        try{
            Connection con = null;
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Book","root","753698");


            System.out.println(">> 추가메뉴를 선택하셨습니다.");
            System.out.println(">> 제목을 입력해주세요.");
            book.setTitle(sc.nextLine());
            System.out.println(">> 작가를 입력해주세요.");
            book.setAuthor(sc.nextLine());
            System.out.println(">> 출판사를 입력해주세요.");
            book.setPublisher(sc.nextLine());
            System.out.println(">> 가격을 입력해주세요.");
            book.setPrice(sc.nextInt());

            PreparedStatement ps = con.prepareStatement("insert into book value (?,?,?,?,?)");

            ps.setInt(1,0);
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4,book.getPublisher());
            ps.setInt(5,book.getPrice());


            ps.executeUpdate();

            System.out.println(">> 책 등록이 완료되었습니다.");

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
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Book","root","753698");


            System.out.println(">> 삭제메뉴를 선택하셨습니다.");

            selectData();

            System.out.println(">> 삭제하실 책의 번호를 입력해주세요.");

            int num = sc.nextInt();

            PreparedStatement ps = con.prepareStatement("delete from book where book_num="+num);
            //where id="+uid  부분을 where id='"+uid"'"

            ps.executeUpdate();

            System.out.println(">> 책 삭제가 완료되었습니다.");

            ps.close();


        } catch (SQLException sqpx){
            System.out.println("SQLException: "+ sqpx.getMessage());
            System.out.println("SQLState: " + sqpx.getSQLState());

        }

    }

    //수정
    public void updateData () throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        PreparedStatement ps=null;
        String sql = null;

        try{
            Connection con = null;
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Book","root","753698");


            System.out.println(">> 수정메뉴를 선택하셨습니다.");

            selectData();

            System.out.println(">> 수정하실 책의 번호를 입력해주세요.");


            int num = sc.nextInt();

            sql = "select * from book where book_num=";
            ps = con.prepareStatement(sql+num);

            ResultSet rs = ps.executeQuery();

            sc.nextLine();

            if(rs.next()) {
                System.out.println(">> 제목");
                book.setTitle(sc.nextLine());
                System.out.println(">> 작가");
                book.setAuthor(sc.nextLine());
                System.out.println(">> 출판사");
                book.setPublisher(sc.nextLine());
                System.out.println(">> 가격");
                book.setPrice(sc.nextInt());

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
            //where id="+uid  부분을 where id='"+uid"'"

            ps.executeUpdate();

            System.out.println(">> 책 수정이 완료되었습니다.");

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
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Book","root","753698");


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
