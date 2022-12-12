<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<!-- /. NAV SIDE  -->
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-10">
				<h2>Chỉnh sửa tài khoản</h2>
			</div>
		</div>
		<!-- /. ROW  -->
		<hr />
		<div class="row">
			<div class="col-md-10">
				<!-- Form Elements -->
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<c:url value="/admin/product/edit" var="edit"></c:url>
								<form role="form"  action="${edit}" method="post"
								<br />
								<br />
								    <div>
									    <input name="id" type="hidden" value="${product.id}" type="hidden">
									</div>
									<div class="form-group" >
										<label >Tên sản phẩm:</label> <input type="text"
											class="form-control" value="${product.name}" name="name" />
									</div>

                                    <div>
                                    </div>
									<div class="form-group" >
									<label >Description:</label>
									    <input type="text" class="form-control" value="${product.description}" name="description" />
									</div>

                                    <div>
                                    </div>
                                    <div class="form-group">
									<label>Price:</label> <input type="text"
                                    		class="form-control" value="${product.price}" name="price" />
									</div>

                                    <div>
                                    </div>
                                    <div class="form-group">
									<label>imageLink:</label> <input type="text"
                                    		class="form-control" value="${product.image}" name="image" />
									</div>

                                    <div class="form-group">
									<label>CategoryID:</label> <input type="text"
                                    		class="form-control" value="${product.categoryID}" name="categoryID" />
									</div>
                                    <div class="form-group">
									<label>SellerID:</label> <input type="text"
                                    		class="form-control" value="${product.sellerID}" name="sellerID" />
									</div>
									<div class="form-group">
									<label>Amount:</label> <input type="text"
                                    		class="form-control" value="${product.amount}" name="amount" />
									</div>
									<div class="form-group">
									<label>Stoke:</label> <input type="text"
                                    		class="form-control" value="${product.stoke}" name="stoke" />
									</div>
                                    <div>
                                    </div>
									<button type="submit" class="btn btn-default" >Edit</button>
									<button type="reset" class="btn btn-primary">Reset</button>
								</form>


							</div>
						</div>
					</div>
				</div>
				<!-- End Form Elements -->
			</div>
		</div>
		<!-- /. ROW  -->
		<div class="row">
			<div class="col-md-12"></div>
		</div>
		<!-- /. ROW  -->
	</div>
	<!-- /. PAGE INNER  -->
</div>
<!-- /. PAGE WRAPPER  -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

