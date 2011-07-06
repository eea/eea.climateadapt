create table ace_measure (
  measureid bigint not null,
  companyid bigint,
  groupid bigint,
  "name" character varying(255),
  description text,
  implementationtype character varying(3900),
  implementationtime character varying(255),
  lifetime character varying(255),
  spatiallayer character varying(75),
  spatialvalues character varying(75),
  legalaspects character varying(3900),
  stakeholderparticipation character varying(3900),
  contact character varying(3900),
  succeslimitations character varying(3900),
  website character varying(1024),
  costbenefit character varying(3900),
  keywords character varying(3900),
  startdate timestamp without time zone,
  enddate timestamp without time zone,
  publicationdate timestamp without time zone,
  "language" character varying(24) DEFAULT 'en_UK'::character varying,
  sectors_ character varying(255),
  elements_ character varying(255),
  climateimpacts_ character varying(255),
  mao_type character varying(24),
  source character varying(75),
  rating bigint,
  importance bigint,
  CONSTRAINT ace_measure_pkey PRIMARY KEY (measureid)
)
WITH (
  OIDS=FALSE
);

ALTER TABLE ace_measure OWNER TO postgres;

/* liferay uses own id counter - for loading in the back start with 100000  */

CREATE SEQUENCE ace_measure_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 100000
  CACHE 1;
ALTER TABLE ace_measure_id_seq OWNER TO postgres;

ALTER TABLE ace_measure ALTER COLUMN measureid SET DEFAULT nextval('ace_measure_id_seq'::regclass);