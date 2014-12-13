-- ------------------------------------------------------------------------
-- Licensed to the Apache Software Foundation (ASF) under one or more
-- contributor license agreements. See the NOTICE file distributed with
-- this work for additional information regarding copyright ownership.
-- The ASF licenses this file to You under the Apache License, Version 2.0
-- (the "License"); you may not use this file except in compliance with
-- the License. You may obtain a copy of the License at
--
-- http://www.apache.org/licenses/LICENSE-2.0
--
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
-- ------------------------------------------------------------------------

CREATE TABLE person(
  id INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  firstName VARCHAR(100) DEFAULT NULL,
  lastName VARCHAR(100) DEFAULT NULL
);


CREATE TABLE Product(
  id INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  name VARCHAR(100) DEFAULT NULL,
  description VARCHAR(100) DEFAULT NULL,
  category VARCHAR(100) DEFAULT NULL,
  price VARCHAR(100) DEFAULT NULL
);


CREATE TABLE CustomerOrder(
  id INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  name VARCHAR(100) DEFAULT NULL,
  street VARCHAR(100) DEFAULT NULL,
  city VARCHAR(100) DEFAULT NULL,
  state VARCHAR(100) DEFAULT NULL,
  zip VARCHAR(100) DEFAULT NULL,
  country VARCHAR(20) DEFAULT NULL,
  giftwarp BOOLEAN 
  );

insert into person (firstName,lastName) values ('Rajesh','Das');
insert into person (firstName,lastName) values ('Pabitra','Mallick');
insert into person (firstName,lastName) values ('Parin','Das');





Insert into Product (name,description,category,price) values ('Kayak','A boat for one person','Watersports','275');
Insert into Product (name,description,category,price) values ('Lifejacket','Protective and fashionable','Watersports','48.95');
Insert into Product (name,description,category,price) values ('Soccer Ball','FIFA-approved size and weight','Soccer','19.5');
Insert into Product (name,description,category,price) values ('Corner Flags','Give your playing field a professional touch','Soccer','34.95');
Insert into Product (name,description,category,price) values ('Stadium','Flat-packed 35,000-seat stadium','Soccer','79500');
Insert into Product (name,description,category,price) values ('Thinking Cap','Improve your brain efficiency by 75%','Chess','16');
Insert into Product (name,description,category,price) values ('Unsteady Chair','secretly give your opponent a disadvantage','Chess','29.95');
Insert into Product (name,description,category,price) values ('Human Chess Board','A fun game for the family','Chess','75');
Insert into Product (name,description,category,price) values ('Bling-Bling King','Gold-plated, dimond-studded King','Chess','1200');

