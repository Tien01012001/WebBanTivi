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
<div class="container" >
<table id="tba" class="table table-striped table-bordered table-condensed"
	style="width: 100%">
	<thead>
		<tr>
			<th style="width:5%">STT</th>
			<th style="width:5%">Tên</th>
			<th style="width:10%">Tổng tiền</th>
			<th>Phương thức thanh toán</th>
			<th>SĐT</th>
			<th>Địa chỉ</th>
			<th>Ngày mua</th>
			<th>Trạng thái</th>
			<th style="width:11%">Hành động</th>

		</tr>
	</thead>
	<tbody>
	    <c:set var = "success" value="Đã giao"/>
	    <c:set var = "shipping" value="Đang giao"/>
		<c:forEach items="${orderList}" var="order" varStatus="STT">
			<tr class="odd gradeX">
				<td>${STT.index+1 }</td>
                <td>${order.nguoiMua.user}</td>
				<td>${order.total}</td>
				<td>${order.phuongThucThanhToan}</td>
				<td>${order.sodienthoai}</td>
				<td>${order.diaChiNhan}</td>
				<td>${order.ngayMua}</td>
				<td>${order.trangThai}</td>
				<td>

				<c:choose>

				    <c:when test="${order.trangThai == success || order.trangThai == shipping}">

					</c:when>
					<c:otherwise>
					        <a href="<c:url value='/delete-order?id=${order.ID }'/>"
                                class="btn btn-sm btn-danger"> <i class="fa fa-trash"></i></a>
                    </c:otherwise>
				</c:choose>

				<a href="<c:url value='/orderdetail?id=${order.ID}'/>"
                    class="btn btn-sm btn-info"> <i class="fa fa-info"></i></a></td>


			</tr>
		</c:forEach>


	</tbody>

</table>
 </div>

<script>
$('#tba').DataTable({
    dom: 'Bfrtip',
    buttons: [
        'copy', 'csv', 'excel', 'pdf', 'print'
    ]
});    </script>

