package com.kh.code.lab.common.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaginationPolicy {

    FREE_BOARD(5, 10);

    private final int pageBarSize;
    private final int pageSize;
    
}



/*================================= [Enum] ====
	
	1. Enum 이란 무엇일까?	
		enum은 서로 **관련된 상수들**을 하나의 타입으로 정의하기 위해 사용되는
		하나의 독립된 문법 단위이다. 
		자바 내부적으로는 특별한 형태의 클래스로 처리되기 때문에 
		필드, 생성자, 메소드 등을 가질 수 있다.
		
	  * 개발자가 사용 가능한 자바의 3대 커스텀 타입 (Class, Interface, Enum)
		- class : 객체의 상태와 동작을 정의하는 타입
		- interface : 객체가 따라야 하는 기능이나 규약을 정의하는 타입
		- enum : 선택할 수 있는 값의 범위가 정해진 상수 타입
		
	2. 언제 사용할까?
		프로그램에서 사용할 수 있는 값의 종류가 명확하게 제한되어 있을 때 사용한다.

		웹사이트 설정/정책: 요일(MONDAY~SUNDAY), 월(JANUARY~DECEMBER)
		상태 값 (State): 주문 상태(ORDERED, SHIPPING, DELIVERED, CANCELLED), 게시글 공개 여부(PUBLIC, PRIVATE)
		권한 및 등급: 회원 등급(VIP, GOLD, SILVER), 관리자 권한(ADMIN, MANAGER, USER)
		도메인별 정책: 아까 보신 게시판별 페이징 정책(FREE_BOARD, NOTICE_BOARD), 결제 수단별 수수료율
		처리 결과 및 정렬 방식: SUCCESS, FAIL, LATEST, OLDEST, POPULAR
	
		단, 데이터가 자주 추가·수정·삭제되거나 운영자가 직접 관리해야 한다면 enum보다 DB에서 관리하는 것이 적절하다.
	
	3. 왜 사용할까?
		시스템의 안정성과 유지보수성을 위해서이다.
		① 컴파일 시점의 타입 검사 (오타 방지, 안정성)
		② 데이터와 로직의 한곳 관리 (응집도, 유지보수성)
		③ 가독성과 문서화 효과 (설계 문서로서의 역할)
	
	4. Enum의 사용방법 
		1) 독립된 Enum 클래스 생성 (가장 많이 사용)
			// 1. Enum 타입의 클래스 생성
			// 2. Enum 상수 선언 (Enum상수명(변수에 주입할 값들),...,Enum상수명(변수에 주입할 값들);)
			// 3. 필드부 전역변수 선언(사용될 진짜 변수, final 권장)
			// 4. All 생성자 (Enum 규칙에 따라 전역변수에 값을 주입)
			// 5. 메소드부 getter (필요한 곳에서 클래스명.Enum상수명.get변수명(); 으로 getter를 이용해 사용한다.
			//    [사용법2]
			//	  Enum타입클래스명  변수명  =  Enum타입클래스명.Enum변수명;
			//	  int a = 변수명.get변수명();
		
		2) Enum 을 모아놓는 클래스 형태
			// 1. enum들을 모아놓는 일반 class 생성
			// 2. public enum 규칙명 { Enum 클래스와 동일한 내용들 } 을 필요한 만큼 여러개 생성
			// 3. 클래스명.Enum규칙명.Enum상수명.get변수명(); 으로 사용
				
*/