/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const btn = document.querySelector(".menutab-btn");
const overlay = document.querySelector(".site-overlay");

// 1. Lắng nghe sự kiện khi bấm nút "Danh mục"
btn.addEventListener("click", (event) => {
    // Vẫn giữ lại câu chào của bạn :))
    console.log("Hello mấy con vợ"); 
    
    // Ném 2 class này vào thẻ body
    document.body.classList.add("open-menu");
    document.body.classList.add("open-overlay");
});

// 2. Lắng nghe sự kiện khi bấm vào vùng xám (overlay) để tắt
overlay.addEventListener("click", () => {
    console.log("Đã bấm ra ngoài, đóng menu!");
    
    // Gỡ 2 class này ra khỏi thẻ body
    document.body.classList.remove("open-menu");
    document.body.classList.remove("open-overlay");
});



