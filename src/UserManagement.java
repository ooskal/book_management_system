import java.sql.SQLException;

public interface UserManagement {


    public void menu() throws SQLException, ClassNotFoundException;

    public void rentalCheck() throws SQLException, ClassNotFoundException;

    public void login() throws SQLException, ClassNotFoundException;

    public void logout() throws SQLException, ClassNotFoundException;

    public void menuPick();

}

