package com.ajinkyabhutkar.springJdbc.entity;




import java.time.LocalDate;
import java.util.List;

public class issueBook {

    private int id;
    private int book_id;
    private int user_id;
    private LocalDate book_issue_date;
    private int price;
    private LocalDate book_submit_date;
    private boolean is_return;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getBook_issue_date() {
        return book_issue_date;
    }

    public void setBook_issue_date(LocalDate book_issue_date) {
        this.book_issue_date = book_issue_date;
    }

    public LocalDate getBook_submit_date() {
        return book_submit_date;
    }

    public void setBook_submit_date(LocalDate book_submit_date) {
        this.book_submit_date = book_submit_date;
    }

    public boolean isIs_return() {
        return is_return;
    }

    public void setIs_return(boolean is_return) {
        this.is_return = is_return;
    }
}
