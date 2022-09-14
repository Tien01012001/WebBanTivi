<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
			<div class="card bg-light mb-3">
				<div class="card-header bg-primary text-white text-uppercase">
					<i class="fa fa-list"></i> Categories
				</div>
				<ul class="list-group category_block">
					<c:forEach items="${listcate}" var="o">
						<c:url value="/image?fname=${o.icon}" var="imgUrl"></c:url>
						<li class="list-group-item ${tagactive == o.id ? "active":""}"><a
							href="product?cid=${o.id}&index=${tag}"> <img height="30"
								width="30" src="${imgUrl}" /> ${o.name}
						</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="card bg-light mb-3">
				<div class="card-header bg-success text-white text-uppercase">Last
					product</div>
				<div class="card-body">
					<img class="img-fluid" src="${list1BestSellerAndNew.image}" />
					<h5 class="card-title">${list1BestSellerAndNew.name}</h5>
					<p class="card-text">${list1BestSellerAndNew.description}</p>
					<p class="bloc_left_price">${list1BestSellerAndNew.price}$</p>
				</div>
			</div>
		</div>