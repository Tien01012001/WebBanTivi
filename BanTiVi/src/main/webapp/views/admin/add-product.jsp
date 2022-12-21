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
						<div id="logreg-forms" class="row">
							<div class="col-md-6">
								<c:url value="/admin/product/add" var="add"></c:url>
								<form role="form"  action="${add}" method="post"
								<br />
								<br />

									<div class="form-group" >
										<label >Tên sản phẩm:</label>
										<input type="text" class="form-control"  name="name" required autofocus/>
									</div>

                                    <div>
                                    </div>
									<div class="form-group" >
									<label >Description:</label>
									    <input type="text" class="form-control"  name="description" required autofocus/>
									</div>

                                    <div>
                                    </div>
                                    <div class="form-group">
									<label>Price:</label> <input type="text"
                                    		class="form-control"  name="price" required autofocus/>
									</div>

                                    <div>
                                    </div>
                                    <div class="form-group">
									<label>imageLink:</label> <input type="text"
                                    		class="form-control"  name="image" required autofocus/>
									</div>

                                    <div class="form-group">
                                        <label>CategoryID:</label>
                                        <select name="categoryID" id="categoryID">
									        <c:forEach items="${cateList}" var="cate">
									               <option value="${cate.id}">${cate.id}</option>
                                            </c:forEach>
                                        </select>
									</div>
									<div class="form-group">
									<label>Amount:</label> <input type="text"
                                    		class="form-control"  name="amount" required autofocus/>
									</div>
									<div class="form-group">
									<label>Stoke:</label> <input type="text"
                                    		class="form-control"  name="stoke" required autofocus/>
									</div>
                                    <div>
                                    </div>
									<button type="submit" class="btn btn-default" >Add</button>
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

 <script>


            function toggleAddProduct(e) {
                e.preventDefault();
                $('#logreg-forms .form-form').toggle(); // display:block or none
            }

        </script>