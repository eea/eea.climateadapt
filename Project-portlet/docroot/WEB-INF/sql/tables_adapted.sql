CREATE TABLE ace_project
(
  projectid bigint NOT NULL,
  companyid bigint,
  groupid bigint,
  acronym character varying(75),
  title character varying(255),
  startdate date,
  enddate date,
  lead character varying(255),
  partners character varying(3800),
  funding character varying(75),
  sectors character varying(255),
  spatiallevel character varying(1024),
  abstracts text,
  element character varying(255),
  keywords character varying(2048),
  website character varying(1024),
  duration character varying(255),
  rating bigint,
  importance bigint,
  CONSTRAINT ace_project_pkey PRIMARY KEY (projectid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ace_project OWNER TO postgres;

/* liferay uses own id counter - for loading in the back start with 100000  */

CREATE SEQUENCE ace_project_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 100000
  CACHE 1;
ALTER TABLE ace_project_id_seq OWNER TO postgres;

ALTER TABLE ace_project ALTER COLUMN projectid SET DEFAULT nextval('ace_project_id_seq'::regclass);