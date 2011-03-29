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
  CONSTRAINT ace_project_pkey PRIMARY KEY (projectid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ace_project OWNER TO postgres;