/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


// Lấy ra thẻ ảnh chính và danh sách tất cả các ảnh phụ
document.addEventListener("DOMContentLoaded", () => {
    const mainImage = document.getElementById("main-product-image");
    const thumbnails = document.querySelectorAll(".thumb-img");
    console.log("Số lượng ảnh phụ quét được là: ", thumbnails.length);

    thumbnails.forEach((thumb) => {
        thumb.addEventListener("click", (event) => {
            //console.log("ê hành động click ok nè");

            thumbnails.forEach((_img) => {
                _img.classList.remove("active");
            });
            
            event.target.classList.add("active");
        });
    });
});