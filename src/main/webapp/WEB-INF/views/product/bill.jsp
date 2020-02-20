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
				<tr >
					<th>상품</th>
					<th>상품이름</th>
					<th>수량</th>
					<th>상품금액</th>
					<th>할인금액</th>
					<th>배송비</th>
					<th>구매내역삭제</th>
				</tr>
			</thead>
			<tbody>
				<tr >
					<td style="width: 60px; height: 30;">
						<img
							src="/images/product-1.jpg"
							style="width: 60px; height: 30px;"
						/>
					</td>
					<td>마우스</td>
					<td><input type="number" value="1" max="100" /></td>
					<td>15000원</td>
					<td>100원</td>
					<td>2500원</td>

					<td><a href="/" class="btn btn-danger">삭제</a></td>
				</tr>
				<tr>
					<td colspan="7" class="text-right">
						<p>
							 주문합계 <strong>17500</strong> 원
						</p>
					</td>	
				</tr>
			</tbody>
		</table>
	</div>

	<br/><br/><br/>
		





<%@include file="../include/footer.jsp"%>	