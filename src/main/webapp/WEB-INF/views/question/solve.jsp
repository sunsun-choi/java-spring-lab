<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">
<title>정보처리기사 문제 풀이</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/question/solve.css">
</head>
<body>

	<main class="question-main">
		<section class="question-panel">
			<div class="question-header">
				<p id="subjectText" class="subject-text"></p>
				<h1 id="keywordText">문제를 불러오는 중입니다.</h1>
			</div>
			
			<form id="answerForm" class="answer-form">
				<input type="text" id="inputAnswer" autocomplete="off" placeholder="정답을 입력하세요">
				<div id="wrongAnswerBox" class="wrong-answer-box"></div>
				
				<div class="button-row">
					<button type="submit" id="submitBtn" class="primary-btn">제출</button>
					<button type="button" id="showAnswerBtn" class="secondary-btn">정답 확인하기</button>
					<button type="button" id="nextBtn" class="secondary-btn">다음 문제</button>
				</div>
			</form>
			
			<p id="resultMessage" class="result-message"></p>
			<div id="answerBox" class="answer-box"></div>
		</section>
	</main>

	<script>
		window.questionConfig = {
			cp: '${pageContext.request.contextPath}'
		};
	</script>
	<script src="${pageContext.request.contextPath}/js/question/solve.js"></script>
</body>
</html>
