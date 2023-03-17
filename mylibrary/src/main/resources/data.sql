INSERT INTO authors (first_name, last_name) VALUES ('Brandon', 'Sanderson');
INSERT INTO authors (first_name, last_name) VALUES ('Robin', 'Hobb');
INSERT INTO authors (first_name, last_name) VALUES ('Stephen', 'King');
INSERT INTO authors (first_name, last_name) VALUES ('George', 'Orwell');
INSERT INTO authors (first_name, last_name) VALUES ('Charles', 'Dickens');
INSERT INTO authors (first_name, last_name) VALUES ('Ernest', 'Hemingway');
INSERT INTO authors (first_name, last_name) VALUES ('Robert', 'Jordan');

INSERT INTO genres (genre_name) VALUES ('Modernist');
INSERT INTO genres (genre_name) VALUES ('Gothic');
INSERT INTO genres (genre_name) VALUES ('Romance');
INSERT INTO genres (genre_name) VALUES ('Fantasy');
INSERT INTO genres (genre_name) VALUES ('Sci-Fi');
INSERT INTO genres (genre_name) VALUES ('Fiction');
INSERT INTO genres (genre_name) VALUES ('Non-fiction');
INSERT INTO genres (genre_name) VALUES ('Self-help');
INSERT INTO genres (genre_name) VALUES ('Historical fiction');
INSERT INTO genres (genre_name) VALUES ('Christmas');
INSERT INTO genres (genre_name) VALUES ('Realism');
INSERT INTO genres (genre_name) VALUES ('Dystopian');
INSERT INTO genres (genre_name) VALUES ('Political satire');
INSERT INTO genres (genre_name) VALUES ('Horror');
INSERT INTO genres (genre_name) VALUES ('War');

INSERT INTO statuses (status) VALUES ('IN STOCK');
INSERT INTO statuses (status) VALUES ('IN STOCK');
INSERT INTO statuses (status) VALUES ('WITHDRAWN');
INSERT INTO statuses (status) VALUES ('NO STOCK');

INSERT INTO books (isbn, title, status_id) VALUES ('1593083327', 'A Tale of Two Cities', 1);
INSERT INTO books (isbn, title, status_id) VALUES ('0671455990', 'A Christmas Carol', 1);
INSERT INTO books (isbn, title, status_id) VALUES ('9781909621411', 'A Farewell To Arms', 1);
INSERT INTO books (isbn, title, status_id) VALUES ('9780451524935', '1984', 1);
INSERT INTO books (isbn, title, status_id) VALUES ('9780451526342', 'Animal Farm', 1);
INSERT INTO books (isbn, title, status_id) VALUES ('9781501142970', 'IT', 2);
INSERT INTO books (isbn, title, status_id) VALUES ('9780007562251', 'Assassin''s Apprentice', 3);
INSERT INTO books (isbn, title, status_id) VALUES ('9780765365279', 'The Way of Kings', 3);
INSERT INTO books (isbn, title, status_id) VALUES ('9780356503950', 'A Memory of Light', 3);

INSERT INTO books_authors (book_id, author_id) VALUES (1, 5);
INSERT INTO books_authors (book_id, author_id) VALUES (2, 5);
INSERT INTO books_authors (book_id, author_id) VALUES (3, 6);
INSERT INTO books_authors (book_id, author_id) VALUES (4, 4);
INSERT INTO books_authors (book_id, author_id) VALUES (5, 4);
INSERT INTO books_authors (book_id, author_id) VALUES (6, 3);
INSERT INTO books_authors (book_id, author_id) VALUES (7, 2);
INSERT INTO books_authors (book_id, author_id) VALUES (8, 1);
INSERT INTO books_authors (book_id, author_id) VALUES (9, 1);
INSERT INTO books_authors (book_id, author_id) VALUES (9, 7);

INSERT INTO books_genres (book_id, genre_id) VALUES (1, 9);
INSERT INTO books_genres (book_id, genre_id) VALUES (2, 9);
INSERT INTO books_genres (book_id, genre_id) VALUES (2, 10);
INSERT INTO books_genres (book_id, genre_id) VALUES (3, 11);
INSERT INTO books_genres (book_id, genre_id) VALUES (3, 15);
INSERT INTO books_genres (book_id, genre_id) VALUES (4, 12);
INSERT INTO books_genres (book_id, genre_id) VALUES (4, 13);
INSERT INTO books_genres (book_id, genre_id) VALUES (5, 12);
INSERT INTO books_genres (book_id, genre_id) VALUES (5, 13);
INSERT INTO books_genres (book_id, genre_id) VALUES (6, 14);
INSERT INTO books_genres (book_id, genre_id) VALUES (7, 6);
INSERT INTO books_genres (book_id, genre_id) VALUES (8, 6);


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
INSERT INTO customers (first_name, last_name, email) VALUES ('Jason', 'Segel', 'realemail17@whoschecking.com');

INSERT INTO withdrawals (customer_id, book_id, start_date) VALUES (1, 1, '2023-03-16');
INSERT INTO withdrawals (customer_id, book_id, start_date) VALUES (2, 2, '2023-03-16');
INSERT INTO withdrawals (customer_id, book_id, start_date) VALUES (3, 3, '2023-03-16');
INSERT INTO withdrawals (customer_id, book_id, start_date) VALUES (4, 4, '2023-03-16');
INSERT INTO withdrawals (customer_id, book_id, start_date) VALUES (5, 5, '2023-03-16');



