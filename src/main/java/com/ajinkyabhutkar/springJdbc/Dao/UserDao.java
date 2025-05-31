package com.ajinkyabhutkar.springJdbc.Dao;

import com.ajinkyabhutkar.springJdbc.RowMapper.UserRowMapper;
import com.ajinkyabhutkar.springJdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.*;

@Repository
public class UserDao {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    //insert record
    public int saveUser(User user) {
        String query = "INSERT INTO users(name, password, email, city) VALUES (?, ?, ?, ?)";
//        int rowsAffected = jdbcTemplate.update(query, name, password, email, city);

        int rowsAffected = jdbcTemplate.update(query, user.getName(), user.getPassword(), user.getEmail(), user.getCity());
        System.out.println("Users added: " + rowsAffected);
        return rowsAffected;
    }

    //delete record
    public void deleteUser(int userId){

        String query="delete from users where id=?";

        int rowsAffected=jdbcTemplate.update(query,userId);
        System.out.println("Users deleted: " + rowsAffected);

    }

    //update
    public void updateUser(int userId,User user){

        String query="update users set name=?,email=?,password=?,city=? where id=?";

        int rowsAffected=jdbcTemplate.update(query,
                user.getName(),
                user.getEmail(),
                user.getCity(),
                user.getPassword()
                ,userId);

        System.out.println("Rows updated "+rowsAffected);

    }

    //get single record
    public User getSingleUser(int userId){
        String query="select * from users where id=?";
        try{
            User user=jdbcTemplate.queryForObject(query,new UserRowMapper(),userId);

            return user;
        }catch (Exception e){
            return  null;
        }



    }

    //get all record
    public List<User> getAllusers(){

        String query="select * from users";

        List<User> allusers=jdbcTemplate.query(query,new UserRowMapper());

        return allusers;

    }

    //search the user
    public List<User> getUser(String userKeyword){

        String query="select * from users where name like ?";

        List<User> getUsers=jdbcTemplate.query(query,new UserRowMapper(),"%"+userKeyword+"%");

        return getUsers;
    }

}
