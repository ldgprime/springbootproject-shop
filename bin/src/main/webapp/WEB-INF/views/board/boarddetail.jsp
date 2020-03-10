<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container" style="margin-top: 50px; margin-bottom: 50px;">
	<h2>글상세보기</h2>
	<br />
	<form action="/action_page.php">
		<input type="hidden" value="${board.id }">
		<div class="form-group">
			<label for="title">글제목:</label> <input type="text"
				class="form-control" placeholder="글제목을 입력하세요." id="id"
				readonly="readonly" value="${board.title }" />
		</div>
		<div class="form-group">
			<label for="content">글내용:</label>
			<textarea rows="15" class="form-control" readonly="readonly">${board.content }</textarea>
		</div>
		<a href="/board/boarddelete/${board.productId }/${board.id }"
			class="btn btn-danger" style="float: right;"> 글삭제 </a> <a
			href="/board/boardupdate/${board.id }" type="submit"
			class="btn btn-warning" style="float: right;"> 글수정 </a> <a
			href="/product/productdetail/${board.productId }" type="submit"
			class="btn btn-primary" style="float: right;"> 상품보기 </a>
	</form>
</div>

<div class="container">
	<div class="card">
		<div class="form-group">
			<div class="card-body">
				<input type="hidden" id="boardId" value="${board.id}" /> <input
					type="hidden" id="userId" value="${sessionScope.principal.id}" />
				<textarea class="form-control" rows="4" id="content"></textarea>
			</div>
			<br />
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

			<ul id="comment--items" class="list-group">

				<c:forEach var="comment" items="${comments}">
					<li id="comment--item--${comment.id}"
						class="list-group-item d-flex justify-content-between align-items-center">
						<div class="font-italic">${comment.content}</div>
						<div class="badge badge-light badge-pill ml-auto">작성자:${comment.username}</div>

						<c:if test="${comment.userId eq principal.id }">
							<button onclick="commentDelete(${comment.id})"
								class="badge badge-danger badge-pill">삭제</button>
						</c:if>
					</li>
				</c:forEach>
			</ul>

		</div>
	</div>
</div>
		

<script>

function getComment(){
	$.ajax({
		type : 'GET',
		url : '/comment/api/getcomment/'+${board.id}
		
	}).done(function(r) {
			console.log(r)
			for(let i=0; i<r.length; i++){			
				var comment_item = "<li id='comment--item--"+r[i].id+"' class='list-group-item d-flex justify-content-between align-items-center'>";
				comment_item += "<div class='font-italic'>"+r[i].content+"</div>";
				comment_item += "<div class='badge badge-warning badge-pill ml-auto'>작성자:"+r[i].username+"</div>";
				comment_item += "<button onclick='commentDelete("+r[i].id+")' class='badge badge-danger badge-pill'>삭제</button>";
				comment_item += "<div><p></div>";
				comment_item += "</li>";
				$('#comment--items').prepend(comment_item);
			}					
		
	}).fail(function(r) {		
		alert('댓글목록 불러오기 실패했습니다.')
	
	})	
	
}

getComment();

function makeCommentItem(r) {
	var comment_item = "<li id='comment--item--"+r.id+"' class='list-group-item d-flex justify-content-between align-items-center'>";
	comment_item += "<div class='font-italic'>"+r.content+"</div>";
	comment_item += "<div class='badge badge-warning badge-pill ml-auto'>작성자:"+r.username+"</div>";
	comment_item += "<button onclick='commentDelete("+r.id+")' class='btn-danger'>삭제</button>";
	comment_item += "<div><p></div>";
	comment_item += "</li>";
	$('#comment--items').prepend(comment_item);
	
}


$('#comment--save--submit').on('click', function() {

	var data = {
		userId : $('#userId').val(),
		boardId : $('#boardId').val(),
		content : $('#content').val()
	}
	
	$.ajax({
		type : 'POST',
		url : '/comment/api/write',
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		dataType : 'json'
	}).done(function(r) {
		if (r.status.statusCode = 200) {		
			makeCommentItem(r);			
			$('#content').val("");
		} else {
			alert('댓글쓰기 실패');
		}
	}).fail(function(r) {
		
		alert('댓글쓰기기 실패');
	});
});





function commentDelete(commentId){

	$.ajax({
		type : 'DELETE',
		url : '/comment/api/delete/'+commentId,
		dataType : 'json'
	}).done(function(r) {
		if (r.statusCode = 200) {
			alert('댓글삭제 성공');
			$('#comment--item--'+commentId).remove();
		} else {
			alert('댓글삭제 실패');
		}
	}).fail(function(r) {
		alert('댓글삭제 실패');
	});
}

</script>



<%@include file="../include/footer.jsp"%>	