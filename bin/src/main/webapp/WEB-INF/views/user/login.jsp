<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container" style="margin-top: 50px; margin-bottom: 50px;">
	<h2 class="">로그인</h2>
	<br />
	<form action="/user/login" method="POST">
		<div class="form-group">
			<label for="username">아이디:</label> 
			<input type="text" class="form-control" placeholder="아이디를 입력해주세요." name="username" />
		</div>
		<div class="form-group">
			<label for="password">비밀번호:</label> 
			<input type="password" class="form-control" placeholder="비밀번호를 입력해주세요." name="password"  />
		</div>

		<div class="form-group form-check">
			<label class="form-check-label"> <c:choose>
					<c:when test="${not empty cookie.usernameCookie.value}">
						<input class="form-check-input" type="checkbox" name="rememberMe" checked /> 아이디 저장
					</c:when>
					<c:otherwise>
						<input class="form-check-input" type="checkbox" name="rememberMe" /> 아이디 저장
					</c:otherwise>
				</c:choose>
			</label>
		</div>
		<button type="submit" class="btn btn-primary p-3 px-xl-4" id="login--submit">로그인</button>
	</form>
</div>

<script>
	/**
	 * 
	 */
/* 
	$('#login--submit').on('click', function(e) {
		// e.preventDefault();
		var data = {
			username : $('#username').val(),
			password : $('#password').val()
		};
		$.ajax({
			type : 'POST',
			url : '/user/login',
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json'
		}).done(function(r) {
			alert("로그인 성공");
			location.href = '/';
		}).fail(function(r) {
			alert("로그인 실패");
		});
	}); */

/* 	//엔터키 치면 바로 로그인 되게
 	$("#password").keydown(function(key) {
		if (key.keyCode == 13) {// 키가 13이면 실행 (엔터는 13)
			$('#login--submit').click();
		}
	});  */
	
</script>






<%@include file="../include/footer.jsp"%>
