<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
  <a class="navbar-brand" href="#">Cửa hàng TV</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarScroll">
    <ul class="navbar-nav mr-auto my-2 my-lg-0 navbar-nav-scroll" style="max-height: 100px;">
      <li class="nav-item active">
        <a class="nav-link" href="/BanHang/admin/home">Home </a>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" aria-haspopup="true" href="#" id="navbarScrollingDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
          Quản lý danh mục
        </a>
        <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
          <li><a class="dropdown-item" href="<c:url value="/admin/category/add"/>">Thêm danh mục mới</a></li>
           <li><a class="dropdown-item"  href="<c:url value="/admin/category/list"/>">Danh sách danh mục</a></li>
        </ul>
      </li>

      <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" aria-haspopup="true" href="#" id="navbarScrollingDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
                Quản lý sản phẩm
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                <li><a class="dropdown-item" href="<c:url value="/admin/product/add"/>">Thêm sản phẩm mới</a></li>
                 <li><a class="dropdown-item"  href="<c:url value="/admin/product/list"/>">Danh sách sản phẩm</a></li>
              </ul>
            </li>

      <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" aria-haspopup="true" href="#" id="navbarScrollingDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
                Quản lý tài khoản
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                 <li><a class="dropdown-item"  href="<c:url value="/admin/account/list"/>">Danh sách tai khoan</a></li>
              </ul>
      </li>

      <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" aria-haspopup="true" href="#" id="navbarScrollingDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
                Quản lý đơn hàng
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                 <li><a class="dropdown-item"  href="<c:url value="/admin/order/list"/>">Danh sách đơn hàng</a></li>
              </ul>
      </li>

      <c:choose>
				<c:when test="${sessionScope.acc == null}">
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath }/login">Đăng nhập</a>
      </li>
      </c:when>
		<c:otherwise>
	<li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath }/admin/home">Chào bạn ${sessionScope.acc.user}</a>
      </li>
      <li><a class="nav-link" href="${pageContext.request.contextPath }/logout">Đăng Xuất</a></li>
      </c:otherwise>
			</c:choose>
    </ul>

   
  </div>
</nav>

<div class="jumbotron text-center">
    
        <h1 class="jumbotron-heading">CỬA HÀNG TIVI CHẤT LƯỢNG VỚI GIÁ SIÊU HẤP DẪN</h1>
        <p class="lead text-muted mb-0">Bạn muốn mua TV vừa rẻ vừa chất lượng? Bạn muốn mua TV mà lo lừa đảo? Hãy đến với cửa hàng chúng tôi ở đây có đầy đủ thứ mà bạn muốn </p>
    	
    
</div>




    