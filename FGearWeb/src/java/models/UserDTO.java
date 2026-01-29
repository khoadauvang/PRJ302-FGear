/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
import java.time.LocalDate;

public class UserDTO {

    // Properties
    private String userId;      
    private String username;    
    private String email;       
    private String password;    
    private String contact;     
    private String sex;         
    
    // Sử dụng LocalDate thay cho java.sql.Date hoặc java.util.Date
    private LocalDate dob;           
    
    private String address;     
    private int role;           
    private String status;      
    
    // Trong hình schema cũ bạn gửi là 'date', nên mình để LocalDate.
    // Nếu trong DB bạn sửa thành 'datetime', hãy đổi dòng này thành LocalDateTime.
    private LocalDate createdAt;     
    private LocalDate updatedAt;     

    // 1. Empty Constructor
    public UserDTO() {
    }

    // 2. Full Constructor
    public UserDTO(String userId, String username, String email, String password, 
                   String contact, String sex, LocalDate dob, String address, 
                   int role, String status, LocalDate createdAt, LocalDate updatedAt) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.contact = contact;
        this.sex = sex;
        this.dob = dob;
        this.address = address;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // 3. Getters and Setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    // Getter/Setter cho LocalDate
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    // 4. toString() để test thử xem data in ra có đẹp không
    @Override
    public String toString() {
        return "UserDTO{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", dob=" + dob +  // Khi in ra sẽ là dạng 1995-01-01
                ", role=" + role +
                '}';
    }
}
