BEGIN;

DELETE FROM public.geometry_columns WHERE f_table_name = 'casestudies' AND f_geometry_column = 'geom';

-- View: casestudies

DROP VIEW casestudies;

CREATE OR REPLACE VIEW casestudies
(geom, area, itemname, "desc", website, sectors, risks, measureid, featured ) AS 
                        SELECT st_pointfromtext(((('POINT('::text || ace_measure.lon) || ' '::text) || ace_measure.lat) || ')'::text, 4326) AS geom, ace_measure.satarea AS area, ace_measure.name AS itemname, "substring"(ace_measure.description, 1, 100) || ' ...'::text AS "desc", ace_measure.website, ace_measure.sectors_ AS sectors, ace_measure.climateimpacts_ AS risks, ace_measure.measureid, 
                        CASE ace_measure.casestudyfeature::text
                        WHEN 'CASESEARCH'::text THEN 'yes'::text 
                        ELSE 'no'::text 
                        END
                       FROM ace_measure
                          WHERE ace_measure.controlstatus = 1 AND ace_measure.mao_type::text = 'A'::text AND ace_measure.lon IS NOT NULL AND ace_measure.lat IS NOT NULL AND ace_measure.lon <> 'NaN'::double precision AND ace_measure.lat <> 'NaN'::double precision AND ace_measure.lat > 0::double precision 
order by 9 desc, 3
;
ALTER TABLE casestudies OWNER TO postgres;
GRANT ALL ON TABLE casestudies TO postgres;
GRANT SELECT ON TABLE casestudies TO chm_viewer;

INSERT INTO public.geometry_columns values ('', 'public', 'casestudies', 'geom', 2, 4326, 'POINT');

END;