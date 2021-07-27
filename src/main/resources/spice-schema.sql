drop table if exists spice CASCADE;

create table spice 

(
	id integer PRIMARY KEY AUTO_INCREMENT, 
	price integer not null, 
	name varchar(255) unique,
	flavourRating integer not null,
	cuisine varchar(255)
);