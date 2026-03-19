/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.addEventListener("DOMContentLoaded", function() {
    const slider = document.getElementById('productSlider');
    const btnLeft = document.getElementById('slideLeftBtn');
    const btnRight = document.getElementById('slideRightBtn');

    // DÒNG LỆNH MỚI NÀY ĐÂY: Ép thanh trượt quay về vị trí 0 (đầu tiên) ngay khi tải xong trang
    if (slider) {
        slider.scrollLeft = 0;
    }

    // Khoảng cách mỗi lần cuộn (bằng chiều rộng 1 card + khoảng cách gap-3)
    const scrollAmount = 240; 

    if (btnLeft && btnRight && slider) {
        btnLeft.addEventListener('click', function() {
            slider.scrollBy({ left: -scrollAmount, behavior: 'smooth' });
        });

        btnRight.addEventListener('click', function() {
            slider.scrollBy({ left: scrollAmount, behavior: 'smooth' });
        });
    }
});
