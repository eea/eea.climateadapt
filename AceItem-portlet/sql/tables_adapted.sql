create table ace_aceitem (
  aceitemid bigint NOT NULL ,
  companyid bigint,
  groupid bigint,
  wxsharvesterid bigint,
  "name" character varying(255),
  description text,
  datatype character varying(255),
  storedat character varying(255),
  storagetype character varying(255),
  specialtagging character varying(75) DEFAULT NULL::character varying,
  textsearch text,
  keyword character varying(2048),
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
  deeplink character varying(255),
  controlstatus smallint,
  creator character varying(75),
  creationdate timestamp without time zone,
  moderator character varying(75),
  approvaldate timestamp without time zone,
  replacesid bigint,
  comments text,
  textwebpage text,
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
  "name" character varying(75),
  url character varying(75),
  ogctype character varying(75),
  every integer,
  topic character varying(75),
  status character varying(75),
  savedtogeonetwork boolean,
  geonetworkid bigint,
  geonetworkuuid character varying(75),
  companyid bigint,
  groupid bigint,
  CONSTRAINT ace_wxsharvester_pkey PRIMARY KEY (wxsharvesterid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ace_wxsharvester OWNER TO postgres;

