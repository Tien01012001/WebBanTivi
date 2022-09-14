<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<div class="page-content-wrapper">
			<div class="page-content">
				<div class="row">
					<div class="col-md-12">
						<!-- BEGIN VALIDATION STATES-->
						<div class="portlet box yellow">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-gift"></i>Validation Using Icons
								</div>
								<div class="tools">
									<a href="javascript:;" class="collapse"> </a> <a
										href="#portlet-config" data-toggle="modal" class="config">
									</a> <a href="javascript:;" class="reload"> </a> <a
										href="javascript:;" class="remove"> </a>
								</div>
							</div>
							<div class="portlet-body form">
								<!-- BEGIN FORM-->
								<form action="order" method="post" id="form_sample_2" class="form-horizontal">
									<div class="form-body">
										<div class="alert alert-danger ${alertmess != null ? "" : "display-hide" }">
											<button class="close" data-close="alert"></button>
											${alertmess }
										</div>
										<div class="alert alert-success display-hide">
											<button class="close" data-close="alert"></button>
											Your form validation is successful!
										</div>
										<div class="form-group">
											<label class="control-label col-md-3">Địa chỉ nhận hàng <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input id="input" type="text" class="form-control"
														name="diachinhan" required />
												</div>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3">Phương thức thanh toán</label>
											<div class="radio-list">
												<label>
												<input type="radio" name="phuongthuc" id="optionsRadios1" value="Momo"> Momo</label>
												<label>
												<input type="radio" name="phuongthuc" id="optionsRadios2" value="Tiền mặt "> Tiền mặt </label>
											</div>
										</div>
									<div class="form-actions">
										<div class="row">
											<div class="col-md-offset-3 col-md-9">
												<button type="submit" class="btn green">Submit</button>
												<button type="button" class="btn default">Cancel</button>
											</div>
										</div>
									</div>
								</form>
								<!-- END FORM-->
							</div>
						</div>
						<!-- END VALIDATION STATES-->
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>