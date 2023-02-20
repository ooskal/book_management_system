package Dto;

public class RentalDto {
    private int id;
    private String rental_date;
    private String return_date;
    private int rental_yn;

    public int getId() {return id;}

    public String getRentalDate() {
        return rental_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public int getRental_yn() {
        return rental_yn;
    }


    public void setId(int id) {this.id = id;}

    public void setRental_yn(int rental_yn) {this.rental_yn = rental_yn;}

    public void setRentalDate(String rental_date) {
        this.rental_date = rental_date;
    }

    public void setReturnDate(String return_date) {
        this.return_date = return_date;
    }


}
