-- alt+c 안먹힐 때, 블럭설정 우클릭 alt+c 찾아서 클릭
---------------member 테이블 부모로 생성하기-----------------------------
create table member (
mno number(5) not null,
bwriter nvarchar2(10) not null,
id nvarchar2(10) primary key,			-- board 테이블의 bwriter와 fk(외래키)로 관계설정 하려고 함 (타입이 일치해야함)
pw nvarchar2(10) not null,
regidate date default sysdate not null	-- regidate(등록일), default sysdate(db에서 날짜를 입력)
)

-- 시퀀스 객체는 이미 1개가 있으니 board_seq 를 같이 사용
drop table member -- member 테이블 삭제용
delete from member
alter table member add email nvarchar2(100)


-- 부모에 대입할 더미데이터 입력
insert into member (mno, bwriter, id, pw)
values (board_seq.nextval, '김기원', 'kkw', '1234')
insert into member (mno, bwriter, id, pw)
values (board_seq.nextval, '이재상', 'ljs', '1234')
insert into member (mno, bwriter, id, pw)
values (board_seq.nextval, '최준오', 'cjo', '1234')
insert into member (mno, bwriter, id, pw)
values (board_seq.nextval, '이은진', 'lej', '1234')
insert into member (mno, bwriter, id, pw)
values (board_seq.nextval, '윤제석', 'yjs', '1234')

select * from member -- member 테이블 모두 보기

create sequence member_seq increment by 1 start with 
1 nocycle nocache

---------------------member의 자식인 board 외래키 생성 필수---------------------

drop table board -- 기존에 board 테이블 삭제
drop sequence board_seq -- 자동번호 생성 제거

create table board(
bno number(5) primary key,
btitle nvarchar2(30) not null,
bcontent nvarchar2(1000) not null,
bwriter nvarchar2(10) not null,
bdate date not null
)

create sequence board_seq increment by 1 start with 
1 nocycle nocache

alter table board add constraint board_member_fk foreign key (bwriter) references member(id)
-- board 테이블은 member의 자식 테이블로 member에 id와 board에 bwriter를 관계 설정(외래키)
-- ORA-02267: column type incompatible with referenced column type -> pk와 fk를 붙여야 함
-- pk와 fk를 확인하고 연결 -> 자식  테이블에 더미데이터를 삭제하고 실행 해보자

-- board에 더미데이터를 넣어보니
-- RA-02291: integrity constraint (BOARDTEST.BOARD_MEMBER_FK) violated - parent key not found
-- 부모 테이블에 김기원이라는 값이 없다. -> board에 김기원을 id인 kkw로 변경

delete from board -- 조건 없이 delete를 실행하면 모든 데이터가 삭제 됨 -> 외래키를 다시 지정 해보자

insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '덥네용~', '무더운데 등교하시느냐고 고생 하셨습니다.', 'kkw', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '안녕하세요~', '무더운데 등교하시느냐고 고생 하셨습니다.', 'ljs', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '감사합니다~', '무더운데 등교하시느냐고 고생 하셨습니다.', 'cjo', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '수고하셨네요~', '무더운데 등교하시느냐고 고생 하셨습니다.', 'lej', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '화이팅하세요~', '무더운데 등교하시느냐고 고생 하셨습니다.', 'yjs', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '반갑습니다~', '무더운데 등교하시느냐고 고생 하셨습니다.', 'kkw', sysdate)
-- 더미데이터 입력


select * from board


----------------------------------------------------
-- 조인 : 2개 테이블을 연결하여 값을 가져온다.

select b.*, m.bwriter from member m inner join board b on m.id = b.bwriter where id = 'kkw'
-- bwrite가 kkw인 값을 모두 출력한다


--------------------------------------
select * from member where id = 'lej' and pw = '4567'

select * from your_schema.member
