<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@include file="/common/taglib.jsp"%>

<div class="container">
    <div class="row">
        <!-- Image -->
        <div class="col-12 col-lg-6">
            <div class="card bg-light mb-3">
                <div class="card-body">
                    <p class="text-center"><a href="" data-toggle="modal" data-target="#productModal">
                        <img class="img-fluid" src="${pdetail.image}" />
                        Zoom
                    </a></p>
                </div>
            </div>
        </div>

        <!-- Add to cart -->
        <div class="col-12 col-lg-6 add_to_cart_block">
            <div class="card bg-light mb-3">
                <div class="card-body">
               <%--  <c:forEach items="${cdetail}" var="c"> --%>

                <h5 class="cname">Danh mục: ${cdetail.name}</h5>

          <%--  </c:forEach> --%>
                ${pdetail.name}
                    <p class="price">${pdetail.price} $</p>
                   
                       <form name="f1" class="product-quantity sm-margin-bottom-20"
								method="get" action="<c:url value="/member/cart-add"></c:url>">
							      <div class="form-group">
                           
                        </div>
                        <div class="form-group">
                            <label>Đã bán : ${pdetail.amount} - Số lượng tồn: ${pdetail.stoke }</label>
                            <div class="input-group mb-3">
                                
                           	<input type="text" value="${pdetail.id}" name="pId" hidden="">
                           	<input type="text" value="${pdetail.stoke}" name="stoke" id="stoke" hidden="">
								<div class="input-group-prepend">
                                    <button id="giam" onclick="tanggiamsoluong(0)" type="button" class="quantity-left-minus btn btn-danger btn-number"  data-type="minus" data-field="">
                                        <i class="fa fa-minus"></i>
                                    </button>
                                </div>
                                <input type="text" class="form-control"  id="quantity" name="quantity" min="1" max="100" value="1">
                                
                                <div class="input-group-append">
                                    <button id="tang" onclick="tanggiamsoluong(1)" type="button" class="quantity-right-plus btn btn-success btn-number" data-type="plus" data-field="">
                                        <i class="fa fa-plus"></i>
                                    </button>
                                </div>
                                <input type="text" class="form-control"  id="pID" name="pId" min="1" max="100" value="${productdetail.productID }" hidden>
                            </div>
                            </div>
                        </div>
                       <div class="form-group">
                       	<button type="submit" class="quantity-right-plus btn btn-success btn-block btn-number">Thêm vào giỏ hàng</button>
                       </div>
                    </form>
                    <div class="product_rassurance">
                        <ul class="list-inline">
                            <li class="list-inline-item"><i class="fa fa-truck fa-2x"></i><br/>Fast delivery</li>
                            <li class="list-inline-item"><i class="fa fa-credit-card fa-2x"></i><br/>Secure payment</li>
                            <li class="list-inline-item"><i class="fa fa-phone fa-2x"></i><br/>+33 1 22 54 65 60</li>
                        </ul>
                    </div>
                    <div class="reviews_product p-3 mb-2 ">
                        3 reviews
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        (4/5)
                        <a class="pull-right" href="#reviews">View all reviews</a>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <!-- Description -->
        <div class="col-12">
            <div class="card border-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-align-justify"></i> Description</div>
                <div class="card-body">
                    <p class="card-text">
                       ${pdetail.description}
                    
                </div>
            </div>
        </div>

        <!-- Reviews -->
        <div class="col-12" id="reviews">
            <div class="card border-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-comment"></i> Reviews</div>
                <div class="card-body">
                    <div class="review">
                        <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                      
                        <span class="fa fa-star"></span>
                        <span class="fa fa-star"></span>
                        <span class="fa fa-star"></span>
                        <span class="fa fa-star"></span>
                        <span class="fa fa-star"></span>
                        Vũ
                        <p class="blockquote">
                            <p class="mb-0">TV đẹp thế mà giá chừng này thôi sao. Tôi đã mua và dùng rất tốt tôi sẽ giới thiếu cho bạn bè của tôi để họ cũng trải nghiệm được cảm giác tốt đẹp này</p>
                        </p>
                        <hr>
                    </div>
                    <div class="review">
                        <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                     
                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        Nguyễn Công Tiến
                        <p class="blockquote">
                            <p class="mb-0">Hàng giá rẻ nhưng chất lượng rất tốt. Tivi sắc nét xem như trực tiếp xem ngoài đời thật</p>
                        </p>
                        <hr>
                    </div>
                    <div class="review">
                        <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                     
                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        Thạch
                        <p class="blockquote">
                            <p class="mb-0">OH MY GOD!!!!!!!!!!!!!!!!!!!!!!!</p>
                        </p>
                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/templates/product-quantity.js"/>"></script>
<script>
		
		function tanggiamsoluong (i){
			if (i == 1){ 
				var soluong = Number($("#quantity").val()) + 1;
				document.getElementById('quantity').value = soluong;
			} else {
				var soluong = Number($("#quantity").val()) - 1;
				document.getElementById('quantity').value = soluong;
			}
			
		}
	</script>
	
