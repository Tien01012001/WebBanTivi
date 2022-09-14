<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

		<div class="container">
    <div class="row">
        <div class="col">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    
                    <li class="breadcrumb-item active" aria-current="page">Giỏ hàng</li>
                </ol>
            </nav>
        </div>
    </div>
</div>

		<!--=== Content Medium Part ===-->
		<div class="content-md margin-bottom-30">
			<div class="container">
				<form class="shopping-cart" action="#">
					<div>
						<div class="header-tags">
							<div class="overflow-h">
								<h2>Giỏ hàng của bạn</h2>
								<p>Xem &amp; kiểm tra sản phẩm của bạn đã chọn</p>
								<i class="rounded-x fa fa-check"></i>
							</div>
						</div>
						<section>
							<div class="table-responsive">
								<table class="table table-striped">
									<thead>
										<tr>
											<th>Tên sản phẩm</th>
											<th>Giá tiền</th>
											<th>Số lượng</th>
											<th>Tổng thành tiền</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${sessionScope.cart}" var="map">

											<tr>
												<c:url value="/image?fname=${map.value.product.image }"
													var="imgUrl"></c:url>
												<td class="product-in-table"><img
													class="img-responsive" src="${imgUrl}" alt="">
													<div class="product-it-in">
														<h3>${map.value.product.name }</h3>
														<span>${map.value.product.description }</span>
													</div></td>
												<td>$ ${map.value.product.price }</td>
												<td>${map.value.quantity }</td>
												<td class="shop-red">$ ${map.value.product.price * map.value.quantity }</td>
												<td><a
													href="${pageContext.request.contextPath}/member/cart-remove?pId=${map.value.product.id}">
													<button
															type="button" class="close">
															<span>&times;</span><span class="sr-only">Thoát</span>
													</button></a></td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
							</div>
						</section>




						<div class="header-tags">
							<div class="overflow-h">
								<h2>Phương thức thanh toán</h2>
								<p>Vui lòng chọn phương thức thanh toán</p>
								<i class="rounded-x fa fa-credit-card"></i>
							</div>
						</div>
						<section>
							<div class="row">
								<div class="col-md-6 md-margin-bottom-50">
									<h2 class="title-type">Chọn một phương thức thanh toán</h2>
									<!-- Accordion -->
									<div class="accordion-v2">
										<div class="panel-group" id="accordion">
											<div class="panel panel-default">
												<div class="panel-heading">
													<h4 class="panel-title">
														<a data-toggle="collapse" data-parent="#accordion"
															href="#collapse1"> <i class="fa fa-bus"></i> Thanh toán COD
														</a>
													</h4>
												</div>
												<div id="collapse1" class="panel-collapse collapse in">
													<div class="content margin-left-10">
														<label class="container">
  															<input type="checkbox" checked="checked" name="codcheck" id="myCheck" onclick="myFunction()">
  															Thanh toán khi nhận hàng (COD)
  															
														</label>
														<br/>
														Phương thức này người mua sẽ thanh toán tiền cho shipper khi nhận hàng.
													</div>
												</div>
											</div>
											
											
											<div class="panel panel-default">
												<div class="panel-heading">
													<h4 class="panel-title">
														<a data-toggle="collapse" data-parent="#accordion"
															href="#collapseOne"> <i class="fa fa-credit-card"></i>
															Thanh toán bằng thẻ tín dụng
														</a>
													</h4>
												</div>
												<div id="collapseOne" class="panel-collapse collapse">
													<div class="panel-body cus-form-horizontal">
														<div class="form-group">
															<label class="col-sm-4 no-col-space control-label">Cardholder
																Name</label>
															<div class="col-sm-8">
																<input type="text" class="form-control required"
																	name="cardholder" placeholder="">
															</div>
														</div>
														<div class="form-group">
															<label class="col-sm-4 no-col-space control-label">Card
																Number</label>
															<div class="col-sm-8">
																<input type="text" class="form-control required"
																	name="cardnumber" placeholder="">
															</div>
														</div>
														<div class="form-group">
															<label class="col-sm-4 no-col-space control-label">Payment
																Types</label>
															<div class="col-sm-8">
																<ul class="list-inline payment-type">
																	<li><i class="fa fa-cc-paypal"></i></li>
																	<li><i class="fa fa-cc-visa"></i></li>
																	<li><i class="fa fa-cc-mastercard"></i></li>
																	<li><i class="fa fa-cc-discover"></i></li>
																</ul>
															</div>
														</div>
														<div class="form-group">
															<label class="col-sm-4">Expiration Date</label>
															<div class="col-sm-8 input-small-field">
																<input type="text" name="mm" placeholder="MM"
																	class="form-control required sm-margin-bottom-20">
																<span class="slash">/</span> <input type="text"
																	name="yy" placeholder="YY"
																	class="form-control required">
															</div>
														</div>
														<div class="form-group">
															<label class="col-sm-4 no-col-space control-label">CSC</label>
															<div class="col-sm-8 input-small-field">
																<input type="text" name="number" placeholder=""
																	class="form-control required"> <a href="#">What's
																	this?</a>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="panel panel-default">
												<div class="panel-heading">
													<h4 class="panel-title">
														<a data-toggle="collapse" data-parent="#accordion"
															href="#collapseTwo"> <i class="fa fa-paypal"></i> Pay
															with PayPal
														</a>
													</h4>
												</div>
												<div id="collapseTwo" class="panel-collapse collapse">
													<div class="content margin-left-10">
														<a href="#"><img
															src="https://www.paypalobjects.com/webstatic/en_US/i/buttons/PP_logo_h_150x38.png"
															alt="PayPal"></a>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- End Accordion -->
								</div>

								<div class="col-md-6">
									<h2 class="title-type">Frequently asked questions</h2>
									<!-- Accordion -->
									<div class="accordion-v2 plus-toggle">
										<div class="panel-group" id="accordion-v2">
											<div class="panel panel-default">
												<div class="panel-heading">
													<h4 class="panel-title">
														<a data-toggle="collapse" data-parent="#accordion-v2"
															href="#collapseOne-v2"> What payments methods can I
															use? </a>
													</h4>
												</div>
												<div id="collapseOne-v2" class="panel-collapse collapse in">
													<div class="panel-body">Lorem ipsum dolor sit amet,
														consectetur adipiscing elit. Nam hendrerit, felis vel
														tincidunt sodales, urna metus rutrum leo, sit amet finibus
														velit ante nec lacus. Cras erat nunc, pulvinar nec leo at,
														rhoncus elementum orci. Nullam ut sapien ultricies,
														gravida ante ut, ultrices nunc.</div>
												</div>
											</div>
											<div class="panel panel-default">
												<div class="panel-heading">
													<h4 class="panel-title">
														<a data-toggle="collapse" class="collapsed"
															data-parent="#accordion-v2" href="#collapseTwo-v2">
															Can I use gift card to pay for my purchase? </a>
													</h4>
												</div>
												<div id="collapseTwo-v2" class="panel-collapse collapse">
													<div class="panel-body">Lorem ipsum dolor sit amet,
														consectetur adipiscing elit. Nam hendrerit, felis vel
														tincidunt sodales, urna metus rutrum leo, sit amet finibus
														velit ante nec lacus. Cras erat nunc, pulvinar nec leo at,
														rhoncus elementum orci. Nullam ut sapien ultricies,
														gravida ante ut, ultrices nunc.</div>
												</div>
											</div>
											<div class="panel panel-default">
												<div class="panel-heading">
													<h4 class="panel-title">
														<a data-toggle="collapse" class="collapsed"
															data-parent="#accordion-v2" href="#collapseThree-v2">
															Will I be charged when I place my order? </a>
													</h4>
												</div>
												<div id="collapseThree-v2" class="panel-collapse collapse">
													<div class="panel-body">Lorem ipsum dolor sit amet,
														consectetur adipiscing elit. Nam hendrerit, felis vel
														tincidunt sodales, urna metus rutrum leo, sit amet finibus
														velit ante nec lacus. Cras erat nunc, pulvinar nec leo at,
														rhoncus elementum orci. Nullam ut sapien ultricies,
														gravida ante ut, ultrices nunc.</div>
												</div>
											</div>
											<div class="panel panel-default">
												<div class="panel-heading">
													<h4 class="panel-title">
														<a data-toggle="collapse" class="collapsed"
															data-parent="#accordion-v2" href="#collapseFour-v2">
															How long will it take to get my order? </a>
													</h4>
												</div>
												<div id="collapseFour-v2" class="panel-collapse collapse">
													<div class="panel-body">Lorem ipsum dolor sit amet,
														consectetur adipiscing elit. Nam hendrerit, felis vel
														tincidunt sodales, urna metus rutrum leo, sit amet finibus
														velit ante nec lacus. Cras erat nunc, pulvinar nec leo at,
														rhoncus elementum orci. Nullam ut sapien ultricies,
														gravida ante ut, ultrices nunc.</div>
												</div>
											</div>
										</div>
									</div>
									<!-- End Accordion -->
								</div>
							</div>
						</section>

						<div class="coupon-code">
							<div class="row">
								<div class="col-sm-4 sm-margin-bottom-30">
									<h3>Discount Code</h3>
									<p>Enter your coupon code</p>
									<input class="form-control margin-bottom-10" name="code"
										type="text">
									<button type="button" class="btn-u btn-u-sea-shop">Apply
										Coupon</button>
								</div>
								<div class="col-sm-3 col-sm-offset-5">
									<ul class="list-inline total-result">
										<li>
											<h4>Subtotal:</h4> <c:set var="total" value="${0}" /> <c:forEach
												items="${sessionScope.cart}" var="map">
												<c:set var="total"
													value="${total + map.value.quantity * map.value.product.price}" />
											</c:forEach>
											<div class="total-result-in">
												<span>$ ${total }</span>

											</div>
										</li>
										<li>
											<h4>Shipping:</h4>
											<div class="total-result-in">
												<span class="text-right">- - - -</span>
											</div>
										</li>
										<li class="divider"></li>
										<li class="total-price">
											<h4>Total:</h4>
											<div class="total-result-in">
												<span>$ ${total }</span>

											</div>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xs-6">
						<a href="${pageContext.request.contextPath}/member/order"
							class="btn btn-primary">Thanh toán</a>
					</div>
				</form>
			</div>
			<!--/end container-->
		</div>
		<!--=== End Content Medium Part ===-->

		
	


	