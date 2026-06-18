# Java Spring Lab

Java와 Spring 기반 웹 개발을 학습하고, 직접 구현한 내용을 기록하는 개인 학습 프로젝트입니다.

기능 구현뿐 아니라 데이터 흐름과 계층별 책임을 이해하고, 코드와 데이터베이스 구조를 개선하는 것을 목표로 합니다.

---

## 기술 스택

### Frontend

* HTML5
* CSS3
* JavaScript ES6
* jQuery 3.7.1
* Bootstrap 4.6.2

### Backend

* Java 21
* Spring Boot 3.5.15
* MyBatis 3.5.19
* JSP 3.1
* Oracle Database 11g XE

### Tools

* Spring Tools Suite
* Visual Studio Code
* Oracle SQL Developer
* Git
* GitHub
* SourceGit
* ERD Cloud
* Figma

---

## 실행 환경

* Server Port: `7777`
* Context Path: `/code-lab`
* View: JSP
* Database: Oracle XE

로컬 환경 설정은 별도의 설정 파일에서 관리합니다.

properties
spring.profiles.active=local

민감한 정보가 포함된 `application-local.properties`는 Git에 포함하지 않습니다.

---

## 프로젝트 구조

java-spring-lab/
├─ src/
├─ sql/
│  ├─ schema/
│  ├─ migration/
│  ├─ data/
│  ├─ practice/
│  └─ README.md
└─ README.md

데이터베이스 구조와 관리 규칙은 [Database README](sql/README.md)에서 확인할 수 있습니다.

---

## 커밋 규칙
작업이 완성되지 않았더라도, 하루 동안 의미 있는 변경사항이 있다면 커밋한다.
커밋은 완성본만 저장하는 것이 아니라 작업 과정과 진행 상태를 기록하는 용도로도 사용한다.

### 커밋 기준
다음과 같은 경우에는 작업이 미완성이어도 커밋할 수 있다.

* 테이블 구조 초안을 작성한 경우
* 일부 테이블의 DDL만 작성한 경우
* README나 문서 구조를 정리한 경우
* 기능 구현의 일부를 작성한 경우
* 오류 해결 과정이나 실험 내용을 기록한 경우
* 다음 작업 위치가 명확한 상태로 중단한 경우

### 커밋 메시지 규칙
커밋 메시지만 보고도 무엇을 변경했는지 알 수 있도록 작성한다.

형식: ` 타입: 변경 내용 `

예시:
        docs: SQL 학습 구조와 진행 방식 정리
        db: 회원 및 게시판 테이블 DDL 초안 작성
        feat: 닉네임 마스킹 로직 추가
        fix: 게시글 조회 쿼리 조건 오류 수정
        refactor: 댓글 조회 쿼리 구조 개선
        test: 게시판 샘플 데이터 추가
        wip: BOARD_REPLY DDL 작성 중

### 커밋 타입

* `docs`: README, 주석, 문서 변경
* `db`: 테이블, 제약조건, migration 등 DB 변경
* `feat`: 새로운 기능 추가
* `fix`: 오류 수정
* `refactor`: 기능 변화 없는 구조 개선
* `test`: 테스트 코드나 테스트 데이터 추가
* `chore`: 설정, 폴더 정리, 기타 작업
* `wip`: 아직 완료되지 않은 작업 기록

### 피해야 할 커밋 메시지
다음처럼 변경 내용을 알 수 없는 메시지는 사용하지 않는다.

    수정
    대충함
    하다맘
    아직안됨
    오늘한거

### 작업 중 커밋
작업이 끝나지 않은 상태라면 `wip`를 사용해 진행 중임을 표시한다.

wip: BOARD 테이블 제약조건 작성 중
wip: 닉네임 마스킹 로직 구현 중

가능하면 깨진 상태의 코드는 개인 작업 브랜치에 커밋한다.

예시:
        feature/db-board
        feature/nickname-masking

### 하루 마무리 기준
하루 작업이 끝났을 때 변경사항이 있다면 다음을 확인한다.

1. 변경한 파일을 확인한다.
2. 비밀번호나 개인정보가 포함되지 않았는지 확인한다.
3. 커밋 메시지에 작업 내용을 명확히 작성한다.
4. 미완성 작업이라면 `wip`를 사용한다.
5. 원격 저장소에 push한다.

---

## 학습 기록

### 2026-06-18

#### 작업

* 회원, 카테고리, 게시글, 댓글 테이블 설계
* 테이블별 시퀀스와 제약조건 작성
* migration 파일과 전체 스키마 파일 분리
* 게시글 본문을 `CLOB` 타입으로 구성

#### 문제

ERD와 컬럼 명세 없이 DDL부터 작성하면서 컬럼명, 제약조건, 외래키 필수값 등의 누락과 불일치가 발생했습니다.

#### 해결

다음 순서로 테이블 정의를 검토했습니다.

컬럼
→ PK
→ UNIQUE
→ FK
→ NOT NULL
→ DEFAULT
→ CHECK
→ 생성 및 삭제 순서

#### 회고

ERD와 테이블 명세가 단순한 제출 문서가 아니라, DDL 작성 과정의 누락을 방지하는 검증 도구라는 점을 체감했습니다.

다음부터는 엔티티 관계와 컬럼별 제약조건을 먼저 정리한 뒤 DDL을 작성할 예정입니다.

---

## 다음 작업

* 게시글 목록 조회 쿼리 작성
* 조회 결과 화면 출력
* 닉네임 마스킹 처리



