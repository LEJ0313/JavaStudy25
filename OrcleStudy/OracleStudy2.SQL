-- <정의어> (객체에 대한 CRUD), (롤백, 커밋 불가), (SYSTEM 계정이 조작)
-- C(CREATE)
-- R(SELECT)
-- U(ALTER)
-- D(DROP)

-- <조작어> (SCOTT계정이 조작)
-- C (INSERT, INTO, VALUES)
-- R (SELECT, WHERE, FROM)
-- U (UPDATE, SET, VALUES)
-- D (DELETE, FROM, WHERE)

-- <제어어> 
-- 권한부여 (DBA), 되돌리기(롤백)
-- 권한제거, 영구저장(커밋)

-- 트렌젝션 = 롤백과 커밋이 동시에 실행

desc emp;       -- emp 테이블 구조보기
select * from emp; -- emp 테이블 내용보기

desc dept;      -- dept 테이블 구조보기
select * from dept; -- dept 테이블 내용보기

desc bonus;     -- bonus 테이블 구조보기
select * from bonus; -- bouns 테이블 내용보기

desc salgrade;  -- salgrade 테이블 구조보기
select * from salgrade; -- salgrade 테이블 내용보기

select empno, ename, deptno from emp; -- emp 테이블 부분 열 출력하기

select distinct deptno from emp; -- distinct로 열의 중복 제거하기(열이 한개인 경우)

select distinct job, deptno from emp; -- distinct로 열의 중복 제거하기(열이 여러개인 경우)

select all job, deptno from emp; -- all로 열 제거 없이 그대로 출력(기본값)

select ename, sal, sal*12+comm, comm from emp; 
-- sal (emp 테이블의 급여 데이터)
-- comm (emp 테이블의 추가수당 데이터)
-- sal*12+comm (급여에 12를 곱하고 추가수당을 더함)

select ename, sal, sal+sal+sal+sal+sal+sal+sal+sal+sal+sal+sal+sal+comm, comm from emp;
-- 곱하기를 사용하지 않고 연간 총 수입 출력하는법

select ename, sal, sal*12+comm as annsal, comm from emp; -- annsal(별칭, 연봉의 약어)

select * from emp order by sal;
-- emp 테이블의 모든 열을 급여 기준으로 오름차순(ASC) 정렬하기
-- order by (정렬하려는 열 이름을 하나 이상 지정, ASC=오름차순(기본값), DESC=내림차순)

select * from emp order by sal desc; -- emp 테이블의 모든 열을 급여 기준으로 내림차순(DESC) 정렬하기

select * from emp order by deptno asc, sal desc;
-- emp 테이블의 전체 열을 부서번호(오름차순)와 급여(내림차순)로 정렬하기

select * from emp where deptno = 30; -- 부서번호가 30인 데이터만 출력하기

select * from emp where deptno = 30 and job = 'salesman'; -- and 연산자로 여러개의 조건식 사용하기

select * from emp where deptno = 30 or job = 'clerk'; -- or 연산자로 여러개의 출력 조건 사용하기

select * from emp where sal * 12 = 36000; -- 곱셈 연산자 사용

select * from emp where sal >= 3000; -- 대소 비교 연산자 사용

select * from emp where ename >= 'F'; 
-- 알파벳 순서대로 대소문자 비교하기때문에 주의하기 (비교 문자열이 하나일 때)
-- ename >= 'F'; (사원 이름의 첫 문자가 F와 같거나 뒤쪽인 것만 검색)

select * from emp where ename <= 'FORZ'; 
-- 비교 문자열이 여러 개일 때
-- 103쪽 이해안됨

select * from emp where sal != 3000;
select * from emp where sal <> 3000;
select * from emp where sal ^= 3000;
-- 등가 비교 연산자(같지 않다.) 사용하기 세가지 방법 모두 출력값이 같음

select * from emp where not sal = 3000; -- '급여가 3000과 같은경우' 가 아닐 경우를 출력
-- 논리 비교 연산자 사용하기
-- NOT 연산자 사용하기 (정반대의 결과값 출력)
-- NOT와 =를 같이 사용해야함

select * from emp where job = 'MANAGER' or job = 'SALESMAN' or job = 'CLERK';
-- or로 여러 개의 열 출력하기 (출력하려는 열이 많으면 길어질 수 있음)

select * from emp where job in ('MANAGER', 'SALESMAN', 'CLERK');
-- in으로 여러 개의 열 출력하기 (or의 상위버전, 작성 길이가 짧아짐)

select * from emp where job != 'MANAGER' and job <> 'SALESMAN' and job ^= 'CLERK';
-- 등가 비교 연산자로 MANAGER, SALESMAN, CLERK 열을 제외하고 나머지 출력하기

select * from emp where job not in ('MANAGER', 'SALESMAN', 'CLERK');
-- IN 연산자와 논리 비교 연산자(NOT)를 사용하여 출력
-- MANAGER, SALESMAN, CLERK 열을 제외하고 나머지 출력하기

select * from emp where sal >= 2000 and sal <= 3000;
-- 대소 비교 연산자와 and 연산자를 사용하여 출력
-- 2000보다 크거나 같고, 3000보다 작거나 같은 것만 출력

select * from emp where sal between 2000 and 3000;
-- BETWEEN A AND B 연산자를 사용하여 출력
-- 2000보다 크거나 같고, 3000보다 작거나 같은 것만 출력

select * from emp where sal not between 2000 and 3000;
-- BETWEEN A AND B 연산자자와 NOT를 사용하여 출력
-- 2000보다 크거나 같고, 3000보다 작거나 같은 것만 빼고 나머지를 출력

select * from emp where ename like 'S%';
-- LIKE 연산자 사용하여 출력 (문자열이 포함된 데이터를 조회할 때 사용)
-- ENAME 열에 'S'가 포함된 행만 출력
-- LIKE와 같이 쓸 수 있는 와일드카드( _ 와 %)
-- % -> 길이와 상관없이 여러개의 문자 데이터, 특정 문자 또는 문자열을 대체, 문자열 데이터의 패턴을 표기하는 특수 문자
-- _ -> 어떤 값이든 상관없이 한개의 문자 데이터

select * from emp where ename like '_L%';
-- 사원 이름의 두 번째 글자가 L인 사원만 출력하기
-- 첫번째 자리가 와일드카드인 '_'가 왔기 때문에 'L' 앞에는 무조건 문자 하나가 있어야함

select * from emp where ename like '%AM%';
-- 사원 이름에 AM이 포함된 사원 데이터만 출력하기
-- AM 앞뒤로 몇 글자가 오건 어떤 종류의 문자가 오건 상관없이 출력\

select * from emp where ename not like '%AM%';
-- 사원 이름에 AM이 포함되지 않은 사원 데이터만 출력하기

select * from some_table where some_column like 'A￦_A%' escape '￦';
-- ￦_ -> 와일드카드 역할이 아닌 데이터에 포함된 문자를 인식해라.

--select * from emp where comm = NULL;
-- NULL 사용하기
-- 데이터 값이 완전히 '비어 있는' 상태
-- 현재 무슨 값인지 확정되어 있지 않은 상태
-- 값 자체가 존재하지 않는 상태
-- 출력되는 데이터가 없음

SELECT * FROM EMP WHERE COMM IS NULL;
-- IS NULL을 사용하여 데이터 출력하기
-- COMM열이 NULL인 데이터만 출력됨

SELECT * FROM EMP WHERE MGR IS NOT NULL;
-- 직속 상관이 있는 데이터만 출력하기

SELECT * FROM EMP WHERE SAL > NULL AND COMM IS NULL;
-- AND 연산자와 IS NULL 연산자 사용하기

-- OR 연산자와 IS NULL 연산자 사용하기
SELECT * FROM EMP WHERE SAL > NULL OR COMM IS NULL;

-- 집합연산자(UNION)를 사용하여 출력하기
-- 열 개수와 각 열의 자료형이 순서별로 일치해야함
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP WHERE DEPTNO = 10 UNION SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP WHERE DEPTNO = 20;

-- 집합 연산자 종류
-- 1. UNION = 연결된 SELECT문의 결과 값을 합집합으로 묶어 줌, 결과 값의 중복은 제거됨
-- 2. UNION ALL = 연결된 SELECT문의 결과 값을 합집합으로 묶어 줌, 중복된 결과 값도 제거 없이 모두 출력함
-- 3. MINUS = 먼저 작성한 SELECT문의 결과 값에서 다음 SELECT문의 결과 값을 차집합 처리함, 먼저 작성한 SELECT문의 결과 값 중 다음 SELECT문에 존재하지 않는 데이터만 출력됨
-- 4. INTERSECT = 먼저 작성한 SELECT문과 다음 SELECT문의 결과 값이 같은 데이터만 출력됨, 교집합과 같은 의미

-- 집합 연산자(UNION)를 사용하여 출력하기(출력 결과 데이터가 같을 떄)
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP WHERE DEPTNO = 10 UNION SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP WHERE DEPTNO = 10;

-- 집합 연산자(UNION ALL)를 사용하여 출력하기(출력 결과 데이터가 같을 때)
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP WHERE DEPTNO = 10 UNION ALL SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP WHERE DEPTNO = 10;

-- 집합 연산자(MINUS)를 사용하여 출력하기
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP MINUS SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP WHERE DEPTNO = 10;
-- DEPTNO가 10인 사원 데이터를 제외한 결과 값이 출력됨

-- 집합 연산자(INTERSECT)를 사용하여 출력하기
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP INTERSECT SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP WHERE DEPTNO = 10;

-- 내장 함수의 종류
-- 단일행 함수 : 데이터가 한 행씩 입력되고 입력된 한 행당 결과가 하나씩 나오는 함수
-- 다중행 함수 : 여려 행이 입력되어 하나의 행으로 결과가 반환되는 함수

-- 대소문자를 바꿔주는 함수
-- 1. UPPER(문자열) : 괄호 안 문자 데이터를 모두 대문자로 변환하여 반환
-- 2. LOWER(문자열) : 괄호 안 문자 데이터를 모두 소문자로 변환하여 반환
-- 3. INITCAP(문자열) : 과ㅑㄹ호 안 문자 데이터 중 첫 글자는 대문자로, 나머지 문자를 소문자로 변환 후 반환
SELECT ENAME, UPPER(ENAME), LOWER(ENAME), INITCAP(ENAME) FROM EMP;

-- UPPER 함수로 문자열 비교하기 (사원 이름이 SCOTT인 데이터 찾기)
SELECT * FROM EMP WHERE UPPER(ENAME) = UPPER('scott');

-- UPPER 함수로 문자열 비교하기 (사원 이름에 SCOTT 단어를 포함한 데이터 찾기)
SELECT * FROM EMP WHERE UPPER(ENAME) LIKE UPPER('%scott%');

-- LENGTH = 특정 문자열의 길이를 구할 때
-- 선택한 열의 문자열 길이 구하기
SELECT ENAME, LENGTH(ENAME) FROM EMP; -- 각 행별 사원 이름이 몇글자인지 출력됨

-- 사원 이름의 길이가 5 이상인 행 출력하기
SELECT ENAME, LENGTH(ENAME) FROM EMP WHERE LENGTH(ENAME) >= 5;

-- LENGTHB = 바이트 수를 반환할 때
-- LENGTH 함수와 LENGTHB 함수 비교하기
SELECT LENGTH('한글'), LENGTHB('한글') FROM DUAL; -- 한글은 한 문자당 2byte로 처리됨

-- SUBSTR = 문자열 일부를 추출할 때
-- 1. SUBSTR(문자열데이터, 시작 위치, 추출 길이) : 문자열 데이터의 시작 위치부터 추출 길이만큼 추출
-- 2. SUBSTR(문자열데이터, 시작 위치) : 문자열 데이터의 시작 위치부터 문자열 데이터 끝까지 추출

-- SUBSTR 함수를 사용하는 예
SELECT JOB, SUBSTR(JOB, 1, 2), SUBSTR(JOB, 3, 2), SUBSTR(JOB, 5) FROM EMP;

-- SUBSTR 함수안에 다른 함수(LENGTH) 함께 사용하기
SELECT JOB, SUBSTR(JOB, -LENGTH(JOB)), SUBSTR(JOB, -LENGTH(JOB), 2), SUBSTR(JOB, -3) FROM EMP;

-- INSTR = 문자열 데이터 안에서 특정 문자 위치를 찾아줌
-- 기본형식 : INSTR([대상 문자열 데이터(필수)],[위치를 찾으려는 부분 문자(필수)],[위치 찾기를 시작할 대상 문자열 데이터 위치(선택, 기본값은 1)],
-- [시작 위치에서 찾으려는 문자가 몇 번째인지 지정(선택, 기본값은 1)])

-- INSTR 함수로 문자열 데이터에서 특정 문자열 찾기
SELECT INSTR('HELLO, ORACLE!', 'L') AS INSTR_1, INSTR('HELLP, ORACLE!', 'L', 5) AS INSTR_2,
INSTR('HELLO, ORACLE!', 'L', 2, 2) AS INSTR_3 FROM DUAL;

----- 138쪽

CREATE TABLE DEPT_TEMP AS SELECT * FROM DEPT;
-- DEPT테이블을 복사해서 DEPT_TEMP테이블 만들기

SELECT * FROM DEPT_TEMP;
-- DEPT_TEMP 테이블 전체 열 조회하기
-- DROP TABLE 테이블 이름; = 테이블 삭제

INSERT INTO DEPT_TEMP (DEPTNO, DNAME, LOC) VALUES (50, 'DATABASE', 'SEOUL');
-- DEPTNO에 50, DNAME에 DATABASE, LOC에 SEOUL 이름으로 데이터 열 추가하기
SELECT * FROM DEPT_TEMP;
-- INSERT INTO 테이블이름 (열1,열2....) VALUES (열1에 들어갈데이터, 열2에 들어갈데이터...); = 테이블에 데이터 추가하는법
-- DEPT_TEMP 테이블에 데이터 추가하기
-- DATABASE 테이블이 추가됨
-- 열 개수랑 자료형 및 길이는 반드시 맞춰주어야함

INSERT INTO DEPT_TEMP VALUES(60, 'NETWORK', 'BUSAN');
SELECT * FROM DEPT_TEMP;
-- INSERT문에 열 지정 없이 데이터 추가하기

INSERT INTO DEPT_TEMP (DEPTNO, DNAME, LOC) VALUES ( 70, 'WEB', NULL);
-- DEPTNO에 70, DNAME에 WEB, LOC에 NULL값으로 데이터 열 추가하기
SELECT * FROM DEPT_TEMP;
-- NULL을 지정하여 입력하기

INSERT INTO DEPT_TEMP (DEPTNO, DNAME, LOC) VALUES (80, 'MOBILE', '');
-- DEPTNO에 80, DNAME에 MOBILE, LOC에 '' 로 데이터 열 추가하기
SELECT * FROM DEPT_TEMP;
-- 빈 공백 문자열('')로 NULL을 입력하기
-- 실무에서는 '' 보단 NULL을 입력하는 방식을 선호함

INSERT INTO DEPT_TEMP (DEPTNO, LOC) VALUES (90, 'INCHEON');
-- DEPTNO에 90, LOC에 INCHEON으로 데이터 열 추가하기
-- 열 데이터를 입력하지않으면 NULL값으로 처리됨
SELECT * FROM DEPT_TEMP;
-- 열 데이터를 넣지않는 방식으로 NULL 데이터 입력하기

-- EMP 테이블을 복사해서 EMP_TEMP 테이블 만들기
CREATE TABLE EMP_TEMP AS SELECT * FROM EMP WHERE 1<>1;
SELECT * FROM EMP_TEMP;

-- INSERT문으로 날짜 데이터 입력하기(날짜 사이에 / 입력)
INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (9999, '홍길동', 'PRESIDENT', 
9999, '2001/01/01', 5000, NULL, 10);
SELECT * FROM EMP_TEMP;

-- ALTER (구조변경)
-- 스키마 (외부, 내부, 개념)

-- CREATE (새 테이블 생성)
CREATE TABLE EMP_DDL(EMPNO NUMBER(4), ENAME VARCHAR2(10), JOB VARCHAR2(9), MGR NUMBER(4), HIREDATE DATE, 
SAL NUMBER(7,2), COMM NUMBER(7,2), DEPTNO NUMBER(2));
-- 정수형 숫자 = NUMBER(숫자)
-- 가변형 문자열 = VARCHAR2(숫자)
-- 날짜 = DATE
-- 소수점 둘째자리까지 표현되는 숫자 = NUMBER(숫자, 숫자)
DESC EMP_DDL;

-- 모든 열의 각 자료형을 정의해서 테이블 생성하기
-- EMP 테이블의 열 구조와 같게 생성함

CREATE TABLE DEPT_DDL AS SELECT * FROM DEPT;
DESC DEPT_DDL;
-- 다른 테이블을 복사하여 테이블 생성하기

SELECT * FROM DEPT_DDL;
-- DEPT_DDL 테이블 전체 조회하기

CREATE TABLE EMP_DDL_30 AS SELECT * FROM EMP WHERE DEPTNO = 30;
-- 다른 테이블의 일부를 복사하여 테이블 생성하기
-- 30번 부서사원 데이터만 복사
SELECT * FROM EMP_DDL_30;

CREATE TABLE EMPDEPT_DDL AS SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM, 
D.DEPTNO, D.DNAME, D.LOC FROM EMP E, DEPT D WHERE 1 <> 1 ;
-- 기존 테이블의 열 구조만 복사하여 새 테이블 생성하기
-- 열 구조는 있지만 데이터는 저장되지 않음
SELECT * FROM EMPDEPT_DDL;

-- ALTER(테이블 변경, 구조 변경)
CREATE TABLE EMP_ALTER AS SELECT * FROM EMP;
-- EMP 테이블을 복사하여 EMP_ALTER 테이블 생성
SELECT * FROM EMP_ALTER;

-- ADD(테이블에 열 추가하기)
ALTER TABLE EMP_ALTER ADD HP VARCHAR2(20);
-- EMP_ALTER 테이블에 문자열이 20개까지 저장되는 HP열을 추가하기
SELECT * FROM EMP_ALTER;

-- RENAME COLUMN(열 이름 변경)
ALTER TABLE EMP_ALTER RENAME COLUMN HP TO TEL;
-- EMP_ALTER 테이블에 있는 HP열을 TEL이름으로 변경
SELECT * FROM EMP_ALTER;

-- MODIFY(열의 자료형을 변경)
-- 테이블의 특정열의 자료형이나 길이를 변경할때 사용
-- 길이를 늘리기 O, 길이 줄이기 X
ALTER TABLE EMP_ALTER MODIFY EMPNO NUMBER(5);
-- EMP_ALTER 테이블에 있는 EMPNO열의 길이를 5로 변경
DESC EMP_ALTER;
-- 바뀐 값 확인

-- DROP COLUMN(특정 열을 삭제)
-- 열을 삭제하면 열의 데이터도 함께 삭제됨
ALTER TABLE EMP_ALTER DROP COLUMN TEL;
-- EMP_ALTER 테이블에 있는 TEL열을 삭제
SELECT * FROM EMP_ALTER;

-- RENAME (테이블 이름 변경)
RENAME EMP_ALTER TO EMP_RENAME;
-- EMP_ALTER을 EMP_RENAME로 이름 변경
-- 기존에 사용했던 EMP_ALTER 이름 사용 불가
DESC EMP_ALTER; -- 이름을 변경했기 때문에 오류 발생
SELECT * FROM EMP_RENAME;

-- TRUNCATE (테이블의 데이터를 삭제)
-- 특정 테이블의 모든 데이터를 삭제함
-- 정의어이기 때문에 삭제 이후 복구할 수 없음
TRUNCATE TABLE EMP_RENAME;
SELECT * FROM EMP_RENAME;

-- DROP(테이블 삭제)
-- 정의어이기 때문에 삭제 이후 복구할 수 없음
DROP TABLE EMP_RENAME;
DESC EMP_RENAME; -- 테이블이 삭제되서 오류 발생

-- 324쪽 1번 문제
CREATE TABLE EMP_HW (EMPNO NUMBER(4), ENAME VARCHAR2(10), JOB VARCHAR2(9), MGR NUMBER(4), HIREDATE DATE, 
SAL NUMBER(7,2), COMM NUMBER(7,2), DEPTNO NUMBER(2));

-- 324쪽 2번 문제
ALTER TABLE EMP_HW ADD BIGO VARCHAR2(20);

-- 324쪽 3번 문제
ALTER TABLE EMP_HW MODIFY BIGO VARCHAR2(30);

-- 324쪽 4번 문제
ALTER TABLE EMP_HW RENAME COLUMN BIGO TO REMARK;

-- 325쪽 5번 문제
CREATE TABLE EMP_HW1 AS SELECT * FROM EMP;
ALTER TABLE EMP_HW1 ADD REMARKS NUMBER(1);

-- 325쪽 6번 문제
DROP TABLE EMP_HW1;

SELECT * FROM EMP_HW1;
SELECT * FROM EMP_HW;
DESC EMP_HW;

SELECT * FROM DICT; -- SCOTT 계정에서 사용 가능한 데이터 사전 살펴보기 (DICT 사용)
SELECT * FROM DICTIONARY; -- SCOTT 계정에서 사용 가능한 데이터 사전 살펴보기 (DICTIONARY 사용)

-- 접두어(USER_, ALL_, DBA_, V$_) 사용시 접두어 뒤에 복수형 단어 사용
-- USER_ (현재 오라클에 접속해 있는 사용자 객체 정보 보기)
SELECT TABLE_NAME FROM USER_TABLES; -- SCOTT 계정이 가지고 있는 객체 정보 살펴보기

-- ALL_ (현재 오라클에 접속해있는 사용자와 사용할 수 있는 테이블 정보를 모두 보여줌)
SELECT OWNER,  TABLE_NAME FROM ALL_TABLES;
-- OWNER (테이블을 소유한 사용자)

-- DBA_ (DB 관리 권한을 가진 사용자만 조회, SCOTT 계정으로 조회 불가)
SELECT * FROM DBA_TABLES;

-- Index (더 빠른 검색)
-- Table Full Scan (테이블 데이터를 처음부터 끝까지 검색하여 찾는방식)
-- Index Scan (인덱스를 통해 데이터를 찾는방식)

SELECT * FROM USER_INDEXES; -- SCOTT 계정이 소유한 인덱스 정보 알아보기 (SCOTT계정일 때)
SELECT * FROM USER_IND_COLUMNS; -- SCOTT 계정이 소유한 인덱스 컬럼 정보 알아보기 (SCOTT계정일 때)

-- 인덱스 생성(CREATE)
-- CREATE INDEX 인덱스 이름 ON 테이블 이름(열 이름 ASC or DESC);
CREATE INDEX IDX_EMP_SAL ON EMP(SAL); -- EMP테이블의 SAL 열에 인덱스를 생성하기
-- IDX_EMP_SAL 인덱스 생성
-- 인덱스의 정렬 옵션을 지정하지 않으면 기본값인 오름차순으로 지정됨
SELECT * FROM USER_IND_COLUMNS;

-- 인덱스 삭제 (DROP)
-- DROP INDEX 인덱스 이름;
DROP INDEX IDX_EMP_SAL;
SELECT * FROM USER_IND_COLUMNS;

-- VIEW (하나 이상의 테이블을 조회하는 SELECT문을 저장한 객체)
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO = 20;
-- 부서 번호가 20인사원의 사원번호, 사원이름, 직책, 부서번호를 출력

-- VIEW CREATE 기본 형식
-- CREATE [OR REPLACE] [FORCE : NOFORCE] VIEW 뷰 이름(열 이름1, 열이름2...) AS(저장할 SELECT문) [WITH CHECK OPTION [CONSTRAINT 제약조건]]
-- [WITH READ ONLY [CONSTRAINT 제약조건]];
-- OR REPLACE = 같은 이름의 뷰가 이미 존재할 경우 현재 생성할 뷰로 대체하여 생성 (선택)
-- FORCE = 뷰가 저장할 SELECT문의 기반 테이블이 존재하지 않아도 강제로 생성 (선택)
-- NOFORCE = 뷰가 저장할 SELECT문의 기반 테이블이 존재할 경우에만 생성 (기본값)(선택)
-- 뷰 이름 = 생성할 뷰 이름을 지정 (필수)
-- 열 이름 = SELECT문에 명시된 이름 대신 사용할 열 이름 지정 (생략가능)(선택)
-- 저장할 SELECT문 = 생성할 뷰에 저장할 SELECT문 지정 (필수)
-- WITH CHECK OPTION = 지정한 제약 조건을 만족하는 데이터에 한해 DML 작업이 가능하도록 뷰 생성(선택)
-- WITH READ ONLY = 뷰의 열람, 즉 SELECT만 가능하도록 뷰 생성(선택)

CREATE VIEW VW_EMP20 AS (SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO = 20); -- 뷰 생성
SELECT * FROM USER_VIEWS; -- 생성한 뷰 확인
SELECT VIEW_NAME, TEXT_LENGTH, TEXT FROM USER_VIEWS; -- 생성한 뷰 내용 확인하기
SELECT * FROM VW_EMP20; -- 생성한 뷰 조회

-- 뷰 삭제 (DROP)
DROP VIEW VW_EMP20;
-- 뷰를 삭제해도 테이블이나 데이터가 삭제되지 않음
SELECT * FROM USER_VIEWS;

-- ROWNUM (의사 열, 실제 테이블에 존재하지 않지만 테이블에 저장되어 있는 열처럼 사용 가능한 열)
SELECT ROWNUM, E.* FROM EMP E; -- ROWNUM을 추가로 조회하기

SELECT ROWNUM, E.* FROM EMP E ORDER BY SAL DESC; -- EMP테이블을 SAL 열 기준으로 내림차순 정렬하기

SELECT ROWNUM, E.* FROM (SELECT * FROM EMP E ORDER BY SAL DESC)E; -- 인라인 뷰(서브쿼리 사용)
WITH E AS (SELECT * FROM EMP ORDER BY SAL DESC) SELECT ROWNUM, E.* FROM E; -- 인라인 뷰(WITH절 사용)
-- 둘 다 결과가 똑같음

-- 급여가 높은 상위 세명의 데이터만 출력하기
SELECT ROWNUM, E.* FROM (SELECT * FROM EMP E ORDER BY SAL DESC) E WHERE ROWNUM <= 3; -- 인라인 뷰로 TOP-N 추출하기(서브쿼리 사용)
WITH E AS (SELECT * FROM EMP ORDER BY SAL DESC) SELECT ROWNUM, E.* FROM E WHERE ROWNUM <= 3; -- 인라인 뷰로 TOP-N 추출하기(WITH절 사용)
-- 둘 다 결과가 똑같음

-- SEQUENCE (특정 규칙에 맞는 연속 숫자를 생성하는 객체, 대기 순번표)
-- SELECT MAX(글 번호) + 1 FROM 게시판 테이블

CREATE TABLE DEPT_SEQUENCE AS SELECT * FROM DEPT WHERE 1 <> 1; -- DEPT 테이블을 사용하여 DEPT_SEQUENCE 테이블 생성
SELECT * FROM DEPT_SEQUENCE;
-- 349쪽

-- NOT NULL (NULL의 저장을 허용하지 않음)
CREATE TABLE TABLE_NOTNULL (LOGIN_ID VARCHAR2(20) NOT NULL, LOGIN_PWD VARCHAR2(20) NOT NULL, TEL VARCHAR2(20));
-- 테이블 생성 시 NOT NULL 설정하기
DESC TABLE_NOTNULL;

INSERT INTO TABLE_NOTNULL (LOGIN_ID, LOGIN_PWD, TEL) VALUES ('TEST_ID_01', NULL, '010-1234-5678');
-- 제약 조건이 NOT NULL인 열에 NULL 값 넣어보기
-- NOT NULL(NULL의 저장을 허용하지 않음)인데 NULL값을 넣어서 오류 발생

INSERT INTO TABLE_NOTNULL (LOGIN_ID, LOGIN_PWD) VALUES ('TEST_ID_01', '1234');
-- 제약 조건이 없는 TELL 열에 NULL 값 입력하기
SELECT * FROM TABLE_NOTNULL;

UPDATE TABLE_NOTNULL SET LOGIN_PWD = NULL WHERE LOGIN_ID = 'TEST_ID_01';
-- 오류 발생

-- OWNER = 제약 조건 소유 계정
-- CONSTRAINT_NAME = 제약 조건 이름(직접 지정하지 않을 경우 오라클이 자동으로 지정함)
-- CONSTRAINT_TYPE = 제약 조건 종류 -> C(CHECK, NOT NULL), U(UNIQUE), P(PRIMARY KEY 기본키), R(FOREIGN KET 외래키)
-- TABLE_NAME = 제약 조건을 지정한 테이블 이름

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS; -- 제약 조건 살펴보기 (SCOTT 계정)

CREATE TABLE TABLE_NOTNULL2(LOGIN_ID VARCHAR2(20) CONSTRAINT TBLNN2_LGNID_NN NOT NULL,
LOGIN_PWD VARCHAR2(20) CONSTRAINT TBLNN2_LGNPWD_NN NOT NULL, TEL VARCHAR2(20));
-- 테이블을 생성할 때 제약 조건에 이름 지정하기
-- TABLE_NOTNULL2이름으로 테이블 생성 LOGIN_ID 필드명에 문자열(VARCHAR2)이 20개까지 저장되는 NOT NULL 조건으로 TBLNN2_LGNID_NN 이름의 테이블 생성
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS;
-- 지정한 필드 명만 출력하기

ALTER TABLE TABLE_NOTNULL MODIFY (TEL NOT NULL); -- TEL 열에 NOT NULL 제약 조건 추가하기
-- 오류 발생 (이미 TEL열의 데이터 중 NULL 값이 존재하기 때문)

--UPDATE TABLE_NOTNULL SET TEL = '010-1234-5678'; -- TEL 열 데이터 수정하기
-- TEL 열에 010-1234-5678 값 넣기
SELECT * FROM TABLE_NOTNULL;

ALTER TABLE TABLE_NOTNULL MODIFY(TEL NOT NULL); -- NOT NULL 제약 조건 추가하기
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS;
-- 제약 조건 추가 방법
-- 1. 값을 넣은 후 제약 조건 추가
-- 2. 열 삭제 후 생성

ALTER TABLE TABLE_NOTNULL2 MODIFY (TEL CONSTRAINT TBLNN_TEL_NN NOT NULL); -- 제약 조건에 이름 지정해서 추가하기
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS;
DESC TABLE_NOTNULL2; -- TABLE_NOTNULL2 테이블 열 구조 확인하기

-- 제약 조건 이름 변경
-- 이미 생성한 제약 조건 이름을 변경하려면 ALTER 명령어에 RENAME CONSTRAINT 키워드를 사용
ALTER TABLE TABLE_NOTNULL2 RENAME CONSTRAINT TBLNN_TEL_NN TO TBLNN2_TEL_NN; -- 이미 생성된 제약 조건 이름 변경하기
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS;

-- 제약 조건 삭제
-- ALTER 명령어에 DROP CONSTRAINT 키워드를 사용하면 지정한 제약 조건 삭제 가능
ALTER TABLE TABLE_NOTNULL2 DROP CONSTRAINT TBLNN2_TEL_NN; -- 제약 조건 삭제하기
DESC TABLE_NOTNULL2;
-- 제약 조건을 삭제하면 NULL이 저장될 수 있는 열이 됨

-- UNIQUE = 중복을 허용하지 않음, NULL은 제외
CREATE TABLE TABLE_UNIQUE(LOGIN_ID VARCHAR2(20) UNIQUE, LOGIN_PWD VARCHAR2(20) NOT NULL, TEL VARCHAR2(20)); -- 제약 조건 지정하기
DESC TABLE_UNIQUE;

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'TABLE_UNIQUE';
-- USER_CONSTRAINTS 데이터 사전 뷰로 제약 조건 확인하기
-- WHERE절을 통해 TABLE_UNIQUE 테이블의 제약조건만 조회

INSERT INTO TABLE_UNIQUE(LOGIN_ID, LOGIN_PWD, TEL) VALUES ('TEST_ID_01', 'PWD01', '010-1234-5678');
-- TABLE_UNIQUE 테이블에 데이터 입력하기 (INSET INTO, VALUES)
SELECT * FROM TABLE_UNIQUE;

INSERT INTO TABLE_UNIQUE(LOGIN_ID, LOGIN_PWD, TEL) VALUES ('TEST_ID_01', 'PWD01', '010-1234-5678'); -- 중복된 데이터가 있음, 오류 발생

INSERT INTO TABLE_UNIQUE(LOGIN_ID, LOGIN_PWD, TEL) VALUES ('TEST_ID_02', 'PWD01', '010-1234-5678');
-- TABLE_UNIQUE 테이블에 데이터 입력하기
SELECT * FROM TABLE_UNIQUE;
-- LOGIN_PWD 열을 NOT NULL 조건만 지정되어 있어서 중복이 허용됨

INSERT INTO TABLE_UNIQUE(LOGIN_ID, LOGIN_PWD, TEL) VALUES (NULL, 'PWD01', '010-2345-6789');
-- UNIQUE 제약 조건이 지정된 열에 NULL 값 입력하기
SELECT * FROM TABLE_UNIQUE;

UPDATE TABLE_UNIQUE SET LOGIN_ID = 'TEST_ID_01' WHERE LOGIN_ID IS NULL; -- TABLE_UNIQUE 테이블 데이터 수정하기
-- 중복된 데이터가 있으므로 오류 발생

CREATE TABLE TABLE_UNIQUE2 (LOGIN_ID VARCHAR2(20) CONSTRAINT TBLUNQ2_LGNID_UNQ UNIQUE, 
LOGIN_PWD VARCHAR2(20) CONSTRAINT TBLUNQ2_LGNPW_NN NOT NULL, TEL VARCHAR2(20)); -- 테이블을 생성할 때 UNIQUE 제약 조건 설정하기
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'TABLE_UNIQUE%';
-- 생성한 UNIQUE 제약 조건 확인하기 (USER_CONSTRAINTS 사용)

-- 이미 생성한 테이블 열에 UNIQUE 제약 조건 추가하기
ALTER TABLE TABLE_UNNIAUE MODIFY (TEL UNIQUE); -- TEL 열에 중복 데이터가 있기에 오류 발생

--UPDATE TABLE_UNIQUE SET TEL = NULL; -- TEL 열 값을 모두 NULL 값으로 변경하기
SELECT * FROM TABLE_UNIQUE;

ALTER TABLE TABLE_UNIQUE MODIFY (TEL UNIQUE); -- TEL 값에 UNIQUE 제약 조건 설정하기

ALTER TABLE TABLE_UNIQUE2 MODIFY (TEL CONSTRAINT TBLUNQ_TEL_UNQ UNIQUE); -- UNIQUE 제약 조건 이름 직접 지정하기
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS
WHERE TABLE_NAME LIKE 'TABLE_UNIQUE%';

-- 이미 만들어져 있는 UNIQUE 제약 조건 이름 수정하기
ALTER TABLE TABLE_UNIQUE2 RENAME CONSTRAINT TBLUNQ_TEL_UNQ TO TBLUNQ2_TEL_UNQ;
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS
WHERE TABLE_NAME LIKE 'TABLE_UNIQUE%';

-- 제약 조건 삭제하기 (DROP CONSTRAINT)
ALTER TABLE TABLE_UNIQUE2 DROP CONSTRAINT TBLUNQ2_TEL_UNQ;
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS
WHERE TABLE_NAME LIKE 'TABLE_UNIQUE%';

-- PRIMARY KEY (기본키, 유일한 값)
-- 테이블 생성할 때 특정 열에 PRIMARY KEY 설정하기
CREATE TABLE TABLE_PK(LOGIN_ID VARCHAR2(20) PRIMARY KEY, LOGIN_PWD VARCHAR2(20) NOT NULL, TEL VARCHAR2(20));
DESC TABLE_PK;

-- 생성한 PRIMARY KEY 확인하기
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS
WHERE TABLE_NAME LIKE 'TABLE_PK%';
-- PRIMARY KEY 제약 조건을 지정한 열에는 자동으로 인덱스가 생성됨

-- 생성한 PRIMARY KEY를 통해 자동 생성된 INDEX 확인하기
SELECT INDEX_NAME, TABLE_OWNER, TABLE_NAME FROM USER_INDEXES WHERE TABLE_NAME LIKE 'TABLE_PK%';

-- 제약 조건의 이름을 직접 지정하여 테이블 생성하기
CREATE TABLE TABLE_PK2(LOGIN_ID VARCHAR2(20) CONSTRAINT TBLPK2_LGNID_PK PRIMARY KEY, LOGIN_PWD VARCHAR2(20)
CONSTRAINT TBLPK2_LGNPW_NN NOT NULL, TEL VARCHAR2(20));
DESC TABLE_PK2;

-- TABLE_PK 테이블에 데이터 입력하기 (중복 허용 여부 살펴보기)
INSERT INTO TABLE_PK(LOGIN_ID, LOGIN_PWD, TEL) VALUES ('TEST_ID_01', 'PWD01', '010-1234-5678');
SELECT * FROM TABLE_PK;

-- TABLE_PK 테이블에 중복되는 데이터 입력하기
INSERT INTO TABLE_PK(LOGIN_ID, LOGIN_PWD, TEL) VALUES ('TEST_ID_01', 'PWD01', '010-1234-5678');
-- PRIMARY KEY 제약 조건이 지정되어 있는 열은 중복 값을 허용하지 않음, 오류 발생

-- NULL 값을 명시적으로 입력하기
INSERT INTO TABLE_PK(LOGIN_ID, LOGIN_PWD, TEL) VALUES (NULL, 'PWD02', '010-2345-6789');
-- PRIMARY KEY 제약 조건이 지정되어 있는 열은 NULL 값을 허용하지 않음, 오류 발생
-- PRIMARY KEY 제약 조건에도 ALTER문의 MODIFY(추가), RENAME(이름 변경), DEOP(삭제), UPDATE(수정) 등이 가능
-- PRIMARY KEY 제약 조건이 테이블에 이미 지정되어 있다면 다른 열에는 추가할 수 없음

-- CREATE문에서 제약 조건을 지정하는 다른 방식
-- 열 바로 옆에 제약 조건을 지정하는 형식 = 인라인(INLINE), 열 레벨(COLUMN-LEVEL)
CREATE TABLE TABLE_NAME( COL1 VARCHAR2(20) CONSTRAINT CONSTRAINT_NAME PRIMARY KEY, -- 이름 지정함
COL2 VARCHAR2(20) NOT NULL, COL3 VARCHAR(20)); -- 이름 지정하지 않음

-- 열을 명시한 후 제약 조건을 테이블 단위에 지정하는 방식 = 아웃오브라인(OUT-OF-LINE), 테이블 레벨(TABLE-LEVEL)
-- NOU NULL 제약 조건을 제외한 제약 조건 지정이 가능
CREATE TABLE TABLE_NAME(COL1 VARCHAR2(20), COL2 VARCHAR2(20), COL3 VARCHAR2(20),
--PRIMARY KET (COL1), -- 이름 지정하지 않음 (COL1 열에 PRIMARY KEY 지정)
CONSTRAINT CONSTRAINT_NAME UNIQUE (COL2)); -- 이름 지정함 (COL2 열에 UNIQUE 지정)

-- FOREIGN KEY (외래키, 외부키) = 서로 다른 테이블 간 관계를 정의하는데 사용하는 제약 조건
-- EMP 테이블과 DEPT 테이블의 제약 조건 살펴보기
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_OWNER, R_CONSTRAINT_NAME FROM USER_CONSTRAINTS
WHERE TABLE_NAME IN ('EMP', 'DEPT');
-- CONSTRAINT_TYPE가 R값이면 외래키를 의미함
-- R_CONSTRAINT_NAME의 PK_DEPT는 DEPT 테이블의 PRIMARY KEY(DEPTNO)열을 참조한다는 뜻

-- FOREIGN KEY(외래키)가 참조하는 열에 존재하지 않는 데이터 입력하기
INSERT INTO EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, TEPTNO) VALUES (9999, '홍길동', 'CLERK', '7788',
TO_DATE('2017/04/30', 'YYYY/MM/DD'), 1200, NULL, 50);
-- 부모 키가 없습니다 = DEPT 테이블의 DEPTNO 열에 50이 존재하지 않음
-- 참조 대상 테이블 = 부모 / 참조하는 테이블 = 자식

-- FOREIGN KEY 지정하기
-- 기본 형식 : CREATE TABLE 테이블이름 (...(다른 열 정의), 열 자료형 CONSTRAINT [제약 조건 이름] REFERENCES 참조 테이블(참조할 영));
-- 제약 조건 이름을 지정하지 않고 FOREIGN KEY 정의 : CREATE TABLE 테이블이름(...(다른 열 정의), 열 자료형 REFERENCES 참조 테이블(참조할 열));
-- 열을 모두 정의한 후 제약조건 지정 : CREATE TABLE 테이블이름(...(다른 열 정의), CONSTRAINT [제약 조건 이름] FOREIGN KEY(열) REFERENCES 참조테이블(참조할 열));

-- DEPT_FK 테이블 생성하기
CREATE TABLE DEPT_FK(DEPTNO NUMBER(2) CONSTRAINT DEPTFK_DEPTNO_PK PRIMARY KEY, DNAME VARCHAR2(14), LOC VARCHAR2(13));
DESC DEPT_FK;

-- EMP_FK 테이블 생성하기
CREATE TABLE EMP_FK (EMPNO NUMBER(4) CONSTRAINT EMPFK_EMPNO_PK PRIMARY KEY, ENAME VARCHAR2(10), JOB VARCHAR2(9),
MGR NUMBER(4), HIRDATE DATE, SAL NUMBER(7,2), COMM NUMBER(7,2), DEPTNO NUMBER(2) CONSTRAINT EMPFK_DEPTNO_FK 
REFERENCES DEPT_FK (DEPTNO)); 
DESC EMP_FK;

-- EMP_FK 테이블에 데이터 삽입하기(DEPTNO 데이터가 아직 DEPT_FK 테이블에 없을 때)
INSERT INTO EMP_FK VALUES (9999, 'TEST_NMAME', 'TEST_JOB', NULL, TO_DATE('2001/01/01', 'YYYY/MM/DD'), 3000, NULL, 10);

-- DEPT_FK에 데이터 삽입하기
INSERT INTO DEPT_FK VALUES (10, 'TEST_DNAME', 'TEST_LOC');
SELECT * FROM DEPT_FK;

-- EMP_FK 테이블에 데이터 삽입하기
INSERT INTO EMP_FK VALUES(9999, 'TEST_NMAME', 'TEST_JOB', NULL, TO_DATE('2001/01/01', 'YYYY/MM/DD'), 3000, NULL, 10);
SELECT * FROM EMP_FK;

-- DEPT_FK 테이블의 10번 부서 데이터 삭제하기
DELETE FROM DEPT_FK WHERE DEPTNO = 10;
-- 자식 레코드, 즉 삭제하려는 DEPTNO 값을 참조하는 데이터가 존재하기 때문에 오류 발생

-- 열 데이터를 삭제할 때 이 데이터를 참조하고 있는 데이터도 함께 삭제
-- 기본 형식 : CONSTRAINT [제약 조건 이름] REFERENCES 참조 테이블(참조할 열) ON DELETE CASCADE

-- 열 데이터를 삭제할 때 이 데이터를 참조하는 데이터를 NULL로 수정
-- 기본 형식 : CONSTRAINT [제약 조건 이름] REFERENCES 참조 테이블(참조할 열) ON DELETE SET NULL

-- CHECK 제약조건 (열에 저장할 수 있는 값의 범위 또는 패턴을 정의)
-- 테이블을 생성할 때 CHECK 제약 조건 설정하기
CREATE TABLE TABLE_CHECK(LOGIN_ID VARCHAR2(20)CONSTRAINT TBLCK_LOGININ_PK PRIMARY KEY,
LOGIN_PWD VARCHAR2(20) CONSTRAINT TBLCK_LOGINPW_CK CHECK (LENGTH(LOGIN_PWD) > 3), TEL VARCHAR2(20));
-- LENGTH(LOGIN_PWD)>3 = LOGIN_PWD 열 길이가 3이상인 데이터만 저장 가능함
DESC TABLE_CHECK;

-- CHECK 제약 조건에 맞지 않는 예
INSERT INTO TABLE_CHECK VALUES ('TEST_ID', '123', '010-1234-5678');
-- 오류 발생

-- CHECK 제약 조건에 맞는 예
INSERT INTO TABLE_CHECK VALUES ( 'TEST_ID', '1234', '010-1234-5678');
SELECT * FROM TABLE_CHECK;
-- 정상 출력

-- CHECK 제약 조건 확인하기
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'TABLE_CHECK';

-- DEFAULT = 기본값 지정
-- 테이블을 생성할 때 DEFAULT 제약 조건을 설정하기
CREATE TABLE TABLE_DEFAULT(LOGIN_ID VARCHAR2(20) CONSTRAINT TBLCK2_LOGINID_PK PRIMARY KEY,
LOGIN_PWD VARCHAR2(20) DEFAULT '1234', TEL VARCHAR2(20));
DESC TABLE_DEFAULT;

-- DEFAULT로 지정한 기본값이 입력되는 INSERT문 확인하기
INSERT INTO TABLE_DEFAULT VALUES ('TEST_ID', NULL, '010-1234-5678');
INSERT INTO TABLE_DEFAULT (LOGIN_ID, TEL) VALUES ('TEST_ID2', '010-1234-5678');
SELECT * FROM TABLE_DEFAULT;

-- 제약 조건 비활성화(DISABLE), 활성화(ENABLE)
-- ALTER TABLE 테이블 이름 DISABLE [NOVALIDATE / VALIDATE(선택)] CONSTRAINT 제약조건이름;
-- ALTER TABLE 테이블 이름 ENABLE [NOVALIDATE / VALIDATE(선택)] CONSTRAINT 제약조건이름;

-- SYSTEM 계정으로 접속 후 계정 만들고 권한을 꼭 줘야함 (GRANT)

-- 사용자 생성 기본 형식
-- CREATE USER = 사용자이름 (필수)
-- IDENTIFIED BY = 패스워드 (필수)
-- DEFAULT TABLESPACE = 테이블 스페이스 이름 (선택)
-- TEMPORARY TABLESPACE = 테이블 스페이스(그룹) 이름(선택)
-- QUOTA = 테이블 스페이스 크기 (선택)
-- ON = 테이블 스페이스 이름 (선택)
-- PROFILE = 프로파일 이름 (선택)
-- PASSWORD EXPIRE = 접속할 수 있는 기한 설정(선택)
-- ACCOUNT [LOCK/UNLOCK] = 기한이 끝난 후 데이터 보관을 위한 설정(선택)

-- SCOTT 계정으로 사용자 생성하기
CREATE USER ORCLSTUDY IDENTIFIED BY ORACLE;
--             ID                     PW    
-- SCOTT 계정은 계정생성 권한이 없음

-- SYSTEM 사용자로 접속 후 사용자 생성하기(CMD접속)
SQLPLUS SYSTEM/oracle -- SYSTEM 계정 접속
CREATE USER ORCLSTUDY IDENTIFIED BY ORACLE; -- 사용자 생성

-- SYSTEM 사용자로 접속 후 ORCLSTUDY 사용자에게 권한 부여하기
CONN SYSTEM/oracle -- SYSTEM 사용자 접속
GRANT CREATE SESSION TO ORCLSTUDY; 

-- 사용자 정보 조회
SELECT * FROM ALL_USERS WHERE USERNAME = 'ORCLSTUDY'; 
SELECT * FROM DBA_USERS WHERE USERNAME = 'ORCLSTUDY';
SELECT * FROM DBA_OBJECTS WHERE OWNER = 'ORCLSTUDY';

-- 사용자 정보(패스워드) 변경하기
ALTER USER ORCLSTUDY IDENTIFIED BY ORCL;
--             ID                  변경할 PW

-- 오라클 사용자 삭제
DROP USER ORCLSTUDY ;

-- 오라클 사용자와 객체 모두 삭제
DROP USER ORCLSTUDY CASCADE;

-- 시스템 권한 부여 GRANT문 기본 형식
-- GRANT [시스템 권한(필수)] TO [사용자이름/롤(ROLE)이름/PUBLIC(필수)][WITH ADMIN OPTION(선택)];
-- RESOURCE = USERS에 대한 권한

-- 시스템 권한 취소 REVOKE
-- 기본형식 : REVOKE [시스템 권한] FROM [사용자이름/롤(ROLE)이름/ PUBLIC]; 

-- 객체 권한 부여 GRANT
-- 기본형식 : GRANT [객체권한/ALL PRIVILEGES(필수)] ON[스키마.객체이름(필수)] TO[사용자이름/롤(ROLE)이름/PUBLIC(필수)][WITH GRANT OPTION(선택);

-- ORCLSTUDY 사용자에게 TEMP 테이블 권한 부여하기
CONN SCOTT/tiger -- SCOTT 계정 접속
CREATE TABLE TEMP(COL1 VARCHAR2(20), COL2 VARCHAR2(20)); -- SCOTT 소유의 TEMP 테이블 생성
GRANT SELECT ON TEMP TO ORCLSTUDY; -- ORCLSTUDY 사용자에게 TEMP 테이블에 SELECT 권한 부여
GRANT INSERT ON TEMP TO ORCLSTUDY; -- ORCLSTUDY 사용자에게 TEMP 테이블에 INSERT 권한 부여

-- ORCL에게 TEMP 테이블의 여러 권한을 한 번에 부여하기
GRANT SELECT, INSERT ON TEMP TO ORCLSTUDY;

-- 객체 권한 취소 
-- 기본형식 : REVOKE[객체권한/ALL PRIVILEGES](필수) ON[스키마.객체이름](필수) FROM[사용자이름/롤이름/PUBLIC](필수) 
--        [CASCADE CONSTRAINTS/FORCE](선택)

-- 롤(ROLE) = 여러 종류의 권한을 묶어 놓은 그룹

-- CONNECT 롤 (사용자가 접속하는데 필요한 CREATE SESSION 권한을 가지고 있음)
-- ALTER SESSION (DB 접속 상태에서 환경 값 변경 권한)
-- CREATE CLUSTER, DATABASE LINK, SEQUENCE, SESSION(DB 접속 권한), SYNONYM(동의어 생성), TABLE(자신의 테이블 생성 권한), VIEW(뷰 생성)

-- RESOURCE 롤 (사용자가 테이블, 시퀀스 등 여러 객체를 생성할 수 있는 기본 시스템 권한들을 가지고 있음)
-- CREATE TRIGGER, SEQUENCE, TYPE, PROCEDURE, CLUSTER, OPERATOR, INDEXTYPE, TABLE(자신의 테이블 생성 권한)

-- DBA 롤 (DB를 관리하는 시스템 권한을 대부분 가지고 있음)

-- 사용자 정의 롤 (필요에 의해 직접 권한을 포함시킨 롤)
-- 1. CREATE ROLL 문으로 롤을 생성한다.
-- 2. GRANT 명령어로 생성한 롤에 권한을 포함시킨다.
-- 3. GRANT 명령어로 권한이 포함된 롤을 특정 사용자에게 부여한다.
-- 4. REVOKE 명령어로 롤을 취소시킨다.

-- 롤 생성 시 데이터 관리 권한이 있는 사용자가 필요함 (SYSTEM 사용자)
-- SYSTEMP 계정으로 ROLESTUDY 롤 생성 및 권한 부여하기
CONN SYSTEM/oracle -- SYSTEM 사용자 접속
CREATE ROLE ROLESTUDY; -- ROLESTUDY 롤 생성
GRANT CONNECT, RESOURCE, CREATE VIEW, CREATE SYNONYM TO ROLESTUDY; -- ROLESTUDY 롤에 권한 부여

-- ORCLSTUDY 사용자에게 롤(ROLESTUDY) 부여하기
GRANT ROLESTUDY TO ORCLSTUDY;

-- ORCLSTUDY에 부여된 롤과 권한 확인하기
CONN ORCLSTUDY/ORACLE -- ORCLSTUDY 사용자 접속
SELECT * FROM USER_SYS_PRIVS; -- 권한 확인
SELECT * FROM USER_ROLE_PRIVS; -- 롤 확인

-- 부여된 롤 취소 (REVOKE)
REVOKE ROLESTUDY FROM ORCLSTUDY;

-- 롤 삭제 (DROP)
DROP ROLE ROLESTUDY;