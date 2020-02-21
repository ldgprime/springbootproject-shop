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
					<th>구매내역삭제</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="bill" items="${bills }">
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
					<td><a href="/" class="btn btn-danger">삭제</a></td>
				</tr>
			</c:forEach>	
				<tr>
					<td colspan="6" class="text-right">
						<p>
							총수량 <span>10</span> 개 &nbsp;
							총금액 <strong>17500</strong> 원
						</p>
					</td>	
				</tr>
			</tbody>
		</table>
	</div>

	<br/><br/><br/>
		





<%@include file="../include/footer.jsp"%>	