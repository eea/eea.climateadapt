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