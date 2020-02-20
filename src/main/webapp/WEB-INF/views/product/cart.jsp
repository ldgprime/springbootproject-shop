<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div>
			<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm" role="banner" style="background-image:url(/images/img_bg_2.jpg);">
				<div class="overlay"></div>
				<div class="container">
					<div class="row">
						<div class="col-md-8 col-md-offset-2 text-center">
							<div class="display-t">
								<div class="display-tc animate-box" data-animate-effect="fadeIn">
									<h1>장바구니</h1>					
								</div>
							</div>
						</div>
					</div>
				</div>
			</header>
			</div>


	<div class="container" style="margin-top: 650px;">
		<table class="table table-hover">
			<thead>
				<tr >
					<th>상품</th>
					<th>상품이름</th>
					<th>수량</th>
					<th>상품금액</th>	
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="respAddCart" items="${respAddCarts }">			
				<tr >
					<td style="width: 60px; height: 30;">
						<img							          	
							src="/images/${respAddCart.imageOne }.jpg"
							style="width: 60px; height: 30px;"
						/>
					</td>
					<td>${respAddCart.productName }</td>
					<td><input type="number" value="${respAddCart.count }" max="100" /></td>
					<td>${respAddCart.productPrice }원</td>
					<td><button onclick="deleteLine(${respAddCart.id },${respAddCart.count },this)" class="btn btn-danger">삭제</button></td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="4" class="text-right">
						<p>
							상품금액 <span>15000</span> 원 +
							배송비 <span>2500</span> 원 = 주문합계 <strong>17500</strong> 원
						</p>
					</td>
					<td><a href="/" class="btn btn-primary">결제</a></td>
				</tr>
			
			</tbody>
		</table>
	</div>

	<br/><br/><br/>
		
	<script>
	

	
    var cookieRemove = function(id,count) {

        // 변수를 선언한다.
        var date = new Date();
        date.setDate(date.getDate() - 1);
		
        var willCookie = "";
        willCookie += ""+id+"="+count+";";
        willCookie += "Expires=" + date.toUTCString()+";";
        willCookie += "path=/";       

        // 쿠키를 집어넣는다.
        document.cookie = willCookie;

        // 출력한다.
        alert('장바구니에 삭제되었습니다!');
    }
    
	
	function deleteLine(id,count,obj) {

		cookieRemove(id,count)	
		
	    let tr = $(obj).parent().parent();	 
	    //라인 삭제
	    tr.remove();	    
	}




	</script>
	



<%@include file="../include/footer.jsp"%>	