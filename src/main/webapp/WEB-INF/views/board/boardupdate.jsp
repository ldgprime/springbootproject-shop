<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>


<div class="container" style="
	margin-top: 50px;
	margin-bottom: 50px;
">
		<h2>글수정</h2>
		<br />
		<form action="/action_page.php">
			<div class="form-group">
				<label for="title">글제목:</label>			
				<input
					type="text"
					class="form-control"
					placeholder="글제목을 입력하세요."
					id="id"
				/>
			</div>		
			<div class="form-group">
				<label for="content">글내용:</label>				
				<textarea
					rows="15"
					class="form-control"
				
				
				></textarea>
			</div>
			<button type="submit" class="btn btn-primary" style="float: right;">
				글수정
			</button>
		</form>	
	</div>		





<%@include file="../include/footer.jsp"%>	