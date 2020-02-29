/**
 * 
 */

$('#comment--save--submit').on('click', function() {

	var data = {
		userId : $('#userId').val(),
		boardId : $('#boardId').val(),
		content : $('#content').val()
	}
	console.log(data);
	$.ajax({
		type : 'POST',
		url : '/comment/write',
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		dataType : 'json'
	}).done(function(r) {
		if (r.status.statusCode = 200) {
			alert('댓글쓰기 성공');
			makeCommentItem(r);
			$('#content').val("");
		} else {
			alert('댓글쓰기 실패');
		}
	}).fail(function(r) {
		console.log(r);
		alert('댓글쓰기기 실패');
	});
});

function makeCommentItem(r) {
	var comment_item = `<li id="comment--item--${r.id}" class="list-group-item d-flex justify-content-between align-items-center">`;
	comment_item += `<div class="font-italic">${r.content}</div>`;
	comment_item += `<div class="badge badge-warning badge-pill ml-auto">작성자:${r.username}</div>`;
	comment_item += `<button onclick="commentDelete(${r.id})" class="badge badge-danger badge-pill">삭제</button>`;
	comment_item += `<div><p></div>`;
	comment_item += `</li>`;
	$('#comment--items').prepend(comment_item);
}

function commentDelete(commentId){
	console.log(commentId);
	$.ajax({
		type : 'DELETE',
		url : '/comment/delete/'+commentId,
		dataType : 'json'
	}).done(function(r) {
		if (r.statusCode = 200) {
			alert('댓글삭제 성공');
			$('#comment--item--'+commentId).remove();
		} else {
			alert('댓글삭제 실패');
		}
	}).fail(function(r) {
		alert('댓글삭제제 실패');
	});
}