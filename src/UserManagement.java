import java.sql.SQLException;

public interface UserManagement {


    public void menu(int choice) throws SQLException, ClassNotFoundException;

    public void rentalCheck();

    public void login();

    public void logout();

}

