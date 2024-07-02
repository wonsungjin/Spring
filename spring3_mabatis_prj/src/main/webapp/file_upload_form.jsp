<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

파일업로드 테스트 <br>
 - 복수파일 :  input type="file" multiple="multiple" <br> 
 - 파일업로드 : form enctype="multipart/form-data"
<hr>

<!-- 단일 파일 업로드 -->
<form action="/file_upload" method="post" enctype="multipart/form-data">
	파일 선택 : <input type="file" name="ufile">
	<input type="submit" value="전송">
</form>

<br><hr><br>

<!-- 멀티파일 업로드 -->
<form action="/file_upload2" method="post" enctype="multipart/form-data">
	파일 선택 : <input type="file" name="ufiles" multiple="multiple" > 
	<input type="submit" value="전송">
</form>
	
</body>
</html>