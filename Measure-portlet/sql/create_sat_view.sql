BEGIN;

DELETE FROM public.geometry_columns WHERE f_table_name = 'casestudies' AND f_geometry_column = 'geom';

-- View: casestudies

DROP VIEW casestudies;

CREATE OR REPLACE VIEW casestudies AS 
 SELECT st_pointfromtext(((('POINT('::text || ace_measure.lat) || ' '::text) || ace_measure.lon) || ')'::text, 4326) AS geom, ace_measure.satarea AS area, ace_measure.name AS itemname, "substring"(ace_measure.description, 1, 100) || ' ...'::text AS "desc", ace_measure.website, ace_measure.sectors_ AS sectors, ace_measure.climateimpacts_ AS risks, ace_measure.measureid
   FROM ace_measure
  WHERE ace_measure.mao_type::text = 'A'::text;

ALTER TABLE casestudies OWNER TO postgres;

INSERT INTO public.geometry_columns values ('', 'public', 'casestudies', 'geom', 2, 4326, 'POINT');

END;