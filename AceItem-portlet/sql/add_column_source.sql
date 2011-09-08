alter table ace_aceitem
add column source character varying(75);

update ace_aceitem
set datatype='GUIDANCE'
where datatype='TOOLGUIDANCE';