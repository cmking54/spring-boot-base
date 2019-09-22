DROP TABLE IF EXISTS DOG;
DROP TABLE IF EXISTS KEEPER;
CREATE TABLE dog
(
   dog_id BIGINT AUTO_INCREMENT PRIMARY KEY,
   name varchar (16) not null,
   breed VARCHAR (16) not null,
   size char (2) not null
   --KEEPER_ID BIGINT
);
CREATE TABLE KEEPER
(
   KEEPER_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
   name varchar (16) not null,
   dog_id bigint
);
--ALTER table DOG ADD FOREIGN KEY (KEEPER_ID) REFERENCES KEEPER(KEEPER_ID);
--alter table keeper add FOREIGN KEY (dog_id) REFERENCES dog(dog_id);