package com.lms.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.prism.paint.RadialGradient;

import com.lms.dao.BookDao;
//import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;
import com.lms.models.Book;
import com.lms.models.Category;
import com.lms.models.Role;
import com.lms.util.Database;

public class BookDaoImpl implements BookDao {

//	Connection conn = Database.getConnection();
    private Connection conn;

    public BookDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Integer addBook(Book book) {
        Integer row = null;
        try {

            java.sql.Date createdDate = new Date(new java.util.Date().getTime());

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO public.book(book_code,title,author,no_of_copies,category,create_date,created_by,status) VALUES(?,?,?,?,?,?,?,1)");
            pstmt.setString(1, book.getBookCode());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setInt(4, book.getNoOfCopies());
            pstmt.setInt(5, book.getCategory().getId());
            pstmt.setDate(6, createdDate);
            pstmt.setInt(7, book.getCreatedBy().getId());

            row = pstmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateBook(Book book) {
        Integer row = null;
        try {

            java.sql.Date updatedDate = new Date(new java.util.Date().getTime());

            PreparedStatement pstmt = conn.prepareStatement("UPDATE public.book SET title=?,author=?,no_of_copies=?,category=?,update_date=?,updated_by=? WHERE id=?");
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getNoOfCopies());
            pstmt.setInt(4, book.getCategory().getId());
            pstmt.setDate(5, updatedDate);
            System.out.print("Updated By id: " + book.getUpdatedBy().getId());
            pstmt.setInt(6, book.getUpdatedBy().getId());
            pstmt.setInt(7, book.getId());

            row = pstmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteBook(Integer id) {
        Integer row = null;
        try {

            java.sql.Date updatedDate = new Date(new java.util.Date().getTime());

            PreparedStatement pstmt = conn.prepareStatement("UPDATE public.book SET status=0 WHERE id=?");

            pstmt.setInt(1, id);

            row = pstmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer getIdByName(String name) {
        Integer id = null;
        ResultSet rs = null;
        try {

            PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM public.book WHERE title=? and status > 0");

            pstmt.setString(1, name);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("book-id");
            }

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return id;
    }

    @Override
    public Book getBookById(Integer id) {
        Book book = null;
        ResultSet rs = null;
        try {

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM public.book WHERE id=? and status > 0");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {

                Category category = new Category();
                category.setId(rs.getInt("category"));

                Role r1 = new Role();
                r1.setId(rs.getInt("created_by"));

                Role r2 = new Role();
                r1.setId(rs.getInt("updated_by"));

                book = new Book();
                book.setId(rs.getInt("id"));
                book.setBookCode(rs.getString("book_code"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setCategory(category);
                book.setNoOfCopies(rs.getInt("no_of_copies"));
                book.setCreateDate(rs.getDate("create_date"));
                book.setCreatedBy(r1);
                book.setUpdateDate(rs.getDate("update_date"));
                book.setUpdatedBy(r2);
            }

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> allBook = new ArrayList<Book>();
        ResultSet rs = null;
        try {

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM public.book WHERE status > 0");

            rs = pstmt.executeQuery();

            while (rs.next()) {

                Category category = new Category();
                category.setId(rs.getInt("category"));

                Role r1 = new Role();
                r1.setId(rs.getInt("created_by"));

                Role r2 = new Role();
                r1.setId(rs.getInt("updated_by"));

                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setBookCode(rs.getString("book_code"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setCategory(category);
                book.setNoOfCopies(rs.getInt("no_of_copies"));
                book.setCreateDate(rs.getDate("create_date"));
                book.setCreatedBy(r1);
                book.setUpdateDate(rs.getDate("update_date"));
                book.setUpdatedBy(r2);

                allBook.add(book);
            }

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return allBook;
    }

}
