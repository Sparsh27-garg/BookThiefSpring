drop database if exists bookthief_db;
create database bookthief_db;
use  bookthief_db;

--drop sequence hibernate_sequence;
--create sequence hibernate_sequence start with 13 increment by 1;

create table login(
   user_name varchar(20),
   password varchar(20)
   );

insert into login (user_name,password) values ("admin","admin");
insert into login (user_name,password) values ("user1","user1@123");
insert into login (user_name,password) values ("user2","user2@123");
insert into login (user_name,password) values ("user3","user3@123");



create table product_fictional(
	product_id int AUTO_INCREMENT,
    product_name varchar(20),
    product_code varchar(10),
    price int,
    description varchar(200),
    image_url varchar(50),
    manufacturer varchar(30),
    ostype varchar(20),
    rating int,
    constraint ps_product_id primary key(product_id)
  );

  
insert into product_fictional(product_id,product_name,product_code,description,price,image_url,manufacturer,ostype,rating) 
         values (NULL,"The Golden Key","FIC-1","...Part Shirley Jackson's stories of inner demons, part Alice's Adventures in Wonderland...part Astrid Lindgren's faith in children's resilience and part ghost story.",380,"assets/fiction/fiction1.jpg","Marian Womack","Titan",4);
insert into product_fictional(product_id,product_name,product_code,description,price,image_url,manufacturer,ostype,rating) 
         values (NULL,"Who Fears Death","FIC-2","An award-winning literary author enters the world of magical realism with her World Fantasy Award-winning novel of a remarkable woman in post-apocalyptic Africa.",271,"assets/fiction/fiction2.jpg","Nnedi Okorafar","HarperCollins Publisher",3);
insert into product_fictional(product_id,product_name,product_code,description,price,image_url,manufacturer,ostype,rating) 
         values (NULL,"Venom","FIC-3","The first of Titan's new series of original Marvel novels, starring Spider-Man's arch foe Venom in his anti-hero role as the Lethal Protector.",349,"assets/fiction/fiction3.jpg","James R. Tuck","Titan",4);
insert into product_fictional(product_id,product_name,product_code,description,price,image_url,manufacturer,ostype,rating) 
         values (NULL,"Justice League","FIC-4","BlackThe Odyssey team are shown a dangerous secret that makes one thing clear -- they must escape the Ghost Sector!",747,"assets/fiction/fiction4.jpg","Joshua Williamson","DC Comics",3);
         
         


create table product_bestsellers(
	product_id int AUTO_INCREMENT,
    product_name varchar(20),
    product_code varchar(10),
    price int,
    description varchar(200),
    image_url varchar(50),
    manufacturer varchar(30),
    ostype varchar(20),
    rating int,
    constraint ps_product_id primary key(product_id)
  );

insert into product_bestsellers(product_id,product_name,product_code,description,price,image_url,manufacturer,ostype,rating)
        values (NULL, "Think and Grow Rich","BS-1","To know about yourself",105,"assets/bestsellers/bs1.jpg","Napolean Hill","Amazing Reads",4);

insert into product_bestsellers(product_id,product_name,product_code,description,price,image_url,manufacturer,ostype,rating)
        values (NULL, "Objective General English","BS-2","For your general english purposes",171,"assets/bestsellers/bs2.jpg","S.P. Bakshi", "Arihant",4);

insert into product_bestsellers(product_id,product_name,product_code,description,price,image_url,manufacturer,ostype,rating)
        values (NULL, "The Immortals of Meluha","BS-3","This is the first book in a trilogy on Shiva, the simple man whose karma re-cast him as our Mahadev, the God of Gods.",349,"assets/bestsellers/bs3.jpg","Amish Tripathi","Westland Publication Limited",4);

insert into product_bestsellers(product_id,product_name,product_code,description,price,image_url,manufacturer,ostype,rating)
        values (NULL,"The Power of Your Subconscious Mind","BS-4","It deals with unknown fact on which our brain act",135,"assets/bestsellers/bs4.jpg","Murphy Joseph","Amazing Reads",3);

insert into product_bestsellers(product_id,product_name,product_code,description,price,image_url,manufacturer,ostype,rating)
        values (NULL,"Harry Potter and the Philosopher's Stone","BS-5","Most thrilling harry potter story",271,"assets/bestsellers/bs5.jpg","J.K. Rowling","Bloomsbury Publishing PLC",4);

insert into product_bestsellers(product_id,product_name,product_code,description,price,image_url,manufacturer,ostype,rating)
        values (NULL,"Firefly - Big Damn Hero","BS-6",	 "The original novel tying into the critically acclaimed and much-missed Firefly series from creator Joss Whedon.",380,"assets/romance/romance2.jpg","Nancy Holder","Titan Books (UK)",4);

insert into product_bestsellers(product_id,product_name,product_code,description,price,image_url,manufacturer,ostype,rating)
        values (NULL,"Red, White & Royal Blue","BS-7","Red, White & Royal Blue is outrageously fun. It is romantic, sexy, witty, and thrilling.",334,"assets/romance/romance3.jpg","Casey McQuiston","St. Martin's Griffin",3);

insert into product_bestsellers(product_id,product_name,product_code,description,price,image_url,manufacturer,ostype,rating)
        values (NULL,"Poemsia","BS-8","VERITY WOLF dreams of being a poet--not that she'd ever admit it to anyone. ",412,"assets/romance/romance4.jpg","Lang Leav","Andrews McMeel Publishing",4);        
  
  
commit;
select * from login;