CREATE TABLE ace_measure
(
  measureid bigint NOT NULL DEFAULT nextval('ace_measure_id_seq'::regclass),
  companyid bigint,
  groupid bigint,
  "name" character varying(255),
  description text,
  implementationtype text,
  implementationtime character varying(255),
  lifetime character varying(255),
  spatiallayer character varying(75),
  spatialvalues character varying(255),
  legalaspects text,
  stakeholderparticipation text,
  contact character varying(3900),
  succeslimitations text,
  website text,
  costbenefit text,
  keywords text,
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  publicationdate timestamp without time zone,
  specialtagging character varying(75) DEFAULT NULL::character varying,
  sectors_ character varying(255),
  elements_ character varying(255),
  climateimpacts_ character varying(255),
  mao_type character varying(24),
  source character varying(75),
  rating bigint,
  importance bigint,
  lon double precision,
  lat double precision,
  satarea character varying(254),
  controlstatus smallint,
  creator character varying(75),
  creationdate timestamp without time zone,
  moderator character varying(2000),
  approvaldate timestamp without time zone,
  replacesid bigint,
  comments text,
  textwebpage text,
  lockdate timestamp without time zone,
  CONSTRAINT ace_measure_pkey PRIMARY KEY (measureid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ace_measure OWNER TO postgres;

/* liferay uses own id counter - for loading in the back start with 100000  

CREATE SEQUENCE ace_measure_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 100000
  CACHE 1;
ALTER TABLE ace_measure_id_seq OWNER TO postgres;

ALTER TABLE ace_measure ALTER COLUMN measureid SET DEFAULT nextval('ace_measure_id_seq'::regclass);

*/