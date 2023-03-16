INSERT INTO authors (first_name, last_name) VALUES ('Brandon', 'Sanderson');
INSERT INTO authors (first_name, last_name) VALUES ('Robin', 'Hobb');
INSERT INTO authors (first_name, last_name) VALUES ('Stephen', 'King');
INSERT INTO authors (first_name, last_name) VALUES ('George', 'Orwell');
INSERT INTO authors (first_name, last_name) VALUES ('Charles', 'Dickens');
INSERT INTO authors (first_name, last_name) VALUES ('Ernest', 'Hemingway');

INSERT INTO genres (genre_name) VALUES ('Modernist'); // 1
INSERT INTO genres (genre_name) VALUES ('Gothic');//2
INSERT INTO genres (genre_name) VALUES ('Romance');//3
INSERT INTO genres (genre_name) VALUES ('Fantasy');//4
INSERT INTO genres (genre_name) VALUES ('Sci-Fi');//5
INSERT INTO genres (genre_name) VALUES ('Fiction');//6
INSERT INTO genres (genre_name) VALUES ('Non-fiction');//7
INSERT INTO genres (genre_name) VALUES ('Self-help');//8
INSERT INTO genres (genre_name) VALUES ('Historical fiction');//9
INSERT INTO genres (genre_name) VALUES ('Christmas');//10
INSERT INTO genres (genre_name) VALUES ('Realism');//11
INSERT INTO genres (genre_name) VALUES ('Dystopian');//12
INSERT INTO genres (genre_name) VALUES ('Political satire');//13
INSERT INTO genres (genre_name) VALUES ('Horror');//14

INSERT INTO books (isbn, genre_id, author_id, amount, title) VALUES ('1593083327', 9, 5, 10, 'A Tale of Two Cities');
INSERT INTO books (isbn, genre_id, author_id, amount, title) VALUES ('0671455990', 10, 5, 10, 'A Christmas Carol');
INSERT INTO books (isbn, genre_id, author_id, amount, title) VALUES ('9781909621411', 11, 6, 10, 'A Farewell To Arms');
INSERT INTO books (isbn, genre_id, author_id, amount, title) VALUES ('9780451524935', 12, 4, 10, '1984');
INSERT INTO books (isbn, genre_id, author_id, amount, title) VALUES ('9780451526342', 13, 4, 10, 'Animal Farm');
INSERT INTO books (isbn, genre_id, author_id, amount, title) VALUES ('9781501142970', 14, 3, 10, 'IT');
INSERT INTO books (isbn, genre_id, author_id, amount, title) VALUES ('9780007562251', 4, 2, 10, 'Assassin''s Apprentice');
INSERT INTO books (isbn, genre_id, author_id, amount, title) VALUES ('9780765365279', 4, 1, 10, 'The Way of Kings');

INSERT INTO customers (first_name, last_name, email) VALUES ('Elijah', 'Wood', 'realemail1@whoschecking.com');
INSERT INTO customers (first_name, last_name, email) VALUES ('Sean', 'Astin', 'realemail2@whoschecking.com');
INSERT INTO customers (first_name, last_name, email) VALUES ('Billy', 'Boyd', 'realemail3@whoschecking.com');
INSERT INTO customers (first_name, last_name, email) VALUES ('Dominic', 'Monaghan', 'realemail4@whoschecking.com');
INSERT INTO customers (first_name, last_name, email) VALUES ('Viggo', 'Mortensen', 'realemail5@whoschecking.com');
INSERT INTO customers (first_name, last_name, email) VALUES ('Sean', 'Bean', 'realemail6@whoschecking.com');
INSERT INTO customers (first_name, last_name, email) VALUES ('Zooey', 'Deschanel', 'realemail7@whoschecking.com');
INSERT INTO customers (first_name, last_name, email) VALUES ('Jake', ' Johnson', 'realemail8@whoschecking.com');
INSERT INTO customers (first_name, last_name, email) VALUES ('Max', 'Greenfield', 'realemail9@whoschecking.com');
INSERT INTO customers (first_name, last_name, email) VALUES ('Hannah', 'Simone', 'realemail10@whoschecking.com');
INSERT INTO customers (first_name, last_name, email) VALUES ('Nasim', 'Pedrad', 'realemail11@whoschecking.com');
INSERT INTO customers (first_name, last_name, email) VALUES ('Lamorne', 'Morris', 'realemail12@whoschecking.com');
INSERT INTO customers (first_name, last_name, email) VALUES ('Courtney', 'Cox', 'realemail13@whoschecking.com');
INSERT INTO customers (first_name, last_name, email) VALUES ('Matthew', 'Perry', 'realemail14@whoschecking.com');
INSERT INTO customers (first_name, last_name, email) VALUES ('Cobie', 'Smulders', 'realemail15@whoschecking.com');
INSERT INTO customers (first_name, last_name, email) VALUES ('Alyson', 'Hannigan', 'realemail16@whoschecking.com');
INSERT INTO customers (first_name, last_name, email) VALUES ('Jason', 'Segel', 'realemail17@whoschecking.com'); --17

INSERT INTO withdrawals (customer_id, book_id, start_date) VALUES (1, 1, '2023-03-16');
INSERT INTO withdrawals (customer_id, book_id, start_date) VALUES (2, 2, '2023-03-16');
INSERT INTO withdrawals (customer_id, book_id, start_date) VALUES (3, 3, '2023-03-16');
INSERT INTO withdrawals (customer_id, book_id, start_date) VALUES (4, 4, '2023-03-16');
INSERT INTO withdrawals (customer_id, book_id, start_date) VALUES (5, 5, '2023-03-16');



