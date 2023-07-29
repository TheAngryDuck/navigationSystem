drop table reports if exists;
drop table base_stations if exists;
drop table mobile_stations if exists;

create table base_stations(id numeric primary key AUTO_INCREMENT,name varchar(255),x_coordinate float,y_coordinate float,detection_radius float);
create table mobile_stations(id numeric primary key AUTO_INCREMENT,last_known_x_coordinate float,last_known_y_coordinate float);
create table reports(id numeric primary key AUTO_INCREMENT,mobile_station_id numeric,foreign key (mobile_station_id) references mobile_stations(id),
base_station_id numeric,foreign key (base_station_id) references base_stations(id), distance float, log_time timestamp);

