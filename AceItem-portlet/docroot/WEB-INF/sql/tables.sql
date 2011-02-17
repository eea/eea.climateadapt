create table Ace_AceItem (
	aceItemId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	type_ VARCHAR(75) null,
	storedAt VARCHAR(75) null,
	sector VARCHAR(75) null,
	pilar VARCHAR(75) null,
	textSearch VARCHAR(75) null,
	keyword VARCHAR(75) null,
	nutsId VARCHAR(75) null,
	nutsLevel VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null
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