package Book;

import User.User;
import java.sql.*;
import java.util.Scanner;

public class Rental extends Book {

    BookDao bookDao = new BookDao();
    User user = new User();
    public void rentalData () throws ClassNotFoundException, SQLException {
        String sql = null;
        PreparedStatement ps=null;
        Scanner sc = new Scanner(System.in);
        try{
            Connection con = null;
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Book","root","753698");

            System.out.println(">> 대여메뉴를 선택하셨습니다.");

            bookDao.selectData();

            System.out.println(">> 대여하실 책의 번호를 입력해주세요.");

            int num = sc.nextInt();


            sql = "select * from book where book_num=";
            ps = con.prepareStatement(sql+num);

            ResultSet rs = ps.executeQuery();

            sc.nextLine();

            if(rs.next()) {

                while(rs.next()){
                    setBookNum(rs.getInt("book_num"));

                }

                sql = "insert into book value (?,?,?,?,?) where book=";
                ps = con.prepareStatement(sql+num);
                ps.setInt(1,0);
                ps.setString(2,rs.);
                ps.setString(3,getPublisher());
                ps.setInt(4,getPrice());
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
}
