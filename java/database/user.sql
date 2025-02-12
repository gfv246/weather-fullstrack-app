-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

--CREATE USER weather_app_db_owner
--WITH PASSWORD 'weatherisgud';
--
--GRANT ALL
--ON ALL TABLES IN SCHEMA public
--TO weather_app_db_owner;
--
--GRANT ALL
--ON ALL SEQUENCES IN SCHEMA public
--TO weather_app_db_owner;

CREATE USER weather_app_db_appuser
WITH PASSWORD 'weatherisgud';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO weather_app_db_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO weather_app_db_appuser;
