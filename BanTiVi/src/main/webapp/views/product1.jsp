<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="index.html">Home</a></li>
						<li class="breadcrumb-item"><a href="category.html">Category</a></li>
						<li class="breadcrumb-item active" aria-current="page">Sub-category</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12 col-sm-3">
				<div class="card bg-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-list"></i> Categories
					</div>
					<ul class="list-group category_block">
						<c:forEach items="${listcate1}" var="o">
							<li class="list-group-item ${tagactive == o.cate_id ? "active":""}"><a
								href="product?cid=${o.cate_id}">${o.icons} ${o.cname}</a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="card bg-light mb-3">
					<div class="card-header bg-success text-white text-uppercase">Last product</div>
					<div class="card-body">
						<img class="img-fluid" src="${list1BestSellerAndNew.image}" />
						<h5 class="card-title">${list1BestSellerAndNew.name}</h5>
						<p class="card-text">${list1BestSellerAndNew.description}</p>
						<p class="bloc_left_price">${list1BestSellerAndNew.price}$</p>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="row">
					<c:forEach items="${listcate}" var="c">
						
						<div class="card bg-light mb-3">

							<div class="card-header bg-primary text-white text uppercase">${c.cname}</div>

							<div class="card-body">

								<div class="row">

									<c:forEach items="${listAllproduct}" var="p">

										<c:if test="${c.cate_id == p.categoryID }">

											<div class="col-12 col-md-6 col-lg-4">

												<div class="card">

													<img class="card-img-top" src="${p.image}" alt="${p.name}">

													<div class="card-body">

														<h4 class="card-title">

															<a href="productdetail?pid=${p.id}&cid=${p.categoryID}" title="View Product">${p.name}</a>

														</h4>

														<p class="card-text">${p.description}</p>

														<div class="row">

															<div class="col">

																<p class="btn btn-danger btn-block">${p.price}$</p>

															</div>

															<div class="col">

																<a href="#" class="btn btn-success btn-block">Add to
																	cart</a>

															</div>

														</div>

													</div>

												</div>

											</div>

										</c:if>

									</c:forEach>

								</div>
<div class="row">
<c:if test="${c.cate_id == p.categoryID }">
					<div class="col-12">
					<nav aria-label="...">
						<ul class="pagination">
							<c:if test="${tag>1}">
								<li class="page-item"><a class="page-link"
									href="product?cid=${tagactive}&index=${tag-1}">Previous</a></li>
							</c:if>
							<c:forEach begin="1" end="${endP}" var="i">
								<li class="page-item ${tag==i ? "active":"" }"><a
									class="page-link" href="product?cid=${tagactive}&index=${i}"">${i}</a></li>
							</c:forEach>
							<c:if test="${tag<endP}">
								<li class="page-item"><a class="page-link"
									href="product?cid=${tagactive}&index=${tag+1}">Next</a></li>
							</c:if>
						</ul>
					</nav>
				</div>

				</div>
				</c:if>



							</div>

						</div>

					</c:forEach>
				</div>
				
			</div>
		</div>
	</div>


