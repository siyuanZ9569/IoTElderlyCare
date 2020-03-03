drop table user;
drop table resident;
drop table  door_sensor;
drop table flow_meter;
drop table time_stamp;

CREATE TABLE user (
	user_id BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    pass_word VARCHAR(255),
    resident_id BIGINT,
    user_name VARCHAR(255),
    
    PRIMARY KEY (user_id)
);

CREATE TABLE resident (
	resident_id BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    
    PRIMARY KEY (resident_id)
);

CREATE TABLE door_sensor (
	sensor_id BIGINT NOT NULL AUTO_INCREMENT,
    resident_id BIGINT,
    
    PRIMARY KEY (sensor_id)
);

CREATE TABLE flow_meter (
	sensor_id BIGINT NOT NULL AUTO_INCREMENT,
    resident_id BIGINT,
    
    PRIMARY KEY (sensor_id)
);

CREATE TABLE time_stamp (
	time_stamp_id BIGINT NOT NULL AUTO_INCREMENT,
    time_stamp VARCHAR(255),
    information VARCHAR(255),
    resident_id BIGINT,
    sensor_id BIGINT,
    
    PRIMARY KEY (time_stamp_id)
);

CREATE TABLE sensor (
	sensor_id BIGINT NOT NULL AUTO_INCREMENT,
    resident_id BIGINT,
    
    PRIMARY KEY (sensor_id)
);

insert into sensor (sensor_id, resident_id)
VALUES (800, 1);

