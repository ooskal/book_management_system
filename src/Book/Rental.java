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


    }
}
