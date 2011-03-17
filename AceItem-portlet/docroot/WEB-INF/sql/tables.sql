create table Ace_AceClimateImpact (
	impactId LONG not null primary key,
	impact VARCHAR(75) null
);

create table Ace_AceElement (
	elementId LONG not null primary key,
	element VARCHAR(75) null
);

create table Ace_AceSector (
	sectorId LONG not null primary key,
	sector VARCHAR(75) null
);

create table Ace_Items_ClimateImpacts (
	aceItemId LONG not null,
	impactId LONG not null,
	primary key (aceItemId, impactId)
);

create table Ace_Items_Elements (
	aceItemId LONG not null,
	elementId LONG not null,
	primary key (aceItemId, elementId)
);

create table Ace_Items_Sectors (
	sectorId LONG not null,
	aceItemId LONG not null,
	primary key (sectorId, aceItemId)
);

create table Ace_AceItem (
	aceItemId LONG not null primary key,
	companyId LONG,
	groupId LONG,
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

create table ace_aceitem (
	aceitemid bigint not null,
	companyid bigint,
	groupid bigint,
	name character varying(254) ,
	description text ,
	type_ character varying(254) ,
	storedat character varying(254),
	sector character varying(254) ,
	pilar character varying(254) ,
	textsearch text ,
	keyword character varying(254) ,
	nutsid character varying(75) ,
	nutslevel character varying(75),
	startdate  timestamp without time zone,
	enddate  timestamp without time zone,
  CONSTRAINT ace_aceitem_pkey PRIMARY KEY (aceitemid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ace_aceitem OWNER TO postgres;