# SQL 관리 가이드

이 디렉터리는 데이터베이스 구조, 변경 이력, 샘플 데이터, SQL 연습 기록을 관리한다.

## 학습 진행 방식
1. 데이터베이스 구조를 직접 설계한다.
2. 설계 검토를 통해 관계와 제약조건을 점검한다.
3. 설계를 기준으로 DDL을 직접 작성한다.
4. SQL 코드 리뷰 후 오류와 개선점을 수정한다.
5. 직접 실행하고 발생한 오류를 기록한다.

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


## 디렉터리 구조

sql/
├─ README.md
├─ schema/
│  └─ current_schema.sql
├─ migration/
│  ├─ V001__create_member.sql
│  ├─ V002__create_board_category.sql
│  ├─ V003__create_board.sql
│  └─ V004__create_board_reply.sql
├─ data/
│  └─ sample_data.sql
└─ practice/
   └─ YYMMDD_topic_queries.sql

## 폴더 역할

### `schema/`

현재 기준의 전체 데이터베이스 구조를 관리한다.

* `current_schema.sql`은 빈 데이터베이스를 처음부터 구성할 수 있는 최신 전체 DDL이다.
* 테이블, 제약조건, 시퀀스, 인덱스의 현재 상태를 반영한다.
* 구조가 변경되면 migration 파일을 추가한 뒤 함께 갱신한다.

### `migration/`

데이터베이스 구조와 데이터의 변경 이력을 관리한다.

* 파일명 형식: `V버전__변경내용.sql`
* 예시: `V005__add_user_nickname.sql`
* 버전은 실행 순서를 의미한다.
* 이미 실행하거나 Git에 공유한 migration 파일은 수정하지 않는다.
* 새로운 변경은 다음 번호의 파일로 추가한다.

migration 파일에는 다음 SQL이 들어갈 수 있다.

* `CREATE TABLE`
* `ALTER TABLE`
* `DROP`
* `CREATE INDEX`
* 제약조건 추가·변경·삭제
* 기존 데이터 보정용 `UPDATE`
* 필수 기준 데이터용 `INSERT`

### `data/`

개발과 테스트에 사용하는 샘플 데이터를 관리한다.

* 실제 개인정보를 넣지 않는다.
* 비밀번호, API 키, 운영 계정 등 비밀정보를 넣지 않는다.
* 반복 실행을 고려해 중복 데이터가 생기지 않도록 주의한다.

### `practice/`

조회, 조인, 서브쿼리, 페이징 등 SQL 연습 기록을 관리한다.

파일명 예시:

260617_board_queries.sql
260618_reply_paging_queries.sql

## Migration 작성 규칙

### 1. 변경 하나당 목적이 분명한 파일을 만든다

V005__add_user_nickname.sql
V006__increase_nickname_length.sql
V007__add_nickname_unique_constraint.sql

### 2. 기존 migration 파일을 수정하지 않는다

이미 적용된 DB는 기존 파일을 수정해도 자동으로 바뀌지 않는다.
구조를 다시 변경하려면 새 migration 파일에 `ALTER TABLE` 등을 작성한다.

### 3. 파일명은 내용을 알아볼 수 있게 작성한다

좋은 예:

V008__add_view_count_to_board.sql
V009__create_board_file.sql

피할 예:

V008__fix.sql
V009__change.sql

### 4. 구조 변경 후 `current_schema.sql`도 갱신한다

migration은 변경 이력이고, `current_schema.sql`은 현재 최종 상태다.
둘의 역할이 다르므로 함께 관리한다.

## 실행 방법

### 빈 데이터베이스를 처음 구성할 때

1. `schema/current_schema.sql` 실행
2. 필요한 경우 `data/sample_data.sql` 실행

### 기존 데이터베이스를 변경할 때

1. 마지막으로 적용한 migration 버전을 확인한다.
2. 이후 버전 파일을 번호 순서대로 실행한다.
3. 실행 결과와 데이터 상태를 확인한다.

## 현재 핵심 구조

현재 전체 구조의 기준 파일:

schema/current_schema.sql

현재 ERD가 있다면 아래 경로에 보관한다.

docs/erd/

README에는 모든 테이블을 중복해서 나열하지 않고, 핵심 관계만 요약한다.

* 회원은 게시글과 댓글을 작성한다.
* 게시글은 하나의 카테고리에 속한다.
* 게시글은 여러 댓글을 가질 수 있다.

## 네이밍 규칙

* 테이블명: 대문자 스네이크 케이스
* 컬럼명: 대문자 스네이크 케이스
* 기본키: `테이블명_NO`
* 외래키: 참조 대상의 기본키 이름과 동일하게 작성
* 날짜 컬럼: `CREATED_AT`, `UPDATED_AT`
* 상태 컬럼: `STATUS`

예시:

MEMBER.USER_NO
BOARD.BOARD_NO
BOARD.USER_NO
BOARD_REPLY.BOARD_NO

제약조건명과 식별자 축약 규칙은
Database Convention을 참고한다.

## 상태값 관리

상태값의 의미는 프로젝트에서 일관되게 사용한다.

예시:

Y / N
ACTIVE / INACTIVE
PUBLIC / PRIVATE

새 상태값을 추가할 때는 코드, SQL, 문서의 정의를 함께 확인한다.

## 삭제 정책

테이블별로 삭제 방식을 결정한다.

* 물리 삭제: 실제 행을 `DELETE`
* 논리 삭제: `STATUS`만 변경하고 행은 유지

게시글과 댓글처럼 복구나 이력 확인이 필요할 수 있는 데이터는 논리 삭제를 우선 검토한다.

## 주의사항

* 실제 비밀번호와 DB 접속정보를 Git에 커밋하지 않는다.
* 운영 데이터나 개인정보를 샘플 데이터로 사용하지 않는다.
* 외래키 관계와 삭제 순서를 확인한다.
* 구조 변경 전 기존 데이터에 미치는 영향을 확인한다.
* migration 실행 전후로 필요한 경우 백업한다.
* migration 파일과 실제 DB 상태가 다르지 않도록 관리한다.

## 추후 확장

Spring Boot 프로젝트에 Flyway를 적용하면 migration 파일을 다음 위치로 옮길 수 있다.

src/main/resources/db/migration/

Flyway 기본 파일명 형식:

V1__create_member.sql
V2__create_board.sql
V3__add_user_nickname.sql

Flyway를 적용한 뒤에는 실행된 migration 파일을 임의로 수정하지 않는다.
