<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<form role="form" action="add" method="post"
	enctype="multipart/form-data">
	<div class="form-group">
		<label>Tên danh mục:</label> <input class="form-control"
			placeholder="please enter category Name" name="cname" />
	</div>
	
	<input type="radio" id="postageyes" name="postage" value="Yes" /> Chèn link ảnh
	<input type="radio" id="postageno" name="postage" value="No" /> Tải ảnh
	<br/>
	
	<div class="form-group" id="anh" hidden="hidden">
		<label>Ảnh đại diện</label> <input id="inputicon" type="file" name="icons" />
	</div>
	<br/>
	<button type="submit" class="btn btn-default">Thêm</button>
	<button type="reset" class="btn btn-primary">Hủy</button>
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
	$('input:radio[name="postage"]').change(
    function(){
        if ($(this).is(':checked') && $(this).val() == 'Yes') {
            $("#anh").removeAttr("hidden")
            $("#inputicon").attr("type","text")
            $("#inputicon").attr("name","imagelink")
        }
        if ($(this).is(':checked') && $(this).val() == 'No') {
            $("#anh").removeAttr("hidden")
           
            $("#inputicon").attr("type","file")
            $("#inputicon").attr("name","icons")
        }
        
    });
</script>