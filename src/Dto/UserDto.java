package Dto;

public class UserDto {

    private int user_num;
    private String id;
    private String pw;
    private int state; //0 -> 로그아웃 1-> 로그인

    public UserDto() {}

    public UserDto(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
    
    public int getNum() {
        return user_num;
    }

    public String getId() {return id;}

    public String getPw() {
        return pw;
    }

    public int getState() {
        return state;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void  setPw(String pw) {
        this.pw = pw;
    }

    public void setNum(int user_num) {this.user_num = user_num;}
    
    public void setState(int state) {this.state = state;}
    

}
