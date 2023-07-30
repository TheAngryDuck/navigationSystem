drop table reports if exists;
drop table base_stations if exists;
drop table mobile_stations if exists;

create table base_stations(id numeric primary key AUTO_INCREMENT,name varchar(255),x_coordinate float,y_coordinate float,detection_radius float);
create table mobile_stations(id numeric primary key AUTO_INCREMENT,last_known_x_coordinate float,last_known_y_coordinate float);
create table reports(id numeric primary key AUTO_INCREMENT,mobile_station_id numeric,foreign key (mobile_station_id) references mobile_stations(id),
base_station_id numeric,foreign key (base_station_id) references base_stations(id), distance float, log_time timestamp);

INSERT INTO base_stations (id, name, x_coordinate, y_coordinate, detection_radius) VALUES (1, 'Alpha', 0, 0, 1);
INSERT INTO base_stations (id, name, x_coordinate, y_coordinate, detection_radius) VALUES (2, 'Beta', 0, 0, 2);
INSERT INTO base_stations (id, name, x_coordinate, y_coordinate, detection_radius) VALUES (3, 'Gamma', 0, 0, 3);
INSERT INTO base_stations (id, name, x_coordinate, y_coordinate, detection_radius) VALUES (4, 'Delta', 0, 0, 4);
INSERT INTO base_stations (id, name, x_coordinate, y_coordinate, detection_radius) VALUES (5, 'Epsilon', 0, 0, 5);

INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (1, 0.5, 0.5);
INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (2, 1.5, 1.5);
INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (3, 2.5, 2.5);
INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (4, 3.5, 3.5);
INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (5, 4.5, 4.5);

INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (6, -0.5, -0.5);
INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (7, -1.5, -1.5);
INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (8, -2.5, -2.5);
INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (9, -3.5, -3.5);
INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (10, -4.5, -4.5);

INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (11, 1, 1);
INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (12, 2, 2);
INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (13, 3, 3);
INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (14, 4, 4);
INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (15, 5, 5);

INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (16, -1, -1);
INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (17, -2, -2);
INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (18, -3, -3);
INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (19, -4, -4);
INSERT INTO mobile_stations (id, last_known_x_coordinate, last_known_y_coordinate) VALUES (20, -5, -5);
