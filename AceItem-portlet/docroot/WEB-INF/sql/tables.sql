create table Ace_AceItem (
	aceItemId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	nasId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	datatype VARCHAR(75) null,
	storedAt VARCHAR(75) null,
	storagetype VARCHAR(75) null,
	language VARCHAR(75) null,
	textSearch VARCHAR(75) null,
	keyword VARCHAR(75) null,
	targetresolution VARCHAR(75) null,
	spatialLayer VARCHAR(75) null,
	spatialValues VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	publicationDate DATE null,
	sectors_ VARCHAR(75) null,
	elements_ VARCHAR(75) null,
	climateimpacts_ VARCHAR(75) null
);

create table Ace_NAS (
	nasId LONG not null primary key,
	name VARCHAR(75) null,
	adoptedStatus VARCHAR(75) null,
	adoptedDescription VARCHAR(75) null,
	companyId LONG,
	groupId LONG,
	parentNasId LONG,
	isoCountry VARCHAR(75) null
);

create table Ace_NASSource (
	nassourceid LONG not null primary key,
	nasId LONG,
	name VARCHAR(75) null,
	companyId LONG,
	groupId LONG
);

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