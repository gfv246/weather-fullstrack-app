BEGIN TRANSACTION;

DROP TABLE IF EXISTS weather, users CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE weather (
    weather_id serial PRIMARY KEY,
    user_id int,
    zipcode int,
    name varchar(255),
    weather_date DATE,
    temp numeric(8, 4),
    feels_like numeric(8, 4),
    humidity int,
    description varchar(255),
    CONSTRAINT FK_weather_users FOREIGN KEY (user_id)
    REFERENCES users (user_id)
);

COMMIT TRANSACTION;
