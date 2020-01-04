
drop table opas_user;

create table opas_user(
		role varchar2(10),
		id number(5),
		name varchar2(30),
     	email_id varchar2(30) not null,
	  	password varchar2(20) not null,
	  	mobile_no varchar2(20),
	  	city varchar2(20),
	  	locality varchar2(20),
	  	constraint opas_user_pk primary key(id)
);

create sequence user_sequence start with 100;

insert into opas_user(id,name,email_id,password,phone,city,locality)values(user_sequence.nextval,?,?,?,?,?);



drop table opas_shop;

create table opas_shop(
		id number(5),
		shop_type varchar2(10),
		shop_name varchar2(50),
		owner_id number(5),
	   	email_id varchar2(30) ,
	   	mobile_no varchar2(20),
	   	city varchar2(10),
	   	locality varchar2(20),
	   	gst_no varchar2(30) ,
	 	constraint shop_pk primary key(id),
	 	constraint shop_fk foreign key(owner_id) references opas_user(id)
);

alter table opas_shop add rating number(2,1);
alter table opas_shop modify open varchar2(1);

create sequence shop_sequence start with 100;

insert into opas_shop(id,shop_type,shop_name,owner_id,email_id,mobile_no,city,locality,gst_no)
values(shop_sequence.nextval,?,?,?,?,?,?,?,?);


drop table ordertable;

create table ordertable(
	request_id number,
	shop_id number,
	user_id number,
	time_int number,
	status varchar2(20),
	service_name varchar2(60),
	total_price number
	constraint order_pk primary key(request_id),
	constraint shop_fk2 foreign key(shop_id) references opas_shop(id),
	constraint shop_fk3 foreign key(user_id) references opas_user(id)
);

alter table ordertable add rating number;
alter table ordertable add order_time timestamp;

create sequence req_sequence start with 1;

insert into ordertable(request_id,shop_id,user_id,status,service_id) values
(req_sequence.nextval,129,161,'served',53);

drop table menuTable;

create table menuTable(
	menu_id number primary key,
	menu_name varchar2(20)
);
alter table menuTable add menu_type varchar2(10);
create sequence menu_sequence start with 50;

insert into menutable values(menu_sequence.nextval,'bleeching','men');
insert into menutable values(menu_sequence.nextval,'facial','men');
insert into menutable values(menu_sequence.nextval,'hair cutting','men');
insert into menutable values(menu_sequence.nextval,'treaming','men');
insert into menutable values(menu_sequence.nextval,'shaving','men');
insert into menutable values(menu_sequence.nextval,'massage','men');
insert into menutable values(menu_sequence.nextval,'hair dye','men');
insert into menutable values(menu_sequence.nextval,'beard dye','men');
insert into menutable values(menu_sequence.nextval,'eyebrow','men');
insert into menutable values(menu_sequence.nextval,'fruit facial','women');
insert into menutable values(menu_sequence.nextval,'rose facial','women');
insert into menutable values(menu_sequence.nextval,'neem facial','women');
insert into menutable values(menu_sequence.nextval,'mehandi','women');
insert into menutable values(menu_sequence.nextval,'forehead threading','women');
insert into menutable values(menu_sequence.nextval,'eyebrow threading','women');
insert into menutable values(menu_sequence.nextval,'menicure','women');
insert into menutable values(menu_sequence.nextval,'pedicure','women');
insert into menutable values(menu_sequence.nextval,'party package','women');
insert into menutable values(menu_sequence.nextval,'bridal package','women');


drop table menuTable2;

create table menuTable2(
	shop_id number,
	menu_id number,
	price number,
	constraint menu_fk1 foreign key(shop_id) references opas_shop(id),
	constraint menu_fk2 foreign key(menu_id) references menutable(menu_id)
);


select b.menu_name,a.request_id from ordertable a join menutable b on a.service_id= b.menu_id 
where a.status='requested'; 


select a.menu_id,a.menu_name,b.shop_id,b.price,b.menu_id from menutable a left join
(select * from menutable2  where shop_id=129) b on a.menu_id=b.menu_id where a.menu_type='men' ;


/*notification2 a*/
select service_name,request_id,time_int from ordertable where status='waiting' and user_id=${sessionScope.customer.id}

/*notification2 a*/
select a.service_name,a.request_id,a.time_int,b.shop_name from ordertable a 
left join opas_shop b
on a.shop_id=b.id
where status='waiting' and  user_id=${sessionScope.customer.id};

/* notification2 b*/
select a.request_id,a.shop_id,b.shop_name,a.service_name from ordertable a left join opas_shop b 
on a.shop_id=b.id where a.status='served' and a.user_id=${sessionScope.customer.id} and a.rating is null;







drop table opas_admin;

create table opas_admin(
	name varchar2(20),
	email_id varchar2(30),
	password varchar2(30)
);


