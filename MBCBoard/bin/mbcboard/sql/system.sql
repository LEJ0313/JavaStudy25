-- 한줄씩 블럭 설정 후 alt + c
create user boardtest identified by boardtest
grant resource, connect to boardtest
alter user boardtest default tablespace users
alter user boardtest temporary tablespace temp

