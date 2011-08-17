BEGIN;

DELETE FROM public.geometry_columns WHERE f_table_name = 'casestudies' AND f_geometry_column = 'geom';

CREATE OR REPLACE VIEW casestudies AS (
	SELECT 
		st_pointfromtext('POINT('|| lat || ' ' || lon ||')', 4326) AS geom, 
		satarea AS area, 
		"name", 
		description,
		website AS website,
		sectors_ AS sectors,
		climateimpacts_ AS risks
 	FROM ace_measure);

INSERT INTO public.geometry_columns values ('', 'public', 'casestudies', 'geom', 2, 4326, 'POINT');

END;