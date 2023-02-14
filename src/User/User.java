package User;

public class User {

    private int user_num;
    private String id;
    private String pw;
    private int state; //0 -> 로그아웃 1-> 로그인
    private int account_state; //유저  일반 관리자 구분

    public User() {

    }

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
    public int getNum() {
        return user_num;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void  setPw(String pw) {
        this.pw = pw;
    }

    public void setNum(int user_num) {this.user_num = user_num;}

    public void setUserNum(int user_num) {
        this.user_num = user_num;
    }

    public void login() {
        System.out.println("일반회원으로 로그인하셨습니다.");
    }

}
