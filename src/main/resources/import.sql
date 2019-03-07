DELETE FROM AUDITORIUM

INSERT INTO AUDITORIUM (NAME, SEATS_NUMBER, VIP_SEATS) VALUES ('Blue hall', 500, '25,26,27,28,29,30,31,32,33,34,35');
INSERT INTO AUDITORIUM (NAME, SEATS_NUMBER, VIP_SEATS) VALUES ('Red hall', 800, '25,26,27,28,29,30,31,32,33,34,35,75,76,77,78,79,80,81,82,83,84,85');
INSERT INTO AUDITORIUM (NAME, SEATS_NUMBER, VIP_SEATS) VALUES ('Yellow hall', 1000, '25,26,27,28,29,30,31,32,33,34,35,75,76,77,78,79,80,81,82,83,84,85,105,106,107,108,109,110,111,112,113,114,115');


DELETE FROM EVENT

INSERT INTO EVENT(NAME, RATE, BASE_PRICE, DATE_TIME, AUDITORIUM) VALUES('Kvitka Concert', 'MID', 94.5, '2019-02-27 10:00:00.000', 3)

DELETE FROM USER

INSERT INTO USER(EMAIL, NAME, EVENT_DATE) VALUES('oleksii@gmail.ru', 'Oleksii', '2017-06-25')

INSERT INTO USER(EMAIL, NAME, EVENT_DATE, PASSWORD, ROLES) VALUES('user@mail.ru', 'user', '2017-06-25', 'password', 'ROLE_RESGISTERED_USER')

INSERT INTO USER(EMAIL, NAME, EVENT_DATE, PASSWORD, ROLES) VALUES('manager@gmail.ru', 'manager', '2017-06-25', 'password', 'ROLE_RESGISTERED_USER,ROLE_BOOKING_MANAGER')

DELETE FROM TICKET

INSERT INTO TICKET(EVENT, DATE_TIME, SEATS, USER, PRICE) VALUES(1, '2019-02-27 10:00:00.000', '5,6', 1, 189.0)

DELETE FROM BOOKING

INSERT INTO BOOKING(USER, TICKET) VALUES(1, 1)