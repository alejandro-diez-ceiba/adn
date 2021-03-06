INSERT INTO TYPE_DOCUMENT(ID, DESCRIPTION) VALUES (1, 'CC');
INSERT INTO TYPE_DOCUMENT(ID, DESCRIPTION) VALUES (2, 'NIT');


INSERT INTO USER(ID, DOCUMENT, FULL_NAME, PASSWORD, TYPE_DOCUMENT_ID)
    VALUES(1, 1017249864, 'Pepito Cardenas', '2222222', 1);


INSERT INTO CUSTOMER(ID, DOCUMENT, FULL_NAME, ADDRESS, PHONE, TYPE_DOCUMENT_ID)
    VALUES(1, 1017253624, 'Cristiano Ronaldo', 'Colombia, Medellin, Calle 23 # 11-12', '3257891245', 1);
INSERT INTO CUSTOMER(ID, DOCUMENT, FULL_NAME, ADDRESS, PHONE, TYPE_DOCUMENT_ID)
    VALUES(2, 1017418974, 'Karim Benzema', 'Colombia, Medellin, Calle 80 # 78-102', '3155487945', 1);


INSERT INTO PROVIDER(ID, DOCUMENT, FULL_NAME, ADDRESS, PHONE, TYPE_DOCUMENT_ID)
    VALUES(1, 9058745, 'Activision', 'Santa Monica, California', '10058945132', 2);
INSERT INTO PROVIDER(ID, DOCUMENT, FULL_NAME, ADDRESS, PHONE, TYPE_DOCUMENT_ID)
    VALUES(2, 9002489, 'SIE Santa Monica Studio', 'Los Angeles, California', '10078945213', 2);


INSERT INTO LANGUAGE(ID, NAME) VALUES(1, 'Frances');
INSERT INTO LANGUAGE(ID, NAME) VALUES(2, 'Ingles');
INSERT INTO LANGUAGE(ID, NAME) VALUES(3, 'Portugues');


INSERT INTO PLATFORM(ID, NAME) VALUES(1, 'Ps');
INSERT INTO PLATFORM(ID, NAME) VALUES(2, 'Xbox');
INSERT INTO PLATFORM(ID, NAME) VALUES(3, 'Nintendo');
INSERT INTO PLATFORM(ID, NAME) VALUES(4, 'Pc');


INSERT INTO GAME(ID, NAME, LAUNCH, PRICE, PLATFORM_ID, LANGUAGE_ID)
    VALUES(1, 'Horizon Zero Dawn', '2017-02-27', 120000, 1, 2);


INSERT INTO KARDEX(ID, TRANSACTION, ENTRY_OR_EXIT, QUANTITY, PRICE, PROVIDER_ID, GAME_ID)
    VALUES(1, '2020-10-14', true, 5, 250000, 1, 1);