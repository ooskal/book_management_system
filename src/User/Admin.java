package User;

import Book.Book;

import java.util.Scanner;

public class Admin extends User  {

    public Admin(String id, String pw) {
        super(id, pw);
    }
    public Admin() {}

    Scanner sc = new Scanner(System.in);

   //List<Book> bookList = new Vector<Book>();

    Book book = new Book();

    public void notice() {
        System.out.println("다른 메뉴를 선택하시거나, 종료버튼(5)을 클릭해주세요.");
    }

    }

