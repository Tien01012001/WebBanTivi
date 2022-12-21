<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<!-- /. NAV SIDE  -->
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-15">
				<h2>Chỉnh sửa tài khoản</h2>
			</div>
		</div>
		<!-- /. ROW  -->
		<hr />
		<div class="row">
			<div class="col-md-6">
				<!-- Form Elements -->
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<h3 style="text-align: center">Tài khoản:</h3>

								<c:url value="/admin/account/edit" var="edit"></c:url>
								<form role="form"  action="${edit}" method="post"
								<br />
								    <div>
									    <input name="uid" type="hidden" value="${account.uid}" type="hidden">
									</div>
                                <br />
									<div class="form-group" >
										<label >Tên đăng nhập:</label> <input type="text"
											class="form-control" value="${account.user}" name="user" />
									</div>

                                    <div>
                                    </div>
									<div class="form-group">
									<label >Mật khẩu:</label> <input type="text"
                                    		class="form-control" value="${account.pass}" name="pass" />
									</div>

                                    <div>
                                    </div>

                                    <div>
                                    </div>
                                    <div>
									<label>isAdmin(vui long nhap 0 hoặc 1):</label> <input type="text"
                                    		class="form-control" value="${account.isAdmin}" name="isAdmin" />
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

