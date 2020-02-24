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
									<h1>구매내역</h1>					
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
				<tr>
					<th>상품</th>
					<th>상품이름</th>
					<th>상품금액</th>	
					<th>수량</th>						
					<th>상품합계금액</th>
					<th>주문일자</th>				
				</tr>
			</thead>
			<tbody>
			<c:forEach var="payment" items="${payments }" varStatus="status">			
			<c:forEach var="bill" items="${bills }">
			<c:if test="${payment.id eq bill.paymentId }">			
				<tr >
					<td style="width: 60px; height: 30;">
						<img
							src="/images/${bill.imageOne }.jpg"
							style="width: 60px; height: 30px;"
						/>
					</td>
					<td>${bill.productName }</td>
					<td>${bill.productPrice } 원</td>
					<td><input type="number" value="${bill.subCount  }" max="100" min="0" readonly="readonly"  /></td>					
					<td>${bill.subPrice } 원</td>
					<td>${bill.createDate }</td>
					
				</tr>	
				</c:if>
				</c:forEach>				
				<tr>
					<td colspan="5" class="text-right">
						<p>
							총수량 <span>${payment.totalCount }</span> 개 &nbsp;
							금액 <span class="total-price">${payment.totalPrice }</span> 원 &nbsp;
							배송비 <span class="shiping-fee">${payment.shipingFee }</span> 원 &nbsp;
							총금액 <strong class="price-fee"></strong> 원
						</p>
					</td>
					<td><a href="/" class="btn btn-danger">삭제</a></td>	
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<br/><br/><br/>
		
	
	<script>
	var total_price = $('.total-price')
	var shiping_fee = $('.shiping-fee')
	var price_fee = $('.price-fee')
	var price_fee_sum = 0;

	
	
	for(let i = 0; i<total_price.length; i++){
		
		price_fee_sum = 0;		
		price_fee_sum += Number((total_price[i].innerHTML))+Number((shiping_fee[i].innerHTML));				
		price_fee.text(price_fee_sum);	
		
	}
	

	</script>




<%@include file="../include/footer.jsp"%>	