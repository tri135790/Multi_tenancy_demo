create schema if not exists tenant1;
create schema if not exists tenant2;
create table tenant1.book(id bigint, name varchar(200));
create table tenant2.book(id bigint, name varchar(200));

CREATE SEQUENCE "tenant1".hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
CREATE SEQUENCE "tenant2".hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;