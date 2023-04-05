-- 시퀀스
DROP SEQUENCE BBS_SEQ;
CREATE SEQUENCE BBS_SEQ NOCACHE;

-- 테이블 
DROP TABLE BBS;
CREATE TABLE BBS (
	BBS_NO NUMBER NOT NULL,
	TITLE VARCHAR2(1000 BYTE) NOT NULL,
	CONTENT CLOB,
	MODIFIED_DATE VARCHAR2(30 BYTE),
	CREATED_DATE VARCHAR2(30 BYTE),
	CONSTRAINT PK_BBS PRIMARY KEY(BBS_NO)
);

-- 데이터(행)
INSERT INTO BBS VALUES(BBS_SEQ.NEXTVAL, '[공지] 회식안내', '내일 회식입니다. 붐따', NULL, TO_CHAR(SYSDATE, 'yy.MM.dd HH:mm:ss'));
INSERT INTO BBS VALUES(BBS_SEQ.NEXTVAL, '[요청] 희망퇴직안내', '1년치 줍니다.', NULL, TO_CHAR(SYSDATE, 'yy.MM.dd HH:mm:ss'));

