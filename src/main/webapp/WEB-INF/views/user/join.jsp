<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container" style="margin-top: 50px; margin-bottom: 50px;">
	<h2 class="">회원가입</h2>
	<br />
	
	<form>
		<label for="username">아이디:</label> 
		<div class="form-group">
			<input type="text" class="form-control" placeholder="아이디를 입력하세요." id="username" />
		</div>
		<div class="check_font" id="id_check"></div>
		<div class="form-group">
			<label for="password">비밀번호:</label> 
			<input type="password" class="form-control" placeholder="비밀번호를 입력하세요." id="password" />
		</div>
		<div class="form-group">
			<label for="email">이메일:</label> 
			<input type="email" class="form-control" placeholder="이메일을 입력하세요." id="email" />
		</div>
		<div class="form-group">
			<label for="phone">전화번호:</label> 
			<input type="text" class="form-control" placeholder="전화번호를 입력하세요." id="phone" />
		</div>
		<div class="form-group">
			<label for="Address">주소:</label> <a href="#" class="btn btn-primary" style="float: right" type="button" onclick="goPopup();">주소 찾기</a> 
			<input type="text" class="form-control" placeholder="주소를 입력하세요." id="address" readonly="readonly"/>
		</div>
		<button id="join--submit" type="button" class="btn btn-primary p-3 px-xl-4">회원가입</button>
	</form>
</div>

<script>
	
	$('#join--submit').on('click', function(e) {
		e.preventDefault();
		var data = {
			username : $('#username').val(),
			password : $('#password').val(),
			email : $('#email').val(),
			phone : $('#phone').val(),
			address : $('#address').val()
		};

		$.ajax({
			type : 'POST',
			url : '/user/join',
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json'
		}).done(function(r) {
			console.log(r);
			if (r.statusCode == 200) {

				console.log(r);
				alert('회원가입 성공');
				location.href = '/user/login';
			} else {
				if (r.msg == '아이디중복') {
					console.log(r);
					alert('아이디가 중복되었습니다.');
				} else {
					console.log(r);
					alert('회원가입 실패');
				}
			}
		}).fail(function(r) {
			var message = JSON.parse(r.responseText);
			console.log((message));
			alert('서버 오류');
		});
	});

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
</script>




<%@include file="../include/footer.jsp"%>
