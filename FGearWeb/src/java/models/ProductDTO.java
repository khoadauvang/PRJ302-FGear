/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Map;

/**
 *
 * @author DELL
 */
public class ProductDTO {
    private String product_id;
    private String name;
    private int price;
    private int sale_price;
    private String slug;
    private String thumbnail_url;
    private int warranty_period;
    private String brand;
    private String status;
    private String specifications;
    private String sub_id;

    public ProductDTO() {
    }

    public ProductDTO(String product_id, String name, int price, int sale_price, String slug, String thumbnail_url, int warranty_period, String brand, String status, String specifications, String sub_id) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.sale_price = sale_price;
        this.slug = slug;
        this.thumbnail_url = thumbnail_url;
        this.warranty_period = warranty_period;
        this.brand = brand;
        this.status = status;
        this.specifications = specifications;
        this.sub_id = sub_id;
    }

    
    //GETTER
    public String getProduct_id() {
        return product_id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getSale_price() {
        return sale_price;
    }

    public String getSlug() {
        return slug;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public int getWarranty_period() {
        return warranty_period;
    }

    public String getBrand() {
        return brand;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecifications() {
        return specifications;
    }

    public String getSub_id() {
        return sub_id;
    }
    
    //SETTER
    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSale_price(int sale_price) {
        this.sale_price = sale_price;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public void setWarranty_period(int warranty_period) {
        this.warranty_period = warranty_period;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }
    
}
