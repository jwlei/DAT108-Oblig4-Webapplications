drop schema oblig4;
create schema oblig4;
use oblig4;

CREATE TABLE person
(
    mobil			varchar(50),
    fornavn			varchar(50),
    etternavn		varchar(50),
    passordhash		varchar(50),
    passordsalt		varchar(50),
    kjonn			varchar(50),
    PRIMARY KEY (mobil)
);