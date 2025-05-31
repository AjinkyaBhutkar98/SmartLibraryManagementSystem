package com.ajinkyabhutkar.springJdbc.RowMapper;

import com.ajinkyabhutkar.springJdbc.entity.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BookRowMapper implements RowMapper<Book> {
    
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

        Book book=new Book();

        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setAbout(rs.getString("about"));
        book.setAuthor(rs.getString("author"));
        book.setLanguage(rs.getString("language"));
        book.setPrice_per_day(rs.getInt("price_per_day"));
        book.setAvaliable(rs.getBoolean("available"));

        return book;
    }
}
