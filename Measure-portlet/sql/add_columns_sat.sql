alter table am_temp
add column lon double precision;

alter table am_temp
add column lat double precision;

alter table am_temp
add column satarea character varying(254);


alter table acemeasure
add column lon double precision;

alter table acemeasure
add column lat double precision;

alter table acemeasure
add column satarea character varying(254);


alter table ace_measure
add column lon double precision;

alter table ace_measure
add column lat double precision;

alter table ace_measure
add column satarea character varying(254);
