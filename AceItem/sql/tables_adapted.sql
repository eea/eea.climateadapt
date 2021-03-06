create table ace_aceitem (
  aceitemid bigint NOT NULL ,
  companyid bigint,
  groupid bigint,
  wxsharvesterid bigint,
  cswharvesterid bigint,
  "name" character varying(255),
  description text,
  datatype character varying(255),
  storedat text,
  storagetype character varying(255),
  specialtagging character varying(75) DEFAULT NULL::character varying,
  textsearch text,
  keyword text,
  targetresolution character varying(255),
  spatiallayer character varying(75),
  spatialvalues character varying(255),
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  publicationdate timestamp without time zone,
  sectors_ character varying(255),
  elements_ character varying(255),
  climateimpacts_ character varying(255),
  rating bigint,
  importance bigint,
  source character varying(75),
  deeplink text,
  controlstatus smallint,
  creator character varying(75),
  creationdate timestamp without time zone,
  moderator character varying(2000),
  approvaldate timestamp without time zone,
  replacesid bigint,
  comments text,
  textwebpage text,
  "year" character varying(7),
  geochars text,
  feature character varying(75),
  scenario character varying(75),
  timeperiod character varying(75),
  lockdate timestamp without time zone,
  CONSTRAINT ace_aceitem_pkey PRIMARY KEY (aceitemid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ace_aceitem OWNER TO postgres;
/*
CREATE SEQUENCE ace_aceitem_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 100898
  CACHE 1;
ALTER TABLE ace_aceitem_id_seq OWNER TO postgres;

ALTER TABLE ace_aceitem ALTER COLUMN aceitemid SET DEFAULT nextval('ace_aceitem_id_seq'::regclass);
*/

CREATE TABLE ace_wxsharvester
(
  wxsharvesterid bigint NOT NULL,
  "name" character varying(255),
  url character varying(255),
  ogctype character varying(75),
  every integer,
  topic character varying(75),
  savedtogeonetwork boolean,
  geonetworkid bigint,
  geonetworkuuid character varying(75),
  companyid bigint,
  groupid bigint,
  status character varying(75),
  CONSTRAINT ace_wxsharvester_pkey PRIMARY KEY (wxsharvesterid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ace_wxsharvester OWNER TO postgres;

alter TABLE ace_wxsharvester
alter column  url type character varying(1024);

CREATE TABLE ace_cswharvester 
(
	cswharvesterid bigint NOT NULL,
	"name" character varying(255),
	url character varying(255),
	freetext character varying(75),
	title character varying(75),
	abstrakt character varying(75),
	subject character varying(75),
  every integer,
  topic character varying(75),
  status character varying(75),
  savedtogeonetwork boolean,
  geonetworkid bigint,
  geonetworkuuid character varying(75),
  companyid bigint,
  groupid bigint,
  type_ character varying(75),
  username character varying(75),
  password_ character varying(75),
  CONSTRAINT ace_cswharvester_pkey PRIMARY KEY (cswharvesterid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ace_cswharvester OWNER TO postgres;
