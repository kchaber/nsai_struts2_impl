--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: parking_places; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE parking_places (
    id integer NOT NULL,
    ordernum integer NOT NULL,
    parkingdata_id integer
);


ALTER TABLE public.parking_places OWNER TO postgres;

--
-- Name: parking_places_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE parking_places_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.parking_places_id_seq OWNER TO postgres;

--
-- Name: parking_places_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE parking_places_id_seq OWNED BY parking_places.id;


--
-- Name: parking_places_reservations; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE parking_places_reservations (
    id integer NOT NULL,
    bookingdate timestamp without time zone NOT NULL,
    parkingplacedata_id integer,
    userdata_id integer
);


ALTER TABLE public.parking_places_reservations OWNER TO postgres;

--
-- Name: parking_places_reservations_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE parking_places_reservations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.parking_places_reservations_id_seq OWNER TO postgres;

--
-- Name: parking_places_reservations_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE parking_places_reservations_id_seq OWNED BY parking_places_reservations.id;


--
-- Name: parkings; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE parkings (
    id integer NOT NULL,
    capacity integer NOT NULL,
    name character varying(50) NOT NULL,
    streetname character varying(100) NOT NULL
);


ALTER TABLE public.parkings OWNER TO postgres;

--
-- Name: parkings_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE parkings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.parkings_id_seq OWNER TO postgres;

--
-- Name: parkings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE parkings_id_seq OWNED BY parkings.id;


--
-- Name: security_roles; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE security_roles (
    id integer NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.security_roles OWNER TO postgres;

--
-- Name: security_roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE security_roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.security_roles_id_seq OWNER TO postgres;

--
-- Name: security_roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE security_roles_id_seq OWNED BY security_roles.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    id integer NOT NULL,
    email character varying(100) NOT NULL,
    firstname character varying(50),
    lastname character varying(100),
    login character varying(30) NOT NULL,
    passwordencrypted character varying(255) NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- Name: users_security_roles; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users_security_roles (
    userdata_id integer NOT NULL,
    securityroles_id integer NOT NULL
);


ALTER TABLE public.users_security_roles OWNER TO postgres;

--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY parking_places ALTER COLUMN id SET DEFAULT nextval('parking_places_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY parking_places_reservations ALTER COLUMN id SET DEFAULT nextval('parking_places_reservations_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY parkings ALTER COLUMN id SET DEFAULT nextval('parkings_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY security_roles ALTER COLUMN id SET DEFAULT nextval('security_roles_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- Data for Name: parking_places; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY parking_places (id, ordernum, parkingdata_id) FROM stdin;
\.


--
-- Name: parking_places_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('parking_places_id_seq', 30, true);


--
-- Data for Name: parking_places_reservations; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY parking_places_reservations (id, bookingdate, parkingplacedata_id, userdata_id) FROM stdin;
\.


--
-- Name: parking_places_reservations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('parking_places_reservations_id_seq', 6, true);


--
-- Data for Name: parkings; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY parkings (id, capacity, name, streetname) FROM stdin;
\.


--
-- Name: parkings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('parkings_id_seq', 1, true);


--
-- Data for Name: security_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY security_roles (id, name) FROM stdin;
1	ROLE_ADMIN
2	ROLE_USER
\.


--
-- Name: security_roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('security_roles_id_seq', 2, true);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (id, email, firstname, lastname, login, passwordencrypted) FROM stdin;
1	admin@admin.pl	admin	admin	admin	$2a$10$e2KSFCEQMvyH1YWilmrfJuJ66NXiCVX3dLRyXndevyuYW0EAK/JfC
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_id_seq', 2, true);


--
-- Data for Name: users_security_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users_security_roles (userdata_id, securityroles_id) FROM stdin;
1	1
1	2
\.


--
-- Name: parking_places_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY parking_places
    ADD CONSTRAINT parking_places_pkey PRIMARY KEY (id);


--
-- Name: parking_places_reservations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY parking_places_reservations
    ADD CONSTRAINT parking_places_reservations_pkey PRIMARY KEY (id);


--
-- Name: parkings_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY parkings
    ADD CONSTRAINT parkings_pkey PRIMARY KEY (id);


--
-- Name: security_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY security_roles
    ADD CONSTRAINT security_roles_pkey PRIMARY KEY (id);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: users_security_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users_security_roles
    ADD CONSTRAINT users_security_roles_pkey PRIMARY KEY (userdata_id, securityroles_id);


--
-- Name: fk_parking_places_parkingdata_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY parking_places
    ADD CONSTRAINT fk_parking_places_parkingdata_id FOREIGN KEY (parkingdata_id) REFERENCES parkings(id);


--
-- Name: fk_parking_places_reservations_parkingplacedata_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY parking_places_reservations
    ADD CONSTRAINT fk_parking_places_reservations_parkingplacedata_id FOREIGN KEY (parkingplacedata_id) REFERENCES parking_places(id);


--
-- Name: fk_parking_places_reservations_userdata_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY parking_places_reservations
    ADD CONSTRAINT fk_parking_places_reservations_userdata_id FOREIGN KEY (userdata_id) REFERENCES users(id);


--
-- Name: fk_users_security_roles_securityroles_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users_security_roles
    ADD CONSTRAINT fk_users_security_roles_securityroles_id FOREIGN KEY (securityroles_id) REFERENCES security_roles(id);


--
-- Name: fk_users_security_roles_userdata_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users_security_roles
    ADD CONSTRAINT fk_users_security_roles_userdata_id FOREIGN KEY (userdata_id) REFERENCES users(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

