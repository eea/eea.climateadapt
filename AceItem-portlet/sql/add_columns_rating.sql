alter table ace_aceitem
add column rating bigint;

alter table ace_aceitem
add column importance bigint;

update ace_aceitem set rating = 0, importance = 0;