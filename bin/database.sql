drop table Client_info
drop table Books
drop table Registered_writer
drop table Non_registered_writer
drop table Publisher
drop table Reviews


create table Client_info(
    Cl_no int auto_increment,
    Username varchar2(30),
    Pass varchar2(30),
    Cl_name varchar2(30),
    Email varchar2(50),
    Occupation varchar2(30),
    Country varchar2(30),
    Gender varchar2(7),
    Birthdate varchar2(20),
    Alma_mater varchar2(75),
    WPR varchar2(10),
    Study_field varchar2(15),
    Type_code int,
    primary key (Cl_no, Username)
);

create table Books(
    Si_no int auto_increment primary key,
    Book_name varchar2(60),
    Topic varchar2(15),
    Writer varchar2(30),
    Publication varchar2(50) default(null),
    Five_stars int default 0,
    Four_stars int default 0,
    Three_stars int default 0,
    Two_stars int default 0,
    One_stars int default 0,
    Year_pub varchar2(5),
    Adder varchar2(30) default(null)
);

create table Registered_writer(
    Username varchar2(30) primary key,
    No_of_books int default 0,
    No_of_5_stars int default 0,
);

create table Non_registered_writer(
    Wr_name varchar2(30) primary key,
    No_of_books int default 0,
    No_of_5_stars int default 0,
    Country varchar2(30),
    Lang varchar2(15)
);

create table Publisher(
    Username varchar2(30) default "admin",
    Publication varchar2(50) primary key,
    No_of_books int default 0,
    No_of_5_stars int default 0,
    Country varchar2(30)
);

create table Reviews(
    Serial_no int auto_increment primary key,
    Username varchar2(30),
    Book_name varchar2(60),
    Topic varchar2(15),
    Stars int,
    Review varchar2(600),
    Time_added varchar2(20)
);