<%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Tables - SB Admin</title>
    </head>
<body>
<!-- --------------------------------------- 게시물 상세보기 ------------------------------- -->

<form id="boardForm" >
<input type="hidden" name="seq" value="${KEY_BOARDVO.seq}">
<input type="hidden" name="regid" value="${KEY_BOARDVO.regid}">

<table border="1" width="100%">
<tr>
   <th width="20%">글번호</th>
   <td width="80%">${KEY_BOARDVO.seq}</td>
</tr>
<tr>
      <th>작성자</th>
      <td>${KEY_BOARDVO.regid}</td>
</tr>
<tr>
      <th>작성일</th>
      <td><input type="text" name="regdate" value="${KEY_BOARDVO.regdate}" readonly></td>
</tr>
<tr>
      <th>제목</th>
      <td><input type="text" name="title" size=60  value="${KEY_BOARDVO.title}"></td>
</tr>
<tr>
      <th>내용</th>
      <td><textarea name="contents" cols="80" rows="6">${KEY_BOARDVO.contents}</textarea></td>
</tr>
<tr>
	<td colspan=2 align="center">
		<input type="button" id="uptButton" value="수정">
		<input type="button" id="delButton"  value="삭제">
		<input type="button" id="listButton" value="목록">
	</td>
</table>
</form>

<br><br>

<!-- --------------------------------------- 댓글목록 ------------------------------- -->
<br>
<div id="replyListDiv">
	<table width=100% border=1>
		<tr><td></td></tr>
	</table>
</div>


<!-- --------------------------------------- 댓글등록 ------------------------------- -->
<br>
<form method="post" id="replyInsertForm">
<input type=hidden name=seq id="seq" value="${KEY_BOARDVO.seq}">
<table width=100% border=1>
<tr>
	<td>
		<input type="text" size=100 name="reply" id="reply">
		<input type="button"  id="replyInsertBtn" value="댓글등록">
	</td>
</tr>
</table>
</form>


<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script>
		$(function() {
			function makeTable() {
				
				//화면 준비되면 댓글목록 바로 가져오기 :::  REST
				$.ajax({
					method      : "POST",
			        url         : "${pageContext.request.contextPath}/reply_list_rest",
			        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			        data 		: "seq=${KEY_BOARDVO.seq}",   
			  		error 	    : function(myval){ console.log("에러:" + myval);   },
			  		success     : function(myval){ 
			  										console.log("성공:" + myval);  //ResponseEntity<>(rlist, HttpStatus.OK)   
			  										
			  										var htmlStr = "<table border=1 width=50%>";
			  										$.map( myval, function( MYval, MYidx ) {
			  											htmlStr += "<tr><td><font color='red'><input type='button' id='replyDeleteBtn' value='[X]' data-rseq='" + MYval.rseq + "' data-seq='" + MYval.seq + "'></font>" + MYval.reply + "</td></tr>";

			  											//console.log(MYval["title"] + "," + MYval["regid"] + "," + MYidx);
			  										});
			  										htmlStr += "</table>";
			  										$("#replyListDiv").empty();
			  										$("#replyListDiv").html(htmlStr);
			  										
			  									}
				});
			}
			
			
			//화면이 실행되자마자 댓글목록 가져오기 :: REST
			makeTable();
			
			
			//댓글 입력 :: REST
			$("#replyInsertBtn").click(  function(){
				var formData = $("#replyInsertForm").serialize();
				$.ajax({
					method      : "POST",
			        url         : "${pageContext.request.contextPath}/reply_insert_rest",
			        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			        //data 		: "seq=" +$("#seq").val()+"&reply=" + $("#reply").val(),   
			  		data 		: formData,
			        error 	    : function(myval){ console.log("에러:" + myval);   },
			  		success     : function(myval){ 
			  										console.log("성공:" + myval);  //msg = "입력성공"   
			  										makeTable();
			  									}
				});
			});
			//댓글 삭제 :: REST
					$(document).on("click", "#replyDeleteBtn", function() {
						var rseq = $(this).data("rseq");
					    var seq = $(this).data("seq");
					    var formData = { rseq: rseq, seq: seq }; // formData 정의
					    
		    $.ajax({
		        method: "POST",
		        url: "${pageContext.request.contextPath}/reply_delete_rest",
		        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		        data: formData,
		        error: function(myval) {
		            console.log("에러:" + myval);
		        },
		        success: function(myval) {
		            console.log("삭제성공:" + myval);
		            makeTable();
		        }
		    });
});
			$("#uptButton").click(  function(){
				alert("수정");
				$("#boardForm").attr("method","post");
				$("#boardForm").attr("action","${pageContext.request.contextPath}/board_update");
				$("#boardForm").submit();
				return true;
			});
			$("#delButton").click(  function(){
				alert("삭제");
				$("#boardForm").attr("method","post");
				$("#boardForm").attr("action","${pageContext.request.contextPath}/board_delete");
				$("#boardForm").submit();
				return true;
			});
			$("#listButton").click(  function(){
				location.href = "${pageContext.request.contextPath}/board_list";
			});            
			
			//------------------------------------------------------------
		});
		
	</script>
</body>
</html>


