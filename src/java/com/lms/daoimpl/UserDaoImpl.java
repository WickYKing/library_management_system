package com.lms.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lms.dao.UserDAO;
import com.lms.models.Role;
import com.lms.models.User;
import com.lms.util.Database;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDaoImpl implements UserDAO {

    private Connection conn;

    public UserDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Integer addUser(User user) {
        Integer row = null;
        try {
            java.util.Date date = new java.util.Date();

            java.sql.Date createdDate = new Date(date.getTime());

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO public.user(name,email,password,role,create_date,created_by,status) VALUES(?,?,?,?,?,?,1)");
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());

            pstmt.setInt(4, user.getRole().getId());
            pstmt.setDate(5, createdDate);
            pstmt.setInt(6, user.getCreatedBy().getId());

            row = pstmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateUser(User user) {
        Integer row = null;
        try {

            java.util.Date date = new java.util.Date();

            java.sql.Date updatedDate = new Date(date.getTime());

            PreparedStatement pstmt = conn.prepareStatement("UPDATE public.user SET name=?,email=?,password=?,role=?,update_date=?,updated_by=? where id=?");
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setInt(4, user.getRole().getId());
            pstmt.setDate(5, updatedDate);
            pstmt.setInt(6, user.getUpdatedBy().getId());
            pstmt.setInt(7, user.getId());

            row = pstmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteUser(Integer roleId) {
        Integer row = null;
        try {

            PreparedStatement pstmt = conn.prepareStatement("UPDATE public.user SET status=0 where id=?");

            pstmt.setInt(1, roleId);

            row = pstmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public User getUserById(Integer id) {
        User user = null;
        ResultSet rs = null;
        try {

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM public.user where id=? and status > 0");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {

                Role r1 = new Role();
                r1.setId(rs.getInt("created_by"));
                Role r2 = new Role();
                r2.setId(rs.getInt("updated_by"));

                Role userRole = new Role();
                userRole.setId(rs.getInt("role"));

                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(userRole);
                user.setCreateDate(rs.getDate("create_date"));
                user.setUpdateDate(rs.getDate("update_date"));
                user.setCreatedBy(r1);
                user.setUpdatedBy(r2);

            }

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public Integer getUserIdByName(String name) {
        Integer id = null;
        ResultSet rs = null;
        try {

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM public.user where name=? and status > 0");
            pstmt.setString(1, name);

            rs = pstmt.executeQuery();

            if (rs.next()) {

                id = rs.getInt("id");

            }

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return id;
    }

    @Override
    public Integer getUserIdByEmailandPass(String email, String pass) {
        Integer id = null;
        ResultSet rs = null;
        try {
            String sqlQuery = "SELECT * FROM public.user WHERE email = ? AND password = ? AND status > 0";
            PreparedStatement pstmt =  conn.prepareStatement(sqlQuery);
            pstmt.setString(1, email);
            pstmt.setString(2, pass);

            rs = pstmt.executeQuery();

            if (rs.next()) {

                id = rs.getInt("id");

            }

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return id;
    }

    @Override
    public List<User> getAllUser() {
        List<User> allUser = new ArrayList<User>();
        ResultSet rs = null;
        try {

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM public.user WHERE status > 0");

            rs = pstmt.executeQuery();

            while (rs.next()) {

                Role r1 = new Role();
                r1.setId(rs.getInt("created_by"));
                Role r2 = new Role();
                r2.setId(rs.getInt("updated_by"));

                Role userRole = new Role();
                userRole.setId(rs.getInt("role"));

                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(userRole);
                user.setCreateDate(rs.getDate("create_date"));
                user.setUpdateDate(rs.getDate("update_date"));
                user.setCreatedBy(r1);
                user.setUpdatedBy(r2);

                allUser.add(user);

            }

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        return allUser;
    }

}
