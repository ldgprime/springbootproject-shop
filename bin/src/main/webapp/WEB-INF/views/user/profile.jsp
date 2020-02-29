<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container" style="
	margin-top: 50px;
	margin-bottom: 50px;">
		<h2 class="">회원가입</h2>
		<br />
		<form action="/action_page.php">
			<div class="form-group">
				<label for="id">아이디:</label>
				<a href="#" class="btn btn-primary" style="float:right">중복확인</a>
				<input
					type="email"
					class="form-control"
					placeholder="아이디를 입력하세요."
					id="id"
				/>
			</div>
			<div class="form-group">
				<label for="password">비밀번호:</label>
				<input
					type="password"
					class="form-control"
					placeholder="비밀번호를 입력하세요."
					id="password"
				/>
			</div>
			<div class="form-group">
				<label for="email">이메일:</label>

				<input
					type="email"
					class="form-control"
					placeholder="이메일을 입력하세요."
					id="email"
				/>
			</div>
			<div class="form-group">
				<label for="Address">주소:</label>
				<a href="#" class="btn btn-primary" style="float:right">주소 찾기</a>
				<input
					type="Address"
					class="form-control"
					placeholder=""
					id="Address"
				/>
			</div>
			<button type="submit" class="btn btn-primary p-3 px-xl-4">
				회원가입
			</button>
		</form>
	</div>

				

		





<%@include file="../include/footer.jsp"%>	