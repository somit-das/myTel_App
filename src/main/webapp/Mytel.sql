create table mytel(Name varchar2(20),MobNo number(10) unique,MailID varchar2(30) ,Password varchar2(20),Profile_Picture varchar2(4000),Address varchar2(40),CONSTRAINT PM_KEY PRIMARY KEY(Name,MobNo));
select * from mytel;
truncate table mytel;
desc mytel; 
drop table mytel purge;

create table mrecharge(MOBNO varchar(10),TYPEE varchar2(10),OPERATOR varchar2(10),CONSTRAINT PM_KEY2 PRIMARY KEY(MOBNO));
select  *  from mrecharge;
delete from mytel where Address='Balasore';
truncate table mytel;
drop table mrecharge purge;
desc mrecharge;

create table Pack_Details(Mobno varchar2(20) not null,Plan_Amount varchar2(20), Validity varchar2(20),Data_Perday varchar2(20), Recharge_Date varchar2(20),primary key(Mobno,Plan_Amount));
desc pack_details;
select * from pack_details;
truncate table pack_details;
drop table pack_details purge;

create table SimDelivery_Address(First_name varchar2(40),Last_name varchar2(40), Mobno varchar2(10),Address varchar2(40), City varchar2(40), ZipCode varchar2(6));
select * from SimDelivery_Address;
truncate table SimDelivery_Address; 
drop table SimDelivery_Address purge;
desc SimDelivery_Address;

create table Conversion_Numbers(Mobno varchar2(10),Confirmation varchar2(20));
select * from Conversion_numbers;
desc Conversion_numbers;
truncate table Conversion_numbers;
drop table Conversion_numbers purge;

create table Message(name varchar2(30),email varchar2(30),subject varchar2(30) ,msg varchar2(4000),primary key(name,email,subject,msg) );
select * from Message;
truncate table Message;
drop table message purge;
desc Message;





