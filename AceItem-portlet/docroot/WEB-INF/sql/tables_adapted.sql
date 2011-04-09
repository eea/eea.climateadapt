create table ace_aceitem (
	aceitemid bigint not null primary key,
	companyid bigint,
	groupid bigint,
	nasid bigint,
	name character varying(255) ,
	description text,
	datatype  character varying(255) ,
	storedat  character varying(255) ,
	storagetype character varying(255) ,
	language character varying(24) ,
	textSearch text,
	keyword character varying(2048) ,
	targetresolution character varying(255) ,
	spatiallayer character varying(75) ,
	spatialvalues character varying(255) ,
	startdate timestamp without time zone,
	enddate timestamp without time zone,
	publicationDate timestamp without time zone,
	sectors_ character varying(255) ,
	elements_ character varying(255) ,
	climateimpacts_ character varying(255)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ace_aceitem OWNER TO postgres;

CREATE SEQUENCE ace_aceitem_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 100898
  CACHE 1;
ALTER TABLE ace_aceitem_id_seq OWNER TO postgres;

ALTER TABLE ace_aceitem ALTER COLUMN aceitemid SET DEFAULT nextval('ace_aceitem_id_seq'::regclass);

CREATE TABLE ace_nas
(
  nasid bigint NOT NULL,
  "name" character varying(255),
  adoptedstatus character varying(255),
  adopteddescription character varying(255),
  companyid bigint,
  groupid bigint,
  parentnasid bigint,
  isocountry character varying(2),
  CONSTRAINT ace_nas_pkey PRIMARY KEY (nasid),
  CONSTRAINT ace_nas_parent_fk FOREIGN KEY (parentnasid)
      REFERENCES ace_nas (nasid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ace_nas OWNER TO postgres;

CREATE TABLE ace_nassource
(
  nassourceid bigint NOT NULL,
  nasid bigint,
  "name" character varying(255),
  companyid bigint,
  groupid bigint,
  CONSTRAINT ace_nassource_pkey PRIMARY KEY (nassourceid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ace_nassource OWNER TO postgres;

