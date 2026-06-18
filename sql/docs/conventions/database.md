# Database Convention

## 1. 제약조건 선언 방식

제약조건은 가급적 테이블 레벨에서 선언한다.

## 2. 제약조건명 규칙
- PK: `pk_<table>`
- FK: `fk_<current_table>_<referenced_table>`
- UK: `uk_<table>_<column>`
- CK: `ck_<table>_<column>`

## 3. 복합 기본키도 컬럼명을 나열하지 않고 다음 형식을 사용한다.
- pk: `pk_<table>`


## 4. 축약어

    원래 단어                 축약어
    customer    (고객)        cust
    order       (주문)        ord
    detail      (상세)        dtl
    corporate   (법인)        corp
    management  (관리)        mgmt
    information (정보)        info
    BOARD_REPLY               BR
    BOARD_CATEGORY            BC
    
## 참고
Oracle 12.1 이하에서는 식별자 길이가 최대 30바이트이므로,
제약조건명이 길어질 경우 일관된 축약어를 사용한다.

## SQL 구분 주석
-- =============== DROP TABLE =================
-- =============== DROP SEQUENCE ==============
-- =============== CREATE SEQUENCE ============
-- =============== CREATE TABLE ===============

