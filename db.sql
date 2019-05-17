--
-- PostgreSQL database dump
--

-- Dumped from database version 11.1
-- Dumped by pg_dump version 11.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.history (
    user_id bigint,
    page_name text,
    time_date timestamp without time zone
);


ALTER TABLE public.history OWNER TO postgres;

--
-- Data for Name: history; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.history (user_id, page_name, time_date) FROM stdin;
1	event	2019-05-17 14:54:15.956
1	event	2019-05-17 14:54:37.95
1	event	2019-05-16 14:55:16.017
2	event	2019-05-17 14:55:42.932
1	event	2019-05-17 21:19:40.433031
1	event	2019-05-17 21:20:38.040989
1	now	2019-05-17 21:40:52.163642
1	now	2019-05-17 21:40:58.35886
\.


--
-- PostgreSQL database dump complete
--

