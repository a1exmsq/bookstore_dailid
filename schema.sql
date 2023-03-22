	DROP TABLE books;

	CREATE TABLE IF NOT exists books (
		id BIGSERIAL PRIMARY KEY,
		author VARCHAR(255),
		isbn VARCHAR(17) UNIQUE,
		publishing_house VARCHAR(255),
		publishing_year SMALLINT,
		type_of_cover VARCHAR(255),
		number_of_pages SMALLINT,
		price DECIMAL(5,2)
	);

	ALTER TABLE books ADD COLUMN title VARCHAR (255);

	ALTER TABLE books ADD CONSTRAINT constraint_name UNIQUE (isbn);