/*
 * Original definition of the case studies view:
 * CREATE OR REPLACE VIEW casestudies AS 
     SELECT st_pointfromtext(((('POINT('::text || ace_measure.lon) || ' '::text) || ace_measure.lat) || ')'::text, 4326) AS geom, ace_measure.satarea AS area, ace_measure.name AS itemname, "substring"(ace_measure.description, 1, 100) || ' ...'::text AS "desc", ace_measure.website, ace_measure.sectors_ AS sectors, ace_measure.climateimpacts_ AS risks, ace_measure.measureid
       FROM ace_measure
      WHERE ace_measure.controlstatus = 1 AND ace_measure.mao_type::text = 'A'::text AND ace_measure.lon IS NOT NULL AND ace_measure.lat IS NOT NULL AND ace_measure.lon <> 'NaN'::double precision AND ace_measure.lat <> 'NaN'::double precision AND ace_measure.lat > 0::double precision;
 */
BEGIN;

DROP VIEW casestudies;

CREATE OR REPLACE VIEW casestudies AS 
         SELECT st_pointfromtext(((('POINT('::text || ace_measure.lon) || ' '::text) || ace_measure.lat) || ')'::text, 4326) AS geom, ace_measure.satarea AS area, ace_measure.name AS itemname, "substring"(ace_measure.description, 1, 100) || ' ...'::text AS "desc", ace_measure.website, ace_measure.sectors_ AS sectors, ace_measure.climateimpacts_ AS risks, ace_measure.measureid, 
                CASE ace_measure.casestudyfeature::text
                    WHEN 'CASESEARCH'::text THEN 'yes'::text
                    ELSE 'no'::text
                END AS featured, 'yes'::text AS newitem
           FROM ace_measure
          WHERE ace_measure.approvaldate >= ('now'::text::date - '90 days'::interval)::date::timestamp with time zone AND ace_measure.controlstatus = 1 AND ace_measure.mao_type::text = 'A'::text AND ace_measure.lon IS NOT NULL AND ace_measure.lat IS NOT NULL AND ace_measure.lon <> 'NaN'::double precision AND ace_measure.lat <> 'NaN'::double precision AND ace_measure.lat > 0::double precision
UNION ALL 
         SELECT st_pointfromtext(((('POINT('::text || ace_measure.lon) || ' '::text) || ace_measure.lat) || ')'::text, 4326) AS geom, ace_measure.satarea AS area, ace_measure.name AS itemname, "substring"(ace_measure.description, 1, 100) || ' ...'::text AS "desc", ace_measure.website, ace_measure.sectors_ AS sectors, ace_measure.climateimpacts_ AS risks, ace_measure.measureid, 
                CASE ace_measure.casestudyfeature::text
                    WHEN 'CASESEARCH'::text THEN 'yes'::text
                    ELSE 'no'::text
                END AS featured, 'no'::text AS newitem
           FROM ace_measure
          WHERE ace_measure.approvaldate < ('now'::text::date - '90 days'::interval)::date::timestamp with time zone AND ace_measure.controlstatus = 1 AND ace_measure.mao_type::text = 'A'::text AND ace_measure.lon IS NOT NULL AND ace_measure.lat IS NOT NULL AND ace_measure.lon <> 'NaN'::double precision AND ace_measure.lat <> 'NaN'::double precision AND ace_measure.lat > 0::double precision
  ORDER BY 9 DESC;

ALTER TABLE casestudies OWNER TO postgres;
GRANT ALL ON TABLE casestudies TO postgres;
GRANT SELECT ON TABLE casestudies TO chm_viewer;

END;