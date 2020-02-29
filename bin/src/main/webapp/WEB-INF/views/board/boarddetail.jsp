<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container" style="
	margin-top: 50px;
	margin-bottom: 50px;
">
		<h2>글쓰기</h2>
		<br />
		<form action="/action_page.php">
			<div class="form-group">
				<label for="title">글제목:</label>			
				<input
					type="text"
					class="form-control"
					placeholder="글제목을 입력하세요."
					id="id"
					readonly="readonly"
				/>
			</div>		
			<div class="form-group">
				<label for="content">글내용:</label>				
				<textarea
					rows="15"
					class="form-control"
					readonly="readonly"				
				></textarea>
			</div>
			<a type="#" class="btn btn-danger" style="float: right;">
				글삭제
			</a>
			<a href="/board/boardupdate" type="submit" class="btn btn-warning" style="float: right;">
				글수정
			</a>
		</form>	
	</div>

	<div class="container">
	<div class="card">
		<div class="form-group">
			<div class="card-body">
				<textarea id="content" rows="4" class="form-control">내용</textarea>
			</div>
			<br/>
			<div class="card-footer">
				<button id="comment--save--submit" type="button" class="btn btn-primary" style="float: right;">등록</button>
			</div>
		</div>
	</div>

	<br />

			<div class="card">
				<div class="form-group">
					<div class="card-header">
						<h4 class="card-title">댓글리스트</h4>
					</div>
					<div class="comment--items card-body">
						<div class="comment--item">
							<span class="comment--content">댓글 내용</span> 
							<span id="comment--delete--submit" value="1">X</span>
						</div>
						<div class="comment--item">
							<span class="comment--content">댓글 내용</span> 
							<span id="comment--delete--submit" value="2">X</span>			
						</div>
						<div class="comment--item">
							<span class="comment--content">댓글 내용</span> 
							<span id="comment--delete--submit" value="3">X</span>				
						</div>
					</div>
				</div>
			</div>
		</div>	
		





<%@include file="../include/footer.jsp"%>	