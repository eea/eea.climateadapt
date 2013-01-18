CREATE TABLE ace_project
(
  projectid bigint NOT NULL DEFAULT nextval('ace_project_id_seq'::regclass),
  companyid bigint,
  groupid bigint,
  acronym character varying(75),
  title character varying(255),
  startdate date,
  enddate date,
  lead character varying(255),
  partners text,
  funding character varying(75),
  sectors character varying(255),
  spatiallayer character varying(1024),
  abstracts text,
  element character varying(255),
  keywords text,
  website text,
  duration character varying(255),
  rating bigint,
  importance bigint,
  specialtagging character varying(75),
  controlstatus smallint,
  creator character varying(75),
  creationdate timestamp without time zone,
  moderator character varying(2000),
  approvaldate timestamp without time zone,
  replacesid bigint,
  comments text,
  textwebpage text,
  spatialvalues character varying(255),
  source character varying(75),
  climateimpacts character varying(255),
  CONSTRAINT ace_project_pkey PRIMARY KEY (projectid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ace_project OWNER TO postgres;

/* liferay uses own id counter - for loading in the back start with 100000  

CREATE SEQUENCE ace_project_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 100000
  CACHE 1;
ALTER TABLE ace_project_id_seq OWNER TO postgres;

ALTER TABLE ace_project ALTER COLUMN projectid SET DEFAULT nextval('ace_project_id_seq'::regclass);
*/