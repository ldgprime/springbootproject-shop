<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div>
	<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm"
		role="banner" style="background-image: url(/images/img_bg_2.jpg);">
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
<form action="/product/billProc" method="POST">
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>상품</th>
				<th>상품이름</th>				
				<th>상품금액</th>
				<th>수량</th>
				<th>상품합계금액</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="respAddCart" items="${respAddCarts }">
			<input type="hidden" name="id" value="${respAddCart.id }"/>
				<tr>
					<td style="width: 60px; height: 30;"><img
						src="/images/${respAddCart.imageOne }.jpg"
						style="width: 60px; height: 30px;" /></td>
					<td>${respAddCart.productName }</td>
					<td><span class="price">${respAddCart.productPrice }</span>원</td>
					<td><input class="count" type="number" min="0"
						value="${respAddCart.count }" name ="count"  max="100" /></td>					
					<td><span class="sub-price"></span>원</td>
					<td><button
							onclick="deleteLine(${respAddCart.id },${respAddCart.count },this)"
							class="btn btn-danger">삭제</button></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" class="text-right">
					<p>
						상품금액 <span id="sub-price-sum">0</span> 원 
						+ 배송비 <span id="shiping-fee" >2500</span> 원 
						= 주문합계 <strong id="total-price" >0</strong> 원
					</p>
				</td>
				<td><button id="payment" type="submit" class="btn btn-primary">결제</button></td>
			</tr>
		</tbody>
	</table>
</form>	
</div>

<br />
<br />
<br />

<script>


	function calculation_price(){
		let price = $('.price');
		let count = $('.count');
		let sub_price = $('.sub-price');	
		let sub_price_sum = $('#sub-price-sum');
		let shiping_fee = $('#shiping-fee');
		let total_price = $('#total-price');
		let sub_price_sum_count = 0;
		
		sub_price_sum_count = 0;

		let sub_price_count = 0;
	
		for(let i=0; i<count.length; i++){				
			sub_price_sum_count += (price[i].innerHTML)*(count[i].value);
			sub_price_count += (price[i].innerHTML)*(count[i].value);
			sub_price[i].innerText = sub_price_count;	
			sub_price_count = 0;		
		}		
		
		sub_price_sum.text(sub_price_sum_count);		
		total_price.text(Number(sub_price_sum.text())+Number(shiping_fee.text()));
		
	}

	calculation_price();

	$('.count').on('click', function(){
		calculation_price();
		
	});
	
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

	    calculation_price();	    
	}

	
</script>




<%@include file="../include/footer.jsp"%>
