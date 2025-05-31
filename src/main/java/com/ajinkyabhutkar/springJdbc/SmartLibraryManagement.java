package com.ajinkyabhutkar.springJdbc;

import com.ajinkyabhutkar.springJdbc.Dao.BookDao;
import com.ajinkyabhutkar.springJdbc.Dao.UserDao;
import com.ajinkyabhutkar.springJdbc.Dao.issueBookDao;
import com.ajinkyabhutkar.springJdbc.entity.Book;
import com.ajinkyabhutkar.springJdbc.entity.User;
import com.ajinkyabhutkar.springJdbc.entity.issueBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;


@SpringBootApplication
public class SmartLibraryManagement implements CommandLineRunner {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private issueBookDao issueBookDao;

    public static void main(String[] args) {


        SpringApplication.run(SmartLibraryManagement.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {

            try {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("Please select option \n 1.User management \n 2.Library management \n 3.Exit");
                int appChoice = Integer.parseInt(bufferedReader.readLine());
                if (appChoice == 1) {
                    System.out.println("*******************************");
                    System.out.println("Welcome to User Management System");
                    System.out.println("*******************************");
                    System.out.println("Please Select Option to Continue......");
                    System.out.println("Press 1. To add new user");
                    System.out.println("Press 2. To see All users");
                    System.out.println("Press 3. To search a particular user");
                    System.out.println("Press 4. To update a user");
                    System.out.println("Press 5. To delete a user");
                    System.out.println("Press 6. To view a user detail");
                    System.out.println("Press 7. To exit");


                    int choice = Integer.parseInt(bufferedReader.readLine());

                    if (choice == 1) {
                        //insert user
                        System.out.println("Please Enter User name");
                        String name = bufferedReader.readLine();
                        System.out.println("Please enter user email:");
                        String email = bufferedReader.readLine();
                        System.out.println("Please enter user password");
                        String password = bufferedReader.readLine();
                        System.out.println("Enter user city");
                        String city = bufferedReader.readLine();

                        User user = new User();
                        user.setName(name);
                        user.setEmail(email);
                        user.setCity(city);
                        user.setPassword(password);

                        userDao.saveUser(user);
                        System.out.println("User added successfully");
                        System.out.println("***************************");

                    } else if (choice == 2) {
                        // see all users
                        System.out.println("List of all users");
                        System.out.println("--------------------------");
                        System.out.println();
                        List<User> users = userDao.getAllusers();

                        for (User u : users) {
                            System.out.println("Name : " + u.getName() + " City : " + u.getCity());
                        }

                        System.out.println("***************************");

                    } else if (choice == 3) {
                        // search user with keyword
                        System.out.println("Enter user name to search");
                        String searchUser = bufferedReader.readLine();
                        List<User> foundUsers = userDao.getUser(searchUser);
                        System.out.println("Users containing" + searchUser + " keyword found given below");
                        for (User u : foundUsers) {
                            System.out.println(u.getName());
                        }

                    } else if (choice == 4) {
                        //update user
                        User updatedUser = new User();
                        System.out.println("Please enter user id to update");
                        int userid = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("enter new user name");
                        String newName = bufferedReader.readLine();
                        updatedUser.setName(newName);

                        System.out.println("enter updated user email");
                        String newEmail = bufferedReader.readLine();
                        updatedUser.setEmail(newEmail);

                        System.out.println("enter updated user password");
                        String newPassword = bufferedReader.readLine();
                        updatedUser.setPassword(newPassword);

                        System.out.println("enter updated user city");
                        String newCity = bufferedReader.readLine();
                        updatedUser.setCity(newCity);

                        userDao.updateUser(userid, updatedUser);

                        System.out.println("User updated successfully");


                    } else if (choice == 5) {
                        //delete book
                        System.out.println("Enter user ID to delete");
                        int userid = Integer.parseInt(bufferedReader.readLine());
                        userDao.deleteUser(userid);
                        System.out.println("user deleted sucessfully");


                    } else if (choice == 6) {
                        //get single book record based on id
                        System.out.println("Enter user id to get info about user:");
                        int userId = Integer.parseInt(bufferedReader.readLine());


                        User u = userDao.getSingleUser(userId);

                        if (u == null) {
                            System.out.println("User not exist in database!");
                            break;
                        }


                        User singleUser = userDao.getSingleUser(userId);
                        System.out.println("*****************************");
                        System.out.println("Name :" + singleUser.getName());
                        System.out.println("email :" + singleUser.getEmail());
                        System.out.println("password :" + singleUser.getPassword());
                        System.out.println("city :" + singleUser.getCity());

                        System.out.println("*****************************");


                    } else if (choice == 7) {
                        //exit app
                        System.out.println("Exiting App");
                        break;
                    } else {
                        System.out.println("Wrong choice");
                    }
                } else if (appChoice == 2) {
                    System.out.println("*******************************");
                    System.out.println("Welcome to Smart Library System");
                    System.out.println("*******************************");
                    System.out.println("Please Select Option to Continue......");
                    System.out.println("Press 1. To add new book");
                    System.out.println("Press 2. To see All books");
                    System.out.println("Press 3. To search a particular book");
                    System.out.println("Press 4. To update a book");
                    System.out.println("Press 5. To delete a book");
                    System.out.println("Press 6. To view a book detail");
                    System.out.println("Press 7. To exit");
                    System.out.println("Press 8. To issue book");
                    System.out.println("Press 9. To see all issued book");
                    System.out.println("Press 10. To return issued book");


                    int choice = Integer.parseInt(bufferedReader.readLine());

                    if (choice == 1) {
                        //insert book
                        System.out.println("Please Enter Book title");
                        String title = bufferedReader.readLine();
                        System.out.println("Please enter something about book:");
                        String about = bufferedReader.readLine();
                        System.out.println("Please enter author name");
                        String author = bufferedReader.readLine();
                        System.out.println("Enter language name");
                        String language = bufferedReader.readLine();
                        System.out.println("Enter book price per day");
                        int price_per_day = Integer.parseInt(bufferedReader.readLine());
                        System.out.println("is the book avaliable ? [T/F]");
                        String avaliable = bufferedReader.readLine();
                        boolean isAvaliable = avaliable.equalsIgnoreCase("T");

                        Book book = new Book();
                        book.setTitle(title);
                        book.setAbout(about);
                        book.setAuthor(author);
                        book.setLanguage(language);
                        book.setPrice_per_day(price_per_day);
                        book.setAvaliable(isAvaliable);

                        bookDao.saveBook(book);
                        System.out.println("Book added successfully");
                        System.out.println("***************************");

                    } else if (choice == 2) {
                        // see all book
                        System.out.println("List of all books");
                        System.out.println("--------------------------");
                        System.out.println();
                        List<Book> books = bookDao.getAll();

                        for (Book b : books) {
                            System.out.println("Title : " + b.getTitle() + " Author : " + b.getAuthor());
                        }

                        System.out.println("***************************");

                    } else if (choice == 3) {
                        // search books with keyword
                        System.out.println("Enter book title to search");
                        String searchBook = bufferedReader.readLine();
                        List<Book> foundBook = bookDao.search(searchBook);
                        System.out.println("Books containing" + searchBook + " keyword found given below");
                        for (Book b : foundBook) {
                            System.out.println(b.getTitle());
                        }

                    } else if (choice == 4) {
                        //update book
                        Book updatedBook = new Book();
                        System.out.println("Please enter book id to update");
                        int bookid = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("enter new book title");
                        String newTitle = bufferedReader.readLine();
                        updatedBook.setTitle(newTitle);

                        System.out.println("enter updated book author");
                        String newAuthor = bufferedReader.readLine();
                        updatedBook.setAuthor(newAuthor);

                        System.out.println("enter updated book about");
                        String newAbout = bufferedReader.readLine();
                        updatedBook.setAbout(newAbout);

                        System.out.println("enter updated book language");
                        String newLanguage = bufferedReader.readLine();
                        updatedBook.setLanguage(newLanguage);

                        System.out.println("enter updated book price per day");
                        int newPriceperday = Integer.parseInt(bufferedReader.readLine());
                        updatedBook.setPrice_per_day(newPriceperday);

                        System.out.println("is the book avaliable ? [T/F]");
                        String updatedavaliable = bufferedReader.readLine();
                        boolean isNewAvaliable = updatedavaliable.equalsIgnoreCase("T");

                        updatedBook.setAvaliable(isNewAvaliable);

                        bookDao.update(bookid, updatedBook);

                        System.out.println("Book updated successfully");


                    } else if (choice == 5) {
                        //delete book
                        System.out.println("Enter book ID to delete");
                        int bookid = Integer.parseInt(bufferedReader.readLine());
                        bookDao.delete(bookid);
                        System.out.println("Book deleted sucessfully");


                    } else if (choice == 6) {
                        //get single book record based on id
                        System.out.println("Enter book id to get info about book:");
                        int bookId = Integer.parseInt(bufferedReader.readLine());
                        Book singleBook = bookDao.getBook(bookId);
                        System.out.println("*****************************");
                        System.out.println("Title :" + singleBook.getTitle());
                        System.out.println("Author :" + singleBook.getAuthor());
                        System.out.println("About :" + singleBook.getAbout());
                        System.out.println("Language :" + singleBook.getLanguage());
                        System.out.println("Price per day :" + singleBook.getPrice_per_day());
                        System.out.println("Book available:" + (singleBook.isAvaliable() ? "Yes" : "No"));
//                    boolean avaliable=singleBook.isAvaliable();
//                    if(avaliable){
//                        System.out.println("Book is avaliable");
//                    }else{
//                        System.out.println("Book is not avaliable");
//                    }
                        System.out.println("*****************************");


                    } else if (choice == 7) {
                        //exit app
                        System.out.println("Exiting App");
                        break;
                    } else if (choice == 8) {

                        //issue the book to user
                        System.out.println("Please enter book id to issue book");
                        int bookid = Integer.parseInt(bufferedReader.readLine());

                        Book book = bookDao.getBook(bookid);

                        if (book == null) {
                            System.out.println("There are no books in library");
                            continue;
                        }
                        if (!book.isAvaliable()) {
                            System.out.println("Book is not avaliable to issue");
                            continue;
                        }

                        System.out.println("Selected book name: " + book.getTitle());

                        System.out.println("Please enter user id to issue the book");

                        int userId = Integer.parseInt(bufferedReader.readLine());

                        User user = userDao.getSingleUser(userId);

                        if (user == null) {
                            System.out.println("User dpes not exist");
                            continue;
                        }

                        System.out.println("selected user name: " + user.getName());

                        LocalDate issueDate = LocalDate.now();

                        System.out.println("Enter no of days to issue");
                        int days = Integer.parseInt(bufferedReader.readLine());

                        int totalprice = days * book.getPrice_per_day();

                        LocalDate submitDate = issueDate.plusDays(days);

                        issueBook issue = new issueBook();

                        issue.setBook_id(bookid);
                        issue.setUser_id(userId);
                        issue.setBook_issue_date(issueDate);
                        issue.setPrice(totalprice);
                        issue.setBook_submit_date(submitDate);

                        issueBookDao.saveIssueBook(issue);
                        book.setAvaliable(false);
                        bookDao.update(book.getId(), book);
                        System.out.println("Book issued successfully to " + user.getName());


                    } else if (choice == 9) {

                        List<issueBook> issueBooks = issueBookDao.getIssuedBooks();

                        if (issueBooks.isEmpty()) {

                            System.out.println("there are no books assigned");

                        } else {
                            HashMap<String, String> userBookMap = new HashMap<>();
                            System.out.println("All Assigned Books are as Below");
                            System.out.println("--------------------------------");
                            for (issueBook i : issueBooks) {

                                Book bookname = bookDao.getBook(i.getBook_id());
                                User userName = userDao.getSingleUser(i.getUser_id());

                                userBookMap.put(userName.getName(), bookname.getTitle());

                            }

                            for (String userName : userBookMap.keySet()) {
                                String bookTitle = userBookMap.get(userName);
                                System.out.println("User: " + userName + " Book: " + bookTitle);
                            }
                        }

                    } else if (choice == 10) {

                        //Returning book

                        System.out.println("Enter user id");

                        int userId = Integer.parseInt(bufferedReader.readLine());

                        User checkUser = userDao.getSingleUser(userId);

                        if (checkUser == null) {
                            System.out.println("user id does not exist please enter valid user id");
                        } else {

                            System.out.println("User name: " + checkUser.getName());

                            List<issueBook> issuedBooks = issueBookDao.getUserIssuedBooks(userId);

                            System.out.println("All issued Books");

                            for (issueBook x : issuedBooks) {


                                Book b = bookDao.getBook(x.getBook_id());

                                System.out.println("issue Book ID: " + x.getId() + " Book Title: " + b.getTitle());
                            }
                            System.out.println("Enter book id to return");
                            int bookId = Integer.parseInt(bufferedReader.readLine());

                            boolean is_returned = issueBookDao.returnBook(bookId, userId);

                            if (is_returned) {
                                System.out.println("Book returned successfully");
                            } else {
                                System.out.println("Something unexpected occured");
                            }

                        }


                    } else {
                        System.out.println("Wrong choice");
                    }
                } else if (appChoice == 3) {
                    System.out.println("Exiting app");
                    break;
                }


            } catch (Exception e) {
                System.out.println("Something unexpected happened : " + e.getMessage());
            }
        }

    }
}
