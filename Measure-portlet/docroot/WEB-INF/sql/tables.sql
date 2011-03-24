create table ace_measure (
	measureid bigint not null,
	companyid bigint,
	groupid bigint,
	name character varying(255) ,
	description text,
	implementationtype character varying(3800) ,
	implementationtime bigint,
	lifetime bigint,
	spatiallayer character varying(75) ,
	spatialvalues character varying(75) ,
	legalaspects character varying(3800) ,
	stakeholderparticipation character varying(3800) ,
	contact character varying(3800) ,
	succeslimitations character varying(3800) ,
    website character varying(1024),
	costbenefit character varying(3800) ,
	keywords character varying(3800) ,
	startdate timestamp without time zone,
	enddate timestamp without time zone,
	publicationDate timestamp without time zone,
	language character varying(24) DEFAULT 'en_UK',
	sectors_ character varying(255) ,
	elements_ character varying(255) ,
	climateimpacts_ character varying(255) ,
	mao_type VARCHAR(24) null ,
    CONSTRAINT ace_measure_pkey PRIMARY KEY (measureid)
)
WITH (
  OIDS=FALSE
);
