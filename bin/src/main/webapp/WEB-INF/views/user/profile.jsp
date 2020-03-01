<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>




<div class="container" style="margin-top: 50px; margin-bottom: 50px;">
	<h2 class="">마이페이지</h2>
	<br />	
		<input type="hidden" value="${sessionScope.principal.id}" id="id"> 
		<div class="form-group">			
			<label for="id">아이디:</label> 
			<input type="text"	class="form-control" id="username"
				readonly="readonly" value="${sessionScope.principal.username }"  />
		</div>
		<div class="form-group">
			<label for="password">비밀번호:</label> <input type="password"
				class="form-control"  id="password" />
		</div>
		<div class="form-group">
			<label for="email">이메일:</label> <input type="email"
				class="form-control" value="${sessionScope.principal.email}" id="email" />
		</div>
			<div class="form-group">
			<label for="phone">전화번호:</label> <input type="text"
				class="form-control" value="${sessionScope.principal.phone}" id="phone" />
		</div>
		<div class="form-group">
			<label for="Address">주소:</label> 
			<a class="btn btn-primary" style="float: right" onclick="goPopup();">주소 찾기</a> 
			<input type="text" class="form-control" value="${sessionScope.principal.address}" id="address" readonly="readonly" />
		</div>
		<button id="profile--submit" type="button" class="btn btn-primary p-3 px-xl-4">
			회원수정</button>

</div>


<script>
	function goPopup() {
		// 주소검색을 수행할 팝업 페이지를 호출합니다.
		// 호출된 페이지(jusopopup.jsp)에서 실제
		// 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
		var pop = window.open("/user/jusoPopup", "pop",
				"width=570,height=420, scrollbars=yes, resizable=yes");

		// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제
		// 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
		// var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes,
		// resizable=yes");
	}

	function jusoCallBack(roadFullAddr) {
		$('#address').val(roadFullAddr);
	}

	$('#profile--submit').on('click', function(e) {
		e.preventDefault();
		var data = {		
			id : $('#id').val(),	
			password : $('#password').val(),
			email : $('#email').val(),
			phone : $('#phone').val(),
			address : $('#address').val()
		};
	

		$.ajax({
			type : 'PUT',
			url : '/user/profileproc',
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json'
		}).done(function(r) {		
			if(r.statusCode == 200){
				alert('회원정보 수정완료! 다시 로그인해주세요');
				location.href ='/user/login';
			}				
			
		}).fail(function(r) {		
			alert('서버 오류');
			
		});
		
	});
	


	
</script>






<%@include file="../include/footer.jsp"%>
