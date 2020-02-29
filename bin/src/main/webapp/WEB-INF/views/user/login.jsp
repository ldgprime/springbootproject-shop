<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container" style="
	margin-top: 50px;
	margin-bottom: 50px;
">
		<h2 class="">로그인</h2>
		<br />
		<form action="/action_page.php">
			<div class="form-group">
				<label for="email">아이디:</label>
				<input
					type="email"
					class="form-control"
					placeholder="아이디를 입력해주세요."
					id="email"
				/>
			</div>
			<div class="form-group">
				<label for="pwd">비밀번호:</label>
				<input
					type="password"
					class="form-control"
					placeholder="비밀번호를 입력해주세요."
					id="pwd"
				/>
			</div>
			<div class="form-group form-check">
				<label class="form-check-label">
					<input class="form-check-input" type="checkbox" /> 아이디 저장
				</label>
			</div>
			<button type="submit" class="btn btn-primary p-3 px-xl-4">
				로그인
			</button>
		</form>
	</div>
		





<%@include file="../include/footer.jsp"%>	