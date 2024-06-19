<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" name= "search_str" id="search_str">
<input type="button" name= "searchBtn" value="검색"><br>
<div id="searchResDiv"></div><br>


<c:forEach items="${KEY_BOARDLIST}" var="bvo">
	${bvo.seq} , 
	<a href="${pageContext.request.contextPath}/board_detail?seq=${bvo.seq}">${bvo.title}</a>, 
	${bvo.regdate} <br> 
</c:forEach>
<p><br>
<a href="${pageContext.request.contextPath}/lec05_board/board_insert.jsp">글쓰기</a>


<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
    $(function() {
        $("#search_str").on('input', function() { // input은 타이핑을 할 때마다 REST로 받아옴
            // 검색어 입력 관련 내용 자동완성 ::: REST
            if($("#search_str").val()!=""){
            $.ajax({
                method: "POST",
                url: "${pageContext.request.contextPath}/board_search",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                data: "search_str=" + $("#search_str").val(),
                error: function(myval) { console.log("에러:" + myval); },
                success: function(myval) {
                    console.log("성공:" + myval);

                    var htmlStr = "<ul>";
                    $.map(myval, function(MYval, MYidx) {
                        htmlStr += "<li>" + MYval.title + "</li>";
                    });
                    htmlStr += "</ul>";
                    $("#searchResDiv").empty();
                    $("#searchResDiv").html(htmlStr);
                }
            });
            }
            else 
	        {
	            	$("#searchResDiv").empty();
	        }
        });
    });
</script>



</body>
</html>