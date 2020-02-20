<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<section>	
	<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm" role="banner" style="background-image:url(/images/img_bg_2.jpg);">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
							<h1>상품상세보기</h1>					
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
</section>	

	<!-- info Content -->
	<section id="info">	
		<div class="container" style="margin-top: 700px;">
			<span style="display: inline-block; width: 700px; height: 700px;">
				<img
					class="img"
					src="/images/product-single-1.jpg"
					alt=""
					style="display: inline-block; width: 700px; height: 700px;"
				/>
			</span>
			<div style="display: inline-block; ">
				<table class="table table-hover" style="display: inline-block; margin-bottom: 40px;">
					<tbody>
						<tr>
							<td>상품명</td>
							<td>마우스</td>
						</tr>
						<tr>
							<td>판매가</td>
							<td>15000원</td>
						</tr>
						<tr>
							<td>마일리지 적립</td>
							<td>15원</td>
						</tr>
						<tr>
							<td>수량</td>
							<td><input type="number" value="1" /></td>
						</tr>
						<tr>
							<td>배송비</td>
							<td>2500원</td>
						</tr>
						<tr>
							<td>총액</td>
							<td>17500원</td>
						</tr>
						<tr>
							<td class="text-center">
								<a href="#" class="icon"><i class="icon-thumbs-up"></i></a>
							</td>
							<td class="text-center">
								<a href="#" class="icon"><i class="icon-thumbs-down"></i></a>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="text-center" style="display: block;">
					<button class="btn btn-warning">장바구니 추가</button>					
				</div>
			</div>		
		</div>
	</section>
	<!-- info Content -->		

		
			<nav class="fh5co-nav" role="navigation">			
					<div class="row">	
						<div class="fh5co-tabs">				
								<ul class="fh5co-tab-nav">
								<li>
									<a href="#detail">상세보기</a>				
								</li>
								<li>
									<a href="#comment">상품후기</a>
								</li>
								<li>
									<a href="#board">상품문의</a>
								</li>							
							</ul>											
					</div>			
				</div>
			</nav>	

						<!-- Tabs -->
						<section id="detail">
						<div class="container">
							<img class="img-responsive center-block" src="/images/g102.jpg" />
						</div>
						</section>
						
						<!-- comment section -->
						<section id="comment">
							<div class="container">
								<br /><br />						
								<h2>상품후기</h2>
								<br /><br />
				
								<table class="table table-hover">
									<thead>
										<tr>
											<th>번호</th>
											<th>글제목</th>
											<th>아이디</th>
											<th>작성일</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>3</td>
											<td>이 상품 좋아요!</td>
											<td>ssar3</td>
											<td>2020-02-18</td>
										</tr>
										<tr>
											<td>2</td>
											<td>이 상품 싫어요!</td>
											<td>ssar2</td>
											<td>2020-02-18</td>
										</tr>
										<tr>
											<td>1</td>
											<td>이 상품 좋아요!</td>
											<td>ssar1</td>
											<td>2020-02-18</td>
										</tr>
									</tbody>
								</table>
								<button id="review" class="btn btn-primary" style="float: right ;">후기작성하기</button>
								<br/>
								<div id="reviewbox">

								</div>
								<br/>

							</div>
						</section>
						<!-- comment section -->
				
						<!-- board section -->
						<section id="board">
							<div class="container"style="
							margin-bottom: 120px;">
								<br /><br />	
								<h2>상품문의</h2>
								<br /><br />
				
								<table class="table table-hover" >
									<thead>
										<tr>
											<th>번호</th>
											<th>문의/답변</th>
											<th>아이디</th>
											<th>작성일</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>3</td>
											<td><a href="/board/boarddetail">주말에 배송이 되나요?</a></td>
											<td>ssar3</td>
											<td>2020-02-18</td>
										</tr>
										<tr>
											<td>2</td>
											<td>품절... 재입고 되나요?</td>
											<td>ssar2</td>
											<td>2020-02-18</td>
										</tr>
										<tr>
											<td>1</td>
											<td>무상 A/S기간이 어떻게 되나요?</td>
											<td>ssar1</td>
											<td>2020-02-18</td>
										</tr>
									</tbody>
								</table>
								<a href="/board/boarddetail" class="btn btn-primary" style="float: right ;">상품문의하기</a>							
							</div>
						</section>
						<!-- board section -->
		
			<script>
		$('#review').on('click',function(){
			let str = "";
			str += "<div class='form-group'>";			
			str += "<div class='card-body'>";
			str += "<label>제목: </label><br/>";
			str += "<input type='text' class='form-control' style='height: 35px; width: 500px;'>";
			str += "<label>내용: </label><br/>";
			str += "<textarea id='content' rows='4' class='form-control'>내용</textarea>";
			str += "</div><br/>";
			str += "<div class='card-footer'>";
			str += "<button id='comment--save--submit' type='button' class='btn btn-primary' style='float: right;''>등록</button>";
			str += "</div></div>";

			$('#reviewbox').prepend(str);	

		});




	</script>





<%@include file="../include/footer.jsp"%>	