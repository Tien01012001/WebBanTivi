<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<!-- /. NAV SIDE  -->
<div class="container">
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Chỉnh sửa danh mục</h2>
				<h5>Nơi bạn có thể chỉnh sửa thông tin danh mục</h5>
			</div>
		</div>
		<!-- /. ROW  -->
		<hr />
		<div class="row">
			<div class="col-md-12">
				<!-- Form Elements -->
				<div class="panel panel-default">
					<div class="panel-heading">Chỉnh sửa danh mục</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<h3>Danh mục:</h3>
								<c:url value="/admin/category/edit" var="edit"></c:url>
								<form role="form" action="${edit}" method="post"
									enctype="multipart/form-data">
									<input name="id" value="${category.id }" hidden="">
									<div class="form-group">
										<label>Tên danh sách:</label> <input type="text"
											class="form-control" value="${category.name }" name="name" />
									</div>

									<input type="radio" id="postageyes" name="postage" value="Yes" checked/>
									Chèn link ảnh 
									<br />
									<input type="radio" id="postageno" name="postage"
										value="No" /> Tải ảnh <br />

									<c:set var = "string1" value="${category.icon}"/>
				<c:set var = "string2" value = "${fn:substring(string1, 0, 4)}" />
		<c:choose>
         <c:when test = "${string2 =='cate'}">
            <c:url value="/image?fname=${category.icon}" var="imgUrl"></c:url>
         </c:when>
         <c:otherwise>
            <c:url value="${category.icon}" var="imgUrl"></c:url>
         </c:otherwise>
      </c:choose>
									
												<img class="img-responsive" width="100px" src="${imgUrl}"
											alt="">

<br/>
									<div class="form-group" id="anh" hidden="hidden">
										 <label>Ảnh đại diện</label> <input id="inputicon" type="file"
											name="icon" value="${category.icon }" accept="image/*" onchange="validateFileType()"/>
									</div>
									<button type="submit" class="btn btn-default">Edit</button>
									<button type="reset" class="btn btn-primary">Reset</button>
									<div class="form-check">
                                      <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                                      <label class="form-check-label" for="flexRadioDefault1">
                                        Default radio
                                      </label>
                                    </div>



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
</div>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
	$('input:radio[name="postage"]').change(function() {
		if ($(this).is(':checked') && $(this).val() == 'Yes') {
			$("#anh").removeAttr("hidden")
			$("#inputicon").attr("type", "text")
			$("#inputicon").attr("name", "imagelink")
		}
		if ($(this).is(':checked') && $(this).val() == 'No') {
			$("#anh").removeAttr("hidden")

			$("#inputicon").attr("type", "file")
			$("#inputicon").attr("name", "icons")
		}

	});

	function validateFileType(){
            var fileName = document.getElementById("inputicon").value;
            var idxDot = fileName.lastIndexOf(".") + 1;
            var extFile = fileName.substr(idxDot, fileName.length).toLowerCase();
            if (extFile=="jpg" || extFile=="jpeg" || extFile=="png"){

            }else{
                alert("XIN LỖI BẠN VỪA CHỌN KHÔNG PHẢI LÀ FILE ẢNH! VUI LÒNG THỬ LẠI");
            }
        }
</script>