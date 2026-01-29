/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.DbUtils;

/**
 *
 * @author DELL
 */
public class ProductDAO {

    public ProductDAO() {
    }
    
            //SEARCH
    //chỉ tra thằng
    public ProductDTO searchById(String id) { 
        ProductDTO prd = null;
        
        try {
            Connection conn = DbUtils.getConnection();
            String sql = "SELECT * FROM product WHERE product_id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs =  pst.executeQuery();
            
            while(rs.next()){
                String product_id = rs.getString("product_id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int sale_price = rs.getInt("sale_price");
                String slug = rs.getString("slug");
                String thumbnail_url = rs.getString("thumbnail_url");
                int warranty_period = rs.getInt("warranty_period");
                String brand = rs.getString("brand");
                String status = rs.getString("status"); // Sửa thành String vì trong DB và DTO là String
                String specifications = rs.getString("specifications");
                String sub_id = rs.getString("sub_id");

                // Tạo đối tượng ProductDTO (Giả sử bạn đã có constructor đầy đủ tham số theo thứ tự này)
                prd = new ProductDTO(product_id, name, price, sale_price, slug, 
                                                    thumbnail_url, warranty_period, brand, 
                                                    status, specifications, sub_id);
            }
        } catch (Exception e) {
            return null;
        }
        
        return prd;
    }
    
    
    
    //create
    
    //update
    
    //delete
}
