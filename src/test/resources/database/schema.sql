CREATE TABLE LOCALIZED(
    ID BIGINT NOT NULL,
    LOCALIZED VARCHAR(255),
    LOCALIZED_KEY VARCHAR(255) NOT NULL
);

ALTER TABLE LOCALIZED ADD CONSTRAINT CONSTRAINT_5E PRIMARY KEY(ID, LOCALIZED_KEY);

CREATE TABLE PERSON(
    ID BIGINT NOT NULL
);

ALTER TABLE PERSON ADD CONSTRAINT CONSTRAINT_8 PRIMARY KEY(ID);

ALTER TABLE LOCALIZED ADD CONSTRAINT FKB833C37B9F844D09 FOREIGN KEY(ID) REFERENCES PERSON(ID);
