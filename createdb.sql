CREATE TABLE USERS(
	user_id VARCHAR(30) PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	created_date DATE NOT NULL,
	review_count INT NOT NULL,
	votes INT NOT NULL,
	average_stars NUMBER NOT NULL,
	friend_count INT NOT NULL
);

CREATE TABLE BUSINESS(
	business_id VARCHAR(30) PRIMARY KEY,
	business_name VARCHAR(100) NOT NULL,
	city VARCHAR(30) NOT NULL,
	state VARCHAR(30) NOT NULL,
	review_count INT NOT NULL,
	stars NUMBER NOT NULL
);

CREATE TABLE REVIEWS(
	review_id VARCHAR(30) PRIMARY KEY,
	author VARCHAR(30) NOT NULL,
	publish_date DATE NOT NULL,
	business_id VARCHAR(30) NOT NULL,
	stars INT CHECK (stars >= 1 AND stars <= 5),
	votes INT NOT NULL,
	FOREIGN KEY (author) REFERENCES USERS (user_id) ON DELETE SET NULL,
	FOREIGN KEY (business_id) REFERENCES USINESS (business_id) ON DELETE SET NULL
);

CREATE TABLE MAIN_CATEGORIES(
	business_id VARCHAR(30),
	main_category VARCHAR(50),
	PRIMARY KEY(business_id, main_category),
	FOREIGN KEY (business_id) REFERENCES BUSINESS(business_id) ON DELETE SET NULL
);

CREATE TABLE SUB_CATEGORIES(
	business_id VARCHAR(30),
	sub_category VARCHAR(50),
	PRIMARY KEY(business_id, sub_category),
	FOREIGN KEY (business_id) REFERENCES BUSINESS(business_id) ON DELETE SET NULL
);


CREATE TABLE BUSINESS_ATTRIBUTES(
	business_id VARCHAR(30),
	attribute_key VARCHAR(50),
	attribute_value VARCHAR(50),
	PRIMARY KEY(business_id, attribute_key),
	FOREIGN KEY(business_id) REFERENCES BUSINESS(business_id) ON DELETE SET NULL
);


CREATE INDEX mc_index ON MAIN_CATEGORIES(main_category);
CREATE INDEX sc_index ON SUB_CATEGORIES(sub_category);
CREATE INDEX ba_index ON BUSINESS_ATTRIBUTES(attribute_key, attribute_value);
CREATE INDEX u_index ON USERS(created_date, review_count, votes, average_stars, friend_count);
CREATE INDEX r_index ON REVIEWS(author, business_id, publish_date);