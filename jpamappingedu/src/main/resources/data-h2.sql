INSERT INTO TEAM(team_name) values ('대한민국');
INSERT INTO TEAM(team_name, parent_id) values ('서울', 1);
INSERT INTO TEAM(team_name, parent_id) values ('대전', 1);
INSERT INTO TEAM(team_name, parent_id) values ('부산', 1);
INSERT INTO TEAM(team_name) values ('미국');
INSERT INTO TEAM(team_name, parent_id) values ('로스앤젤레스', 5);
INSERT INTO TEAM(team_name, parent_id) values ('워싱턴', 5);
INSERT INTO TEAM(team_name, parent_id) values ('뉴욕', 5);
INSERT INTO TEAM(team_name, parent_id) values ('라스베이거스', 5);
INSERT INTO TEAM(team_name, parent_id) values ('타이완', 2);
INSERT INTO TEAM(team_name, parent_id) values ('도쿄', 2);
INSERT INTO TEAM(team_name, parent_id) values ('상하이', 3);
INSERT INTO TEAM(team_name, parent_id) values ('홍콩', 4);


INSERT INTO MEMBER(name, age, team_id) values('아이유', 27, 1);
INSERT INTO MEMBER(name, age, team_id) values('레드벨벳', 24, 1);
INSERT INTO MEMBER(name, age, team_id) values('비투비', 30, 2);
INSERT INTO MEMBER(name, age, team_id) values('악동뮤지션', 18, 5);
INSERT INTO MEMBER(name, age, team_id) values('씨야', 12, 4);
INSERT INTO MEMBER(name, age, team_id) values('방탄소년단', 26, 13);
INSERT INTO MEMBER(name, age, team_id) values('윤종신', 36, 12);
INSERT INTO MEMBER(name, age, team_id) values('마마무', 31, 8);
INSERT INTO MEMBER(name, age, team_id) values('트와이스', 19, 7);
INSERT INTO MEMBER(name, age, team_id) values('엑소', 33, 9);
INSERT INTO MEMBER(name, age, team_id) values('태연', 32, 9);
INSERT INTO MEMBER(name, age, team_id) values('윤하', 16, 10);