create table role
(
  pk_role int auto_increment,
  name varchar(255) not null,
  constraint role_pk
    primary key (pk_role)
) DEFAULT CHARSET=utf8;

create unique index role_name_uindex
on role (name);

create table user_account
(
  pk_user_account int auto_increment,
  user_login varchar(255) not null,
  user_password varchar(255) not null,
  constraint user_account_pk
    primary key (pk_user_account)
) DEFAULT CHARSET=utf8;

create unique index user_account_user_login_uindex
on user_account (user_login);

create table user_account_role
(
  pk_user_account_role int auto_increment,
  fk_user_account int not null,
  fk_role int not null,
  constraint user_account_role_pk
    primary key (pk_user_account_role),
  constraint pk_role
    foreign key (fk_role) references role (pk_role),
  constraint pk_user_account
    foreign key (fk_user_account) references user_account (pk_user_account)
) DEFAULT CHARSET=utf8;

alter table accountant
  add fk_user int null;

alter table accountant
  add constraint pk_user
    foreign key (fk_user) references user_account (pk_user_account);

alter table economic_officer
  add fk_user int null;

alter table economic_officer
  add constraint economic_officer_user
    foreign key (fk_user) references user_account (pk_user_account);

alter table university_worker
  add fk_user int null;

alter table university_worker
  add constraint university_worker_user
    foreign key (fk_user) references user_account (pk_user_account);



