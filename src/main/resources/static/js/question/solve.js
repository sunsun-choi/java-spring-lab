(function () {
	const cp = window.questionConfig.cp;
	const state = {
		questionNo: null
	};
	
	const subjectText = document.getElementById('subjectText');
	const keywordText = document.getElementById('keywordText');
	const answerForm = document.getElementById('answerForm');
	const inputAnswer = document.getElementById('inputAnswer');
	const submitBtn = document.getElementById('submitBtn');
	const showAnswerBtn = document.getElementById('showAnswerBtn');
	const nextBtn = document.getElementById('nextBtn');
	const resultMessage = document.getElementById('resultMessage');
	const wrongAnswerBox = document.getElementById('wrongAnswerBox');
	const answerBox = document.getElementById('answerBox');
	
	document.addEventListener('DOMContentLoaded', function () {
		loadQuestion();
	});
	
	answerForm.addEventListener('submit', function (event) {
		event.preventDefault();
		submitAnswer();
	});
	
	showAnswerBtn.addEventListener('click', function () {
		showAnswer();
	});
	
	nextBtn.addEventListener('click', function () {
		loadQuestion(state.questionNo);
	});
	
	function loadQuestion(currentQuestionNo) {
		resetSolveArea();
		
		let url = cp + '/question/random';
		if(currentQuestionNo) {
			url += '?currentQuestionNo=' + encodeURIComponent(currentQuestionNo);
		}
		
		fetch(url)
			.then(function (response) {
				return response.json();
			})
			.then(function (data) {
				if(!data.success) {
					showResult(data.message || '문제를 불러오지 못했습니다.', false);
					keywordText.textContent = '문제가 없습니다.';
					return;
				}
				
				state.questionNo = data.questionNo;
				subjectText.textContent = data.subject || '정보처리기사 실기';
				keywordText.textContent = data.keyword;
				inputAnswer.focus();
			})
			.catch(function () {
				showResult('문제를 불러오는 중 오류가 발생했습니다.', false);
			});
	}
	
	function submitAnswer() {
		const value = inputAnswer.value.trim();
		
		if(value.length === 0) {
			showResult('정답을 입력해주세요.', false);
			inputAnswer.focus();
			return;
		}
		
		fetch(cp + '/question/submit', {
			method: 'POST',
			headers: createJsonHeaders(),
			body: JSON.stringify({
				questionNo: state.questionNo,
				inputAnswer: value
			})
		})
			.then(function (response) {
				return response.json();
			})
			.then(function (data) {
				if(!data.success) {
					showResult(data.message || '채점 중 오류가 발생했습니다.', false);
					return;
				}
				
				showResult(data.resultMessage, data.correct);
				renderWrongAnswers(data.wrongAnswers);
				nextBtn.style.display = 'inline-flex';
				
				if(data.correct) {
					inputAnswer.disabled = true;
					submitBtn.disabled = true;
					showAnswerBtn.style.display = 'none';
				} else {
					inputAnswer.value = '';
					inputAnswer.disabled = false;
					submitBtn.disabled = false;
					showAnswerBtn.style.display = 'inline-flex';
					inputAnswer.focus();
				}
			})
			.catch(function () {
				showResult('채점 중 오류가 발생했습니다.', false);
			});
	}
	
	function showAnswer() {
		if(!state.questionNo) {
			return;
		}
		
		fetch(cp + '/question/answer?questionNo=' + encodeURIComponent(state.questionNo))
			.then(function (response) {
				return response.json();
			})
			.then(function (data) {
				if(!data.success) {
					answerBox.textContent = data.message || '정답을 조회하지 못했습니다.';
					answerBox.style.display = 'block';
					return;
				}
				
				answerBox.innerHTML = '<strong>정답</strong><span>' + escapeHtml(data.answers.join(', ')) + '</span>';
				answerBox.style.display = 'block';
				nextBtn.style.display = 'inline-flex';
			})
			.catch(function () {
				answerBox.textContent = '정답을 조회하는 중 오류가 발생했습니다.';
				answerBox.style.display = 'block';
			});
	}
	
	function resetSolveArea() {
		inputAnswer.value = '';
		inputAnswer.disabled = false;
		submitBtn.disabled = false;
		showAnswerBtn.style.display = 'none';
		nextBtn.style.display = 'none';
		resultMessage.textContent = '';
		resultMessage.className = 'result-message';
		wrongAnswerBox.innerHTML = '';
		wrongAnswerBox.style.display = 'none';
		answerBox.innerHTML = '';
		answerBox.style.display = 'none';
		subjectText.textContent = '';
		keywordText.textContent = '문제를 불러오는 중입니다.';
	}
	
	function showResult(message, correct) {
		resultMessage.textContent = message;
		resultMessage.className = correct ? 'result-message result-message--correct' : 'result-message result-message--wrong';
	}
	
	function renderWrongAnswers(wrongAnswers) {
		if(!wrongAnswers || wrongAnswers.length === 0) {
			wrongAnswerBox.innerHTML = '';
			wrongAnswerBox.style.display = 'none';
			return;
		}
		
		wrongAnswerBox.innerHTML = '<span>이전 오답</span> ' + wrongAnswers.map(escapeHtml).join(', ');
		wrongAnswerBox.style.display = 'block';
	}
	
	function createJsonHeaders() {
		const headers = {
			'Content-Type': 'application/json'
		};
		const csrfToken = document.querySelector('meta[name="_csrf"]').content;
		const csrfHeader = document.querySelector('meta[name="_csrf_header"]').content;
		
		if(csrfToken && csrfHeader) {
			headers[csrfHeader] = csrfToken;
		}
		
		return headers;
	}
	
	function escapeHtml(value) {
		return String(value)
			.replaceAll('&', '&amp;')
			.replaceAll('<', '&lt;')
			.replaceAll('>', '&gt;')
			.replaceAll('"', '&quot;')
			.replaceAll("'", '&#039;');
	}
})();
