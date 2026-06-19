<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <div>
        <div onclick="go('/board/list');">게시판 바로가기</div>
    </div>


    <script>
        const cp = '${pageContext.request.contextPath}';

        function go(path){
            location.href = cp + path;
        }
    </script>
</body>
</html>