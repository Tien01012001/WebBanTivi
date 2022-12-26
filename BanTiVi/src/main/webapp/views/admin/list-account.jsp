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
<table id="tba" class="table table-striped table-bordered table-condensed"
	style="width: 100%">
	<thead>
		<tr>
			<th>STT</th>
			<th>Username</th>
			<th>Password</th>
			<th>isAdmin</th>
			<th>Hành động</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${acc}" var="account" varStatus="STT">
			<tr class="odd gradeX">
				<td>${STT.index+1 }</td>
                <td>${account.user}</td>
				<td>${account.pass}</td>
				<td>${account.isAdmin}</td>
				<td><a
					href="<c:url value='/admin/account/edit?id=${account.uid }'/>"
					class="btn btn-success"><i class="fa fa-pencil"></i></a> | <a
					href="<c:url value='/admin/account/delete?id=${account.uid }'/>"
					class="btn btn-danger"><i class="fa fa-trash"></i></a></td>
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

