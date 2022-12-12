<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!--Import jQuery before export.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>


    <!--Data Table-->
    <script type="text/javascript"  src=" https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript"  src=" https://cdn.datatables.net/buttons/1.2.4/js/dataTables.buttons.min.js"></script>

    <!--Export table buttons-->
    <script type="text/javascript"  src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
    <script type="text/javascript" src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/pdfmake.min.js" ></script>
    <script type="text/javascript"  src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/vfs_fonts.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.html5.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.2.1/js/buttons.print.min.js"></script>

<!--Export table button CSS-->

<link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.2.4/css/buttons.dataTables.min.css">
<div class="container">
<table id="tbl" class="table table-striped table-bordered table-condensed"
	style="width: 100%">
	<thead>
		<tr>
			<th>STT</th>
			<th>Tên Sản phẩm</th>
			<th>Hình ảnh</th>
			<th>Description</th>
			<th>Giá</th>
			<th>CategoryID</th>
			<th>Đã bán</th>
			<th>Còn lại</>
			<th>Hành động</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${proList}" var="product" varStatus="STT">
			<tr class="odd gradeX">
				<td>${STT.index+1 }</td>
				<c:set var = "string1" value="${product.image}"/>
				<c:set var = "string2" value = "${fn:substring(string1, 0, 4)}" />
		<c:choose>
         <c:when test = "${string2 =='product'}">
            <c:url value="/image?fname=${product.image}" var="imgUrl"></c:url>
         </c:when>
         <c:otherwise>
            <c:url value="${product.image}" var="imgUrl"></c:url>
         </c:otherwise>
      </c:choose>
                <td>${product.name}</td>
                <td><img height="150" width="200" src="${imgUrl}" /></td>
                <td>${product.description}</td>
				<td>${product.price}$</td>
				<td>${product.categoryID}</td>
				<td>${product.amount}</td>
				<td>${product.stoke}</td>
				<td><a
					href="<c:url value='/admin/product/edit?id=${product.id }'/>"
					class="center">Sửa</a> | <a
					href="<c:url value='/admin/product/delete?id=${product.id }'/>"
					class="center">Xóa</a></td>
			</tr>
		</c:forEach>


	</tbody>

</table>
 </div>

<script>
$('#tbl').DataTable({
    dom: 'Bfrtip',
    buttons: [
        'copy', 'csv', 'excel', 'pdf', 'print'
    ]
});    </script>

