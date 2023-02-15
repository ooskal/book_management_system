package Dto;

public class BookDto {
    private int book_num;
    private String title;
    private String author;
    private String publisher;
    private int price;

    public BookDto() {}

    public BookDto(String title, String author, String publisher, int price){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }
    public int getBookNum() {
        return book_num;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() { return author; }

    public String getPublisher() { return publisher; }

    public int getPrice() {return price;}

    public void setBookNum(int book_num) {this.book_num = book_num;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void  setPublisher(String publisher){
        this.publisher = publisher;
    }

    public  void setPrice(int price) {
        this.price = price;
    }

}
