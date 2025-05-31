package com.ajinkyabhutkar.springJdbc.Dao;


import com.ajinkyabhutkar.springJdbc.RowMapper.issueBookRowMapper;
import com.ajinkyabhutkar.springJdbc.entity.issueBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class issueBookDao {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public issueBookDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public void saveIssueBook(issueBook issueBook){
        String query="insert into issue_books(book_id,user_id,book_issue_date,price,book_submit_date) values(?,?,?,?,?)";
        int rowsAffected=jdbcTemplate.update(query,
                issueBook.getBook_id(),
                issueBook.getUser_id(),
                issueBook.getBook_issue_date(),
                issueBook.getPrice(),
                issueBook.getBook_submit_date()
                );

        System.out.println("Books issued : "+rowsAffected);

    }

    public List<issueBook> getIssuedBooks(){

        String query="select * from issue_books where is_return=?";

        int is_return=0;

        List<issueBook> allIssuedBooks=jdbcTemplate.query(query,new issueBookRowMapper(),is_return);

        return allIssuedBooks;
    }

    public List<issueBook> getUserIssuedBooks(int userid){

        String query="select * from issue_books where user_id=? and is_return=?";

        try{
            return jdbcTemplate.query(query, new issueBookRowMapper(), userid, 0);


        }catch (Exception e){
            return null;
        }
    }

    public boolean returnBook(int bookID, int userId) {
        String query = "UPDATE issue_books SET is_return = ? WHERE book_id = ? AND user_id = ?";

        try {
            int rowsAffected = jdbcTemplate.update(query, 1, bookID, userId);
            return rowsAffected > 0;
        } catch (Exception e) {
            System.err.println("Error updating issue_books: " + e.getMessage());
            return false;
        }
    }



}
