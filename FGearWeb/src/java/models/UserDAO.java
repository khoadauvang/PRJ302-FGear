/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import utils.DbUtils;
import utils.HashPasswordUtils;

/**
 *
 * @author DELL
 */
public class UserDAO {

    //constructor
    public UserDAO() {
        //
    }

    public UserDTO login(String email, String password) {
        UserDTO user = searchByEmail(email);

        if (user != null) {
            String hashedInput = HashPasswordUtils.hashPassword(password);

            if (user.getPassword().equals(hashedInput)) {
                return user;
            }
        }

        return null;
    }

    public UserDTO searchByEmail(String email) {
        UserDTO user = null;

        try {
            Connection conn = DbUtils.getConnection();
            String sql = "SELECT * FROM users WHERE email=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            System.out.println(sql); //giá trị của sql không bị thay đổi
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String user_id = rs.getString("user_id");
                String username = rs.getString("username");
//                String email = rs.getString("email");
                String password = rs.getString("password");
                String contact = rs.getString("contact");
                String sex = rs.getString("sex");
                Date sqlDob = rs.getDate("dob");
                LocalDate dob = (sqlDob != null) ? sqlDob.toLocalDate() : null;
                String address = rs.getString("address");
                int role = rs.getInt("role");
                String statusStr = rs.getString("status");
                Date sqlCreatedAt = rs.getDate("created_at");
                LocalDate created_at = (sqlCreatedAt != null) ? sqlCreatedAt.toLocalDate() : null;
                Date sqlUpdatedAt = rs.getDate("updated_at");
                LocalDate updated_at = (sqlUpdatedAt != null) ? sqlUpdatedAt.toLocalDate() : null;

                user = new UserDTO(user_id, username, email, password, contact, sex, dob, address, role, statusStr, created_at, updated_at);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public boolean updatePassword(String email, String password) {

        String sql = "UPDATE Users SET password=? WHERE email=?";

        try {

            Connection conn = DbUtils.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, password);
            ps.setString(2, email);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean checkEmail(String email) {

        String sql = "SELECT email FROM Users WHERE email=?";

        try {

            Connection conn = DbUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean register(String email, String name, String password) {
        boolean check = false;
        String sql = "INSERT INTO Users(user_id, email, username, password) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = DbUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            String userId = generateUserId(); // 🔥 thêm dòng này

            ps.setString(1, userId);
            ps.setString(2, email);
            ps.setString(3, name);
            ps.setString(4, password);

            int result = ps.executeUpdate();

            if (result > 0) {
                check = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }

    public String generateUserId() {
        String newId = "USR001";

        try {
            Connection conn = DbUtils.getConnection();
            String sql = "SELECT TOP 1 user_id FROM Users ORDER BY user_id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String lastId = rs.getString("user_id"); // VD: USR010
                int num = Integer.parseInt(lastId.substring(3)); // lấy 010 → 10
                num++;
                newId = String.format("USR%03d", num); // → USR011
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return newId;
    }
}
