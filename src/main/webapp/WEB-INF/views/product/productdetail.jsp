<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<section>
	<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm"
		role="banner" style="background-image: url(/images/img_bg_2.jpg);">
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
			<img class="img" src="/images/${product.imageOne }.jpg" alt=""
			style="display: inline-block; width: 700px; height: 700px;" />
		</span>
		<div style="display: inline-block;">
			<table class="table table-hover"
				style="display: inline-block; margin-bottom: 30px;">
				<tbody>
					<tr>
						<td>상품명</td>
						<td>${product.productName }</td>
					</tr>
					<tr>
						<td>판매가</td>
						<td>${product.productPrice }</td>
					</tr>
					<tr>
						<td>마일리지 적립</td>
						<td>15원</td>
					</tr>
					<tr>
						<td>수량</td>
						<td><input id="count" type="number" value="1" /></td>
					</tr>
					<tr>
						<td>배송비</td>
						<td>2500원</td>
					</tr>
					<tr>
						<td class="text-center">
							<!-- input hidden --> <input type="hidden" id="userId"
							value="${sessionScope.principal.id }"> <input
							type="hidden" id="productId" value="${product.id }">

							<div id="nice${product.id}" style="display: inline-block;">
								<c:if test="${not empty sessionScope.principal }">
									<c:choose>
										<c:when test="${niceResult eq 1 }">
											<a onclick="niceminus(${product.id})" class="icon btn "><i
												class="icon-heart2"></i></a>
											<span>&nbsp;&nbsp;${product.niceCount }</span>
										</c:when>
										<c:otherwise>
											<a onclick="nice(${product.id})" class="icon btn "><i
												class="icon-thumbs-up"></i></a>
											<span>&nbsp;&nbsp;${product.niceCount }</span>
										</c:otherwise>
									</c:choose>
								</c:if>
								<c:if test="${empty sessionScope.principal }">
									<a class="icon btn"><i class="icon-heart2"></i></a>
									<span>&nbsp;&nbsp;${product.niceCount }</span>
								</c:if>
							</div>
						</td>
						<td class="text-center">
							<div id="hate${product.id}" style="display: inline-block;">
								<c:if test="${not empty sessionScope.principal }">
									<c:choose>
										<c:when test="${hateResult eq 1 }">
											<a onclick="hateminus(${product.id})" class="icon btn"><i
												class="icon-heart"></i></a>
											<span>&nbsp;&nbsp;${product.hateCount }</span>
										</c:when>
										<c:otherwise>
											<a onclick="hate(${product.id})" class="icon btn"><i
												class="icon-thumbs-down"></i></a>
											<span>&nbsp;&nbsp;${product.hateCount }</span>
										</c:otherwise>
									</c:choose>
								</c:if>
								<c:if test="${empty sessionScope.principal }">
									<a class="icon btn"><i class="icon-heart"></i></a>
									<span>&nbsp;&nbsp;${product.hateCount }</span>
								</c:if>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="text-center" style="display: block;">
				<button id="addCart" class="btn btn-warning" value="${product.id }">장바구니
					추가</button>
				<br /> <a href="/product/product" class="btn btn-primary">상품페이지로</a>
			</div>
		</div>
	</div>
</section>
<!-- info Content -->


<nav class="fh5co-nav" role="navigation">
	<div class="row">
		<div class="fh5co-tabs">
			<ul class="fh5co-tab-nav">
				<li><a href="#detail">상세보기</a></li>
				<li><a href="#review">상품후기</a></li>
				<li><a href="#board">상품문의</a></li>
			</ul>
		</div>
	</div>
</nav>

<!-- Tabs -->
<section id="detail">
	<div class="container">
		<img class="img-responsive center-block"
			src="/images/${product.imageTwo }.jpg" />
	</div>
</section>

<!-- review section -->
<section id="review">
	<div class="container">
		<br /> <br />
		<h2>상품후기</h2>
		<br /> <br />

		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>글제목</th>
					<th>아이디</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody id="review--list--box">

			</tbody>
			<tr id="pagenate">

			</tr>
		</table>

		<button id="review--save" class="btn btn-primary"
			style="float: right;">후기작성하기</button>
		<br />
		<div id="review--save--box"></div>
		<br />

	</div>
</section>
<!-- comment section -->

<!-- board section -->
<section id="board">
	<div class="container" style="margin-bottom: 120px;">
		<br /> <br />
		<h2>상품문의</h2>
		<br /> <br />

		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>문의/답변</th>
					<th>아이디</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody id="board--list--box">
				<c:forEach var="board" items="${boards }">
					<tr class="board--title--box" >
						<td>${board.id }</td>
						<td><a href="/board/boarddetail/${board.id }">${board.title }</a></td>
						<td>${board.username }</td>
						<td>${board.createDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/board/boardwrite/${product.id }" class="btn btn-primary"
			style="float: right;">상품문의하기</a>
	</div>
</section>
<!-- board section -->





<script>
var productId = $('#productId').val()		

		function getreview2(page){
			$.ajax({
				type : 'GET',
				url : '/review/api/getreview/'+productId+'/'+page
				
			}).done(function(r) {
				$('.review--title--box').remove();
				
					for(let i=0; i<r.length; i++){			
					let str = "";
					str += "<tr class='review--title--box' id='review--title--box"+r[i].id+"'>";
					str += "<td>"+r[i].id+"</td>";
					str += "<td><a  class='btn' style='padding-top: 1px; padding-bottom: 1px;' onclick='getcontent("+r[i].id+"); this.onclick=null;'>"+r[i].title+"</td>";
					
					str += "<td>"+r[i].username+"</td>";
					str += "<td>"+r[i].createDate+"</td>";
					str += "</tr>";				
								
					$('#review--list--box').append(str);

					}

				$('#pagenate').empty();
				$('.review--content').remove();
					
				let str2="";

				
				str2 +="<td colspan='4' align='center'>";
				str2 +="<input type='hidden' id='page1' value='"+r[0].reviewPageMaker.page+"'/>";
				str2 +="<input type='hidden' id='perPageNum' value='"+r[0].reviewPageMaker.perPageNum+"'>";
				if(r[0].reviewPageMaker.prev){
					str2 += "<a class='btn' onclick='getreview2("+(r[0].reviewPageMaker.startPage-1)+")'>이전</a>";
				}else{			
					str2 += "이전 ";
				}
				for(let i = r[0].reviewPageMaker.startPage; i<= r[0].reviewPageMaker.endPage; i++){
					if(r[0].reviewPageMaker.page == i){
						str2 += " "+i+" ";	
					}else{
						str2 +="<a class='btn' style='padding-top: 1px; padding-bottom: 1px;padding-left: 1px; padding-right: 1px;' onclick='getreview2("+i+")'>"+i+"</a>";
					}
				}
				
				if(r[0].reviewPageMaker.next){
					str2 += "<a class='btn' onclick='getreview2("+(r[0].reviewPageMaker.endPage+1)+")'>다음</a>";
				}else{
					str2 +="다음";	
				}
				str2 +="</td>";

				$('#pagenate').append(str2);				
									
				
			}).fail(function(r) {		
				alert('구매후기 로딩 실패했습니다.')
			
			})	
			
		}

		getreview2(1);

		function getcontent(reviewId){
			$.ajax({
				type : 'GET',
				url : '/review/api/getcontent/'+reviewId
				
			}).done(function(r) {				
				
					let str = "";
					str += "<tr class='review--content' >";
					str += "<td colspan='4' class='text-center'>"+r.content+"</td>";					
					str += "</tr>";				

					let str1 = "review--title--box"+reviewId;		
					$('#'+str1).after(str);
									
				
			}).fail(function(r) {		
				alert('구매후기 로딩 실패했습니다.')
			
			})


		} 		
	
		$('#review--save').on('click',function(event){
			
			if($('#review--title').val()==null){
			
			let str = "";
			str += "<div id='review--save--container'>";			
			str += "<div class='card-body'>";
			str += "<label>제목: </label><br/>";
			str += "<input id='review--title' type='text' class='form-control' style='height: 35px; width: 500px;'>";
			str += "<label>내용: </label><br/>";
			str += "<textarea id='review--content' rows='4' class='form-control'>내용</textarea>";
			str += "</div><br/>";
			str += "<div class='card-footer'>";
			str += "<button id='review--save--submit' type='button' class='btn btn-primary' style='float: right;''>등록</button>";
			str += "</div></div>";

			$('#review--save--box').prepend(str);	
			}else{
				return;
			}

		});

		$(document).on('click','#review--save--submit',function(){

			let data = {
				title:$('#review--title').val(),
				content:$('#review--content').val(),	
				userId:$('#userId').val(),
				productId:$('#productId').val()
			}
			

			$.ajax({
				type : 'POST',
				url : '/review/api/save',
				data:JSON.stringify(data),
				contentType:'application/json; chartset=utf-8',
				dataType : 'json'
			}).done(function(r) {				
				if (r.respCM.statusCode == 200) {
					
						let str = "";
						str += "<tr>";
						str += "<td>"+r.id+"</td>";
						str += "<td><a href='#' id='review"+r.id+"'>"+r.title+"</td>";
						str += "<td>"+r.username+"</td>";
						str += "<td>"+r.createDate+"</td>";
						str += "</tr>";	
									
									
						$('#review--list--box').prepend(str);
						$('#review--save--container').remove();			
					
				} else {		
					alert('실패')
				}
			}).fail(function(r) {		
			
			
			})	

		})
		
		function getboard(page){
			$.ajax({
				type : 'GET',
				url : '/board/api/getboard/'+productId+'/'+page
				
			}).done(function(r) {
				$('.board--title--box').remove();
				
					for(let i=0; i<r.length; i++){			
					let str = "";
					str += "<tr class='board--title--box' id='board--title--box"+r[i].id+"'>";
					str += "<td>"+r[i].id+"</td>";
					str += "<td><a href='/board/boarddetail/"+r[i].id+"'>"+r[i].title+"</a></td>";
					       				
					str += "<td>"+r[i].username+"</td>";
					str += "<td>"+r[i].createDate+"</td>";
					str += "</tr>";				
								
					$('#board--list--box').append(str);
					}
			}).fail(function(r) {		
					alert('상품문의 로딩 실패했습니다.')					
			})	


		}

		getboard(1)	
		
		
		
		
		
	


		
		
		$('#addCart').on('click',function(){	

			let productId = $('#addCart').val();
			let productCount = $('#count').val();			

			let date = new Date();
			 
			date.setDate(date.getDate() + 7);
			 
			let willCookie = "";
			    willCookie += ""+productId+"="+productCount+";";
			    willCookie += "expires=" + date.toUTCString()+";";
			    willCookie += "path=/";
			    
			 // 쿠키에 넣는다.
			document.cookie = willCookie;		
			alert('장바구니에 추가되었습니다!')					

		});	



		function niceminus(productId){
			let data = {			
				userId:$('#userId').val(),
				productId:productId				
			}					
			let niceId = 'nice'+productId;
			
			$.ajax({
				type : 'DELETE',
				url : '/nicehate/api/niceminus',
				data:JSON.stringify(data),
				contentType:'application/json; chartset=utf-8',
				dataType : 'json'
			}).done(function(r) {				
				if (r.respCM.statusCode == 200) {				
					
					let str = "";

					str +="<a onclick='nice("+productId+")' class='icon'>";
					str +="<i class='icon-thumbs-up btn'></i></a>";
					str +="<span>&nbsp;&nbsp;"+r.niceCount+"</span>";
												
					$('#'+niceId).html(str);				
					
				} else {		
					alert('좋아요! 실패')
				}
			}).fail(function(r) {		
				alert('좋아요! 실패')
			
			})			

		}

		function hateminus(productId){
			let data = {			
				userId:$('#userId').val(),
				productId:productId				
			}			
			let hateId = 'hate'+productId;
			
			$.ajax({
				type : 'DELETE',
				url : '/nicehate/api/hateminus',
				data:JSON.stringify(data),
				contentType:'application/json; chartset=utf-8',
				dataType : 'json'
			}).done(function(r) {				
				if (r.respCM.statusCode == 200) {			
				
					let str = "";
											
					str +="<a onclick='hate("+productId+")'class='icon'>";					
					str +="<i class='icon-thumbs-down btn'></i></a>";
					str +="<span>&nbsp;&nbsp;"+r.hateCount+"</span>";
												
					$('#'+hateId).html(str);				
					
				} else {		
					alert('좋아요! 실패')
				}
			}).fail(function(r) {		
				alert('좋아요! 실패')
			
			})			

		}


		
		function nice(productId){
			let data = {			
				userId:$('#userId').val(),
				productId:productId				
			}			
			let niceId = 'nice'+productId;
			
			$.ajax({
				type : 'POST',
				url : '/nicehate/api/nice',
				data:JSON.stringify(data),
				contentType:'application/json; chartset=utf-8',
				dataType : 'json'
			}).done(function(r) {					
				if (r.respCM.statusCode == 200) {				
					
					let str = "";

					str +="<a onclick='niceminus("+productId+")' class='icon'>";
					str +="<i class='icon-heart2 btn'></i></a>";
					str +="<span>&nbsp;&nbsp;"+r.niceCount+"</span>";
												
					$('#'+niceId).html(str);				
					
				} else {		
					alert('좋아요! 실패')
				}
			}).fail(function(r) {		
				alert('좋아요! 실패')
			
			})			

		}

		function hate(productId){
			let data = {			
				userId:$('#userId').val(),
				productId:productId				
			}			
			let hateId = 'hate'+productId;
			
			$.ajax({
				type : 'POST',
				url : '/nicehate/api/hate',
				data:JSON.stringify(data),
				contentType:'application/json; chartset=utf-8',
				dataType : 'json'
			}).done(function(r) {				
				if (r.respCM.statusCode == 200) {			
				
					let str = "";
											
					str +="<a onclick='hateminus("+productId+")'class='icon'>";					
					str +="<i class='icon-heart btn'></i></a>";
					str +="<span>&nbsp;&nbsp;"+r.hateCount+"</span>";
												
					$('#'+hateId).html(str);				
					
				} else {		
					alert('좋아요! 실패')
				}
			}).fail(function(r) {		
				alert('좋아요! 실패')
			
			})			

		}	

	</script>





<%@include file="../include/footer.jsp"%>
