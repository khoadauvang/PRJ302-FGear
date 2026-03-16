<%@page import="models.ProductDAO"%>
<%@page import="models.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chi tiết sản phẩm - FGear</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>
    <link rel="stylesheet" href="assets/css/style.css"/>

    <style>
        /* =========================================
           CSS TÙY CHỈNH CHO HEADER & LAYOUT CHUNG
           ========================================= */
        :root {
            --gearvn-red: #ff6600; /* Chỉnh lại màu đỏ cho giống ảnh mẫu hơn */
        }

        body {
            background-color: #f4f6f8;
            font-family: 'Roboto', Arial, sans-serif;
            padding-bottom: 40px;
        }

        /* --- Header CSS --- */
        .bg-gearvn { background-color: var(--gearvn-red); }
        .header-search-input:focus { box-shadow: none; border-color: white; }
        .btn-glass { background: rgba(255, 255, 255, 0.2); color: white; border: none; }
        .btn-glass:hover { background: rgba(255, 255, 255, 0.3); color: white; }
        .hover-opacity-100 { opacity: 1 !important; }
        .header-user { transition: opacity 0.2s; color: white; }
        .header-user:hover { opacity: 0.8; }

        /* =========================================
           CSS CHO TRANG CHI TIẾT SẢN PHẨM
           ========================================= */
        .breadcrumb-custom a {
            color: #0056b3;
            text-decoration: none;
            font-size: 14px;
        }
        .breadcrumb-custom a:hover { text-decoration: underline; }
        
        .product-title {
            font-size: 24px;
            font-weight: 700;
            color: #333;
            line-height: 1.4;
        }

        .product-price-sale {
            font-size: 32px;
            font-weight: bold;
            color: var(--gearvn-red);
        }

        .product-price-old {
            font-size: 16px;
            text-decoration: line-through;
            color: #999;
        }

        .discount-badge {
            background-color: #fff;
            color: var(--gearvn-red);
            border: 1px solid var(--gearvn-red);
            padding: 2px 8px;
            border-radius: 4px;
            font-size: 12px;
            font-weight: bold;
        }

        /* Khung khuyến mãi (Flash Sale) */
        .promo-box {
            border: 1px dashed var(--gearvn-red);
            border-radius: 8px;
            padding: 15px;
            background-color: #fffafb;
            position: relative;
            margin-top: 15px;
        }
        .promo-title {
            background-color: var(--gearvn-red);
            color: white;
            padding: 4px 12px;
            border-radius: 4px;
            font-size: 12px;
            font-weight: bold;
            display: inline-block;
            margin-bottom: 10px;
        }

        /* Nút mua hàng */
        .btn-buy-now {
            background-color: var(--gearvn-red);
            color: white;
            font-weight: bold;
            text-transform: uppercase;
            padding: 12px;
            border-radius: 8px;
            border: none;
            transition: all 0.3s;
        }
        .btn-buy-now:hover {
            background-color: #c00015;
            color: white;
        }

        .btn-consult {
            background-color: white;
            color: #0056b3;
            font-weight: bold;
            text-transform: uppercase;
            padding: 12px;
            border-radius: 8px;
            border: 1px solid #0056b3;
            transition: all 0.3s;
        }
        .btn-consult:hover {
            background-color: #f0f8ff;
            color: #0056b3;
        }

        /* Thumbnail nhỏ xíu dưới ảnh chính */
        .thumb-img {
            width: 60px;
            height: 60px;
            object-fit: contain;
            border: 1px solid #ddd;
            border-radius: 4px;
            cursor: pointer;
            padding: 2px;
        }
        .thumb-img:hover {
            border-color: var(--gearvn-red);
        }
        .thumb-img.active {
            border-color: var(--gearvn-red);
            border-width: 2px;
        }
    </style>
</head>
<body>
    <%
        ProductDTO product = (ProductDTO)request.getAttribute("product");
    %>
    <header class="bg-gearvn sticky-top shadow-sm py-2 mb-3">
        <div class="container" style="max-width: 1200px;">
            <div class="d-flex align-items-center justify-content-between">
                <div class="d-flex align-items-center gap-3">
                    <a href="http://localhost:8080/FGearWeb" class="text-white text-decoration-none fw-bold fs-3">FGear</a>
                    <div class="site-overlay"></div>
                    <div class="menu-wrapper">
                        <button class="btn btn-glass d-flex align-items-center gap-2 menutab-btn">
                            <i class="fa-solid fa-bars"></i> Danh mục
                        </button>
                        <div class="main-menu sidebar-menu">
                            <nav class="megamenu-nav">
                                <ul class="megamenu-nav-main">
                                    <li class="megamenu-item"><a class="megamenu-link" href="MainController?action=ShowProduct&keyword=LPT"><span class="megamenu-name">Laptop</span><span class="megamenu-ic-right">❯</span></a></li>
                                    <li class="megamenu-item"><a class="megamenu-link" href="MainController?action=ShowProduct&keyword=CPU"><span class="megamenu-name">CPU</span><span class="megamenu-ic-right">❯</span></a></li>
                                    <li class="megamenu-item"><a class="megamenu-link" href="MainController?action=ShowProduct&keyword=VGA"><span class="megamenu-name">VGA</span><span class="megamenu-ic-right">❯</span></a></li>
                                    <li class="megamenu-item"><a class="megamenu-link" href="MainController?action=ShowProduct&keyword=KEY"><span class="megamenu-name">Bàn Phím</span><span class="megamenu-ic-right">❯</span></a></li>
                                    <li class="megamenu-item"><a class="megamenu-link" href="MainController?action=ShowProduct&keyword=MSE"><span class="megamenu-name">Chuột</span><span class="megamenu-ic-right">❯</span></a></li>
                                    <li class="megamenu-item"><a class="megamenu-link" href="MainController?action=ShowProduct&keyword=RAM"><span class="megamenu-name">RAM</span><span class="megamenu-ic-right">❯</span></a></li>
                                    <li class="megamenu-item"><a class="megamenu-link" href="MainController?action=ShowProduct&keyword=MON"><span class="megamenu-name">Màn hình</span><span class="megamenu-ic-right">❯</span></a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>

                <div class="flex-grow-1 mx-4">
                    <div class="input-group">
                        <input type="text" class="form-control header-search-input border-0" placeholder="Bạn cần tìm gì?">
                        <button class="btn btn-light text-danger" type="button"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>

                <div class="d-flex gap-3 text-white">
                    <div class="d-flex align-items-center gap-2" role="button">
                        <i class="fa-solid fa-headset fs-4"></i>
                        <div class="d-none d-lg-block lh-1 small"><div>Hotline</div><div class="fw-bold">1900.5301</div></div>
                    </div>
                    <div class="d-flex align-items-center gap-2" role="button">
                        <i class="fa-solid fa-location-dot fs-4"></i>
                        <div class="d-none d-lg-block lh-1 small">Hệ thống<br>Showroom</div>
                    </div>
                    <div class="d-flex align-items-center gap-2 position-relative" role="button">
                        <i class="fa-solid fa-cart-shopping fs-4"></i>
                        <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-warning text-dark border border-light">0</span>
                        <div class="d-none d-lg-block lh-1 small">Giỏ<br>hàng</div>
                    </div>

                    <div class="d-flex align-items-center gap-2" role="button">
                        <%
                            UserDTO curUser = (UserDTO)session.getAttribute("user");
                            if (curUser != null) {
                        %>
                        <a href="#" class="header-user d-flex align-items-center gap-2 text-decoration-none">
                            <i class="fa-solid fa-user fs-5"></i>
                            <span class="d-none d-lg-block">Hello, <%= curUser.getUsername() %></span>
                        </a>
                        <a href="UserController?action=logout" class="d-flex align-items-center gap-1 text-white text-decoration-none ms-3 opacity-75 hover-opacity-100">
                            <i class="fa-solid fa-right-from-bracket"></i> <span>Logout</span>
                        </a>
                        <% } else { %>
                        <a href="login.jsp" class="header-user d-flex align-items-center gap-2 text-decoration-none">
                            <i class="fa-solid fa-user fs-5"></i>
                            <span class="d-none d-lg-block">Đăng nhập</span>
                        </a>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <div class="container bg-white p-4 rounded shadow-sm" style="max-width: 1200px;">
        
        <%
            
        %>

        <div class="breadcrumb-custom mb-3">
            <a href="http://localhost:8080/FGearWeb"><i class="fa-solid fa-house"></i> Trang chủ</a> 
            <span class="text-muted mx-1">/</span> 
            <span class="text-muted"><%= product.getSlug() %></span>
        </div>

        <div class="row">
            <div class="col-md-5">
                <div class="border rounded p-2 mb-3 d-flex justify-content-center align-items-center" style="height: 400px;">
                    <img id="main-product-image" src="<%= product.getThumbnail_url() %>" alt="<%= "TEST" %>" class="img-fluid" style="max-height: 100%; object-fit: contain;">
                </div>
                <div class="d-flex gap-2 justify-content-center">
                    <img src="<%= product.getThumbnail_url() %>" class="thumb-img active" id="1" alt="thumb 1">
                    <img src="${pageContext.request.contextPath}/assets/img/fgear-logo.png" class="thumb-img" id="2" alt="thumb 2">
                    <img src="${pageContext.request.contextPath}/assets/img/fgear-logo.png" class="thumb-img" id="3" alt="thumb 3">
                    <img src="${pageContext.request.contextPath}/assets/img/fgear-logo.png" class="thumb-img" id="4" alt="thumb 4">
                </div>
            </div>

            <div class="col-md-7 ps-md-4">
                <h1 class="product-title mb-2"><%= "TEST" %></h1>
                <div class="mb-3">
                    <a href="#" class="text-decoration-none text-primary fs-6">Xem đánh giá</a>
                </div>

                <div class="d-flex align-items-end gap-3 mb-2">
                    <% if (true) { 
                        // Tính phần trăm giảm giá
                    %>
                        <span class="product-price-sale"><%= "TEST" %></span>
                        <span class="product-price-old pb-1"><%= "TEST" %></span>
                        <span class="discount-badge mb-2"> -<%= "TEST" %>% </span>
                    <% } else { %>
                        <span class="product-price-sale"><%= "TEST" %></span>
                    <% } %>
                </div>

                <div class="promo-box mb-4">
                    <div class="promo-title">FLASH SALE</div>
                    <div class="d-flex justify-content-between align-items-center">
                        <div>
                            <span class="d-block text-muted small">GIÁ SỐC</span>
                            <strong class="fs-4 text-danger"><%= "TEST" %></strong>
                        </div>
                        <div class="border border-danger text-danger px-3 py-1 border-2 border-dashed rounded fw-bold bg-white">
                            RON95-GVN
                        </div>
                    </div>
                    <div class="text-muted small mt-2 fst-italic">Không áp dụng với chương trình khuyến mãi khác</div>
                </div>

                <div class="row g-2 mb-4">
                    <div class="col-6">
                        <form action="CartController" method="POST">
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" name="productId" value="<%= "TEST" %>"> <button type="submit" class="btn btn-buy-now w-100 d-flex flex-column align-items-center">
                                <span>MUA NGAY</span>
                                <span class="fw-normal" style="font-size: 11px;">Giao tận nơi/Nhận tại cửa hàng</span>
                            </button>
                        </form>
                    </div>
                    <div class="col-6">
                        <button class="btn btn-consult w-100 d-flex flex-column align-items-center">
                            <span><i class="fa-solid fa-comment-dots"></i> TƯ VẤN NGAY</span>
                            <span class="fw-normal" style="font-size: 11px;">Màn "chuẩn gu" làm việc & giải trí</span>
                        </button>
                    </div>
                </div>

                <div class="pt-3 border-top">
                    <p class="mb-2"><strong>- Nhà sản xuất:</strong> ViewSonic</p>
                    <p class="mb-2"><strong>- Hỗ trợ đổi mới trong 7 ngày.</strong></p>
                    <p class="mb-0 text-danger fw-bold">Hỗ trợ trả góp MPOS (thẻ tín dụng), HDSAISON <a href="#" class="text-decoration-none">(Xem chi tiết)</a>.</p>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/script.js"></script>
    <script src="assets/js/script2.js"></script>
</body>
</html>