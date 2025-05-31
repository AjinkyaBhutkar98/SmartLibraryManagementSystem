package com.ajinkyabhutkar.springJdbc.RowMapper;

import com.ajinkyabhutkar.springJdbc.entity.issueBook;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class issueBookRowMapper implements RowMapper<issueBook> {
    @Override
    public issueBook mapRow(ResultSet rs, int rowNum) throws SQLException {

        issueBook issueBook=new issueBook();
        issueBook.setId(rs.getInt("id"));
        issueBook.setBook_id(rs.getInt("book_id"));
        issueBook.setUser_id(rs.getInt("user_id"));
        issueBook.setPrice(rs.getInt("price"));
        issueBook.setBook_issue_date(rs.getDate("book_issue_date").toLocalDate());
        issueBook.setBook_submit_date(rs.getDate("book_submit_date").toLocalDate());

        return issueBook;

    }
}
