<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

	<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm" role="banner" style="background-image:url(/images/img_bg_2.jpg);">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
							<h1>상품</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	
	<div id="fh5co-product">
		<div class="container">			
			<c:forEach var="product" items="${products }">
				<div class="col-md-4 text-center ">
					<div class="product">
						<div class="product-grid" style="background-image:url(/images/${product.imageOne}.jpg);">
							<div class="inner">
								<p>
									
									<a href="/product/productdetail/${product.id }" class="icon"><i class="icon-eye"></i></a>
								</p>
							</div>
						</div>
						<div id="${product.id }" class="desc">
							<h3><a href="/product/productdetail/${product.id }">${product.productName }</a></h3>
							<span class="price"><strong>${product.productPrice }</strong> ₩</span>
							<br/>
							<button onclick="nice(${product.id})" class="icon"><i class="icon-thumbs-up"></i></button><span>&nbsp;&nbsp;${product.niceCount }</span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button onclick="hate(${product.id})" class="icon"><i class="icon-thumbs-down"></i></button><span>&nbsp;&nbsp;${product.hateCount }</span>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>	
	</div>
	
	<script>
		function nice(productId){
			let data = {			
				userId:1,
				productId:productId				
			}			

			
			$.ajax({
				type : 'POST',
				url : '/nicehate/api/nice',
				data:JSON.stringify(data),
				contentType:'application/json; chartset=utf-8',
				dataType : 'json'
			}).done(function(r) {		
				if (r.status.statusCode == 200) {				
					alert('댓글쓰기에 성공했습니다!')			
					
				} else {		
					alert('댓글쓰기에 실패했습니다!')
				}
			}).fail(function(r) {		
				alert('댓글쓰기에 실패했습니다!')
			
			})


			

		}




	</script>
	
	
	
	
	
	
	

<%@include file="../include/footer.jsp"%>	