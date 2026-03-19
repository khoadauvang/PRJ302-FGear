/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Timestamp;

/**
 *
 * @author AD
 */
public class ProductReviewDTO {
    private int review_id;
    private String product_id;
    private String user_id;
    private int rating;
    private String content;
    private String image_url;
    private String parent_id;
    private Timestamp created_at; ; 
    private String username; // Thêm dòng này

    public ProductReviewDTO() {
    }

    public ProductReviewDTO(int review_id, String product_id, String user_id, int rating, String content, String image_url, String parent_id, Timestamp created_at, String username) {
        this.review_id = review_id;
        this.product_id = product_id;
        this.user_id = user_id;
        this.rating = rating;
        this.content = content;
        this.image_url = image_url;
        this.parent_id = parent_id;
        this.created_at = created_at;
        this.username = username;
    }

    public int getReview_id() {
        return review_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public int getRating() {
        return rating;
    }

    public String getContent() {
        return content;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getParent_id() {
        return parent_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }
    public String getUsername() {
        return username;
    }
    
    //SETTERS
    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
    
    
}
