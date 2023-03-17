DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS withdrawals;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS books_authors;
DROP TABLE IF EXISTS books_genres;
DROP TABLE IF EXISTS genres;
DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS statuses;

CREATE TABLE customers(
   customer_id identity primary key,
   first_name varchar(100) not null,
   last_name varchar(100) not null,
   email varchar(100) not null
);

CREATE TABLE withdrawals(
    withdrawal_id identity primary key,
    customer_id int not null,
    book_id int not null,
    start_date date not null
);

CREATE TABLE books(
    book_id identity primary key,
    isbn varchar(100) not null,
    title varchar(100) not null,
    status_id int not null,
    withdrawal_id int
);

CREATE TABLE books_authors(
    books_authors_id identity primary key,
    book_id int not null,
    author_id int not null
);

CREATE TABLE books_genres(
      books_genres_id identity primary key,
      book_id int not null,
      genre_id int not null
);

CREATE TABLE statuses(
     status_id identity primary key,
     status varchar(40)
);

CREATE TABLE genres(
    genre_id identity primary key,
    genre_name varchar(100) not null
);

CREATE TABLE authors(
    author_id identity primary key,
    first_name varchar(100) not null,
    last_name varchar(100) not null
);