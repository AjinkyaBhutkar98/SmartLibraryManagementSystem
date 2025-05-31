package com.ajinkyabhutkar.springJdbc.Dao;


import com.ajinkyabhutkar.springJdbc.RowMapper.BookRowMapper;
import com.ajinkyabhutkar.springJdbc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BookDao {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    //insert record
    public void saveBook(Book book){

        String insertQuery="insert into books(title,about,author,language,price_per_day,available) values(?,?,?,?,?,?)";


        int rowsAffected=jdbcTemplate.update(insertQuery,
                book.getTitle(),
                book.getAbout(),
                book.getAuthor(),
                book.getLanguage(),
                book.getPrice_per_day(),
                book.isAvaliable()
        );

        System.out.println("Books added :"+rowsAffected);


    }

    //delete record
    public void delete(int bookId){

        String deleteQuery="delete from books where id=?";

        int rowsAffected=jdbcTemplate.update(deleteQuery,
                bookId
        );

        System.out.println("deleted book id :"+bookId);


    }

    //update record
    public void update(int bookId,Book book){
        String updateQuery="Update books set title=?,about=?,author=?,language=?,price_per_day=?,available=? where id=?";

        int rowsAffected=jdbcTemplate.update(updateQuery,
                book.getTitle(),
                book.getAbout(),
                book.getAuthor(),
                book.getLanguage(),
                book.getPrice_per_day(),
                book.isAvaliable(),

                bookId
        );

        System.out.println("Rows updated "+rowsAffected);

    }

    //get single record
    public Book getBook(int bookId){

        String selectSingleQuery="select * from books where id=?";
        try{
        Book book=jdbcTemplate.queryForObject(selectSingleQuery,new BookRowMapper(),bookId);
        return book;
        }catch (Exception e){
//            System.out.println("Something wrong happened !"+e);
            return null;
        }



    }

    //get all record
    public List<Book> getAll(){

        String selectAllQuery="select * from books";

        List<Book> allBooks=jdbcTemplate.query(selectAllQuery,new BookRowMapper());

        return allBooks;

    }

    //search the record
    public List<Book> search(String keyword){

        String searchquery="select * from books where title like ?";
        List<Book> book=jdbcTemplate.query(searchquery,new BookRowMapper(),"%"+keyword+"%");

        return book;

    }




}
