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
          Categories
        </a>
        <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
          <c:forEach items="${listcate}" var="o">
          <c:set var = "string1" value="${o.icon}"/>
				<c:set var = "string2" value = "${fn:substring(string1, 0, 4)}" />
		<c:choose>
         <c:when test = "${string2 =='cate'}">
            <c:url value="/image?fname=${o.icon}" var="imgUrl"></c:url>
         </c:when>
         <c:otherwise>
            <c:url value="${o.icon}" var="imgUrl"></c:url>
         </c:otherwise>
      </c:choose>
          
          
          <li><a class="dropdown-item ${tagactive == o.id ? "active":""}" href="product?cid=${o.id}">
          
          <img height="30" width="30" src="${imgUrl}" /> ${o.name}</a></li>
         </c:forEach>
        </ul>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath }/product?cid=0">Sản phẩm</a>
      </li>

       
      <c:choose>
				<c:when test="${sessionScope.acc == null}">
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath }/login">Đăng nhập</a>
      </li>
      </c:when>
		<c:otherwise>
	<li class="nav-item">
        <a class="nav-link" href="">Xin chào ${sessionScope.acc.user}</a>
    </li>



      <li><a class="nav-link" href="${pageContext.request.contextPath }/logout">Đăng Xuất</a></li>
      </c:otherwise>
			</c:choose>
    </ul>
    <form action="search" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input type="text" name="txt" value="${txtS }" class="form-control" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="${pageContext.request.contextPath }/member/cart">
                    <c:set var="count" value="${0}" /> 
	<c:forEach items="${sessionScope.cart}" var="map">
			<c:set var="count" value="${count + map.value.quantity}" />
	</c:forEach> 
                    <i class="fa fa-shopping-cart"></i> Giỏ hàng
                    <span class="badge badge-light">${count }</span>
                </a>
                
	
                
    </form>
   
  </div>
</nav>

<div class="jumbotron text-center">
    
        <h1 class="jumbotron-heading">CỬA HÀNG TIVI CHẤT LƯỢNG VỚI GIÁ SIÊU HẤP DẪN</h1>
        <p class="lead text-muted mb-0">Bạn muốn mua TV vừa rẻ vừa chất lượng? Bạn muốn mua TV mà lo lừa đảo? Hãy đến với cửa hàng chúng tôi ở đây có đầy đủ thứ mà bạn muốn </p>
    	
    
</div>



    