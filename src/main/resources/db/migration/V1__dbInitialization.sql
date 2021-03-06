create table users (
    user_id serial primary key,
    name varchar(40) not null,
    password varchar(20) not null,
    address varchar(100) null,
    phone_number varchar(50) null,
    activate boolean not null
);

create table purposes (
    purpose_id serial primary key,
    title varchar(100) not null,
    creation_date date not null,
    days_tally int not null,
    user_id bigint not null,
    category_id bigint not null,
    foreign key (user_id) references users(user_id),
    foreign key (category_id) references categories(category_id)
);

create table roles(
    role_id serial primary key,
    name varchar(50) not null
);

create table users_roles(
    user_id bigint not null,
    role_id bigint not null,
    foreign key (user_id) references users(user_id),
    foreign key (role_id) references roles(role_id)
);

create table categories(
    category_id serial primary key,
    name varchar not null
);

insert into
    users (name, password, address, phone_number, activate)
    values
           ('UserAccount', '123', 'Moscow', '+74953332211', true),
           ('AdminAccount', '321', 'Saint-Petesburg', '+78125554433', true);

insert into
    roles (name)
    values
           ('User'),
           ('Admin');

insert into
    users_roles (user_id, role_id)
    values
           (1,1),(2,2);

insert into
    categories (name)
    values
           ('Healthy life');

insert into
    purposes (title, creation_date, days_tally, user_id)
    values
           ('Stop to drink corbonated drinks like coca-cola', '2021-07-17', 1, 1);