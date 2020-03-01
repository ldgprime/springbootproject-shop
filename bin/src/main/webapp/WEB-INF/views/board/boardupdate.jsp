<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>


<div class="container" style="
	margin-top: 50px;
	margin-bottom: 50px;
">
		<h2>글수정</h2>
		<br />			
			<input type="hidden" id="id" value="${board.id }" >
			<div class="form-group">
				<label for="title">글제목:</label>			
				<input
					type="text"
					class="form-control"
					placeholder="글제목을 입력하세요."
					id="title"
					value="${board.title }"		
				/>
			</div>		
			<div class="form-group">
				<label for="content">글내용:</label>				
				<textarea
					rows="15"
					class="form-control"
					id="content"
				>${board.content }</textarea>
			</div>
			<button id="update--submit" type="button" class="btn btn-primary" style="float: right;">
				글수정
			</button>

	</div>		

<script>
$('#update--submit').on('click', function(e) {
	e.preventDefault();
	var data = {		
		id : $('#id').val(),		
		title : $('#title').val(),
		content : $('#content').val()
	};
	console.log(id)

	$.ajax({
		type : 'PUT',
		url : '/board/updateproc',
		data : JSON.stringify(data),
		contentType : 'application/json; charset=utf-8',
		dataType : 'json'
	}).done(function(r) {		
		if(r.statusCode == 200){
			alert('글 수정완료!');
			location.href ='/board/boarddetail/'+data.id;
		}				
		
	}).fail(function(r) {		
		alert('서버 오류');
		
	});
	
});




</script>




<%@include file="../include/footer.jsp"%>	