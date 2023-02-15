import Dto.UserDto;

public class Admin implements UserManagement {
    UserDto user = new UserDto();
    String url = "jdbc:mysql://127.0.0.1:3306/Book";
    String u = "root";
    String pw = "753698";


    @Override
    public void rentalCheck() {}
    @Override
    public void login() {}
    @Override
    public void logout() {}

    public void insertData() {}

    public void deleteData() {}

    public void updateData() {}

}
