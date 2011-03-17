create table Ace_AceClimateImpact (
	impactId bigint not null primary key,
	impact VARCHAR(75) null
);

create table Ace_AceElement (
	elementId bigint not null primary key,
	element VARCHAR(75) null
);

create table Ace_AceSector (
	sectorId bigint not null primary key,
	sector VARCHAR(75) null
);

create table Ace_Items_ClimateImpacts (
	aceItemId bigint not null,
	impactId bigint not null,
	primary key (aceItemId, impactId)
);

create table Ace_Items_Elements (
	aceItemId bigint not null,
	elementId bigint not null,
	primary key (aceItemId, elementId)
);

create table Ace_Items_Sectors (
	sectorId bigint not null,
	aceItemId bigint not null,
	primary key (sectorId, aceItemId)
);

create table Ace_AceItem (
	aceitemid bigint not null primary key,
	companyid bigint,
	groupid bigint,
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
	spatialvalues character varying(75) ,
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
  START 1
  CACHE 1;
ALTER TABLE ace_aceitem_id_seq OWNER TO postgres;

ALTER TABLE ace_aceitem ALTER COLUMN aceitemid SET DEFAULT nextval('ace_aceitem_id_seq'::regclass);
