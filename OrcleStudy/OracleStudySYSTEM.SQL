SELECT * FROM DBA_TABLES;

SELECT * FROM DBA_USERS WHERE USERNAME = 'SCOTT'; -- DBA_USERS를 사용하여 사용자 정보 알아보기

-- 뷰를 생성하기 위해 계정 변경 접속하기
-- 1. cmd 접속 
-- 2. SQLPLUS SYSTEM/oracle 입력
-- 3. GRANT CREATE VIEW TO SCOTT; 입력
-- 4. cmd 종료
-- 5. SCOTT 계정으로 접속